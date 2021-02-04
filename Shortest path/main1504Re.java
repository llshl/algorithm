package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node11 implements Comparable<Node11>{
	
	private int distance;
	private int index;
	
	public Node11(int index, int distance) {
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
	public int compareTo(Node11 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
	
}

public class main1504Re {

	public static int N,E,v1,v2;
	public static int INF = (int)1e9;
	public static ArrayList<ArrayList<Node11>> graph = new ArrayList<ArrayList<Node11>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int[] d1 = new int[N+1];
		int[] d2 = new int[N+1];
		int[] d3 = new int[N+1];
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<Node11>());
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node11(b,c));
			graph.get(b).add(new Node11(a,c));
		}
		st = new StringTokenizer(br.readLine()," ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		Arrays.fill(d1, INF);
		Arrays.fill(d2, INF);		
		Arrays.fill(d3, INF);		
		dijkstra(1,d1);
		dijkstra(v1,d2);
		dijkstra(N,d3);
		
		int startTov1 = d1[v1];
		int startTov2 = d1[v2];
		
		int v1Tov2 = d2[v2];
		
		int v1Toend = d3[v1];
		int v2Toend = d3[v2];
		
		//경우는 두가지
		//start -> v1 -> v2 -> end
		//start -> v2 -> v1 -> end
		int ans = Math.min(startTov1+v1Tov2+v2Toend, startTov2+v1Tov2+v1Toend);
		if(startTov1 == INF || startTov2 == INF || v1Tov2 == INF || v1Toend == INF || v2Toend == INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
		
	}
	private static void dijkstra(int start, int[] d) {
		PriorityQueue<Node11> pq = new PriorityQueue<Node11>();
		d[start] = 0;
		pq.offer(new Node11(start, 0));
		while(!pq.isEmpty()) {
			Node11 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			for(int i=0;i<graph.get(now).size();i++) {
				int cost = dist + graph.get(now).get(i).getDistance();
				if(d[graph.get(now).get(i).getIndex()] > cost) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node11(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
}
