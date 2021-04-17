package algorithm;

public class Pro_2016년 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/12901?language=java
	 * Level 1
	 * 2016년은 윤년 2월이 29일까지 있음
	 * 2016년 1월 1일은 금요일
	 * a월 b일은 무슨 요일인지 return
	 * */
	private static String[] week = {"THU", "FRI","SAT","SUN","MON","TUE","WED"};
	private static int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static String solution(int a, int b) {
		int sum = 0;
		for(int i = 0; i < a-1; i++) {
			sum += month[i];
		}
		sum += b;
        String answer = week[sum % 7];
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 24;
		System.out.println(solution(a, b));
		
	}

}
