package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Nodes implements Comparable<Nodes> {
	int end, weight;

	public Nodes(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

//	오름차순(가중치가 작은 거 우선순위 큐)
	@Override
	public int compareTo(Nodes o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}
	
} 

public class Back1916_최소비용구하기 {
	
	static int N, M, INF = 100000000;
	static ArrayList<Nodes>[] list;
	static int[] dist;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
//		1부터 시작
		list = new ArrayList[N+1];
		dist = new int[N+1];
//		무한대로 초기화
		Arrays.fill(dist, INF);
//		list 초기화
		for(int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Nodes>();
		}
//		리스트에 그래프 정보 넣기(간선 수에 따라)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
//			s->e로 가는 w의미
			list[s].add(new Nodes(e, w));
		}
		
		 st = new StringTokenizer(br.readLine());
	     int start = Integer.parseInt(st.nextToken());
	     int end = Integer.parseInt(st.nextToken());
	     
	     dijkstra(start);
//	     해당 end에 맞는 값만
	     System.out.println(dist[end]);

	}
	
	static void dijkstra(int start) {
		PriorityQueue<Nodes> q = new PriorityQueue<Nodes>();
		boolean[] check = new boolean[N+1];
		q.add(new Nodes(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Nodes node = q.poll();
			int here = node.end;

//			방문한거라면
			if(check[here] == true) continue;
			check[here] = true;
			
			for(Nodes n : list[here]) {
//				기존 값보다 지금 값과 가중치를 더한 값이 작다면
				if(dist[n.end] > dist[here] + n.weight) {
					dist[n.end] = dist[here] + n.weight;
					q.add(new Nodes(n.end, dist[n.end]));
				}
			}
		}
	}

}
