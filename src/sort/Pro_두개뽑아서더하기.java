package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Pro_두개뽑아서더하기 {
/*
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * Level.1
 * 정수배열 : numbers
 * 서로 다른 인덱스에 있는 두개의 수 뽑아 
 * 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return
 * 1:32 - 1:45
 * */
	static TreeSet<Integer> solution(int[] numbers) {
        TreeSet<Integer> answer = new TreeSet<>();
        for(int i = 0; i < numbers.length; i++) {
        	for(int j = i+1; j < numbers.length; j++) {
        		answer.add(numbers[i]+numbers[j]);
        	} 
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2, 1, 3, 4, 1};
		for(int i : solution(numbers)) {
			System.out.println(i);
		}
	}

}
