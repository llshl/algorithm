package String;

import java.util.Scanner;

public class main10942 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int cnt=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == 'a' ||s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o'||s.charAt(i) == 'u') {
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
