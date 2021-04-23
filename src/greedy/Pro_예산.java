package greedy;

import java.util.Arrays;

public class Pro_예산 {
	public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i : d) {
        	answer += i;
        	if(i == budget) break;
        	else if(i > budget) {
        		answer -= i;
        		break;
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
