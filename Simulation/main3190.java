package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dir{
	int time;
	String direction;
	int x;
	int y;
	String nowDir;
	public Dir(int time, String direction,int x,int y) {
		super();
		this.time = time;
		this.direction = direction;
		this.x = x;
		this.y = y;
	}
}

class Po{
	int x;
	int y;
	public Po(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class main3190 {

	public static int N,K,L;
	public static int x=1;
	public static int y=1;
	public static int lastPointX=-1;
	public static int lastPointY=-1;
	public static int beforeTime = 0;
	public static int answer = 0;
	public static String nowDir = "R";
	public static int[][] arr;
	public static boolean flag = false;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static Deque<Po> snake;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 2;
		}
		arr[1][1] = 1;	//뱀이 1, 사과가 2
		L = Integer.parseInt(br.readLine());
		Queue<Dir> q = new LinkedList<Dir>();
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int time = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();
			q.add(new Dir(time,direction,1,1));
		}
		
		snake = new ArrayDeque<>();
		snake.addFirst(new Po(1,1));
		
		while(true) {
			Dir temp = q.poll();
			forward(temp.time,temp.direction);
			if(flag) {
				break;
			}
			if(q.isEmpty()) {
				forward(999999,"");
				break;
			}
		}
		System.out.println(answer+1);
	}
	
	
	private static void forward(int time, String direction) {
		int cnt = 0;
		switch(nowDir) {
			case "R":
				while(cnt != time-beforeTime) {
					if(inBound(x,++y)) {
						if(arr[x][y] == 2) {
							snake.addFirst(new Po(x,y));
							arr[x][y] = 1;
						}
						else {
							arr[x][y] = 1;
							snake.addFirst(new Po(x,y));
							Po temp = snake.getLast();
							arr[temp.x][temp.y] = 0;
							snake.removeLast();
						}
						answer++;
					}
					else {
						//범위밖으로 나갔거나 자기 몸에 박았거나하면 종료
						flag = true;
						break;
					}
					cnt++;
				}
				nowDir = nextDir(direction);
				beforeTime = time;
				break;
				
			case "L":
				while(cnt != time-beforeTime) {
					if(inBound(x,--y)) {
						if(arr[x][y] == 2) {
							snake.addFirst(new Po(x,y));
							arr[x][y] = 1;
						}
						else {
							arr[x][y] = 1;
							snake.addFirst(new Po(x,y));
							Po temp = snake.getLast();
							arr[temp.x][temp.y] = 0;
							snake.removeLast();
						}
						answer++;
					}
					else {
						//범위밖으로 나갔거나 자기 몸에 박았거나하면 종료
						flag = true;
						break;
					}
					cnt++;
				}
				nowDir = nextDir(direction);
				beforeTime = time;
				break;
			case "U":
				while(cnt != time-beforeTime) {
					if(inBound(--x,y)) {
						if(arr[x][y] == 2) {
							snake.addFirst(new Po(x,y));
							arr[x][y] = 1;
						}
						else {
							arr[x][y] = 1;
							snake.addFirst(new Po(x,y));
							Po temp = snake.getLast();
							arr[temp.x][temp.y] = 0;
							snake.removeLast();
						}
						answer++;
					}
					else {
						//범위밖으로 나갔거나 자기 몸에 박았거나하면 종료
						flag = true;
						break;
					}
					cnt++;
				}
				nowDir = nextDir(direction);
				beforeTime = time;
				break;
			case "D":
				while(cnt != time-beforeTime) {
					if(inBound(++x,y)) {
						if(arr[x][y] == 2) {
							snake.addFirst(new Po(x,y));
							arr[x][y] = 1;
						}
						else {
							arr[x][y] = 1;
							snake.addFirst(new Po(x,y));
							Po temp = snake.getLast();
							arr[temp.x][temp.y] = 0;
							snake.removeLast();
						}
						answer++;
					}
					else {
						//범위밖으로 나갔거나 자기 몸에 박았거나하면 종료
						flag = true;
						break;
					}
					cnt++;
				}
				nowDir = nextDir(direction);
				beforeTime = time;
				break;
		}
	}
	
	public static boolean inBound(int x, int y) {
		if(x>=1&&y>=1&&x<=N&&y<=N) {
			if(arr[x][y]==1){
				return false;
			}
			return true;
		}
		return false;
	}
	
	public static String nextDir(String nowdir) {
		if(nowdir.equals("L")) {
			if(nowDir.equals("R")) {
				return "U";
			}
			else if(nowDir.equals("L")) {
				return "D";
			}
			else if(nowDir.equals("U")) {
				return "L";
			}
			else if(nowDir.equals("D")) {
				return "R";
			}
		}
		else{
			if(nowDir.equals("R")) {
				return "D";
			}
			else if(nowDir.equals("L")) {
				return "U";
			}
			else if(nowDir.equals("U")) {
				return "R";
			}
			else if(nowDir.equals("D")) {
				return "L";
			}
		}
		return "Error";
	}
}
