package String;

import java.util.Scanner;

public class main2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int[] count = new int[10];
		int ans = A*B*C;
		String a = String.valueOf(ans);
		
		for(int i=0;i<a.length();i++) {
			count[a.charAt(i)-'0']++;
		}
		for(int i=0;i<count.length;i++) {
			System.out.println(count[i]);
		}
	}

}
