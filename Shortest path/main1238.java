package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node8 implements Comparable<Node8>{

	private int distance;
	private int index;
	
	public Node8(int index, int distance) {
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
	public int compareTo(Node8 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class main1238 {
	public static int N,M,X;
	public static int INF = (int)1e9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());	//출발
		M = Integer.parseInt(st.nextToken());	//거리
		X = Integer.parseInt(st.nextToken());	//도착
		int[] dGo = new int[N+1];
		int[] dBack = new int[N+1];
		ArrayList<ArrayList<Node8>> graph = new ArrayList<ArrayList<Node8>>();
		ArrayList<ArrayList<Node8>> graph2 = new ArrayList<ArrayList<Node8>>();
		for(int i=0;i<=N;i++) {	//0번째 요소는 사용 안하니까 <=로 범위
			graph.add(new ArrayList<Node8>());
			graph2.add(new ArrayList<Node8>());	//간선 뒤집을 용도 그래프
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node8(b,c));	//a에서 b로가는 거리
			graph2.get(b).add(new Node8(a,c));	//간선을 뒤집은 그래프
		}
		Arrays.fill(dGo, INF);
		Arrays.fill(dBack, INF);
		dijkstra(X,graph,dBack);	//도착지에서 출발지로의 각각 최단경로들, 일반 다익스트라
		dijkstra(X,graph2,dGo);	//각각의 출발지에서 도착지로의 최단경로들, 간선 방향을 뒤집은 다익스트라
		
		int ans = 0;
		for(int i=1;i<N+1;i++) {
			if(ans < dGo[i] + dBack[i]) {
				ans = dGo[i] + dBack[i];
			}			
		}
		System.out.println(ans);
	}
	private static void dijkstra(int X, ArrayList<ArrayList<Node8>> graph, int[] d) {
		PriorityQueue<Node8> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		d[X] = 0;
		pq.offer(new Node8(X,0));
		while(!pq.isEmpty()) {
			Node8 node = pq.poll();
			int dist = node.getDistance();	//누적거리
			int now = node.getIndex();	//현재 위치한 마을 인덱스
			//if(d[now] >= dist) {
			if(visit[now] == false) {
				visit[now] = true;
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();
					if(d[graph.get(now).get(i).getIndex()] > cost) {
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node8(graph.get(now).get(i).getIndex(),cost));
					}
				}
			}
		}
	}
}
