package String;

import java.util.Scanner;

public class main8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] problem = new String[N];
		int[] score = new int[N];
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			problem[i] = sc.next();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<problem[i].length();j++){
				char c = problem[i].charAt(j);
				if(c == 'O') {
					cnt++;
				}
				else {
					cnt=0;
				}
				score[i] += cnt;
			}
			cnt=0;
		}
		for(int i=0;i<score.length;i++) {
			System.out.println(score[i]);
		}
	}

}
