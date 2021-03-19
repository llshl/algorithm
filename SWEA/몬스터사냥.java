package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 몬스터사냥 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		  int T = Integer.parseInt(br.readLine()); 
		  for(int t=1;t<=T;t++) { 
			  StringTokenizer st = new StringTokenizer(br.readLine()); 
			  int D = Integer.parseInt(st.nextToken()); 
			  int L = Integer.parseInt(st.nextToken());
			  int N = Integer.parseInt(st.nextToken());
			  int answer = 0;
			  for(int i=0;i<N;i++) {
				  answer += (D+i*D/100*L);
			  }
			  System.out.println("#"+t+" "+answer);
		 }
	}
}
