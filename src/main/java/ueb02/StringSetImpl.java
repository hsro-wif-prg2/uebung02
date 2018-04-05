package ueb02;

public class StringSetImpl implements StringSet {
 class Element {
     String val;
     Element left,right;

     Element (String _val,Element _left,Element _right){
         _val = val;
         _left = left;
         _right = _right;
     }
 }



    @Override
    public boolean add(String s) {
        return false;
    }

    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public String remove(String s) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
