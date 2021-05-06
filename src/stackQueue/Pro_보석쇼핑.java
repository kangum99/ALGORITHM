package stackQueue;

import java.util.*;

public class Pro_보석쇼핑 {

	public int[] solution(String[] gems) {
        int start = 0;
        int startPoint = 0;
        int end = gems.length;
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
//        보석의 종류 개수 구하기 위해
        for(String gem : gems) {
            set.add(gem);
        }
        for(int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
            q.add(gems[i]);
            
            while(!q.isEmpty()) {
//            	개수가 늘어나면
                String gem = q.peek();
                int cnt = map.get(gem);
                if(cnt > 1){
                    map.replace(gem, cnt-1);
                    q.poll();
                    start++;
                }else
                    break;
            }
//            end는 결국 최소 개수-> 같은것까지 포함 시키면 최소 start가 아닌 큰 start가 나온다
//            start의 필요성 -> 개수가 같을 때 맨처음꺼
            if(map.size() == set.size() && end > q.size()) {
                end = q.size();
                startPoint = start;
            }
            
        }
//        1부터 시작
        int[] answer = {startPoint+1, startPoint+end};
        return answer;
    }
}
