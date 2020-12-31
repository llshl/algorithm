package String;

import java.util.Scanner;

public class main1652 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Vcnt=0;
		int Hcnt=0;
		String[] s = new String[N];
		for(int i=0;i<N;i++) {
			s[i] = sc.next();
		}
		for(int i=0;i<N;i++) {
			boolean[][] visited = new boolean[N][N];
			for(int j=1;j<N;j++) {			
				if(s[i].charAt(j) == '.' && s[i].charAt(j-1) == '.' && visited[i][j] == false && visited[i][j-1] == false) {
					Hcnt++;
					visited[i][j] = true;
					visited[i][j-1] = true;
				}
				else if(s[i].charAt(j) == '.' && s[i].charAt(j-1) == '.') {
					visited[i][j] = true;
					visited[i][j-1] = true;
				}
			}
			
			boolean[][] visited2 = new boolean[N][N];
			for(int j=1;j<N;j++) {
				if(s[j].charAt(i) == '.' && s[j-1].charAt(i) == '.' && visited2[j][i] == false && visited2[j-1][i] == false) {
					Vcnt++;
					visited2[j][i] = true;
					visited2[j-1][i] = true;
				}
				else if(s[j].charAt(i) == '.' && s[j-1].charAt(i) == '.') {
					visited2[j][i] = true;
					visited2[j-1][i] = true;
				}
			}
		}
		System.out.println(Hcnt + " " + Vcnt);
	}
}
