package bitMasking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1062_가르침 {
	static int N, K, max = 0, ch = 0;
	static int[] word;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new int[N];
		
//		남극 단어의 글자수의 최소도 못배웠을 때
		if (K < 5) 
			System.out.println(0);
//		알파벳 다 배웠을 때
		else if (K >=26)
			System.out.println(N);
		else {
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
//				필수 글자들 제외한 나머지
				word[i] = toBit(s.substring(4, s.length()-4));
//				word[i] = toBit(s.replaceAll("[antic]", ""));
				
			}
//			ch에 알파벳들의 사용유무를 비트로 저장.
			ch |= 1<<('a'-'a');
			ch |= 1<<('n'-'a');
			ch |= 1<<('t'-'a');
			ch |= 1<<('i'-'a');
			ch |= 1<<('c'-'a');
				
//			조합하기 -> 5개는 무조건 배워야 하므로 5부터 시작
			comb(0,5, ch);
//			최대 단어 수 출력
			System.out.println(max);
			
		}
	}
	
//	
	static void comb(int n, int r, int ch) {
//		다 골랐을 때 
		if(r == K) {
//			배운 단어 나올 때마다 1씩 깎기
			int count = N;
			for(int i = 0; i < N; i++) {
//				가르친 글자가 하나라도 없을 때 - 백트래킹
//				포함되었을 때 == 합집합이 ch와 같을때!
				if((word[i] | ch) != ch) {
					count--;
					
				}
			}
			max = Math.max(max, count);
			
		}else {
//			모든 알파벳 갯수만큼
			for(int i = n; i < 26; i++) {
//				a, b, c, ...가 배운 글자에 들어있지 않다면
//				같은 게 있다면 무조건 1이상의 값이 나온다.
				if((ch & (1<<i)) == 0) {
//					해당 글자를 배운글자에 넣어줘라
					ch |= (1<<i);
//					해당 글자를 배웠다는 가정하에 조합 돌리기!
					comb(i+1, r+1, ch);
//					해당 글자를 배운 글자에서 빼줘라
					ch &= ~(1<<i);
				}
			}
		}
	}
//	단어를 비트마스크로 바꾸기
	static int toBit(String str) {
		int temp = 0;
		for(int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			temp |= 1<<(c-'a');
		}
		return temp;
	}

}
