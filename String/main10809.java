package String;

import java.util.Scanner;

public class main10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String small_S = S.toLowerCase();
		int[] ans = new int[26];
		boolean[] ansBool = new boolean[small_S.length()];
		int SIndex = 0;
		
		for(int i=0;i<26;i++) {
			for(int index=0;index<small_S.length();index++) {
				if((97+i) == (int)small_S.charAt(index)){
					ans[i] = index;
					break;
				}
				if(index == small_S.length()-1) {
					ans[i] = -1;
					break;
				}
			}
		}
		
		for(int i1=0;i1<26;i1++) {
			System.out.print(ans[i1]+" ");
		}
	}

}
