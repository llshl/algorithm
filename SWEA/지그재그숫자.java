package temp;

import java.util.Scanner;

public class 지그재그숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int answer = 0;
			for(int i=1;i<=N;i++) {
				if(i%2==0) {
					answer = answer + (-1)*i;
				}
				else {
					answer = answer + i;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}
