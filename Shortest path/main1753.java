package Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node3 implements Comparable<Node3>{
	private int distance;
	private int index;
	public Node3(int index, int distance) {
		this.index = index;
		this.distance = distance;
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
	public int compareTo(Node3 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}	
}

public class main1753 {

	public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();
	public static int[] d;	// = new int[20001];
	public static final int INF = (int)1e9; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();
		d = new int[V+1];
		
		for(int i=0;i<=V;i++) {
			graph.add(new ArrayList<Node3>());
		}
		
		for(int i=1;i<=E;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			graph.get(u).add(new Node3(v,w));	//u에서 v로가는 가중치w의 간선
		}
		Arrays.fill(d, INF);
		dijkstra(start);
		d[start] = 0;
		for(int i=1;i<=V;i++){
			if(d[i] == INF) {
				System.out.println("INF");
			}
			else {
				System.out.println(d[i]);
			}
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node3> pq = new PriorityQueue<>();
		pq.offer(new Node3(start,0));
		while(!pq.isEmpty()) {
			Node3 node = pq.poll();
			int dist = node.getDistance();
			int index = node.getIndex();
			if(d[index] >= dist) {
				for(int i=0;i<graph.get(index).size();i++) {
					int cost = dist + graph.get(index).get(i).getDistance();
					if(cost < d[graph.get(index).get(i).getIndex()]) {
						d[graph.get(index).get(i).getIndex()] = cost;
						pq.offer(new Node3(graph.get(index).get(i).getIndex(),cost));
					}
				}
			}
		}
	}
}

