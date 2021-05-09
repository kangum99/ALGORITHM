package 카카오인턴2021;

public class no1 {
	static String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static String temp = "";
	static int isNumber(char c) {
		int n = Character.getNumericValue(c);
		for(int i = 0; i < 10; i++) {
			if(n == i) {
				return n;
			}
		}
		return -1;
	}
	static int isString(String str) {
		for(int i = 0; i < num.length; i++) {
			if(num[i].equals(str)) {
				temp = "";
				return i;
			}	
		}
		return -1;
	}
	public static int solution(String s) {
        String answer = "";
   
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int number = isNumber(c);
        	if(number == -1) {
        		temp = temp + c;
        		int str = isString(temp);
        		if(str == -1)
        			continue;
        		else {
        			answer = answer + str;
        		}
        	}else {
        		answer = answer + number;
        	}
        }
        return Integer.parseInt(answer);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2three45sixseven";
		System.out.println(solution(s));
	}

}
