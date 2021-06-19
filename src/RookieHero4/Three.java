package RookieHero4;

public class Three {
	
	public static String solution(int U, int L, int[] C) {
        // write your code in Java SE 11
		int[] s1 = new int[C.length];
		int[] s2 = new int[C.length];
		for(int i = 0; i < C.length; i++) {
			if(C[i] == 2) {
				s1[i] = 1;
				s2[i] = 1;
				U--;
				L--;
			}else if(C[i] == 0) {
				s1[i] = 0;
				s2[i] = 0;
			}
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i < C.length; i++) {
			sb1.append(s1[i]);
			sb2.append(s2[i]);
		}
		return String.valueOf(sb1+", "+sb2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
