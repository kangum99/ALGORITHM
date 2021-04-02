package heap;

import java.util.*;

public class Pro_이중우선순위큐 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42628
	 * Level.3
	 * I 숫자	큐에 주어진 숫자를 삽입합니다.
	 * D 1	큐에서 최댓값을 삭제합니다.
	 * D -1	큐에서 최솟값을 삭제합니다.
	 * 이중 우선순위 큐가 할 연산 : operations
	 *  모든 연산을 처리한 후 큐가 비어있으면 [0,0] 
	 *  비어있지 않으면 [최댓값, 최솟값]을 return
	 */

	static int[] solution(String[] operations) {
		int[] answer = new int[2];
//        최소힙
        PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
//        최대힙
        PriorityQueue<Integer> maxq = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
        for(String i : operations) {
//        	문자랑 숫자랑 나누기
        	StringTokenizer st = new StringTokenizer(i);
        	String op = st.nextToken();
        	int num = Integer.parseInt(st.nextToken());
//        	빈 힙일때 연산 무시
//        	=="D"쓰면 안됨.. equals-> 문자열이라서..ㅜㅡㅜ
        	if(minq.size() == 0 && op.equals("D")) continue;
//        	삽입
        	if(op.equals("I")) {
        		minq.offer(num);
        		maxq.offer(num);
        		continue;
        	}
//        	삭제
        	if(num == 1) minq.remove(maxq.poll());
        	else if(num == -1) maxq.remove(minq.poll());

        }
        if(minq.size() > 0) {
        	answer[0] = maxq.poll();
        	answer[1] = minq.poll();
        }
        	
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = {"I 16","D 1", "I 45"};
		for(int i = 0; i < 2; i++) {
			System.out.println(solution(operations)[i]);
		}
		
	}

}
