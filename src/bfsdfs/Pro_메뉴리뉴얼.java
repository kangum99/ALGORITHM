package bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Pro_메뉴리뉴얼 {
	static String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
	static int[] course = {2, 3, 4};
//	각 코스메뉴의 개수 마다 나오는 조합을 사람들이 먹은 경우
	static HashMap<String, Integer> map;
//	result를 넣을 리스트
	static ArrayList<String> list = new ArrayList<String>();
	static int max = 0;

	static String[] solution(String[] orders, int[] course) {
		for(int i = 0; i < course.length; i++ ) {
//			매 코스 요리 개수 마다 초기화
			map = new HashMap<String, Integer>();
			max = 0;
			
//			조합하기
			for(int j = 0; j < orders.length; j++) {
				comb(0, 0, "", course[i], orders[j]);
			}
			
			for(String s : map.keySet()) {
//				값이 max여야 하고, max값이 2명이상 먹은 메뉴여야 하기 때문에 1초과
				if(map.get(s) == max && max > 1) {
					list.add(s);
				}
			}
		}
		
//		사전순 이기 때문에
		Collections.sort(list);
		
//		String 배열에 넣기
		String[] answer = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
        return answer;
    }
	
//	조합 DFS, temp = 조합된 알파벳을 붙여놓은 것
	static void comb(int n, int r, String temp, int course, String menu) {
//		메뉴 개수와 뽑은 개수가 같을 때 
		if(r == course) {
			char[] c = temp.toCharArray();
//			정렬을 하는 이유 : 각각의 메뉴가 조합되었을 때 해당 key에 value를 넣어야 하는데
//			key가 WX, XW를 다르게 봐서 따로 숫자를 카운트하는 상황을 없애기 위해
			Arrays.sort(c);
			String temps = "";
			for(int i = 0; i < c.length; i++) {
				temps += c[i];
			}
			map.put(temps, map.getOrDefault(temps, 0) + 1);
			max = Math.max(max, map.get(temps));
			return;
		}
		
//		조합
		for(int i = n; i < menu.length(); i++) {
			char c = menu.charAt(i);
			comb(i+1, r+1, temp + c, course, menu);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = solution(orders, course);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
