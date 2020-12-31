package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//해시셋으로 했는데 시간초과

public class main11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<N+M;i++) {
			sb.append(pq.poll()+" ");
		}
		System.out.println(sb);
	}
}
