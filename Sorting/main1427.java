package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class main1427 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		String[] arr = N.split("");
		Arrays.sort(arr);
		Collections.reverse(Arrays.asList(arr));
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
}
