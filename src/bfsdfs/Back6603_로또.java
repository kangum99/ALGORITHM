package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back6603_로또 {
	static int n;
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			visit = new boolean[n];
			
			if(n == 0) break;
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Dfs(0,0);
			System.out.println();
		}

	}
	
	static void Dfs(int N, int R) {
		if(R == 6) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < N; j++) {
				if(visit[j])
					sb.append(arr[j] + " ");
			}
			System.out.println(sb);
		}
		for(int i = N; i < n; i++) {
			visit[i] = true;
			Dfs(i+1, R+1);
			visit[i] = false;
		}
	}

}
