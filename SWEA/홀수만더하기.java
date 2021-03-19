package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홀수만더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int answer = 0;
			int temp = 0;
			for(int i=0;i<10;i++) {
				temp = Integer.parseInt(st.nextToken());
				if(temp%2==1) {
					answer += temp;
				}
			}
			System.out.println("#"+(t+1)+" "+answer);
		}
	}
}
