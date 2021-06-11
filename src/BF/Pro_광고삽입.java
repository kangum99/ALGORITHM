package BF;

public class Pro_광고삽입 {
	
	static String play_time = "02:03:55", adv_time = "00:14:15";
	static String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};	
	static int[] time;
	static long max = 0;
	static int maxStartIndex = 0;
	static int logsSec[][];
	
	static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSecTime(play_time);
        time = new int[playTime+1];
        int advTime = toSecTime(adv_time);
        logsSec = new int[logs.length][2];
		toSecLog(logs);
		
//		logs에 따라서 time에 ++ 카운트 해주기
		for(int i = 0; i < logs.length; i++) {
			int start = logsSec[i][0];
			int end = logsSec[i][1];
			for(int j = start; j < end; j++) {
				time[j]++;
			}
			
		}
		
//		만약 시작이 0일때를 먼저 구해서 max에 넣어주기 (max의 최소값)
//		-> 그렇지 않으면 0번째가 max일때를 구하지 못함 (0<값)
		long sum = 0;
		for(int j = 0; j < advTime; j++) {
			sum += time[j];		
		}
		
		max = sum;
//		투포인터 이용 (i = start, i+advTime = end)
//		투포인터 이용안하고 for문으로 sum을 매번 구해주면 시간초과
		for(int i = 0; i < time.length; i++) {
//			i+advTime이 인덱스 값을 벗어 났을 때
			if(i+advTime > (time.length-1)) break;
			sum -= time[i];
			sum += time[i+advTime];
			if(max < sum) {
				max = sum;
				maxStartIndex = i+1;
			}
		}
		
		int hour = (maxStartIndex / 60) / 60;
		int min = (maxStartIndex / 60) % 60;
		int sec = maxStartIndex % 60;
//		2개의 숫자(없으면 0채워라)
		String answer = String.format("%02d:%02d:%02d", hour, min, sec);
        return answer;
    }
	
//	time -> 초
	static int toSecTime(String time) {
		String[] temp = time.split(":");
		return Integer.parseInt(temp[0])*60*60
				+Integer.parseInt(temp[1])*60
				+Integer.parseInt(temp[2]);
	}
	
//	logs -> 초
	static void toSecLog(String[] logs) {
		for(int i = 0; i < logs.length; i++) {
			String[] temp = logs[i].split("-");
			logsSec[i][0] = toSecTime(temp[0]);
			logsSec[i][1] = toSecTime(temp[1]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(play_time, adv_time, logs));
	}

}
