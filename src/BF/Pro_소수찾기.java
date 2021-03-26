package BF;

import java.util.HashSet;
//궁금한점: 프로그래머스는 왜 public인가... IDE에서는 private static인데

public class Pro_소수찾기 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42839
	 * Level.2
	 * 각 종이 조각에 적힌 숫자가 적힌 문자열 : numbers
	 * 
	 */
	private static int cnt = 0;
    private static String[] s;
    private static String[] result;
    private static boolean[] visit;
    private static HashSet<Integer> set;
    
    static int solution(String numbers) {
        visit = new boolean[numbers.length()];
        s = new String[numbers.length()];
        s = numbers.split("");
        
        set = new HashSet();
        for(int i = 1; i <= numbers.length(); i++){
            result = new String[i];
            cycle(0, i, numbers.length());
        }
        return set.size();
    }
    static void cycle (int start, int end, int length) {
        if(start == end) {
            checkPrime();
        }else{
            for(int i = 0; i < length; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    result[start] = s[i];
                    cycle(start+1, end, length);
                    visit[i] = false;
                }
            }
        }
    }
//    소수 체크
    static void checkPrime() {
        String str = "";
        for(int i = 0; i < result.length; i++)
            str += result[i];
        int num = Integer.parseInt(str);
        
        if(num == 1|| num == 0)
            return;
        boolean flag = false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                flag = true;
        }
        if(!flag)
            set.add(num);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "17";
		System.out.println(solution(numbers));
	}

}
