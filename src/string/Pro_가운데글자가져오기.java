package string;

public class Pro_가운데글자가져오기 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/12903?language=java
	 * Level 1
	 * 문자열 : s
	 * 홀수 일때는 가운데 글자, 짝수 일때는 가운데 2개 글자*/
	
	static String solution(String s) {
        int mid = (int)(s.length()/2);
        if(s.length() % 2 == 0) 
            return String.valueOf(s.charAt(mid-1)) + s.charAt(mid);
        else 
            return String.valueOf(s.charAt(mid));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcde";
		String s2 = "qwer";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}

}
