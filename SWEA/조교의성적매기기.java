package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 조교의성적매기기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Double[] arr = new Double[N+1];
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int mid = Integer.parseInt(st.nextToken());
				int fin = Integer.parseInt(st.nextToken());
				int homework = Integer.parseInt(st.nextToken());
				arr[i] = (Double) (mid*0.35+fin*0.45+homework*0.2);
			}
			arr[0] = (double) -1;
			Double target = arr[K];
			Arrays.sort(arr, Collections.reverseOrder());
			int g = -1;
			for(int i=1;i<=N;i++) {
				if(arr[i] == target) {
					g = i;
					break;
				}
			}
			System.out.println("#"+t+" "+grade[g/(N/10)]);
		}
	}
}
