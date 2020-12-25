package String;

import java.util.Scanner;

public class main11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String num = sc.next();
		
		int ans=0;
		
		for(int i=0;i<N;i++) {
			ans += num.charAt(i)-'0';
		}
		System.out.println(ans);
	}

}
