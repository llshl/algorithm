package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class main11004 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer((br.readLine()));
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer((br.readLine()));
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st2.nextToken()));
		}
		Collections.sort(list);
		System.out.println(list.get(K-1));
	}
}
