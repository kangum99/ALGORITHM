package algorithm;

import java.util.Arrays;

public class One {
	
	public static int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int j = discounts.length-1;
        for(int i = prices.length-1; i >= 0; i--) {
        	if(j < 0) {
        		answer += prices[i];
        		continue;
        	}
        	double price = discounts[j]/100.0;
        	price *= prices[i];
        	price = prices[i]-price;
        	answer += price;
        	j--;
        	
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {13000, 88000, 10000};
		int[] discounts = {30, 20};
		System.out.println(solution(prices, discounts));
	}

}
