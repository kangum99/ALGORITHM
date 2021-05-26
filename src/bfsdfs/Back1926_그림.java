package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Back1926_그림 {
	
	static boolean[][] visited;
	static int maxArea = 0;
	static int drawCnt = 0;
	static int m, n;
	static int[][] map;
//	상하좌우
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[m][n];
		map = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visited[i][j])
					bfs(i, j);
			}
		}
		System.out.println(drawCnt);
		System.out.println(maxArea);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		int area = 1;
		drawCnt++;
		q.add(new Node(x, y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i = 0; i < 4; i++) {
				int _x = dx[i] + node.x;
				int _y = dy[i] + node.y;
				
				if(_x < 0 || _y < 0 || _x >= m || _y >= n) continue;
				if(visited[_x][_y] || map[_x][_y] == 0) continue;
				
				q.add(new Node(_x, _y));
				visited[_x][_y] = true;
				area++;
//				System.out.println(_x+" , "+_y + " = " + area);
			}	
		}
		maxArea = Math.max(maxArea, area);
	}

}
