package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Node11{
	private int x;
	private int y;
	private int drill;
	private int move;
	private int cnt;
	public Node11(int x, int y, int drill, int move){
		this.x = x;
		this.y = y;
		this.drill = drill;
		this.move = move;
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
	public int getDrill() {
		return drill;
	}
	public void setDrill(int drill) {
		this.drill = drill;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	
	
}

public class main2206 {
	public static int N;
	public static int M;
	public static int ans = 0;
	public static int[][] arr;
	public static int[][] visited;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		if(N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		arr = new int[N][M];
		visited = new int[N][M];	//벽 부순 횟수	0,1가능, 2는 아직 방문x
		for(int i=0;i<N;i++) {
			temp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);	//temp한줄받은거를 한글자씩 [0][1][2]...이렇게 넣은것
				visited[i][j] = 2;
			}
		}
		
		bfs(0,0);
	
		
		if(visited[N-1][M-1]!=5) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	/*반례는 이처럼 ㄹ자모양으로 빙 돌아가는 애가 정답인 경우. 시작지접에서 곧바로 밑에벽을 뚫은 후 방문처리하면 ㄹ자로 돌아가는 애가 가질 못한다
	 * 6 5
		00000
		11110
		00000
		01111
		01111
		00010
	 */
	private static void bfs(int x, int y) {
		Queue<Node11> q = new LinkedList<>();
		q.add(new Node11(x,y,0,1));	//x좌표, y좌표, 구멍뚫은횟수, 이동거리
		visited[x][y] = 0;
		while(!q.isEmpty()) {
			Node11 node  = q.poll();
			x = node.getX();
			y = node.getY();
			int drill = node.getDrill();
			int move = node.getMove();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(nx == N-1 && ny == M-1) {	//가장먼저 도달한 이동거리
					visited[nx][ny] = 5;	//도닷리 5로 해줌, 걍 0,1,2 제외한 아무거나
					ans = move+1;	//move+1해서 큐에 넣어준값으로 출력
					return;
				}
				//visited 배열은 그 길을 통과하는 노드가 지금까지 몇번 벽을 뚫었는지 횟수로 초기화된 배열
				//만약, 길을 한번 뚫은애가 지나간 길에는 1로 설정돼있고 한번도 안뚫은 애가 지나간경우에는 0으로 설정돼있다.
				//아무도 안지나간 경우 위에서 설정해준 visited배열의 dafault인 2로 돼있다.
				//visited배열의 모든 칸은 INF(여기서는 2로설정), 즉 2>1인경우나 1>0인 경우만 동시에 한 경로로 겹쳐서 들어갈수있다
				//2>1는 아무도 안지나간 길에 구멍한번뚫은애가 진입할때
				//2>0은 아무도 안지나간 길에 구멍 한번도 안뚫은애가 진입할때
				//1>0은 구멍 한번뚫은애가 지나간 길에 구멍 한번도 안뚫은 애가 진입할때
				//그 이외의 경우는 구멍한번뚫은애들끼리 지나가기 or 구멍 한번도 안뚫은 애들끼리 지나가기 이므로 그냥 무시해도된다. 구멍뚫은횟수가 같은애들끼리는 한놈만 탐색하는 경우를 보면 된까(귿이 둘다 확인하 ㄹ필요 ㅇ벗다
				if(visited[nx][ny] > drill) {	
					if(arr[nx][ny] == 0) {	//길이라면
						visited[nx][ny] = drill;	//지나간
						q.add(new Node11(nx,ny,drill,move+1));
					}
					else if(arr[nx][ny] == 1) {	//벽이라면
						if(drill == 0) {	//드릴 안썻다면
							visited[nx][ny] = drill+1;
							q.add(new Node11(nx,ny,1,move+1)); 	//드릴횟수 1회 추가해서 큐에 추가
						}
					}
				}
			}
		}
	}
}
