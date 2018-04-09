package ueb02;

class Duplikate {
	/**
	 * Gibt ein StringSet mit den Wörtern zurück, welche mindestens zwei mal im Text vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return StringSet mit den Wörtern, welche mind. zwei mal vorkommen.
	 */
	static StringSet findeDuplikate(String text) {
		// TODO Implementieren Sie die Methode gemäß dem obigen Javadoc Kommentar.
		StringSetImpl set1 = new StringSetImpl();
		StringSetImpl set2 = new StringSetImpl();

		text = text.replaceAll("[^a-zA-Z 0-9]", "");

		for (String c : text.split(" ")) {
			if (set1.add(c) == false){
				set2.add(c);
			}
		}

		return set2;
	}
}
