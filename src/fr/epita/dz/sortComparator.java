package fr.epita.dz;

import java.util.Comparator;

public class sortComparator implements Comparator <Person>{

	@Override
	public int compare(Person p1, Person p2) {
		if(p1.getLeftDays() >= p2.getLeftDays()) {
			return 1;
		}
		else
			return -1;
	}
}
