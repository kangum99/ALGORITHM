package stackQueue;
import java.util.*;

public class Pro_기능개발 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
	 * Level.2
	 * 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 : progresses
	 * 각 개발 속도가 적힌 정수 배열 : speeds
	 * 각 배포마다 몇 개의 기능이 배포되는 지?
	 */

	static List<Integer> solution(int[] progresses, int[] speeds) {
        Stack<Integer> s = new Stack<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        
//        거꾸로 넣기
        for(int i = progresses.length-1; i >= 0; i--) {
//        	올림 : ceil, 버림 : floor, 반올림 : round, 절대값 : abs 
        	s.add((int)Math.ceil((double)(100 - progresses[i])/(double)speeds[i]));
        }
        
        while(!s.isEmpty()) {
        	int cnt = 1; 
        	int top = s.pop();
//        	젤 위에 있는거랑 아까 뽑아논 top이랑 비교!
        	while (!s.isEmpty() && s.peek() <= top) {
        		cnt++;
        		s.pop();
        	}
        	answer.add(cnt);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		List<Integer> answer = solution(progresses, speeds);
		
		for(int i : answer)
			System.out.println(i);
	}

}
