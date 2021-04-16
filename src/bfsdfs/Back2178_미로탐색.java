package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2178 BFS(미로탐색- 최단 거리 탐색)

public class Back2178_미로탐색 {
	
	static int[][] arr;
	static int N, M;
	static boolean[][] check;
//	하(0 , 1) 우(1, 0) 상(0, -1) 좌(-1, 0)
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	
	static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.add(x);
		qy.add(y);
		check[x][y] = true;
		
		while (!qx.isEmpty() && !qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
//			상하좌우로 비교하기 갈수 있는 곳이 있는지
			for(int i = 0; i < 4; i++) {
//				하(0 , 1) 우(1, 0) 상(0, -1) 좌(-1, 0)
				int _x = x + dx[i];
				int _y = y + dy[i];
				
				if(_x >= 0 && _y >= 0 && _x < N && _y < M) {
					if(arr[_x][_y] == 1 && check[_x][_y] == false) {
						qx.add(_x);
						qy.add(_y);
						check[_x][_y] = true;
//						방문했던 칸들의 숫자를 계속 더해준다
						arr[_x][_y] = arr[x][y] + 1; 
					}
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}

}
