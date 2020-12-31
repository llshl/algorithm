package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class main1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		boolean[] check = new boolean[26];
		String[] s = new String[N];
		int ans=0;
		for(int i=0;i<N;i++) {
			s[i] = br.readLine();
		}
		char temp = s[0].charAt(0);	
		
		for(int i=0;i<N;i++) {
			boolean[] check = new boolean[26];
			
			for(int j=1;j<s[i].length();j++) {
				if(s[i].charAt(j) != s[i].charAt(j-1)) {
					if(check[(int)s[i].charAt(j)-97] == true) {	//실패 개수
						ans++;
						break;
					}
				}
				check[(int)temp-97] = true;
			}
		}
		System.out.println(N-ans);
		

	}

}
