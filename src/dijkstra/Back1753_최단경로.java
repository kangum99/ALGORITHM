package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end, weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

//	오름차순(가중치가 작은 거 우선순위 큐)
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}
	
} 

public class Back1753_최단경로 {
	
	static int V, E, K, INF = 100000000;
	static ArrayList<Node>[] list;
	static int[] dist;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
//		1부터 시작
		list = new ArrayList[V+1];
		dist = new int[V+1];
//		무한대로 초기화
		Arrays.fill(dist, INF);
//		list 초기화
		for(int i = 1; i < V+1; i++) {
			list[i] = new ArrayList<Node>();
		}
//		리스트에 그래프 정보 넣기(간선 수에 따라)
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
//			s->e로 가는 w의미
			list[s].add(new Node(e, w));
		}
		
//		K에서 시작하는 다익스트라
		dijkstra(K);

//		출력부
		StringBuilder sb = new StringBuilder();
//		각 도착지마다 최소 거리
		for(int i = 1; i < V+1; i++) {
			if(dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		boolean[] check = new boolean[V+1];
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int here = node.end;

//			방문한거라면
			if(check[here] == true) continue;
			check[here] = true;
			
			for(Node n : list[here]) {
//				기존 값보다 지금 값과 가중치를 더한 값이 작다면
				if(dist[n.end] > dist[here] + n.weight) {
					dist[n.end] = dist[here] + n.weight;
					q.add(new Node(n.end, dist[n.end]));
				}
			}
		}
	}

}
