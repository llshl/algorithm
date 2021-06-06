package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ∏‘¿ª∞Õ¿Œ∞°∏‘»˙∞Õ¿Œ∞°_7795 {
	static int T,Asize,Bsize;
	static int[] A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			Asize = Integer.parseInt(st.nextToken());
			Bsize = Integer.parseInt(st.nextToken());
			A = new int[Asize+1];
			B = new int[Bsize+1];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1;i<=Asize;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1;i<=Bsize;i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
		
			sort();
			int answer = 0;
			for(int i=1;i<=Asize;i++) {
				answer += binary(A[i]);
			}
			System.out.println(answer);
		}
	}

	private static int binary(int target) {
		int L = 1;
		int R = Bsize;
		int answer = L-1;
		while(L<=R) {
			int mid = (L+R)/2;
			if(B[mid] < target) {
				L = mid + 1;
				answer = mid;
			}else {
				R = mid - 1;
			}
		}
		return answer;
	}

	private static void sort() {
		Arrays.sort(B);
	}
}
