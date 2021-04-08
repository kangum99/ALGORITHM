package greedy;

import java.util.Arrays;

public class Pro_체육복 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
	 * Level 1
	 * 전체 학생 수 : n
	 * 체육복을 도난 당한 학생들의 번호가 담긴 배열 : lost
	 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 : reserve
	 * 체육수업을 들을 수 있는 학생의 최댓값 return
	 * */
	static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
//        여벌옷을 가진 학생이 도난당한 경우 (참석 가능)
        int lostCase1 = 0;
//        도난 당했지만 여벌옷을 빌린 경우 (참석 가능)
        int lostCase2 = 0;
        
//        여벌옷을 가지고 있는 학생이 도난당한 경우 -> 빌려줄수 없게.
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(lost[i] - reserve[j] == 0) {
        			lostCase1++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
//        도난 당한 학생들을 여벌가지고 있는 학생들 것을 빌려준다
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(Math.abs(lost[i] - reserve[j]) == 1) {
        			lostCase2++;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        answer = n - lost.length + lostCase1 + lostCase2;
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] lost = {3, 1, 2};
		int[] reserve = {2, 4, 3};
		System.out.println(solution(n, lost, reserve));

	}

}
