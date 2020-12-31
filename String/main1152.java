package String;

import java.util.Scanner;
import java.util.StringTokenizer;

public class main1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		StringTokenizer st = new StringTokenizer(a);
		int cnt = st.countTokens();
		System.out.println(cnt);
	}
}
