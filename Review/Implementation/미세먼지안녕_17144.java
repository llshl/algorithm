package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class �̼������ȳ�_17144 {

	public static int R,C,T;
	public static int[][] arr, copy;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		copy = new int[R][C];
		
		int[] robot = new int[2];
		int point = 0;
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<C;j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == -1) {
					robot[point++] = i;
				}
				arr[i][j] = input;
			}
		}
		//1.�̼����� Ȯ��
		//2.�����ȯ
		for(int time=0;time<T;time++) {
			spread();
			circulate(robot[0],robot[1]);	//����û������ ��ĭ ��ġ(�� 2��)
		}
		int answer = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				answer += arr[i][j];
			}
		}
		System.out.println(answer+2);
	}
	
	private static void circulate(int p1, int p2) {
		//p1,p2���� �������� ���������� 1ĭ�� : Move1
		
		//���� p1�����߿� [C-1]���� �������� ����1ĭ	:Move2_1
		//���� p2�̻��߿� [C-1]���� �������� �Ʒ���1ĭ	:Move2_2
		
		//0��, R-1���� �������� �������� 1ĭ	:Move3
		
		//���� p1�����߿� 0���� �������� �Ʒ��� 1ĭ(-1ĭ�� ������ �Ҹ�)	:Move4_1
		//���� p2�̻��߿� 0���� �������� ���η� 1ĭ(-1ĭ�� ������ �Ҹ�)	:Move4_2
		int[] corner = new int[2];
		corner = move1(p1,p2);
		
		int move2_up_temp = move2_UP(p1,corner[0]);
		int move2_down_temp = move2_DOWN(p2,corner[1]);
		
		corner = new int[2];
		corner = move3(move2_up_temp,move2_down_temp);
		
		move4_DOWN(p1,corner[0]);
		move4_UP(p2,corner[1]);
	}
	
	private static void move4_UP(int p2, int temp) {
		arr[R-2][0] = temp;	//�ڳʵ��ƿ°�
		for(int i=p2;i<R-1;i++) {
			arr[i][0] = arr[i+1][0];
		}
		arr[p2][0] = -1;	//����û���� �ڸ� ����
	}
	
	private static void move4_DOWN(int p1, int temp) {
		arr[1][0] = temp;	//�ڳʵ��ƿ°�
		for(int i=p1;i>0;i--) {
			arr[i][0] = arr[i-1][0];
		}
		arr[p1][0] = -1;	//����û���� �ڸ� ����
	}
	private static int[] move3(int move2_up_temp, int move2_down_temp) {
		//�������� ���� ������
		int[] ret = {arr[0][0],arr[R-1][0]};
		System.out.println("����° �ڳʿ��� �Ʒ��ΰ��°�: "+arr[0][0]);
		System.out.println("������ �ڳʿ��� ���ΰ��°�: "+arr[R-1][0]);
		for(int i=0;i<C-1;i++) {
			arr[0][i] = arr[0][i+1];
			arr[R-1][i] = arr[R-1][i+1];
		}
		arr[0][C-2] = move2_up_temp;
		arr[R-1][C-2] = move2_down_temp;
		return ret;
	}
	
	private static int move2_DOWN(int p2, int temp) {
		//�������� �Ѱ��� �ڳʰ� �̸����
		int ret = arr[R-1][C-1];
		System.out.println("�ι�° �ڳ�(������ �Ʒ�)���� �������� ���°�: "+ret);
		for(int i=R-1;p2<i;i--) {
			arr[i][C-1] = arr[i-1][C-1];
		}
		arr[p2+1][C-1] = temp;
		return ret;
	}
	
	private static int move2_UP(int p1, int temp) {
		//�������� �Ѱ��� �ڳʰ� �̸����
		int ret = arr[0][C-1];
		System.out.println("�ι�° �ڳ�(������ ��)���� �������� ���°�: "+ret);
		for(int i=0;i<p1;i++) {
			arr[i][C-1] = arr[i+1][C-1];
		}
		arr[p1-1][C-1] = temp;
		return ret;
	}
	
	private static int[] move1(int p1, int p2) {
		int[] ret = {arr[p1][C-1],arr[p2][C-1]};
		System.out.println("ù �ڳʿ��� ���ΰ��°�: "+arr[p1][C-1]);
		System.out.println("ù �ڳʿ��� �Ʒ��ΰ��°�: "+arr[p2][C-1]);
		//�������� ��ĭ�� �ű��
		for(int i=1;i<C-1;i++) {
			arr[p1][C-i] = arr[p1][C-i-1];
			arr[p2][C-i] = arr[p2][C-i-1];
		}
		arr[p1][1] = 0;
		arr[p2][1] = 0;
		return ret;
	}
	
	private static void spread() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				copy[i][j] = 0;	//ī�ǹ迭�� ����ġ�� ����ִٰ� 2�����迭 �ѹ� �� ������ arr�� �ѹ��� ���ϱ�
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j] >= 5) {	//�̼������ִ�ĭ(4���ϸ� Ȯ��ȵ�)
					int weight = arr[i][j]/5;	//Ȯ�귮
					int cnt = 0;	//��������� Ȯ��ƴ��� ī��Ʈ
					for(int k=0;k<4;k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(inBound(nx,ny)) {
							copy[nx][ny] += weight;	//ī�ǹ迭�� ����ġ �ݿ��صΰ� ���߿� �ѹ��� ��������� arr�� �ݿ�
							cnt++;
						}
					}
					arr[i][j] -= weight*cnt;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				arr[i][j] += copy[i][j];
			}
		}
	}
	private static boolean inBound(int nx, int ny) {
		if(nx>=0&&ny>=0&&nx<R&&ny<C&&arr[nx][ny]!=-1) {
			return true;
		}
		return false;
	}
}
