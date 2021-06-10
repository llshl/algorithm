package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {
	static int N,S;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution());
	}
	private static int solution() {
		int R = 0;
		int sum = 0;
		int answer = N+1;
		for(int L=1;L<=N;L++) {
			//L을 한칸씩 이동
			sum -= arr[L-1];	//배열의 첫 인덱스는 1부터 시작이니 0번째 인덱스 빼고 시작해도 0빼는것
			
			//R을 갈수있는만큼 이동
			while(sum < S && R < N) {
				R++;
				sum += arr[R];
			}
			
			//최소길이 갱신
			if(sum >= S) {
				answer = Math.min(answer, R-L+1);
			}
		}
		if(answer == N+1) answer = 0;
		return answer;
	}
}
