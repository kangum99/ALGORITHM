package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Two {
	static String[] answer;
	public static String[] solution(String s) {
		ArrayList<String> list = new ArrayList<String>();
		String front = "";
		String back = "";
		String temp = "";
		Queue<String> q = new LinkedList<String>();
		q.add(s);
		a:
		while(!q.isEmpty()) {
			temp = q.poll();
			int j = temp.length()-1;
			for(int i = 0; i < temp.length()/2; i++) {
				front += temp.charAt(i);
				back = temp.charAt(j)+ back;
				System.out.println(front +" "+ back);
				if(front.equals(back)) {
					list.add(front);
					temp = temp.substring(i+1, j);
					if(temp.equals(""))
						break a;
					System.out.println(temp);
					q.add(temp);
					break;
				}
				j--;
			}
			front = "";
			back = "";
		}
		boolean check = false;
		if(list.isEmpty()) {
			answer = new String[1];
			answer[0] = s;
		}else {
			if(!temp.equals("")) {
				list.add(temp);
				check = true;
			}
			if(check) {
				answer = new String[list.size()*2-1];
				int k = list.size()-2;
				for(int i = 0; i < answer.length; i++) {
					if(i <= answer.length/2) {
						answer[i] = list.get(i);
					}else {
						answer[i] = list.get(k);
						k--;
					}
				}
			}else {
				answer = new String[list.size()*2];
				int k = list.size()-1;
				for(int i = 0; i < answer.length; i++) {
					if(i < answer.length/2) {
						answer[i] = list.get(i);
					}else {
						answer[i] = list.get(k);
						k--;
					}
				}
			}
			
		}
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcxyqwertyxyabc";
		System.out.println(solution(s));

	}

}
