package bfsdfs;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 * level 3
 * 컴퓨터의 개수 : n
 * 연결에 대한 정보가 담긴 2차원 배열 : computers
 * 네트워크 개수 return
 * 43
 * */

public class Pro_네트워크 {
	static boolean[] visit; 
	static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n]; 
        for (int i = 0; i < n; i++) {
//          방문안된 노드들만
        	if(!visit[i]) {
//        		이어지는 노드들을 visit=true로 바꿈
        		dfs(i, computers, n);
//        		네트워크 하나 생성
        		answer++;
        	}
        }
        return answer;
    }
	static void dfs(int node, int[][] arr, int n) {
		visit[node] = true;
		for(int i = 0; i < n; i++) {
//			방문을 안했고 arr값이 1인 경우
			if(visit[i] == false && arr[node][i] == 1) {
				dfs(i, arr, n);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] computers= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n, computers));
	}

}
