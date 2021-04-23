package bfsdfs;

import java.util.*;


public class Pro_카카오프렌즈컬러링북 {
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static class node {
    	int x;
    	int y;
    	public node(int x, int y) {
    		this.x = x;
    		this.y = y;
		}
    }
	static boolean[][] visit;
	static Queue<node> q = new LinkedList<node>();
	static int size = 1;
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
      
        visit = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(picture[i][j] != 0 && !visit[i][j]) {
        			size = 1;
        			bfs(picture, i, j, m, n);
        			numberOfArea++;
        			maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
        		}
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

	static void bfs(int[][] pic, int x, int y, int m, int n) {
		q.add(new node(x, y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			node index = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int indexX = index.x + dx[i];
				int indexY = index.y + dy[i];
				
				if(0 <= indexX && indexX < m && 0 <= indexY && indexY < n) {
					if(pic[indexX][indexY] == pic[x][y] && !visit[indexX][indexY]) {
						q.add(new node(indexX, indexY));
						visit[indexX][indexY] = true;
						size++;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
