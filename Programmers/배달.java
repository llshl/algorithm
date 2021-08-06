package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Bae implements Comparable<Bae> {
    int next;
    int dist;

    public Bae(int next, int dist) {
        this.next = next;
        this.dist = dist;
    }

    @Override
    public int compareTo(Bae o) {
        return this.dist - o.dist;
    }
}

class Baedal {
    static int[][] road;
    static ArrayList<Bae>[] graph;
    static int[] distance;
    static int N,K;
    public int solution(int inN, int[][] inRoad, int inK) {
        int answer = 0;
        N = inN;
        K = inK;
        road = inRoad;
        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<road.length;i++) {
        	int from = road[i][0];
        	int to = road[i][1];
        	int weight = road[i][2];
        	graph[from].add(new Bae(to,weight));
        	graph[to].add(new Bae(from,weight)); 
        }
        distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1] = 0;
        dijk();
        for(int a : distance) {
        	if(a <= K) answer++;
        }
        return answer;
    }

    private void dijk() {
        distance[1] = 0;
        PriorityQueue<Bae> pq = new PriorityQueue<>();
        pq.add(new Bae(1,0));
        
        while(!pq.isEmpty()){
            Bae temp = pq.poll();
            for(Bae nextNode : graph[temp.next]) {
            	int distanceToNextNode = nextNode.dist;
            	int stackedDistance = temp.dist;
            	int minimunDistanceIndex = nextNode.next;
            	if(distanceToNextNode + stackedDistance < distance[minimunDistanceIndex]) {
            		distance[minimunDistanceIndex] = distanceToNextNode + stackedDistance;
            		pq.add(new Bae(minimunDistanceIndex, stackedDistance + distanceToNextNode));
            	}
            }
        }
    }
}

public class ¹è´Þ {

    public static void main(String[] args) {
        Baedal s = new Baedal();
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        System.out.println(s.solution(N,road,K));
    }

}
