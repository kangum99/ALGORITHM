package RookieHero4;

import java.util.HashMap;

public class One {
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static String[] s;
	
	public static String solution(String S, String C) {
		String answer = "";
		s = S.split(", ");
		for(int i = 0; i < s.length; i++) {
			String email = toEmail(s[i], C);
			map.put(email, map.getOrDefault(email, 0)+1);
			if(map.get(email) != 1) {
				String[] temp = email.split("@");
				email = temp[0] + map.get(email) + "@" + temp[1];
			}
			System.out.println(email);
			answer = answer +", " + s[i] + " " + email;
		}
        return answer.substring(2);
    }
	
	public static String toEmail(String str, String C) {
		String name =str.toLowerCase();
		String[] names = name.split(" ");
		if(names.length == 2) {
			return "<" + names[0].charAt(0) + names[1] 
					+ "@" + C.toLowerCase() +".com>";
		}
		if(names[2].contains("-")) {
			return "<" + names[0].charAt(0) + names[1].charAt(0) + names[2].split("-")[0] + names[2].split("-")[1].substring(0, 2)
					+ "@" + C.toLowerCase() +".com>";
		}
		return "<" + names[0].charAt(0) + names[1].charAt(0) + names[2]
				+ "@" + C.toLowerCase() +".com>";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker", "Example"));
	}

}
