package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main10953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = new String[N];
		int ans = 0;
		for(int i=0;i<N;i++) {
			s[i] = br.readLine();
		}
		for(int i=0;i<N;i++) {
			String[] temp = s[i].split(",");
			for(int j=0;j<temp.length;j++) {
				ans += Integer.parseInt(temp[j]);
			}
			System.out.println(ans);
			ans=0;
		}
		
	}

}
