package All;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    int stage;
    public Node15(int x, int y, int stage){
        this.x = x;
        this.y = y;
        this.stage = stage;
    }
}

class Solutionn {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][] map;
    public static int n;
    public static int m;
    public int solution(int[][] maps) {
        int answer = 0;
        map = maps;
        n = maps.length;
        m = maps[0].length;
        answer = bfs(0,0);
        return answer;
    }
    public int bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,1));
        boolean[][] visit = new boolean[n][m];
        visit[x][y] = true;
        while(!q.isEmpty()){
            Node temp = q.poll();
            
            if(temp.x == n-1 && temp.y == m-1){
                return temp.stage;
            }
            
            for(int i=0;i<4;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(inBound(nx,ny)){
                    if(visit[nx][ny] == false){
                        if(map[nx][ny] == 1){
                            visit[nx][ny] = true;
                            q.add(new Node(nx,ny,temp.stage+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
    public boolean inBound(int x, int y){
        if(x>=0 && y>=0 && x<n && y<m){
            return true;
        }
        return false;
    }
}

public class 게임맵최단거리 {

	public static void main(String[] args) {
		//clear

	}

}
