package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back14501_퇴사 {
	static int n, max = 0;
	static int[][] tp;
	static void value(int i, int sumP) {
		if(i >= n) {
			max = Math.max(max, sumP);
			return;
		}
		if(i+tp[i][0] <= n) value(i+tp[i][0], sumP+tp[i][1]);
		else value(i+tp[i][0], sumP);
		
		value(i+1, sumP);
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tp = new int[n][2];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				tp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			value(0, 0);
		
		System.out.println(max);
	}

}
