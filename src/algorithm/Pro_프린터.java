package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_프린터 {
	
//	public static int solution(int[] priorities, int location) {
//        int answer = 0;
//        int maxIndex = 0;
//
//        Queue<ArrayList<Integer>> q= new LinkedList<ArrayList<Integer>>();
//        for(int i = 0; i < priorities.length; i++) {
//        	ArrayList<Integer> list = new ArrayList<Integer>();
//        	list.add(priorities[i]);
//        	list.add(i);
//        	q.add(list);
//        }
//        Integer boxed[] = Arrays.stream(priorities).boxed().toArray(Integer[]::new); 
//        Arrays.sort(boxed, (o1,o2)->o2-o1);
//        for(Integer i : boxed) System.out.println(i);
//        while(!q.isEmpty()) {
//        	ArrayList<Integer> n = q.poll();
//               	if(boxed[maxIndex] == n.get(0)) {
//        		answer++;
//        		maxIndex++;
//        		if(location == n.get(1)) break;
//        	}else {
//        		q.add(n);
//        	}
//        }
//        return answer;
//    }
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;
        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }
        return answer;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 1, 3, 2};
		System.out.println(solution(a, 2));
	}

}
