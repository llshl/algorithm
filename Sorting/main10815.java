package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class main10815 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		boolean ok = false;
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			ok = set.contains(Integer.parseInt(st2.nextToken()));
			if(ok == true) {
				arr[i] = 1;
				ok = false;
			}
		}
		
		for(int i=0;i<M;i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}
}
