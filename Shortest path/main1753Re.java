package Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node4 implements Comparable<Node4>{
	private int distance;
	private int index;
	
	
	
	public Node4(int index, int distance) {
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
	public int compareTo(Node4 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
	
}


public class main1753Re {

	public static int V,E,K;
	public static int[] d = new int[20001];
	public static ArrayList<ArrayList<Node4>> graph = new ArrayList<ArrayList<Node4>>();
	public static final int INF = (int)1e9;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		for(int i=0;i<=V;i++) {
			graph.add(new ArrayList<Node4>());
		}
		int start = sc.nextInt();
		for(int i=1;i<=E;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Node4(b,c));	//a에서 b로가는 가중치 c 간선
		}
		Arrays.fill(d, INF);
		dijkstra(start);
		for(int i=1;i<=V;i++) {
			if(d[i] == INF) {
				System.out.println("INF");
			}
			else {
				System.out.println(d[i]);
			}
		}
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node4> pq = new PriorityQueue<Node4>();
		d[start] = 0;
		pq.offer(new Node4(start,0));
		while(!pq.isEmpty()) {
			Node4 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			if(d[now] >= dist) {
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();	//두번째 get의 i라서 for문이 0부터 < 인듯
					if(d[graph.get(now).get(i).getIndex()] > cost) {
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node4(graph.get(now).get(i).getIndex(),cost));
					}
				}
			}
		}
	}
}
