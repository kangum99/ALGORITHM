package heap;
import java.util.*;

public class Pro_디스크컨트롤러 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42627
	 * Level.3
	 * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 : jobs
	 * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return
	 * 소수점 이하는 버림 
	 */

	static int solution(int[][] jobs) {
        int answer = 0;
//        시간
        int time = 0;
//        하나의 작업이 끝나는 시간
        int endtime = 0;
//        수행한 작업 개수
        int count = 0;
//        오른차순(요청시간 기준)
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
//       힙으로 정렬 오름차순(작업량 기준)
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
        
        while(count < jobs.length) {
//        	하나의 작업이 끝나는 시점까지의 작업을 q에 넣는다
        	while (time < jobs.length && jobs[time][0] <= endtime) q.add(jobs[time++]);
//        	더이상 q에 아무것도 없다면 조금 뒤(작업이 안겹침)에 있는 것
        	if (q.isEmpty()) endtime = jobs[time][0];
//        	작업이 끝나기 전에 들어온 것중에 작업량이 젤 짧은 요청부터
        	else {
        		int[] temp = q.poll();
        		answer += temp[1] + endtime - temp[0];
        		endtime += temp[1];
        		count++;
        	}
        	
        }
//        소수점 버림
        return (int) Math.floor(answer/jobs.length);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(jobs));
	}

}
