package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ÆÄ¸®ÅðÄ¡ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
	
			int max = 0;
			int temp = 0;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					for(int x=i;x<M+i;x++) {
						for(int y=j;y<M+j;y++) {
							temp += arr[x][y];
						}
					}
					max = Math.max(max, temp);
					temp = 0;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
