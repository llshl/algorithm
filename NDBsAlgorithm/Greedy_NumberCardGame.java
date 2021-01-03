package NDBsAlgorithm;

import java.util.Scanner;

public class Greedy_NumberCardGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int rowmin = 0;
		for(int i=0;i<N;i++) {
			int min = 10001;
			for(int j=0;j<M;j++) {
				int temp = sc.nextInt();
				if(min > temp) {
					min = temp;
				}
			}
			if(rowmin < min) {
				rowmin = min;
			}
		}
		System.out.println(rowmin);
	}

}
