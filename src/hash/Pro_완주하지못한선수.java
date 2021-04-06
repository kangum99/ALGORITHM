package hash;

import java.util.HashMap;

//https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
//해쉬


public class Pro_완주하지못한선수 {
//	해쉬맵 선언
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static String solution(String[] participant, String[] completion) {
        String answer = "";
//        해쉬맵에 {참가자 : 참가자 중복 수(동명이인 시 숫자++)}넣어주기
		for(String s : participant) {
//			참가자가 없는 경우 값을 넣어라
//			getOrDefault을 사용하면 좋다 ->두줄을 한번에 
			map.put(s, map.getOrDefault(s, 0) + 1);
//        	map.putIfAbsent(s, 0);
////        	그리고 0 -> 1로 한명이 있다는 의미 
//        	map.replace(s, map.get(s)+1);
        }
//		완주자에 대한 value값--
        for(String s : completion) {
        	map.replace(s, map.get(s)-1);
        }
//        참가자에 대한 value값이 1이상인 경우 동명이인이 몇명이든 완주 못한 이름-> 출력
        for(String s : participant) {
        	if(map.get(s) > 0)
        		answer = s;
        }
        
//      여기서 keySet을 굳이 해줘야 하는이유? 
//      entrySet이 더 좋다고는 함-> 난 get만 씀 차이는?
//        for (String key : hm.keySet()) {
//            if (hm.get(key) != 0){
//                answer = key;
//            }
//        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(solution(participant, completion));
	}

}
