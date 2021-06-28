package string;

public class Pro_1차다트게임 {
	static int[] num = new int[3];
	
	public static int solution(String dartResult) {
//		숫자의 개수를 구한뒤 각각 배열에 넣기
		int cnt = 0;
		for(int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if(Character.isDigit(c)) {
				System.out.println(c);
				if(Character.isDigit(dartResult.charAt(i+1))) {
					num[cnt] = 10;
					i++;
				}else {
					num[cnt] = Character.getNumericValue(c);
				}
				cnt++;
			}
		}
		
//		1앞에 아무것도 없기때문에 bonus[0]="" 1, 2사이 S bonus[1] = "S"
		String[] bonus = dartResult.split("[0-9]");
		for(int i = 1; i < bonus.length; i++) {
			if(bonus[i].length() == 0) continue;
			if(bonus[i].length() == 1) {
				oper(bonus[i], i);
			}else {
//				S, D, T
				oper(bonus[i].charAt(0)+"", i);
//				*, #
				oper(bonus[i].charAt(1)+"", i);
			}
		}
        int answer = 0;
        for(int i = 0; i < num.length; i++) {
        	answer += num[i];
        }
        return answer;
    }
	
	static void oper(String s, int i) {
//		숫자 배열의 위치
		int index = i-1;
		switch (s) {
			case "S":
				break;
			case "D":
				num[index] = (int)Math.pow(num[index], 2);
				break;
			case "T":
				num[index] = (int)Math.pow(num[index], 3);
				break;
			case "*":
				if(index == 0) {
					num[index] *= 2;
				}else {
					num[index] *= 2;
					num[index-1] *= 2;
				}
				break;
//			"#"
			default:
				num[index] *= -1;
				break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dartResult = "1D2S#10S";
		System.out.println(solution(dartResult));

	}

}
