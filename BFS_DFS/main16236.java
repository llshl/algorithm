package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Shark{
	private int x;
	private int y;
	private int move;
	private int size;
	private int eat;
	public Shark(int x, int y, int move, int size, int eat){
		this.x = x;
		this.y = y;
		this.move = move;
		this.size = size;
		this.eat = eat;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getEat() {
		return eat;
	}
	public void setEat(int eat) {
		this.eat = eat;
	}
	
}

public class main16236 {
	public static int N;
	public static int sharkX;
	public static int sharkY;
	public static int ans=-1;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1,0,1,0};	//상좌하우
	public static int[] dy = {0,-1,0,1};
	public static Queue<Shark> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if(arr[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					q.add(new Shark(i,j,0,2,0));	//초기 상어의 위치를 큐에 넣기
				}				//x,y,move,size,eat
			}
		}
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		boolean flag = false;	//true되면 상어가 먹을 것이 더 이상 없는것
		while(!q.isEmpty()) {
			Shark node = q.poll();
			int x = node.getX();
			int y = node.getY();
			int move = node.getMove();
			int size = node.getSize();
			int eat = node.getEat();
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) {	//범위나가면 스킵
					continue;
				}
				if(arr[nx][ny] > size) {	//물고기 크기가 상어보다 클경우 못감
					continue;
				}
				if(arr[nx][ny] != 0 && arr[nx][ny] < size && visited[nx][ny] == false) {	//상어보다 작은 물고기 잇는 칸에 도달한 경우 먹는다. 먹고 다시 수행해야한다
					arr[nx][ny] = 0;	//먹었으므로 빈칸으로 만든다
					visited = new boolean[N][N];	//방문배열 초기화
					arr[sharkX][sharkY] = 0;	//초기 상어위치도 0으로 해준다
					q.clear(); //먹었으면 그 자리에서부터 다시 시작이다. 다른 경우는 무시해야한다.
					if(eat == size) {	//자기 크기만큼 먹엇다면 레벨업
						size++;
						eat = 0;
						q.add(new Shark(nx,ny,move+1,size,eat));	//자기 크기만큼 넉어서 커진경우 eat을 0으로 넣어준다
					}
					else {
						q.add(new Shark(nx,ny,move+1,size,eat+1));	//먹고 안커진경우 eat+1을 넘겨준다
					}
				}
				if(arr[nx][ny] == 0 && visited[nx][ny] == false) {	//빈칸이면 거기로 이동
					visited[nx][ny] = true;
					q.add(new Shark(nx,ny,move+1,size,eat));
				}
			}
			//배열 전체 확인하여 상어가 먹을 수 있는 물고기가 없다면 종료
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j] != 0 && arr[i][j] < size) {	//0이 아니면서 상어보다 작은 물고기가있다면 계속 진행
						flag = true;
					}			
				}
			}
			if(flag == false) {
				//종료
				ans = move;
				return;
			}
			flag = false;
		}
		
	}
}
