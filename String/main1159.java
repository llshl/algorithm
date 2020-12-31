package String;

import java.util.Scanner;

public class main1159 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		boolean flag=false;
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			String s = sc.next();
			arr[s.charAt(0)-97]++;
		}
		for(int i=0;i<26;i++) {
			if(arr[i] >= 5) {
				flag = true;
				System.out.print((char)(i+97));
			}
		}
		if(flag == false) {
			System.out.println("PREDAJA");
		}
	}
}
