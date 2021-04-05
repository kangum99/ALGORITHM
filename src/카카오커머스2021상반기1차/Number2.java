package 카카오커머스2021상반기1차;
import java.util.*;
public class Number2 {
	
	static int solution(int[][] needs, int r) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
        int[] cnt = new int[r];
        int[] robot = new int[r-1];
//        부품 카운트
        for(int i = 0; i < needs.length; i++){
        	set.add(new ArrayList<Integer>());
        	ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < r; j++) {
            	if(needs[i][j]==1) {
            		cnt[j]++;
            		list.add(j);
            	}
            }
            set.add(list);
        }
//        1번째, 2번째 큰거
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i : cnt) {
        	pq.add(i);
        }
        for(int i = 0; i < r-1; i++) {
        	robot[i]=pq.poll();
        }
     
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] needs = {{1, 0, 0}, {1, 1, 0},{1, 1, 0},{1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
		System.out.println(solution(needs, 2));
	}

}
