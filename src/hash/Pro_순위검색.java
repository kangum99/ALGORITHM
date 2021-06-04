package hash;

import java.util.*;

public class Pro_순위검색 {
	static String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
	static String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

	/*
	 * 처음 했던 코드 대로 하면 최대원소갯수라고 했을 때가 5만 * 1만 이므로 굉장히 느려진다.. 
	 * 조합표를 만들어서 계산하는 게 훨씬 빠르다 4*3*3*3
	 * 또한 순차 탐색은 느리다 sort() 
	 * 그래서 이분 탐색을 해야 한다!
	 * */
	public static int[] solution(String[] info, String[] query) {
//		모든 (info에 가지고 있는 것들 + "-")로 나올수 있는 조합표를 만듬
        Map<String, List<Integer>> map = new HashMap<>();
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

//            2*2*2*2 => 있고 없고 로 만든 집합의 부분집합을 구하면 조합을 구할 수 있다.
            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
//                	자리수들 중 하나라도 일치한다는 의미 -> 추가해주기
//                	1010 -> 1000이면 1->java가 일치 (여기서 0은 없다가 아니고 -의미)
//                	1010 -> 0010이면 javapizza
                    if ((i & (1 << j)) != 0) key.append(split[j]);
                }
//                key만 map에 삽입하면 널포인트 에러(초기화 안해서..)
//                key를 삽입할 때 value를 List로 초기화 한 후 score점수를 넣겠다는 의미
                map.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        // Map 안에 List sorting
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()){
            entry.getValue().sort(null);
        }

        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
//        	"javabackendpizza" "150"
            String[] splits = query[i].replaceAll("-", "").replaceAll(" and ", "").split(" ");
            String key = splits[0];
            int score = Integer.parseInt(splits[1]);
//            점수들..list
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
//            이진탐색
            int start = 0;
            int end = list.size();
//             lower bound 를 구해야 함 
//            기준 되는 점수가 만약 중복되는 점수일 때 upper bound를 하면 중복되는 점수들 중 마지막에 있는 점수만 포함됨. -> 개수가 안맞음..
            while (start < end) {
                int mid = (start + end) / 2;
                if(list.get(mid) < score) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }
            // 전체에서 lower bound를 빼면 score와 같거나 큰 경우의 수
            answer[i] = list.size() - start;
        }
        return answer;
    }
	
/*	
 * 효율성 0점..ㅜㅜ
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
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = solution(info, query);
		for(int i : result) System.out.println(i);
	}

}
