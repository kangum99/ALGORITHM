package bfsdfs;

public class Pro_단어변환 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
	 * Level 3
	 * 단어 1 : begin
	 * 단어 2 : target
	 * 단어 집합 : words
	 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
	 * 2. words에 있는 단어로만 변환할 수 있습니다.
	 * 변환이 어려울경우 0 return
	 * begin에서 target으로 변환하는 가장 짧은 변환 과정의 개수 return*/
	static boolean[] visit;
	static int answer;
	static int solution(String begin, String target, String[] words) {
        answer = 100;
        visit = new boolean[words.length];
        dfs(begin, target, 0, words);
//        answer == 100이라는 것은 cnt된것이 하나도 없다는 뜻
//        변환될 수 있는 단어가 없다.
        return answer == 100 ? 0 : answer;
    }
	static void dfs(String begin, String target, int cnt, String[] words) {
//		재귀를 빠져 나오는 조건
		if(begin.equals(target)) {
//			최소 변환 단계
			answer = Math.min(answer, cnt);
			return;
		}
		for(int i = 0; i < words.length; i++) {
//			아직 방문하지 않았고, 한글자만 달라서 바꿀수 있는 단어
			if(!visit[i] && canChange(words[i], begin)) {
//				깊이 탐색할때 반복하지 않기 위해 true
				visit[i] = true;
				dfs(words[i], target, cnt+1, words);
//				다음 word를 비교할때는 false로 초기화되어야 함 (중요포인트)
				visit[i] = false;
			}
		}
	}
	
	static boolean canChange(String word, String begin) {
		int cnt = 0;
//		다른 글자가 하나일때
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != begin.charAt(i)) {
				cnt++;
			}
		}
		return cnt == 1 ? true : false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
	}

}
