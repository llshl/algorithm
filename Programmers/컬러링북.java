package All;

import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Color {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean visit[][];
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visit = new boolean[m][n];
        for(int i=0;i<picture.length;i++) {
        	for(int j=0;j<picture[i].length;j++) {
        		if(picture[i][j] != 0 && visit[i][j] == false) {
        			int temp = bfs(picture[i][j],i,j,m,n,picture);
        			if(maxSizeOfOneArea < temp) {
        				maxSizeOfOneArea = temp;
        			}
        			numberOfArea++;
        		}
        	}
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	private int bfs(int number,int x, int y,int m, int n, int[][] picture) {
		//상하좌우로 number와 일치하는 칸을 방문처리
		int area = 0;
		Queue<Point> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point point = q.poll();
			for(int i=0;i<4;i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < m && ny < n ) {
					if(visit[nx][ny] == false && picture[nx][ny] == number) {
						visit[nx][ny] = true;
						q.add(new Point(nx,ny)); 
						area++;
					}
				}
			}
		}
		return area+1;	//시작칸까지 해서 +1
	}
}

public class 컬러링북 {

	public static void main(String[] args) {
		Color s = new Color();
		int m = 6;
		int n = 4;
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		int[] answer = new int[2];
		answer = s.solution(m, n, picture);
		System.out.println(answer[0] +" "+ answer[1]); 
	}

}
