package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class main12015 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[1000001];
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			int temp = arr[i];
			if(list.get(list.size()-1) < temp) {
				list.add(temp);
			}
			else {
				int left = 0;
				int right = list.size()-1;
				while(left < right) {
					int mid = (left+right)/2;
					if(temp <= list.get(mid)) {
						right = mid;
					}
					else {
						left = mid+1;
					}
				}
				list.set(right, temp);
			}
		}
		System.out.println(list.size()-1);
	}
}
