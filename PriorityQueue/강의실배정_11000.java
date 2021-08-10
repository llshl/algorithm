package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정_11000 {
	static int N;
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1]; 
				return o1[0] - o2[0];
			}
			
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0][1]);
		for(int i=1;i<N;i++) {
			int nextStart = arr[i][0];
			int currentEnd = pq.peek();
			if(currentEnd <= nextStart) {
				pq.poll();
			}
			pq.add(arr[i][1]);
		}
		System.out.println(pq.size());
	}
}
