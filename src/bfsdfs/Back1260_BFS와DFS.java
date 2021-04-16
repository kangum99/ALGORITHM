package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1260 Dfs와 Bfs
 
//- 노드2에 연결된 노드들을 모두 보고 싶다 → 인접리스트
//- 노드2와 노드3이 연결되어있는지 확인하고 싶다 → 인접행렬

public class Back1260_BFS와DFS {
	
	private static int N, M, V;
//	private static int[][] arr;
	private static boolean[] tf;
	private static StringBuilder sb = new StringBuilder();
	private static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	
	private static void dfs(int v) {
		sb.append(v + " ");
		tf[v] = true;
		
//		인접리스트 사용
		for(int i : list.get(v)) {
//			i에 간적 없으면 재귀돌리기
			if(tf[i] == false) dfs(i);
		}
		
//		인접행렬 사용
//		for (int i = 1; i < N+1; i ++) {
////			간적 없는 노드이고, 그 노드에 간선이 존재 할 때
//			if(tf[i] == false && arr[v][i] == 1) {
//				dfs(i);
//			}
//		}
	}
	
	private static void bfs(int v) {
		tf[v] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		
		while (!q.isEmpty()) {
			int num = q.poll();
			sb.append(num+ " ");
			
//			인접리스트 사용
			for(int i : list.get(num)) {
//				i에 간적 없으면 재귀돌리기
				if(tf[i] == false) {
					q.add(i);
					tf[i] = true;
				}
			}
			
//			인접행렬
//			for (int i = 1; i < N+1; i++) {
////				간적 없는 노드이고, 그 노드에 간선이 존재 할 때
//				if (tf[i] == false && arr[num][i] == 1) {
//					q.add(i);
//					tf[i] = true;
//				}
//			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
//		arr = new int[N+1][N+1];
		tf = new boolean[N+1];
		
//		리스트안에 리스트 초기화
		for(int i = 0; i <N+1; i++){
			list.add(new ArrayList<Integer>());
		}

			
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
//			양방향이기 때문에
//			arr[a][b] = 1;
//			arr[b][a] = 1;
			list.get(a).add(b);		
			list.get(b).add(a);
		}
		
//		갈 수 있는 노드가 여러 개일때는 오름차순으로 정한다.
		for(int i = 1; i < N+1; i++ ) Collections.sort(list.get(i));
		
		dfs(V);
		sb.append("\n");
		Arrays.fill(tf, false);
		bfs(V);
		
		System.out.println(sb);
		
	}

}
