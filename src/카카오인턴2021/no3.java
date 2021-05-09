package 카카오인턴2021;

import java.util.ArrayList;
import java.util.Stack;

public class no3 {
	public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        ArrayList<String> num = new ArrayList<>();
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
        	num.add("O");
        }
        for(int i = 0; i < cmd.length; i++) {
        	String[] str = cmd[i].split("");
        	if(str[0].equals("D")) {
        		k += Integer.parseInt(str[2]);
        		System.out.println(k);
        	}else if(str[0].equals("U")) {
        		k -= Integer.parseInt(str[2]);
        		System.out.println(k);
        	}else if(str[0].equals("C")) {
        		s.add(k);
        		num.remove(k);
        		if(k == num.size()) {
        			k--;
        		}
        		System.out.println(k);
        	}else if(str[0].equals("Z")) {
        		int val = s.pop();
        		num.add(val, "O");
        		if(val <= k) {
        			k++;
        		}
        		System.out.println(k);
        	}
        }
        while(!s.empty()) {
        	int val = s.pop();
        	num.add(val, "X");
        }
        for(String str : num) {
        	answer = answer + str;
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(n, k, cmd));
	}

}
