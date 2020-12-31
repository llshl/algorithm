package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main1100 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] pan = new String[8];
		for(int i=0;i<8;i++) {
			pan[i] = br.readLine();
		}
		int cnt = 0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(pan[i*2].charAt(j*2) == 'F') {
					cnt++;
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(pan[i*2+1].charAt(j*2+1) == 'F') {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
