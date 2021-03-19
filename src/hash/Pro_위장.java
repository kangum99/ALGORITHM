package hash;
import java.util.*;

public class Pro_위장 {
//	https://programmers.co.kr/learn/courses/30/lessons/42578 -위장
	/*
	 * 해쉬
	 * 서로 다른 옷의 조합 구하기
	 1. yellow_hat
	 2. blue_sunglasses
	 3. green_turban
	 4. yellow_hat + blue_sunglasses
	 5. green_turban + blue_sunglasses*/
	public int solution(String[][] clothes) {
        int answer = 1;
//        해쉬맵 선언 {옷의 종류 : 그 종류에 포함되는 옷의 개수}
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i ++) {
//        	getOrDefault : 값이 없으면 값을 넣고나서 가져오고 있으면 들어있는 값을 가져와라
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
//         각 옷을 안입을 경우 +1
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue()+1);
        }
//         옷을 아무것도 안입을 경우 -1
        return answer-1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
