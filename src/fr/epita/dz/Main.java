package fr.epita.dz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int y2,m2,d2;
		List<Person> persons = new ArrayList<Person>();
		System.out.println("Please input today's date first,Thanks : ");
		Scanner input = new Scanner(System.in);
		y2 = input.nextInt();
		m2 = input.nextInt();
		d2 = input.nextInt();
		System.out.println("Please input the list of names and birthdas, end with '0' : ");
		while(!input.hasNext("0")){    // End input with "0" string, otherwise return true
	       	String name = input.next();
	       	int y = input.nextInt();
	       	int m = input.nextInt();
	       	int d = input.nextInt();
	       	persons.add(new Person(name, y, m, d, y2, m2, d2));	   
        }
		Collections.sort(persons, new sortComparator());
		persons.forEach((p) -> System.out.printf( "%s in %d days\n", p.getName(),p.getLeftDays()));
		
//       	List<Person> sortedDate = persons
//                .stream()
//                .sorted( (p, p2) -> (p.getLeftDays() - p2.getLeftDays()) )
//                .collect( toList() );
//		sortedDate.forEach((p) -> System.out.printf( "%s in %d days\n",p.getName(),p.getLeftDays()));
						 
		
	}
}
