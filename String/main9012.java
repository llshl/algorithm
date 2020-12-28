package String;

import java.util.Scanner;

public class main9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] ans = new boolean[N]; 
		String[] s = new String[N]; 
		for(int i=0;i<N;i++) {
			s[i] = sc.next();
		}
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			String changed = s[i].replaceFirst("\\(\\)", "");
			while(true){
				if(changed.equals("")) {
					ans[i] = true;
					break;
				}
				else if(cnt == s[i].length()/2 && changed.length()>0) {
					ans[i]= false;
					break;
				}
				changed = changed.replaceFirst("\\(\\)", "");
				cnt++;
			}
			cnt=0;
		}
			
		for(int i=0;i<N;i++) {
			if(ans[i] == true) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

}
