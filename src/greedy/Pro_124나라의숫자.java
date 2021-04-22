package greedy;

public class Pro_124나라의숫자 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/12899
	 * Level 2
	 * n : 주어진 숫자
	 * n을 124나라의 숫자로 바꿔서 return*/
	
	public static String solution(int n) {
		String answer = "";
		String[] s = {"4", "1", "2"};
		while( n > 0 ) {
			int a = n%3;
			n /= 3;
			if( a == 0 ) n--;
			answer = s[ a ] + answer ;
		}
		return answer;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(solution(n));
	}

}
