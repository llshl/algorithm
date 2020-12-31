package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main1120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		int cnt=0;
		int temp=0;
		int time = B.length()-A.length()+1;
		for(int i=0;i<time;i++) {
			for(int j=0;j<A.length();j++) {
				if(A.charAt(j) == B.charAt(j+i)) {
					temp++;
				}
			}
			if(cnt<=temp) {
				cnt = temp;
			}
			temp=0;
		}
		System.out.println(A.length()-cnt);
	}
}
