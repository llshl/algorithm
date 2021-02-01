package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node5 implements Comparable<Node5>{
	private int distance;
	private int index;
	
	
	public Node5(int index, int distance) {
		this.distance = distance;
		this.index = index;
	}


	public int getDistance() {
		return distance;
	}


	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(Node5 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
	
}

public class main1916 {
	
	public static int N,M;
	public static int INF = (int)1e9;
	public static int[] d = new int[1001];
	public static ArrayList<ArrayList<Node5>> graph = new ArrayList<ArrayList<Node5>>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<Node5>());
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node5(b,c));
		}
		Arrays.fill(d, INF);
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);	//end는 인자로 안넣었다. 이 뜻은 모든 최단경로를 확인하겠단뜻 시간초과나면 end도 넣어서 중간에 end에 도달하면 멈추도록 하자
		System.out.println(d[end]);
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node5> pq = new PriorityQueue<>();
		d[start] = 0;
		pq.offer(new Node5(start,0));
		while(!pq.isEmpty()) {
			Node5 node = pq.poll();
			int dist = node.getDistance();	//누적거리
			int now = node.getIndex();	//현재 위치한 노드
			if(d[now] >= dist) {
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();
					if(d[graph.get(now).get(i).getIndex()] > cost) {	//누적합+현재노드의가중치가 원래 값보다 작으면 갱신
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node5(graph.get(now).get(i).getIndex(),cost));
					}
				}
			}
		}
	}
}
