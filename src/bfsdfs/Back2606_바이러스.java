package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2606 BFS, DFS (바이러스)

public class Back2606_바이러스 {
	
	static int n, m, cnt = 0;
	static int[][] arr;
	static boolean[] check;
	
//	static int dfs(int v) {
//		check[v] = true;
//		
//		for (int i = 1; i < n+1; i++) {
//			if(arr[v][i] == 1 && check[i] == false) {
//				dfs(i);
//				cnt++;
//			}
//		}
//		return cnt;
//	}
	static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		check[1] = true;
		q.add(1);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i = 1; i < n+1; i++) {
				if(arr[num][i]==1 && check[i] == false) {
					q.add(i);
					check[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][n+1];
		check = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
//		System.out.println(dfs(1));
		System.out.println(bfs());
	}

}
