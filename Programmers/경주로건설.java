package All;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Racer{
	int x;
	int y;
	int dir;
	int cost;
	public Racer(int x, int y, int dir, int cost) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cost = cost;
	}
}
//상-0, 하-1, 좌-2, 우-3
class ROAD {
	public static int xLen;
	public static int yLen;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int answer2 = Integer.MAX_VALUE;
        xLen = board.length;
        yLen = board[0].length;
        Queue<Racer> q = new LinkedList<>();
        q.add(new Racer(0,0,1,0));
        
        answer = startOne(board,answer,1);
        answer2 = startOne(board,answer2,3);
       
        return Math.min(answer, answer2);//Math.min(answer, answer2); 
    }
	private int startOne(int[][] board, int answer,int dir) {
		Queue<Racer> q = new LinkedList<>();
        q.add(new Racer(0,0,dir,0));
		int[][] visit = new int[board.length][board[0].length];
		for(int i=0;i<visit.length;i++) {
			Arrays.fill(visit[i], Integer.MAX_VALUE); 
		}
        visit[0][0] = 0;
        //아래방향 레이서부터 시작
        while(!q.isEmpty()) {
        	Racer temp = q.poll();
        	if(temp.x == xLen-1 && temp.y == yLen-1) {
        		answer = Math.min(answer, temp.cost);
        	}
        	for(int i=0;i<4;i++) {
        		int nx = temp.x + dx[i];
        		int ny = temp.y + dy[i];
        		if(inBound(nx,ny)) {
        			if(visit[nx][ny] >= temp.cost && board[nx][ny] == 0) {
        				visit[nx][ny] = temp.cost;
	        			int tempcost = 0;
	        			if(i==temp.dir) {
	        				tempcost = 100;
	        			}
	        			else {
	        				tempcost = 600;
	        			}
	        			q.add(new Racer(nx,ny,i,temp.cost+tempcost));
        			}
        		}
        	}
        }
		return answer;
	}
	private boolean inBound(int nx, int ny) {
		if(nx>=0&&ny>=0&&nx<xLen&&ny<yLen) {
			return true;
		}
		return false;
	}
}

public class 경주로건설 {

	public static void main(String[] args) {
		ROAD s = new ROAD();
		//int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		//int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		System.out.println(s.solution(board));
	}
}
