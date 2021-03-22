package temp;

import java.util.Scanner;

public class 무한사전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			String P = sc.next();
			String Q = sc.next();
			boolean flag = false;
			if(Q.length()-P.length()==1) {
				//맨 뒤에 한글자빼고 앞에가 다 일치하며 그 한글자가 a인경우만 N이다
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
