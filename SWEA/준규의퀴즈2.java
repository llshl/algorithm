package temp;

import java.util.Scanner;

/*
���� N�� ���´� (2<=N<=100)
N�� �ΰ� �̻��� �ڿ����� �������� �������ִ�
�̶� �� ���������� �������� ���� ū ���� ������ ��츦 "�ڿ��������"�̶�� �Ѵ�
N�� �־������� "�ڿ��������"�� ���Ͽ���
ex) 13�� ������ 2+2+3+3+3�� ��찡 2x2x3x3x3���� ���� ū ���̴�
*/
public class �ر�������2 {

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
