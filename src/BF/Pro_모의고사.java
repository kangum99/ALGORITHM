package BF;

import java.util.ArrayList;

public class Pro_모의고사 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42840
	 * Level.1
	 * 1번 문제 부터 마지막 문제까지의 정답이 순서대로 들은 배열 : answers
	 * 가장 많은 문제를 맞힌 사람이 누구인지?-> 여럿일 경우 오름차순 return
	 */
	
	static ArrayList<Integer> solution(int[] answers) {
	    int[] one = {1, 2, 3, 4, 5};
	    int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
	    int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	    int[] stu = new int[3];
//		반복되는 부분의 개수로 나눠서 나머지값을 넣어주기
	    for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5])
                stu[0]++;
            if(answers[i] == two[i%8])
                stu[1]++;
            if(answers[i] == three[i%10])
                stu[2]++;
        }
//	    max값 찾기
	    int max= Math.max(stu[0], Math.max(stu[1], stu[2]));
//	    리스트 선언-> 1개면 1개만 나와야 하므로 list가 좋음
	    ArrayList <Integer> list = new ArrayList<>();
//	    max값이랑 같은 stu를 list에 넣어주기
	    for(int i = 0; i < 3; i++) {
//	    	오름차순으로 넣어주기 
	        if(max == stu[i]) {
	            list.add(i+1);
	        }
	    } 
	    return list; 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = {1, 3, 2, 4, 2};
		ArrayList<Integer> solution = solution(answers);
		for(int i : solution)
			System.out.println(i);
	}

}
