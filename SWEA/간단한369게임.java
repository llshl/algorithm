package temp;

import java.util.Scanner;

public class °£´ÜÇÑ369°ÔÀÓ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		String temp = "";
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			temp = Integer.toString(i);
			if((temp).contains("3") ||(temp).contains("6") ||(temp).contains("9")) {
				for(int j=0;j<(i+"").length();j++) {
					if(temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
						cnt++;
					}
				}
				for(int k=0;k<cnt;k++) {
					sb.append("-");
				}
				sb.append(" ");
				cnt = 0;
				continue;
			}
			sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}
}
