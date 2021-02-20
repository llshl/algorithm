package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	private int stage;
	private int value;
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node(int value, int stage) {
		super();
		this.stage = stage;
		this.value = value;
	}
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=edge.length;i++) {
        	graph.add(new ArrayList<Integer>()); 
        }
        
        for(int i=0;i<edge.length;i++) {
        	graph.get(edge[i][0]).add(edge[i][1]);
        	graph.get(edge[i][1]).add(edge[i][0]); 
        }
        
        boolean[] visit = new boolean[n+1];
        int[] ans = new int[n+1];
        q.add(new Node(1,0));
        while(!q.isEmpty()) {
        	Node node = q.poll();
        	int index = node.getValue();
        	int stage = node.getStage();
        	
        	visit[index] = true;
	       	for(int i=0;i<graph.get(index).size();i++) {
	       		if(!visit[graph.get(index).get(i)]) {
	       			visit[graph.get(index).get(i)] = true;
		       		q.add(new Node(graph.get(index).get(i),stage+1));
		       		ans[graph.get(index).get(i)] = stage+1;
	       		}
	       	}
        }
        int max = -1;
        for(int a : ans) {
        	if(a > max) {
        		max = a;
        	}
        }
        for(int a : ans) {
        	if(a == max) {
        		answer++;
        	}
        }
        return answer;
    }
}


public class 가장먼노드 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 6;
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		int answer = solution.solution(n,edge);
		System.out.println(answer);
	}

}
