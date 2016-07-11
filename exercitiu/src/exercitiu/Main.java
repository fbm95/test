package exercitiu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		System.out.println("Print out all duplicate words from a given word list");
		Scanner sc = null;
		try {
			sc = new Scanner(new File("./src/exercitiu/text.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] words = null;
		ArrayList<String> cuvinte = new ArrayList<String>();
		while (sc.hasNext()) {
			String line = sc.nextLine();
			words = line.split(" ");
			for (int i = 0; i < words.length; i++) {
				cuvinte.add(words[i].toString());
			}
		}
		System.out.println("\nelemente din fisier:");

		for (Iterator<String> iterator = cuvinte.iterator(); iterator.hasNext();) {
			String strings = (String) iterator.next();
			System.out.print(strings.toString() + " ");
		}

		List<String> duplicates = new ArrayList<String>();
		Set<String> wordSet = new TreeSet<String>();
		List<String> wordSet2 = new ArrayList<String>();

		for (String c : cuvinte)
			if (!wordSet.add(c))
				if (!duplicates.contains(c))
					duplicates.add(c);

		for (String c : wordSet)
			if (!duplicates.contains(c))
				wordSet2.add(c);

		System.out.println("\n\nelemente duplicat:");
		for (Iterator<String> iterator = duplicates.iterator(); iterator.hasNext();) {
			String strings = (String) iterator.next();
			System.out.print(strings.toString() + " ");
		}

		System.out.println("\n\nPrint out all distinct words from a given word list");
		for (Iterator<String> iterator = wordSet2.iterator(); iterator.hasNext();) {
			String strings = (String) iterator.next();
			System.out.print(strings.toString() + " ");
		}

		System.out.println("\n\nPrint out the word list in alphabetical order");
		cuvinte.sort(null);
		for (Iterator<String> iterator = cuvinte.iterator(); iterator.hasNext();) {
			String strings = (String) iterator.next();
			System.out.print(strings.toString() + " ");
		}

		System.out.println("\n\nGenerate a frequency table of a given word list. This table maps each word ");
		System.out.println("\tto the number of times it occurs from a given word list");
		System.out.println("\tPrint the frequency table in the alphabetical order");
		Map<String, Integer> aparitii = new HashMap<String, Integer>();
		for (String word : cuvinte) {
			aparitii.put(word, aparitii.containsKey(word) ? aparitii.get(word) + 1 : 1);
		}
		for (Entry<String, Integer> entry : aparitii.entrySet()) {
			System.out.println("Cuvant: " + entry.getKey() + "\t, numar_aparitii: " + entry.getValue());
		}

		System.out.println("\n\nPrint the frequency table in the order the words appear in the given word list\n");
		
		List list = new LinkedList(aparitii.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}

		Map<String, Integer> map = sortedHashMap;

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Cuvant: " + entry.getKey() + "\t, numar_aparitii: " + entry.getValue());
		}
	}

}
