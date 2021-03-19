package stackQueue;

import java.util.*;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 * Level.2
 * 다리 길이 : bridge_length
 * 다리 무게 : weight
 * 트럭별 무게 : truck_weights
 * 모든 트럭이 다리를 건너려면 최소 몇 초?
 */

public class Pro_다리를지나는트럭 {

	static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
//        현재 다리에 있는 트럭들의 무게의 합
        int sum = 0;
        for(int i : truck_weights) {
        	while(true) {
        		if(q.isEmpty()) {
        			q.offer(i);
        			sum += i;
        			answer++;
        			break;
//        			큐 사이즈와 다리 길이가 같다면 맨 처음 버스가 다리 앞부분에 온것.-> 빼주기
        		}else if(q.size()==bridge_length) {
        			sum -= q.poll();
        		}else {
//        			다리의 무게가 기준 무게보다 높을 때, 0을 더해서 큐 길이를 늘림
        			if(sum + i > weight) {
        				q.add(0);
        				answer++;
        			}else {
        				q.add(i);
        				sum += i;
        				answer++;
        				break;
        			}
        		}
        	}
        }
        
//        answer+다리에 남아있는 트럭들
        return answer+bridge_length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

}
