package bfsdfs;

import java.util.ArrayList;
public class Pro_수식최대화 {
//	수식을 넣기
	static ArrayList<Long> list = new ArrayList<Long>();
	static ArrayList<String> oper = new ArrayList<String>();
	static ArrayList<String> op = new ArrayList<String>();
//	우선순위에 맞는 순열 넣을 배열
	static String[] pre = new String[3];
	static boolean[] visit = new boolean[3];
	static long max = 0; 
	
	static long solution(String expression) {
//		식 나누기
        divString(expression);

        dfs(0, op.size());
        return max;
    }
	static void dfs(int index, int r) {
		if(index == r ) {
//			(우선순위)에 맞게 계산
			sol();
			return;
		}else {
			for(int i = 0; i < r; i++) {
//				op순열 (우선순위)
				if(!visit[i]) {
					visit[i] = true;
					pre[index] = op.get(i);
					dfs(index+1, r);
					visit[i] = false;
				}
			}
		}
	}
	static void sol() {
//		계산을 위한 copy
		ArrayList<Long> num = new ArrayList<Long>();
		num.addAll(list);
		ArrayList<String> operation = new ArrayList<String>();
		operation.addAll(oper);
		
//		우선순위에 맞게 계산
		for(int i = 0; i < pre.length; i++) {
			for(int j = 0; j < operation.size(); j++) {
				if(pre[i].equals(operation.get(j))) {
					long n = num.get(j);
					long m = num.get(j+1);
//					사칙연산
					long ans = cal(n, m, operation.get(j));
					
					num.remove(j+1);
					num.remove(j);
					
					operation.remove(j);
					
					num.add(j, ans);
					j--;
					
				}
			}
		}
		long answer = Math.abs(num.get(0));
		System.out.println(answer);
		max = Math.max(max, answer);
	}
	
	static long cal(long n, long m, String operation) {
		if(operation.equals("+") ) {
			return n+m;
		}else if(operation.equals("-") ) {
			return n-m;
		}else {
			return n*m;
		}
	}
	
	static void divString (String expression) {
		int point = 0;
//		들어있는 연산들의 배열 : op
		if (expression.contains("+")) {
        	op.add("+");
		}
        if (expression.contains("-")) {
        	op.add("-");
        }
        if (expression.contains("*")) {
        	op.add("*");
        }
//        숫자, 연산자 배열 : list, oper
        for(int i = 0; i < expression.length(); i++) {
        	Character c = expression.charAt(i);
        	
        	if(c=='+' || c=='-' || c=='*') {
        		oper.add(c+"");
        		String num = expression.substring(point, i);
        		list.add(Long.parseLong(num));
        		point = i+1;
        	}
        }
        String num = expression.substring(point, expression.length());
        list.add(Long.parseLong(num));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "50*6-3*2";
		
		System.out.println(solution(s));
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		System.out.println(oper);
		System.out.println(op);
	}

}
