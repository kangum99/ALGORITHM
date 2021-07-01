package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int x;
	int y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Back9205_맥주마시면서걷기 {
	static int t, n;
	static Location[] store;
	static Location festival, home;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			store = new Location[n+2];
			for(int j = 0; j < n+2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				store[j] = new Location(x, y);
				
			}
//			---- 입력 ----
//			bfs
			BFS();
		}
			
	}
	
	static void BFS() {
		Queue<Location> q = new LinkedList<Location>();
		visited = new boolean[n+2];
		home = store[0];
		festival = store[n+1];
		q.add(home);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			Location here = q.poll();
//			도착지점에 온다면
			if(here.equals(festival)) {
				System.out.println("happy");
				return;
			}
			for(int i = 1; i < n+2; i++) {
//				50*20 최대 갈 수 있는 거리 1000보다 작거나 같을 때, 방문하지 않은 경우
				if(!visited[i] && oper(here.x, here.y, store[i].x, store[i].y) <= 1000) {
					visited[i] = true;
					q.add(store[i]);
				}	
			}
		}
		System.out.println("sad");
	}
	
	static int oper (int x, int y, int _x, int _y) {
			return Math.abs(x - _x) + Math.abs(y - _y);
		}
}
