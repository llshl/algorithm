package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node16 implements Comparable<Node16>{
	private int index;
	private int distance;
	
	public Node16(int index, int distance) {
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
	public int compareTo(Node16 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
	
}

public class main11779Re {

	public static int n,m,start,end;
	public static int[] d;
	public static int[] passed;
	public static ArrayList<ArrayList<Node16>> graph = new ArrayList<ArrayList<Node16>>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		d = new int[n+1];
		passed = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<Node16>());
		}
				
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node16(b,c)); 
		}
		
		Arrays.fill(d, Integer.MAX_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(d[end]);
		/*
		Stack<Integer> stack = new Stack<>();
		while(true) {
			stack.push(end);
//			int before = passed[end];
			end = passed[end];
			if(end == start) {
				stack.push(start);
				break;
			}
		}
		System.out.println(stack.size());
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		*/
		
		List<Integer> list = new ArrayList<>();
		list.add(end);	//마지막 노드부터 거꾸로 짚어간다
		while(!(passed[end] == start)) {
			int before = passed[end];
			list.add(before);
			end = before;
		}
		list.add(start);	//중간에 다 훑었으면 맨 처음 인덱스 추가해서 출력
		System.out.println(list.size()); 
		for(int i=list.size()-1;i>=0;i--) {	//내림차순이므로 거꾸로 출력
			System.out.print(list.get(i)+" ");
		}
		//오히려 리스트가 더 빠르다
		
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node16> pq = new PriorityQueue<Node16>();
		boolean[] visit = new boolean[n+1];
		d[start] = 0;
		pq.offer(new Node16(start,0));
		while(!pq.isEmpty()) {
			Node16 node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			if(visit[now] == false) {
				visit[now] = true;
				for(int i=0;i<graph.get(now).size();i++) {
					int cost = dist + graph.get(now).get(i).getDistance();
					
					//이게 여기있으며 메모리초과난다, 조건문으로 안거르고 배열값 수정이 너무 많아서 오버헤드인가
//					passed[graph.get(now).get(i).getIndex()] = now;		
					
					if(d[graph.get(now).get(i).getIndex()] > cost) {
						d[graph.get(now).get(i).getIndex()] = cost;
						pq.offer(new Node16(graph.get(now).get(i).getIndex(),cost));
						passed[graph.get(now).get(i).getIndex()] = now;	//여기가 옳은 위치 
					}
				}
			}
		}
	}
}
