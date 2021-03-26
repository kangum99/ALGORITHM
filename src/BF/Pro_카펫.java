package BF;

public class Pro_카펫 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42842
	 * Level.2
	 * 갈색 격자의 수 : brown
	 * 노란색 격자의 수 : yellow
	 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
	 */
	static int[] solution(int brown, int yellow) {
        
        int h = 0;
        int w = 0;
//        높이가 짧아야 하니까 높이를 작은거부터 세줌
//        2w + 2h - 4(두번 겹치는 부분) = brown 개수
//        (w-2) + (h-2) = yellow 개수 -> 겉은 무조건 1줄이기 때문
//        w, h의 최소값은 3이다. brown, yellow가 무조건 하나씩은 있기 때문
        for(int i = 3; i <= (int)((brown+4)/2)-3; i++) {
        	h = i;
        	w = (int)((brown+4)/2)-h;
        	if(yellow == (w-2)*(h-2))
        		break;
        }
        int[] answer = {w, h};
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int brown = 10;
		int yellow = 2;
		for(int i : solution(brown, yellow))
			System.out.println(i);
	}

}
