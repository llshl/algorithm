package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class main1373 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String N = br.readLine();
		int cnt = 0;
		
		if(N.length()%3==1) {
			N = "00"+N;
		}
		else if(N.length()%3 == 2) {
			N = "0"+N;
		}
		for(int i=0;i<N.length();i++) {
			sb.append(N.charAt(i));
			
			cnt++;
			if(cnt == 3) {
				cnt = 0;
				int a = Integer.parseInt(sb.toString(),2);
				System.out.print(a);
				sb.delete(0, 3);
			}
		}
	}
}
		
