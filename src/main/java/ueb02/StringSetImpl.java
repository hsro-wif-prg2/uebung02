package ueb02;

import com.sun.xml.internal.bind.v2.runtime.output.NamespaceContextImpl;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {

    private class Element {
        String value;
        Element left;
        Element right;

        public Element (String value, Element left, Element right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int elementSize (Element e){
            int size = 1;
            if (e.right != null) {
                size = size + e.right.elementSize(e.right);
            } else if(e.left != null) {
                size = size + e.left.elementSize(e.left);
            }
            return size;
        }
    }

    Element root;

    @Override
    public boolean add(String s) {
        if (root == null) {
            root = new Element(s, null, null);
            return true;
        }

        Element it = root;

        while (it != null) {
            if (it.value.compareTo(s) == 0){
                return false;
            }
            if (s.compareTo(it.value) > 0){
                if (it.right == null){
                    it.right = new Element(s, null, null);
                    return true;
                }
                it = it.right;
            } else {
                if (it.left == null){
                    it.left = new Element(s, null, null);
                    return true;
                }
                it = it.left;
            }
        }

        return false;
    }

    @Override
    public boolean contains(String s) {
        if (root.value.compareTo(s) == 0){
            return true;
        }

        Element it = root;

        while (it != null){
            if (it.value.compareTo(s) == 0){
                return true;
            }

            if (s.compareTo(it.value) > 0){
                it = it.right;
            } else {
                it = it.left;
            }
        }
        return false;
    }

    @Override
    public String remove(String s) {
        if (!this.contains(s)) {
            throw new NoSuchElementException();
        }

        if (root.value.compareTo(s) == 0 ){
            String temp;
            if (root.left == null && root.right == null) {
                temp = root.value;
                root = null;
                return temp;
            } else if (root.left == null) {
                temp = root.value;
                root = root.right;
                return temp;
            } else if (root.right == null){
                temp = root.value;
                root = root.left;
                return temp;
            } else {
                temp = root.value;
                Element right = root.right;
                root = root.left;
                this.add(right.value);
                return temp;
            }
        }

        Element it = root;

        /*while (it.right.value.compareTo(s) == 0 || it.left.value.compareTo(s) == 0){
            if (s.compareTo(it.value) > 0){
                it = it.right;
            } else {
                it = it.left;
            }
        }

        if (s.compareTo(it.value) > 0){

        } else {
            it = it.left;
        }*/

        return it.value;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }

        return root.elementSize(root);
    }
}
