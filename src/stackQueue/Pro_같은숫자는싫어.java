package stackQueue;

import java.util.Stack;

public class Pro_같은숫자는싫어 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/12906?language=java
	 * Level 1
	 * 배열 : arr
	 * 중복된 숫자를 제외하고 return*/

	public static Stack<Integer> solution(int []arr) {
        Stack<Integer> s = new Stack<Integer>();
        for(int i : arr) {
        	if(!s.isEmpty() && s.peek() == i) continue;
        	s.add(i);
        }
        return s;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		System.out.println(solution(arr));
	}

}
