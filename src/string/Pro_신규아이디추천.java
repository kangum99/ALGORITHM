package string;

public class Pro_신규아이디추천 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
	 * Level 1
	 * 신규 유저가 입력한 아이디 : new_id
	 * "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디 return
	 * 2:50 - 3:50 
	 * */

	static String solution(String new_id) {
        String answer = "";
//        1단계 : 대문자 -> 소문자
        new_id = new_id.toLowerCase();
//        2단계 : 알파벳 소문자(a-z), 숫자(0-9), 빼기, 밑줄, 마침표 제외(^) 제거
        String match = "[^a-z0-9-_.]";
        new_id = new_id.replaceAll(match, "");
//        3단계 : 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        new_id = new_id.replaceAll("[.]{2,}", ".");
//        4단계 : 마침표(.)가 처음이나 끝에 위치한다면 제거(n, n-1)
        new_id = new_id.replaceAll("^[.]|[.]$", "");
//        if(new_id.startsWith(".")) new_id = new_id.substring(1);
//        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
//        5단계 : 빈 문자열이라면, new_id에 "a"를 대입
        if(new_id.isEmpty()) new_id = "a";
//        6단계 : new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        if(new_id.length() >= 16) new_id = new_id.substring(0, 15);
//        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        new_id = new_id.replaceAll("[.]$","");
//        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙이기
        if(new_id.length() <= 2) {
        	String last = String.valueOf(new_id.charAt(new_id.length()-1));
        	while(new_id.length()<3) {
        		new_id = new_id.concat(last);
        	}
        }
        answer = new_id;
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String new_id = ".a.**a.";
		System.out.println(solution(new_id));
	}

}
