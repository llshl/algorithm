package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목판정 {

	public static int cnt = 0;
	public static int N;
	public static int nowDir = -1;
	public static char[][] arr;
	public static boolean flag = false;
	public static int[] dx = {-1,1,0,0,-1,-1,1,1};	//상하좌우 좌상 우상 좌하 우하
	public static int[] dy = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			for(int i=0;i<N;i++) {
				char[] temp = br.readLine().toCharArray();
				arr[i] = temp;
			}
			
			for(int i=0;i<N;i++) {
				if(flag) {
					break;
				}
				for(int j=0;j<N;j++) {
					if(flag) {
						break;
					}
					if(arr[i][j] == 'o') {
						for(int k=0;k<8;k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							int cnt = 1;
							for(int time=0;time<4;time++) {
								if(inBound(nx,ny) && arr[nx][ny] == 'o') {
									cnt++;
									nx += dx[k];
									ny += dy[k]; 
								}
							}
							if(cnt==5) {
								flag = true;
								break;
							}
						}
					}
				}
			}
			if(flag) {
				System.out.println("#"+t+" "+"YES");
				flag = false;
			}
			else {
				System.out.println("#"+t+" "+"NO");
			}
		}
	}
	private static boolean inBound(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<N) {
			return true;
		}
		return false;
	}
}
