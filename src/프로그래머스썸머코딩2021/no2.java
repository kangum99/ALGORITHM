package 프로그래머스썸머코딩2021;

import java.util.ArrayList;

public class no2 {
	public static int[] solution(int[] t, int[] r) {
//		리프트
		int num = 0;
//		사람수
		int cnt = 0;
		int[] answer = new int [t.length];
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(cnt < t.length) {
			for(int i = 0; i < t.length; i++) {
				if(num == t[i]) {
					list.add(i);
				}
			}
			System.out.println(list.size());
			if(!list.isEmpty()) {
				int min = 10;
				int id = -1;
				for(int i = 0; i < list.size(); i++) {
					if(min > r[list.get(i)]) {
						id = i;
						min = r[list.get(i)];
						System.out.println(min);
					}
				}
				list.remove(id);
				answer[cnt] = min;
				System.out.println("answer["+cnt+"]= "+answer[cnt]);
				num++;
				cnt++;
			}
			else {
				num++;
			}
		}
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = {0, 1, 3, 0};
		int[] r = {2, 1, 4, 0};
		System.out.println(solution(t, r));
	}

}
