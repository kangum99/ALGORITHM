//https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
//2022 KAKAO BLIND RECRUITMENT

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, HashSet<Integer>> map2 = new HashMap<>();
        int[] answer = new int[id_list.length];
				
		//id_list의 index값을 map1에 넣어주기
        for (int i = 0; i < id_list.length; i++) {
            map1.put(id_list[i], i);
        }
        
        for(String s : report) {
            String[] id = s.split(" ");
			//set을 이용한 이유는 한명이 한사람을 여러번 신고했을 때는 한번으로 처리하기 위해
            map2.computeIfAbsent(id[1], v -> new HashSet<>()).add(map1.get(id[0]));
        }
        
        for(String id : id_list) {
			//id가 없을 수 있음-> 신고 안당했다면
            if(map2.containsKey(id) && map2.get(id).size() >= k) {
                for(int i : map2.get(id)){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
