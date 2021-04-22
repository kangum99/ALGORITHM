package BF;

public class Pro_소수만들기 {
	
	public static int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
        	for(int j = i+1; j < nums.length; j++) {
        		for(int k = j+1; k < nums.length; k++) {
        			int sum = nums[i]+nums[j]+nums[k];
        			if(check(sum)) answer++;
        		}
        	}
        }
        return answer;
    }
	public static boolean check(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
