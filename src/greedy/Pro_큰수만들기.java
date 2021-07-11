package greedy;

import java.util.Stack;

public class Pro_큰수만들기 {
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<Character>();
//		k개를 제거한 수
		int cnt = number.length()-k;
		
		for(int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
//			3중에 하나라도 안맞으면 while문 안돔
			while(!s.isEmpty() && s.peek() < c && k-- > 0) {
					s.pop();
			}
			s.push(c);
		}
		int i = 0;
		while(i < cnt) {
			sb.append(s.get(i));
			i++;
		}
		
        return sb.toString();
    }

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String number = "1231234";
		int k = 3;
		System.out.println(solution(number, k));
	}

}
