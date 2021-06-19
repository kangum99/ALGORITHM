package RookieHero4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Two {
	static double size = Math.pow(2, 20) * 14;
	static String[] s;
	static ArrayList<String> list = new ArrayList<String>();
	
	public static String solution(String S) {
		s = S.split("\n");
		for(int i = 0; i < s.length; i++ ) {
			if(s[i].substring(0, 5).equals("admin") 
					&& s[i].charAt(9) == 'x'
					&& scope(s[i].substring(23, 33))) {
				list.add(s[i].substring(11, 22));
			}
		}
		if(list.isEmpty()) 
			return "NO FILES";
		Queue<String> q = new LinkedList<String>();
		q.add("");
		
		int min = 10000;
		for(int i = 0; i < list.size(); i++) {
			int year = Integer.parseInt(list.get(i).split(" ")[2]);
			if(year <= min) {
				min = year;
				q.add(list.get(i));
				q.poll();
			}
		}
		
		if(q.size() == 1)
			return q.poll();
		
		min = 13;
		for(int i = 0; i < q.size(); i++) {
			String date = q.poll();
			int temp = month(date.split(" ")[1]);
			if(temp <= min) {
				min = temp;
				q.add(date);
			}
		}
		
		min = 32;
		for(int i = 0; i < q.size(); i++) {
			String date = q.poll();
			int temp = Integer.parseInt(date.split(" ")[0]);
			if(temp <= min) {
				min = temp;
				q.add(date);
			}
		}
		
		return q.poll();
    }
	public static boolean scope (String str) {
		if(Double.parseDouble(str) < size) 
			return true;
		return false;
	}
	
	public static int month (String str) {
		switch(str) {
			case "Jan":
				return 1;
			case "Feb":
				return 2;
			case "Mar":
				return 3;
			case "Apr":
				return 4;
			case "May":
				return 5;
			case "Jun":
				return 6;
			case "Jul":
				return 7;
			case "Aug":
				return 8;
			case "Sep":
				return 9;
			case "Oct":
				return 10;
			case "Nov":
				return 11;			
			default:
				return 12;			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "admin  -wx 29 Sep 1983        833 source.h" +"\n"+ 
				"admin  r-x 23 Jun 2003     854016 blockbuster.mpeg"  +"\n"+
				"admin  --x 28 Sep 1983        821 delete-this.py"  +"\n"+
				"admin  -w- 15 Feb 1971      23552 library.dll" +"\n"+
				"admin  --x 15 May 1979  645922816 logs.zip" +"\n"+
				"jane   --x 04 Dec 2010      93184 old-photos.rar" +"\n"+
				"jane   -w- 08 Feb 1982  681574400 important.java" +"\n"+
				"admin  rwx 26 Dec 1952   14680064 to-do-list.txt";
		System.out.println(solution(str));
	}

}
