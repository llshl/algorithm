package temp;

import java.util.Scanner;

public class ���ѻ��� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			String P = sc.next();
			String Q = sc.next();
			boolean flag = false;
			if(Q.length()-P.length()==1) {
				//�� �ڿ� �ѱ��ڻ��� �տ��� �� ��ġ�ϸ� �� �ѱ��ڰ� a�ΰ�츸 N�̴�
				if(Q.subSequence(0, Q.length()-1).equals(P)){
					if(Q.charAt(Q.length()-1)=='a') {
						System.out.println("#"+t+" "+"N");
					}
					else {
						System.out.println("#"+t+" "+"Y");
					}
				}
				else {
					System.out.println("#"+t+" "+"Y");
				}
			}
			else {
				//Yes
				System.out.println("#"+t+" "+"Y");
			}
		}
	}
}
