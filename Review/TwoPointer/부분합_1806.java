package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �κ���_1806 {
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
			//L�� ��ĭ�� �̵�
			sum -= arr[L-1];	//�迭�� ù �ε����� 1���� �����̴� 0��° �ε��� ���� �����ص� 0���°�
			
			//R�� �����ִ¸�ŭ �̵�
			while(sum < S && R < N) {
				R++;
				sum += arr[R];
			}
			
			//�ּұ��� ����
			if(sum >= S) {
				answer = Math.min(answer, R-L+1);
			}
		}
		if(answer == N+1) answer = 0;
		return answer;
	}
}
