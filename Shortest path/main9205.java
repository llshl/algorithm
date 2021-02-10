package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location{	//집,편의점,페스티벌장의 좌표
	private int x;
	private int y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	
}

public class main9205 {

	public static int T,N;
	public static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			Location[] location = new Location[N+2];	//시작1개+편의점N개+도착지1개
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int tempX = Integer.parseInt(st.nextToken());
			int tempY = Integer.parseInt(st.nextToken());
			location[0] = new Location(tempX,tempY);	//집위치
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine()," ");	//편의점위치
				tempX = Integer.parseInt(st.nextToken());
				tempY = Integer.parseInt(st.nextToken());
				location[i] = new Location(tempX,tempY);
			}
			st = new StringTokenizer(br.readLine()," ");
			tempX = Integer.parseInt(st.nextToken());
			tempY = Integer.parseInt(st.nextToken());
			location[N+1] = new Location(tempX,tempY);	//도착지위치
			
			solution(location);
			
			if(flag) {	//마지막지점에 도착하고 끝나면 flag == true이다
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
			flag = false;
		}
	}
	private static void solution(Location[] location) {
		Queue<Location> q = new LinkedList<>();
		boolean[] visit = new boolean[N+2];
		q.add(location[0]);	//출발지 q에 넣음
		
		while(!q.isEmpty()) {
			Location now = q.poll();
			if(now.equals(location[N+1])) {	//마지막 위치에 도착했다면 그만
				flag = true;
				break;
			}
			for(int i=1;i<=N+1;i++) {
				if(visit[i] == false && Math.abs(now.getX()-location[i].getX()) + Math.abs(now.getY() - location[i].getY()) <= 1000){
					//방문을 안한 위치이면서 x1-x2 + y1-y2가 1000이상인 지점이라면
					q.add(location[i]);
					visit[i] = true;
				}
			}
		}	
	}
}
