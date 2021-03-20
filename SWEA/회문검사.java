package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문검사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input = br.readLine();
			boolean flag = true;
			for(int i=0;i<input.length()/2+1;i++) {
				if(input.charAt(i) == input.charAt(input.length()-1-i)) {
					continue;
				}
				else {
					flag = false;
				}
			}
			if(flag) {
				System.out.println("#"+t+" "+1);
			}
			else {
				System.out.println("#"+t+" "+0);
			}
		}
	}
}
