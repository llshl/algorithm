package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*for(int i=0;i<N;i++) {
	for(int j=0;j<M;j++) {
		System.out.print(arr[i][j]+" ");
	}
	System.out.println("");
}
*/
class Image{
	String[][] arr;
	int stage;
	int Rx;
	int Ry;
	int Bx;
	int By;
	public Image(String[][] arr, int stage, int rx, int ry, int bx, int by) {
		super();
		this.arr = arr;
		this.stage = stage;
		Rx = rx;
		Ry = ry;
		Bx = bx;
		By = by;
	}
}
public class main13460Re {

	public static int N,M;
	public static String[][] arr,arr2;
	public static int init_Red_X, init_Blue_X, init_Red_Y, init_Blue_Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N][M];
		arr2 = new String[N][M];
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				if(temp[j].equals("B")) {
					init_Blue_X = i;
					init_Blue_Y = j;
				}
				else if(temp[j].equals("R")) {
					init_Red_X = i;
					init_Red_Y = j;
				}
				arr[i][j] = temp[j];
			}
		}
		printArr("시작",arr);
		bfs();
		printArr("종료",arr);
		
	}
	private static void printArr(String msg,String[][] arr) {
		System.out.println("===="+msg+"====");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	private static void bfs() {
		Queue<Image> q = new LinkedList<>();
		q.add(new Image(arr,0,init_Red_X,init_Red_Y,init_Blue_X,init_Blue_Y));
		while(true) {
			Image temp = q.poll();
			for(int i=0;i<4;i++) {	//상하좌우로 이동시키기 각각의 시나리오를 큐에 넣고 계속 돌리기
				if(i==0) {
					Up(arr,0,q,temp.Bx,temp.By,temp.Rx,temp.Ry);
				}
				else if(i==1) {
					Down(arr,0,q,temp.Bx,temp.By,temp.Rx,temp.Ry);
				}
//				else if(i==2) {
//					left(arr,q);
//				}
//				else{
//					right(arr,q);
//				}
			}
			break;
		}
	}
	private static void Down(String[][] arr, int cnt, Queue<Image> q, int bx, int by, int rx, int ry) {
		boolean stop1 = false;
		boolean stop2 = false;
		boolean frontOne = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		if(bx<rx) {
			//bx가 더 위에
			frontOne = true;
		}
		arr2[bx][by] = ".";
		arr2[rx][ry] = ".";
		while(true) {
			if(arr[bx][by].equals(".") && stop1) {
				bx++;
			}
			else if(arr[bx][by].equals("R") && stop1) {
				if(frontOne) {	//bx가 원래 더 위였다면
					bx = rx-1;
				}
			}
			else {
				stop1 = true;
			}
			
			if(arr[rx][ry].equals(".") && !stop2) {
				rx++;
			}
			else if(arr[rx][ry].equals("B") && stop2) {
				if(!frontOne) {	//rx가 원래 더 위였다면
					rx = bx-1;
				}
			}
			else {
				stop2 = true;
			}
			
			if(stop1&&stop2) {
				break;
			}
		}
		arr2[bx-1][by] = "B";
		arr2[rx-1][ry] = "R";
		printArr("Down",arr2);
		q.add(new Image(arr2,cnt+1,rx,ry,bx,by));
	}
		
	private static void Up(String[][] arr, int cnt, Queue<Image> q, int bx, int by, int rx, int ry) {
		boolean stop1 = false;
		boolean stop2 = false;
		boolean frontOne = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		if(bx<rx) {
			//bx가 더 위에
			frontOne = true;
		}
		arr2[bx][by] = ".";
		arr2[rx][ry] = ".";
		while(true) {
			if(arr[bx][by].equals(".") && stop1) {
				bx--;
			}
			else if(arr[bx][by].equals("R") && stop1) {
				if(!frontOne) {	//rx가 원래 더 위였다면
					bx = rx+1;
				}
			}
			else {
				stop1 = true;
			}
			
			if(arr[rx][ry].equals(".") && !stop2) {
				rx--;
			}
			else if(arr[rx][ry].equals("B") && stop2) {
				if(frontOne) {	//bx가 원래 더 위였다면
					rx = bx+1;
				}
			}
			else {
				stop2 = true;
			}
			
			if(stop1&&stop2) {
				break;
			}
		}
		arr2[bx+1][by] = "B";
		arr2[rx+1][ry] = "R";
		printArr("Up",arr2);
		q.add(new Image(arr2,cnt+1,rx,ry,bx,by));
	}
}
