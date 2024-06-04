package dictionaryelev;

import biler.Bil;

public class DictionaryDemo {

	public static void main(String[] args) {
		// Dictionary map = new DictionaryHashMap<Integer,String>();
		Dictionary<Bil, Integer> dictionary = new DictionaryLinked<>();
//		System.out.println(dictionary.isEmpty());
//		System.out.println(dictionary.size());

		dictionary.put(new Bil("EH22333", "Volvo", "Voldsom", "Rød"), 3);
		dictionary.put(new Bil("EH22333", "Volvo1", "Voldsom", "Gul"), 4);

//		System.out.println(dictionary.isEmpty());
//		System.out.println(dictionary.size());

//		System.out.println(dictionary.get(new Bil("EH22333", "Volvo", "Voldsom", "Rød")));

		dictionary.put(new Bil("EH22333", "Volvo2", "Voldsom", "blå"), 0);
		dictionary.put(new Bil("EH22333", "Volvo3", "Voldsom", "Sort"), 2);

//		System.out.println(dictionary.isEmpty());
//		System.out.println(dictionary.size());
//		System.out.println(dictionary.remove(new Bil("EH22333", "Volvo", "Voldsom", "Rød")));
		dictionary.remove(new Bil("EH22333", "Volvo", "Voldsom", "Rød"));

//		System.out.println(dictionary.size());

		System.out.println(dictionary.put(new Bil("EH22333", "Volvo", "Voldsom", "Rød"), 3));
		System.out.println(dictionary.get(new Bil("EH22333", "Volvo", "Voldsom", "Rød")));
	}
}
