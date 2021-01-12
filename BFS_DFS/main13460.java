package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Node16{
	private int x;
	private int y;
	private int move;
	
	public Node16(int x, int y, int move) {
		this.x = x;
		this.y = y;
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
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	
}

public class main13460 {
	public static int N;
	public static int M;
	public static int ans;
	public static boolean flag = false;	//빨간공이 들어갔다면 true
	public static boolean BlueTurn = false;
	public static char[][] arr;
	public static Queue<Node16> qRed;
	public static Queue<Node16> qBlue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		qRed = new LinkedList<>();
		qBlue = new LinkedList<>();
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		arr = new char[N][M];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = input.charAt(j);
				if(arr[i][j] == 'R') {
					qRed.add(new Node16(i,j,1));
				}
				if(arr[i][j] == 'B') {
					qBlue.add(new Node16(i,j,1));
				}
			}
		}
		
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		while(!qRed.isEmpty()) {	//빨간공이 기준이다.
			Node16 Red = qRed.poll();
			Node16 Blue = qBlue.poll();
			int xred = Red.getX();
			int yred = Red.getY();
			int xblue = Blue.getX();
			int yblue = Blue.getY();
			int movered = Red.getMove();
			int moveblue = Blue.getMove();
			if(movered == 11) {	//10번이 넘으면
				//-1출력하며 종료
				ans = -1;
				return;
			}//한칸씩밖에 안움직인다
			//move를 시작하자마자 1 올려줘야한다
			arr[xred][yred] = '.';
			arr[xblue][yblue] = '.';
			for(int i=0;i<4;i++) {	//arr에서 수정하자 R B위치를
				
				//파랑이 먼저 움직이고 그 뒤로 빨강이 움직이는 경우도 생각해야한다
				int nxred = -1;
				int nyred = -1;	
				int nxblue = -1;
				int nyblue = -1; 
				if(i == 0) {
					if(xred<xblue) {	//위로가기일때 빨강이 더 위에있다면 빨강부터 실행
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//빨감이 들어갔다면 , //빨강이 들어가 뒤 동시에 파랑이 들어가면 안된다.
							flag = true;		//발강이 들어갔다는 표시이고 바로 뒤에 파랑이 안들어간다면 for문 끝에서도 true로 남는다
						}else {
							arr[nxred][nyred] = 'R';
						}
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//파란공이 들아간경우 스킵
						}
						arr[nxblue][nyblue] = 'B';	
					}
					else {	//파랑이 더 위에있으면 파랑부터 실행
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//파란공이 들아간경우 스킵
						}
						arr[nxblue][nyblue] = 'B';	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//빨감이 들어갔다면 , //빨강이 들어가 뒤 동시에 파랑이 들어가면 안된다.
							flag = true;		//발강이 들어갔다는 표시이고 바로 뒤에 파랑이 안들어간다면 for문 끝에서도 true로 남는다
						}else {
							arr[nxred][nyred] = 'R';
						}
					}
				}
				else if(i==1) {
					if(xred<xblue) {	//아래로가기일때 파랑이 더 낮게있으면 파랑부터 실행
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//파란공이 들아간경우 스킵
						}
						arr[nxblue][nyblue] = 'B';	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);
						if(nxred == 500 || nyred == 500) {	//빨감이 들어갔다면 , //빨강이 들어가 뒤 동시에 파랑이 들어가면 안된다.
							flag = true;		//발강이 들어갔다는 표시이고 바로 뒤에 파랑이 안들어간다면 for문 끝에서도 true로 남는다
						}else {
							arr[nxred][nyred] = 'R';
						}
					}
					else {	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//빨감이 들어갔다면 , //빨강이 들어가 뒤 동시에 파랑이 들어가면 안된다.
							flag = true;		//발강이 들어갔다는 표시이고 바로 뒤에 파랑이 안들어간다면 for문 끝에서도 true로 남는다
						}else {
							arr[nxred][nyred] = 'R';
						}
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//파란공이 들아간경우 스킵
						}
						arr[nxblue][nyblue] = 'B';	
					}
				}
				else if(i==2) {
					if(yred<yblue) {	//왼쪽가기일때 빨강이 더 왼쪽에있으면 빨강부터 실행
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//빨감이 들어갔다면 , //빨강이 들어가 뒤 동시에 파랑이 들어가면 안된다.
							flag = true;		//발강이 들어갔다는 표시이고 바로 뒤에 파랑이 안들어간다면 for문 끝에서도 true로 남는다
						}else {
							arr[nxred][nyred] = 'R';
						}
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//파란공이 들아간경우 스킵
						}
						arr[nxblue][nyblue] = 'B';	
					}
					else {
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//파란공이 들아간경우 스킵
						}
						arr[nxblue][nyblue] = 'B';	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);
						if(nxred == 500 || nyred == 500) {	//빨감이 들어갔다면 , //빨강이 들어가 뒤 동시에 파랑이 들어가면 안된다.
							flag = true;		//발강이 들어갔다는 표시이고 바로 뒤에 파랑이 안들어간다면 for문 끝에서도 true로 남는다
						}else {
							arr[nxred][nyred] = 'R';
						}
					}
				}
				else if(i==3) {
					if(yred<yblue) {	//오른쪽으로 가기일때 파랑이 더 오른쪽에있으면 파랑부터 실행
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//파란공이 들아간경우 스킵
						}
						arr[nxblue][nyblue] = 'B';	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);
						if(nxred == 500 || nyred == 500) {	//빨감이 들어갔다면 , //빨강이 들어가 뒤 동시에 파랑이 들어가면 안된다.
							flag = true;		//발강이 들어갔다는 표시이고 바로 뒤에 파랑이 안들어간다면 for문 끝에서도 true로 남는다
						}else {
							arr[nxred][nyred] = 'R';
						}
					}
					else {	
						nxred = gotoEndX(xred,yred,i);
						nyred = gotoEndY(xred,yred,i);	
						if(nxred == 500 || nyred == 500) {	//빨감이 들어갔다면 , //빨강이 들어가 뒤 동시에 파랑이 들어가면 안된다.
							flag = true;		//발강이 들어갔다는 표시이고 바로 뒤에 파랑이 안들어간다면 for문 끝에서도 true로 남는다
						}else {
							arr[nxred][nyred] = 'R';
						}
						nxblue = gotoEndX(xblue,yblue,i);
						nyblue = gotoEndY(xblue,yblue,i); 
						if(nxblue == 500 || nyblue == 500) {
							continue;	//파란공이 들아간경우 스킵
						}
						arr[nxblue][nyblue] = 'B';	
					}
				}
				
				qRed.add(new Node16(nxred,nyred,movered+1));
				qBlue.add(new Node16(nxblue,nyblue,moveblue+1));
				arr[nxred][nyred] = '.';
				arr[nxblue][nyblue] = '.';
				if(flag == true) {
					ans = movered;
					return;
				}
			}
		}
		
	}
	private static int gotoEndY(int x, int y, int dir) {	//x좌표와 상하좌우 방향
		if(dir == 0) {	//상 하 이동이면 y좌표는 그대로 반환
			return y;
		}
		else if(dir == 1) {
			return y;
		}
		else if(dir == 2) {
			while(true) {
				if(arr[x][y-1] == '.') {
					y = y-1;
				}
				else if(arr[x][y-1] == 'O') {
					//구슬이 들어갓으므로 처리하자
					y = 500;
					break;
				}
				else {
					break;
				}
			}
			return y;
		}
		else {
			while(true) {
				if(arr[x][y+1] == '.') {
					y = y+1;
				}
				else if(arr[x][y+1] == 'O') {
					y = 500;
					break;
				}
				else {
					break;
				}
			}
			return y;
		}
	}
	
	private static int gotoEndX(int x, int y, int dir) {
		if(dir == 0) {
			while(true) {
				if(arr[x-1][y] == '.') {
					x = x-1;
				}
				else if(arr[x-1][y] == 'O') {
					x = 500;
					break;
				}
				else {
					break;
				}
			}
			return x;
		}
		else if(dir == 1) {
			while(true) {
				if(arr[x+1][y] == '.') {
					x = x+1;
				}
				else if(arr[x+1][y] == 'O') {
					x = 500;
					break;
				}
				else {
					break;
				}
			}
			return x;
		}
		else if(dir == 3) {	//좌 우 이동이면 x좌표는 그대로 반환
			return x;
		}
		else{
			return x;
		}
	}
}
