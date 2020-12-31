package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main1032 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = new String[N];
		int cnt = 0;
		String ans = "";
		for(int i=0;i<s.length;i++) {
			s[i] = br.readLine();
		}
		boolean flag = true;
		boolean[] check = new boolean[s[0].length()];
		
		for(int i=0;i<s[0].length();i++) {
			for(int j=1;j<N;j++) {
				if(s[0].charAt(i) == s[j].charAt(i)) {	//N개를 동시에 다 비교해서 and로 맞을때만 테크 트루로
					flag = true;
				}
				else {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				ans += s[0].charAt(i);
			}
			else {
				ans += "?";
			}
		}
		System.out.println(ans);
	}
}
