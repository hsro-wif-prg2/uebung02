package ueb02;

class Duplikate {
	/**
	 * Gibt ein StringSet mit den Wörtern zurück, welche mindestens zwei mal im Text vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return StringSet mit den Wörtern, welche mind. zwei mal vorkommen.
	 */
	static StringSet findeDuplikate(String text) {

		StringSet str1 = new StringSetImpl();
		StringSet str2 = new StringSetImpl();


			String[] satz = {
				"\\?", "!", ",", ".", ":","\"", "-"};
			for (String z : satz)
		text = text.replaceAll(z, "");

					for (String w : text.split(" ")) {

							if (str1.contains(w))
		str2.add(w);


						str1.add(w);
			}

					return str2;

	}
}
