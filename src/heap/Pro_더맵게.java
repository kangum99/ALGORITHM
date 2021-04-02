package heap;
import java.util.*;

public class Pro_더맵게 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 * Level.2
	 * 음식의 스코빌 지수를 담은 배열 : scoville
	 * 원하는 스코빌 지수 : K
	 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	 * 모든 음식이 스코빌 지수를 K이상으로 만드기 위해 섞어야 하는 최소 횟수
	 * 모든 음식을 K이상 못할때 -> -1
	 */

	static int solution(int[] scoville, int K) {
		int answer = 0;
//        우선순위 큐 선언(힙)
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
//        큐에 값 넣기
        for(int i : scoville) {
        	q.offer(i);
        }
//        큐가 1개가 아니라면
        while(q.size() != 1) {
//        	젤 작은 스코빌
        	int a = q.poll();
//        	최소 스코빌이 K이상일때
        	if(a >= K) return answer;
        	else {
//        		두번째 작은 스코빌
        		int b = q.poll();
//        		섞은 스코빌
        		int c = a+(b*2);
        		q.offer(c);
        	}
//        	섞는 횟수 ++
        	answer++;
        }
//        하나 남았을 때 K 이상이면 섞은 횟수 아니면 -1
        if(q.poll() >= K) return answer;
        else return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}

}
