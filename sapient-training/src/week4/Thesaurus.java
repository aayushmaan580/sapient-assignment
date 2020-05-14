package week4;

import java.util.*;

public class Thesaurus {
	
	public static void main(String args[]) {
		Map<String, Set<String>> lst = new HashMap<String, Set<String>>();
		Set<String> s1;
		s1 = new TreeSet<String>();
		s1.add("GoodMorning");
		s1.add("Shubhodaya");
		s1.add("Shubhohday");
		s1.add("Bonjour");
		lst.put("GoodMorning", s1);
		s1 = new TreeSet<String>();
		s1.add("good Evening");
		s1.add("Shubha sange");
		s1.add("susandhya");
		s1.add("Bonsoir");
		lst.put("GoodEvening", s1);
		Scanner sc = new Scanner(System.in);
		String c = "y";
		String word;
		while(c.equals("y") || c.equals("Y")) {
			System.out.println("Search word in Thesaurus : ");
			word = sc.next();
			if(lst.containsKey(word)) {
				s1 = lst.get(word);
				Iterator<String> it = s1.iterator();
				int count = 1;
				System.out.println("Synonyms : ");
				while(it.hasNext()) 
					System.out.println(count + ") " + it.next());
			}
			else {
				System.out.println("Not in Thesaurus! Want to update? (Y/N)");
				c = sc.next();
				if(c.equals("y") || c.equals("Y")) {
					String str;
					s1 = new TreeSet<String>();
					str = sc.nextLine() + word;
					while(!(str.equals("")||str.equals(" "))) {
						str = sc.nextLine();
						if(!(str.equals("")||str.equals(" ")))
							s1.add(str);
					} 
					lst.put(word, s1);
				}
			}
			System.out.println("Continue searching for more words? (Y/N)");
			c = sc.next();
		}
		sc.close();
	}
}
