package 카카오인턴2021;

public class no2 {
	static boolean[][] visit = new boolean[5][5];
	static int[] answer = new int[5];
	
	public static int[] solution(String[][] places) {
        for(int i = 0; i < 5; i++) {
        	char[][] temp = {};
//        	초기화
        	for(int j = 0; j < 5; j++) {
        		for(int k = 0; k < 5; k++) {
        			temp[j][k] = places[i][j].charAt(k);
        		}
        	}
        	
        	for(int j = 0; j < 5; j++) {
        		for(int k = 0; k < 5; k++) {
        			visit[j][k] = true;
        			dfs(temp, i, 0, 0, 0, 0);
        			if(answer[i] == 1) break;
        		}
        		if(answer[i] == 1) break;
        	}
        	visit = new boolean[5][5];
        }
        return answer;
    }
	static void dfs(char[][] temp, int i, int j, int k, int row, int col) {
		if(isIn(j, k, row, col) && visit[row][col] == false) {
			visit[row][col] = true;
			if(temp[row][col] == 'P') {
				answer[i] = 1;
				return;
			}else if(temp[row][col] == 'O') {
				dfs(temp, i, j, k, row+1, col);
				dfs(temp, i, j, k, row+1, col+1);
			}
		}
		
	}
	static boolean isIn(int j, int k, int row, int col) {
		int n = Math.abs(j-row) + Math.abs(k-col);
		if(n > 2) return false;
		else return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
