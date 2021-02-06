package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node14 implements Comparable<Node14>{

	private int index;
	private int distance;
	
	public Node14(int index, int distance) {
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
	public int compareTo(Node14 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class main1854 {

	public static int n,m,k,temp;
	public static int[] d;
	public static ArrayList<ArrayList<Node14>> graph = new ArrayList<ArrayList<Node14>>();
	public static PriorityQueue<Integer>[] countK;	//
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		d = new int[n+1];
		countK = new PriorityQueue[n+1];
		
		for(int i=0;i<=n;i++) {	//graph초기화
			graph.add(new ArrayList<Node14>());
		}
		
		for(int i=0;i<=n;i++) {	//countK초기와
			countK[i] = new PriorityQueue<>(k);	//배열의 각 인덱스마다 크기 k의 pq로 초기화
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node14(b,c));
		}
		Arrays.fill(d, Integer.MAX_VALUE); 
		dijkstra(1);
		//최단경로없으면 -1
		//countK배열에서 각 인덱스마다의 pq의 peek을 -1 곱해서 출력
		for(int i=1;i<=n;i++) {
			if(countK[i].size() == k) {
				System.out.println(countK[i].peek() * (-1));	//넣을때 -1곱해서 내림차순이었으므로 다시 곱해서 원래 값으로 뽑는다
			}
			else {
				System.out.println(-1);
			}
		}
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node14> pq = new PriorityQueue<Node14>();
		countK[start].add(0);	//
		pq.offer(new Node14(start, 0));
		while(!pq.isEmpty()) {
			Node14 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			for(int i=0;i<graph.get(now).size();i++) {
				int cost = dist + graph.get(now).get(i).getDistance();
				
				if(countK[graph.get(now).get(i).getIndex()].size() < k) {
					countK[graph.get(now).get(i).getIndex()].add(cost*(-1));	//새로 들어오는 값 저장, -1곱해서 내림차순으로 정렬할것
					pq.add(new Node14(graph.get(now).get(i).getIndex(),cost)); 
				}
				else if(countK[graph.get(now).get(i).getIndex()].peek()*(-1) > cost) {	//kpq에 k개이상 값이 있을때 k배열 pq의 첫번째 값보다 새로 갱신된 비용이 작다면 넣는다
					countK[graph.get(now).get(i).getIndex()].poll();	//첫번째 값을 지우고
					countK[graph.get(now).get(i).getIndex()].add(cost*(-1));	//새 값을 넣는다
					pq.add(new Node14(graph.get(now).get(i).getIndex(),cost)); 
				}
			}
		}
	}
}
