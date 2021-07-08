package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Three {
	public static int solution(String s, String t) {
        int result = 0;
        Queue<String> q = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        q.add(s);
        String temp = "";
        while(!q.isEmpty()) {
        	temp = q.poll();
        	for(int i = 0; i < temp.length()-t.length(); i++) {
        		StringBuilder sb2 = new StringBuilder();
        		for(int j = 0; j < t.length(); j++) {
        			sb2.append(temp.charAt(i+j));
        		}
        		String str = String.valueOf(sb2);
        		if(str.equals(t)) {
        			result++;
        			sb.delete(i, i+t.length());
        			System.out.println(sb);
        			String str2 = String.valueOf(sb);
        			q.add(str2);
        			break;
        		}
        	}
        }
        if(temp.equals(t)) return result+1;
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaabbbbb";
		String t = "ab";
		System.out.println(solution(s, t));
	}

}
