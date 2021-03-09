package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class makeOne{
	int value;
	int stage;
	public makeOne(int value, int stage) {
		this.value = value;
		this.stage = stage;
	}
}

public class main1463bfs {

	public static int answer = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		bfs(N);
		System.out.println(answer);
	}

	private static void bfs(int n) {
		Queue<makeOne> q = new LinkedList<>();
		q.add(new makeOne(n,0));
		while(!q.isEmpty()) {
			makeOne num = q.poll();
			if(num.value == 1) {
				answer = num.stage;
				break;
			}
			for(int i=0;i<3;i++) {
				if(i==0) {
					if(num.value%3==0) {
						q.add(new makeOne(num.value/3,num.stage+1));
					}
				}else if(i==1) {
					if(num.value%2==0) {
						q.add(new makeOne(num.value/2,num.stage+1));
					}
				}else {
					if(num.value > 0) {
						q.add(new makeOne(num.value-1,num.stage+1));
					}
				}
			}
		}
	}
}
