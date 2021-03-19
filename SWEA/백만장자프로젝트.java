package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long max = 0;
			int count = 0;
			long profit = 0;
			for(int i=N-1;i>=0;i--) {
				if(arr[i] > max) {	//다음게 감소하면 팔기
					if(count != 0) {
						profit = profit + max*count;
					}
					max = arr[i];
					count = 0;
				}
				else if(arr[i] < max){	//다음날도 증가하면 사기
					profit = profit - arr[i];
					count++;
				}
			}
			if(count != 0) {
				profit = profit + max*count;
			}
			System.out.println("#"+t+" "+profit);
		}
	}
}
