package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7569-토마토(BFS)

public class Back7569_토마토{

	static int[][][] arr;
	static int M, N, H, day, count;
//	우, 상, 위, 좌, 하, 아래
	static int[] dx = { 1, 0, 0, -1, 0, 0 };
	static int[] dy = { 0, 1, 0, 0, -1, 0 };
	static int[] dz = { 0, 0, 1, 0, 0, -1 };
	static boolean all1 = true;

	static void bfs() {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qz = new LinkedList<Integer>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 1) {
						count--;
						qx.add(k);
						qy.add(j);
						qz.add(i);
					} else if (arr[i][j][k] == -1)
						count--;
				}
			}
		}
		while (!qx.isEmpty() && !qy.isEmpty() && !qz.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			int z = qz.poll();

			for (int i = 0; i < 6; i++) {
				int _x = x + dx[i];
				int _y = y + dy[i];
				int _z = z + dz[i];
				if (_x >= 0 && _y >= 0 && _z >= 0 && _x < M && _y < N && _z < H) {
					if (arr[_z][_y][_x] == 0) {
						arr[_z][_y][_x] = arr[z][y][x] + 1;
						day = arr[z][y][x];
						qx.add(_x);
						qy.add(_y);
						qz.add(_z);
						count--;
					}
				}

			}
		}
		if(count == 0)
			System.out.println(day);
		else if(count > 0)
			System.out.println(-1);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];
		count = N * M * H;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(str.nextToken());
//					모두 익은것인지 확인
					if (arr[i][j][k] == 0)
						all1 = false;
				}
			}
		}

		if (all1 == true)
			System.out.println(0);
		else
			bfs();

	}

}
