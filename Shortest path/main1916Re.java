package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node7 implements Comparable<Node7>{

	private int distance;
	private int index;
	
	
	public Node7(int index, int distance) {
		super();
		this.distance = distance;
		this.index = index;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int compareTo(Node7 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
	
}

public class main1916Re {

	public static int N,M;
	public static ArrayList<ArrayList<Node7>> graph = new ArrayList<ArrayList<Node7>>();
	public static int INF = (int)1e9;
	public static int[] d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		d = new int[N+1];	//도시의 개수 +1
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<Node7>());
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node7(b,c)); 	//a에서출발, b가 도착, c가 비용
		}
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start =Integer.parseInt(st.nextToken());
		int end =Integer.parseInt(st.nextToken());
		Arrays.fill(d, INF);
		dijkstra(start);
		System.out.println(d[end]);
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node7> pq = new PriorityQueue<>();
		d[start] = 0;	//출발지니까 출발지까지 거리는 0
		pq.offer(new Node7(start,0));
		while(!pq.isEmpty()) {
			Node7 node = pq.poll();
			int dist = node.getDistance();	//누적거리
			int now = node.getIndex();	//현재 위치한 마을인덱스
			if(d[now] >= dist) {	//초기화를 INF로 해놨으니까 처음 방문시에는 여기 통과, 하지만 그 이후부턴 이 조건에 걸리지 않는다. 즉 방문여부판별
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();
					if(d[graph.get(now).get(i).getIndex()] > cost) {
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node7(graph.get(now).get(i).getIndex(),cost));
					}
				}
			}
		}	
	}
}
