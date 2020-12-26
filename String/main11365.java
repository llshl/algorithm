package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class main11365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int i=0;
		while(true) {
			String s = br.readLine();
			if(s.equals("END")) {
				break;
			}
			sb.append(s);
			System.out.println(sb.reverse());
			sb.delete(0, s.length());
		}
	}
}
