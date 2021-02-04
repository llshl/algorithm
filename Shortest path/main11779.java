package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node13 implements Comparable<Node13>{
	private int index;
	private int distance;
	
	public Node13(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Node13 other) {
		if(this.distance < other.distance) {
			return -1;	//음수는 위치바꾸기
		}
		return 1;
	}
}


public class main11779 {

	public static int N,M,start,end;
	public static int[] d;
	public static boolean[] visit;
	public static int INF = (int)1e9;
	public static int[] passed;
	public static ArrayList<ArrayList<Node13>> graph = new ArrayList<ArrayList<Node13>>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		d = new int[N+1];
		visit = new boolean[N+1];
		passed = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<Node13>());
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node13(b,c));
		}
		Arrays.fill(d, INF);
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(d[end]);
		Stack<Integer> stack = new Stack<>();
		while(true) {
			stack.add(end);
			end = passed[end];
			if(end == start) {
				stack.add(start);
				break;
			}
		}
		System.out.println(stack.size());
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node13> pq = new PriorityQueue<Node13>();
		d[start] = 0;
		pq.offer(new Node13(start,0));
		
		while(!pq.isEmpty()) {
			Node13 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			if(visit[now] == false) {
				visit[now] = true;
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();
					if(d[graph.get(now).get(i).getIndex()] > cost) {
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node13(graph.get(now).get(i).getIndex(),cost));
						passed[graph.get(now).get(i).getIndex()] = now;
					}
				}
			}
		}
	}
}

