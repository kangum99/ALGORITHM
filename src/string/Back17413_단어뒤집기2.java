package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back17413_단어뒤집기2 {
	static String s;
	static String[] str;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
//		태그 안인지 아닌지
		boolean check = false;
		s = br.readLine();

		for(char ch : s.toCharArray()) {
			if(ch == '<') {
				check = true;
//				태그 시작 전까지 단어 뒤집기
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append('<');
			}else if(ch == '>') {
				check = false;
				sb.append('>');
			}else if(ch == ' ') {
//				공백 전까지의 단어 뒤집기
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			}else {
//				태그 아니면 스택에 넣기
				if(!check) stack.push(ch);
//				태그 안이면 그냥 글자 넣기
				else sb.append(ch);
			}
		}
		
//		공백이나 태그가 끝나고 남은 단어들 뒤집기
		while(!stack.empty()) sb.append(stack.pop());
		System.out.println(sb);
	}
}
