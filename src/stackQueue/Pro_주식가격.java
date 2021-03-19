package stackQueue;
import java.util.*;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 * Level.2
 * 주식 가격 : prices
 * 각 주식이 떨어지는 데 걸리는 시간은 몇 초?
 */

//스택으로 틀려서.. 배열로 풀어봄

public class Pro_주식가격 {
	static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
        int sec=0;
//        주식 하나를 그거 이후의 모두와 직접 비교
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
 
            	if(prices[i] <= prices[j]) {
            		sec++;
            	}
            	else {
//            		주식이 떨어진 경우
            		sec++;
            		break;
            	}
            }
            answer[i] = sec;
            sec = 0;
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {1,2,3,2,3};
		for(int i : solution(price)) {
			System.out.println(i);
		}
	}

}
