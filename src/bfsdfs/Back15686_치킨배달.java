package bfsdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Index {
    int x;
    int y;
 
    Index(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Back15686_치킨배달 {
    static int N, M;
    static int[][] map;
    static ArrayList<Index> house;
    static ArrayList<Index> chicken;
    static int ans;
    static boolean[] open;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
 
        // 집, 치킨집 좌표 각각의 ArrayList에 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
 
                if (map[i][j] == 1) {
                    house.add(new Index(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Index(i, j));
                }
            }
        }
 
        ans = Integer.MAX_VALUE;
//        그 치킨집이 열었는지 아닌지
        open = new boolean[chicken.size()];
 
//        재귀 돌리기
        dfs(0, 0);
        System.out.println(ans);
    }
 
    public static void dfs(int start, int cnt) {
//    	적정 치킨집 개수가 주어진 M과 같으면 재귀 나오기
        if (cnt == M) {
            int res = 0;
 
            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
 
                // 집과 치킨집의 최소 거리 구하고 -> 최소값 찾기
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);
 
                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
        }
 
        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
//            dfs(1, 1)-> dfs(1, 2)-> dfs(1, 3)
            dfs(i + 1, cnt + 1);
//            open[i]초기화
            open[i] = false;
        }
    }
 
}
