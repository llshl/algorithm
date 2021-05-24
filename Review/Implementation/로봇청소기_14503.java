package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class User{
	int x;
	int y;
	int dir;
	int clean;
	public User(int x, int y, int dir, int clean) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.clean = clean;
	}
}
/*
 * 상-0
 * 우-1
 * 하-2
 * 좌-3
 */
public class 로봇청소기_14503 {

	public static int N, M, r, c, d;
	public static int[][] arr;
	public static boolean[][] visit;
	public static User user;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int turnCnt = 0;
		
		user = new User(r,c,d,1);
		visit[r][c] = true;
		while(true) {
			if(turnCnt==4) {
				turnCnt = 0;
				if(isWall(user)) {
					//벽이면 그만
					break;
				}
				else {
					//벽아니면 뒤로1칸
					back(user);
				}
			}
			if(lookLeft(user)) {
				//왼쪽으로 돈후 갈수있는지 확인
				turnCnt = 0;
				go(user);
			}
			else {
				turnCnt++;
			}
		}
		System.out.println(user.clean);
	}
	
	private static void go(User user) {
		int[] nextPoint = moveDir(user.x, user.y, user.dir);
		user.x = nextPoint[0];
		user.y = nextPoint[1];
		visit[user.x][user.y] = true; 
		user.clean = user.clean+1;
	}

	private static boolean lookLeft(User user) {
		int dir = user.dir-1;
		if(dir<0) {
			dir = 3;
		}
		user.dir = dir;	//왼쪽으로 돈다
		int[] nextPoint = moveDir(user.x, user.y, dir);
		int nextX = nextPoint[0];
		int nextY = nextPoint[1];
		if(inBound(nextX,nextY)) {
			if(!visit[nextX][nextY] && arr[nextX][nextY] == 0) {
				return true;	//갈수있다
			}
		}
		return false;
	}

	private static void back(User user) {
		int dir = getReverseDir(user.dir);
		int[] nextPoint = moveDir(user.x, user.y, dir);
		user.x = nextPoint[0];
		user.y = nextPoint[1];
	}

	private static int getReverseDir(int dir) {
		int ret = -1;
		if(dir == 0) {
			ret = 2;
		}
		else if(dir == 1) {
			ret = 3;
		}
		else if(dir == 2) {
			ret = 0;
		}
		else if(dir == 3) {
			ret = 1;
		}
		return ret;
	}

	private static boolean isWall(User user) {
		int dir = getReverseDir(user.dir);
		int[] nextPoint = moveDir(user.x, user.y, dir);
		int backX = nextPoint[0];
		int backY = nextPoint[1];
		if(inBound(backX,backY)) {
			if(arr[backX][backY] == 0) {
				return false;	//뒤로 갈수있다
			}
		}
		return true;
	}

	private static boolean inBound(int x, int y) {
		if(x>=0&&y>=0&&x<N&&y<M) {
			return true;
		}
		return false;
	}
	
	private static int[] moveDir(int x, int y, int dir) {
		//방향을 입력하면 그 방향으로 움직인 좌표 반환
		int[] ret = new int[2];
		int nextX = -1;
		int nextY = -1;
		if(dir == 0) {
			nextX = x-1;
			nextY = y;
		}
		else if(dir == 1) {
			nextX = x;
			nextY = y+1;
		}
		else if(dir == 2) {
			nextX = x+1;
			nextY = y;
		}
		else if(dir == 3) {
			nextX = x;
			nextY = y-1;
		}
		ret[0] = nextX;
		ret[1] = nextY;
		return ret;
	}
}
