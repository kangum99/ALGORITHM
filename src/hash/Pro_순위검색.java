package hash;


public class Pro_순위검색 {
	static String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
	static String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
	
	public static int[] solution(String[] info, String[] query) {
		String[] infos = new String[info.length];
		int[] scoreInfos = new int[info.length];
		String[] querys = new String[query.length];
		int[] scoreQuerys = new int[query.length];
		int[] answer = new int[query.length];
		
//		info값 바꾸기
		for(int i = 0; i < info.length; i++) {
			String[] temp = new String[5];
			StringBuilder sb = new StringBuilder();
			temp = info[i].split(" ");
			for(int j = 0; j < 4; j++) {
				sb.append(temp[j].charAt(0));
			}
//			"jbjp"
			infos[i] = sb.toString();
//			150
			scoreInfos[i] = Integer.parseInt(temp[4]);
		}
		
//		query값 바꾸기
		for(int i = 0; i < query.length; i++) {
			String[] temp = new String[4];
			StringBuilder sb = new StringBuilder();
			temp = query[i].split(" and ");
			
			for(int j = 0; j < 4; j++) {
//					pizza 100
				if(j == 3) {
					String[] last = temp[j].split(" ");
					sb.append(last[0].charAt(0));

//					100
					scoreQuerys[i] = Integer.parseInt(last[1]);
				}
				sb.append(temp[j].charAt(0));
			}
//			"jbjp"
			querys[i] = sb.toString();
		}
		
//		infos와 querys 비교하기
		for(int i = 0; i < querys.length; i++) {
			for(int j = 0; j < infos.length; j++) {
				boolean tf = true;
				for(int k = 0; k < 4; k++) {
					char qc = querys[i].charAt(k);
					char ic = infos[j].charAt(k);
//					통과 조건들
					if(qc == '-') continue;
					if(qc == ic) continue;
//					한번이라도 안맞으면 false로 바꾸기
					tf = false;
					break;
				}
//				조건이 다 맞을 때
				if(tf) {

//					코테 점수도 통과 했다면?
					if(scoreInfos[j] >= scoreQuerys[i]) answer[i]++;
				}
			}
		}
        return answer;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = solution(info, query);
		for(int i : result) System.out.println(i);
	}

}
