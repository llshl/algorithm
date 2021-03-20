package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 중간평균값구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int max = 0;
			int min = 10001;
			int maxIndex = -1;
			int minIndex = -1;
			int[] arr = new int[10];
			for(int i=0;i<10;i++) {
				int temp = Integer.parseInt(st.nextToken());
				if(max < temp) {
					max = temp;
					maxIndex = i;
				}
				if(min > temp) {
					min = temp;
					minIndex = i;
				}
				arr[i] = temp;
			}
			arr[maxIndex] = 0;
			arr[minIndex] = 0;
			int answer = 0;
			for(int i=0;i<10;i++) {
				answer += arr[i];
			}
			answer = (int) Math.round((answer+0.5)/8);
			System.out.println("#"+t+" "+answer);
		}
	}
}
