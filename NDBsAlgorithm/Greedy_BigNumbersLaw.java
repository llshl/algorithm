package NDBsAlgorithm;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_BigNumbersLaw {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int ans = 0;
		Integer[] arr = new Integer[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr,Collections.reverseOrder());
		if(arr[0] == arr[1]) {
			System.out.println(arr[0]*M);
		}
		else {
			System.out.println((arr[0]*(M/K)*K)+(arr[1]*(M%K)));
		}
	}

}
