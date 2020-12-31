package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//¹Ì¿Ï
public class main2108 {

	public static void main(String[] args) throws  IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[8001];
		int sum=0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		for(int i=0;i<8001;i++) {
			if(list.get(i)>0) {
				
			}
			cnt[list.get(i)]++;
		}
		Collections.sort(list);
		br.close();
		int temp=0;
		for(int i=0;i<N;i++) {
			sum = sum+list.get(i);
		}
		temp = cnt[0];
		int many=0;
		for(int i=0;i<4001;i++) {
			if(temp<=cnt[i]) {
				temp = cnt[i];
				many = i;
			}
		}
		System.out.println(Math.round(sum));
		System.out.println(list.get(N/2));
		System.out.println(list.get(many));
		System.out.println(list.get(N-1)-list.get(0));
	}

}
