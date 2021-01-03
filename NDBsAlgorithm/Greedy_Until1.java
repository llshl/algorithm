package NDBsAlgorithm;

import java.util.Scanner;

public class Greedy_Until1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt=0;
		while(N!=1) {
			if(N%K!=0) {
				N--;
				cnt++;
			}
			else {
				N = N/K;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
