package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144 {

	public static int R,C,T;
	public static int[][] arr, copy;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		copy = new int[R][C];
		
		int[] robot = new int[2];
		int point = 0;
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<C;j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == -1) {
					robot[point++] = i;
				}
				arr[i][j] = input;
			}
		}
		//1.미세먼지 확산
		//2.공기순환
		for(int time=0;time<T;time++) {
			spread();
			circulate(robot[0],robot[1]);	//공기청정기의 두칸 위치(행 2개)
		}
		int answer = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				answer += arr[i][j];
			}
		}
		System.out.println(answer+2);
	}
	
	private static void circulate(int p1, int p2) {
		//p1,p2행의 먼지들은 오른쪽으로 1칸씩 : Move1
		
		//행이 p1이하중에 [C-1]열의 먼지들은 위로1칸	:Move2_1
		//행이 p2이상중에 [C-1]열의 먼지들은 아래로1칸	:Move2_2
		
		//0행, R-1행의 먼지들은 왼쪽으로 1칸	:Move3
		
		//행이 p1이하중에 0열의 먼지들은 아래로 1칸(-1칸에 닿으면 소멸)	:Move4_1
		//행이 p2이상중에 0열의 먼지들은 위로로 1칸(-1칸에 닿으면 소멸)	:Move4_2
		int[] corner = new int[2];
		corner = move1(p1,p2);
		
		int move2_up_temp = move2_UP(p1,corner[0]);
		int move2_down_temp = move2_DOWN(p2,corner[1]);
		
		corner = new int[2];
		corner = move3(move2_up_temp,move2_down_temp);
		
		move4_DOWN(p1,corner[0]);
		move4_UP(p2,corner[1]);
	}
	
	private static void move4_UP(int p2, int temp) {
		arr[R-2][0] = temp;	//코너돌아온값
		for(int i=p2;i<R-1;i++) {
			arr[i][0] = arr[i+1][0];
		}
		arr[p2][0] = -1;	//공기청정기 자리 고정
	}
	
	private static void move4_DOWN(int p1, int temp) {
		arr[1][0] = temp;	//코너돌아온값
		for(int i=p1;i>0;i--) {
			arr[i][0] = arr[i-1][0];
		}
		arr[p1][0] = -1;	//공기청정기 자리 고정
	}
	private static int[] move3(int move2_up_temp, int move2_down_temp) {
		//왼쪽으로 가는 움직임
		int[] ret = {arr[0][0],arr[R-1][0]};
		System.out.println("세번째 코너에서 아래로가는값: "+arr[0][0]);
		System.out.println("세번재 코너에서 위로가는값: "+arr[R-1][0]);
		for(int i=0;i<C-1;i++) {
			arr[0][i] = arr[0][i+1];
			arr[R-1][i] = arr[R-1][i+1];
		}
		arr[0][C-2] = move2_up_temp;
		arr[R-1][C-2] = move2_down_temp;
		return ret;
	}
	
	private static int move2_DOWN(int p2, int temp) {
		//다음으로 넘겨줄 코너값 미리담기
		int ret = arr[R-1][C-1];
		System.out.println("두번째 코너(오른쪽 아래)에서 왼쪽으로 가는값: "+ret);
		for(int i=R-1;p2<i;i--) {
			arr[i][C-1] = arr[i-1][C-1];
		}
		arr[p2+1][C-1] = temp;
		return ret;
	}
	
	private static int move2_UP(int p1, int temp) {
		//다음으로 넘겨줄 코너값 미리담기
		int ret = arr[0][C-1];
		System.out.println("두번째 코너(오른쪽 위)에서 왼쪽으로 가는값: "+ret);
		for(int i=0;i<p1;i++) {
			arr[i][C-1] = arr[i+1][C-1];
		}
		arr[p1-1][C-1] = temp;
		return ret;
	}
	
	private static int[] move1(int p1, int p2) {
		int[] ret = {arr[p1][C-1],arr[p2][C-1]};
		System.out.println("첫 코너에서 위로가는값: "+arr[p1][C-1]);
		System.out.println("첫 코너에서 아래로가는값: "+arr[p2][C-1]);
		//우측으로 한칸씩 옮기기
		for(int i=1;i<C-1;i++) {
			arr[p1][C-i] = arr[p1][C-i-1];
			arr[p2][C-i] = arr[p2][C-i-1];
		}
		arr[p1][1] = 0;
		arr[p2][1] = 0;
		return ret;
	}
	
	private static void spread() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				copy[i][j] = 0;	//카피배열은 가중치만 담고있다가 2차원배열 한번 다 돌고나면 arr에 한번에 더하기
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j] >= 5) {	//미세먼지있는칸(4이하면 확산안됨)
					int weight = arr[i][j]/5;	//확산량
					int cnt = 0;	//몇방향으로 확산됐는지 카운트
					for(int k=0;k<4;k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(inBound(nx,ny)) {
							copy[nx][ny] += weight;	//카피배열에 가중치 반영해두고 나중에 한번에 깊은복사로 arr에 반영
							cnt++;
						}
					}
					arr[i][j] -= weight*cnt;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				arr[i][j] += copy[i][j];
			}
		}
	}
	private static boolean inBound(int nx, int ny) {
		if(nx>=0&&ny>=0&&nx<R&&ny<C&&arr[nx][ny]!=-1) {
			return true;
		}
		return false;
	}
}
