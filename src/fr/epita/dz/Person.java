package fr.epita.dz;


public class Person{
	 
	private String name;
	private int birthyear, birthmonth,birthday;
	private int y2,m2,d2;
	 
	public Person(String name, int birthyear, int birthmonth, int birthday,int y2,int m2,int d2 )       {
	          this.name = name;
	          this.birthyear = birthyear;
	          this.birthmonth = birthmonth;
	          this.birthday = birthday;
	          this.y2 = y2;
	          this.m2 = m2;
	          this.d2 =d2;
	}

	public String getName() {
		return name;
	}
//	public int getBirthyear() {
//		return birthyear;
//	}
//	public int getBirthmonth() {
//		return birthmonth;
//	}
//	public int getBirthday() {
//		return birthday;
//	}
//	
//	public void setY2(int y2) {
//		this.y2 = y2;
//	}
//	public void setM2(int m2) {
//		this.m2 = m2;
//	}
//	public void setD2(int d2) {
//		this.d2 = d2;
//	}
	
	public int getLeftDays() {
		if((birthmonth < m2 || (birthmonth ==m2 && birthday < d2))) 
			return getAlldays(y2,m2,d2,y2+1,birthmonth,birthday);
		if (birthmonth == 2 && birthday ==29)
			return IsLeap(y2+1)==366?getAlldays(y2,m2,d2,y2+1,2,29):
				(IsLeap(y2+2)==366?getAlldays(y2,m2,d2,y2+2,2,29):
					IsLeap(y2+3)==366?getAlldays(y2,m2,d2,y2+3,2,29):
						IsLeap(y2+4)==366?getAlldays(y2,m2,d2,y2+4,2,29):1 );
		else
			return getAlldays(y2,m2,d2,y2,birthmonth,birthday);
	}
	
	/****I used 0/12/31 as my base date point,to calculate the diff value of each date from base year point	*****/
	public int getDiffValue(int y,int m,int d) {		
		return m==1 ? (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400 + d 
				: (m == 2 ? (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400 + d +31 
				:(y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400 + (m - 1)*28 + (13*(m+1))/5 - 7 + d +IsLeap(y)/366 );	
	}
	
	/**** get the alldays we have been lived *******/
	public int getAlldays(int y1,int m1,int d1,int y2,int m2,int d2) {
		return getDiffValue(y2,m2,d2) - getDiffValue(y1,m1,d1);
	}
	
	/****	Define whether if it is a leap year	***/
	public int IsLeap(int y) {		
		return (y % 400 == 0 || (y % 4 == 0 && y % 100 !=0 )) ? 366 : 365;
	}

}