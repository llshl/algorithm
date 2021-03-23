package temp;

import java.util.Scanner;

/*
정수 N이 들어온다 (2<=N<=100)
N을 두개 이상의 자연수의 덧셈으로 나눌수있다
이때 이 나눈값들을 곱했을때 가장 큰 값이 나오는 경우를 "자연스러운곱"이라고 한다
N이 주어졌을때 "자연스러운곱"을 구하여라
ex) 13이 들어오면 2+2+3+3+3의 경우가 2x2x3x3x3으로 가장 큰 곱이다
*/
public class 준규의퀴즈2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N==2) {
			System.out.println("1");
			return;
		}
		if(N==3) {
			System.out.println("2");
			return;
		}
		long answer = -1;
		if(N%3==0) {
			answer = (long) (Math.pow(2, 0) * Math.pow(3, N/3));
		}
		else if(N%3==2) {
			answer = (long) (Math.pow(2, 1) * Math.pow(3, (N+1)/3-1));
		}
		else {
			answer = (long) (Math.pow(2, 2) * Math.pow(3, (N+2)/3-2));
		}
		System.out.println(answer);
	}
}
