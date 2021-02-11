package BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 여행경로 {

	public static boolean[] visit;
	public static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) {
		String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
		//String[][] tickets = {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};
		//String[][] tickets = {{"ICN","A"},{"ICN","B"},{"B","ICN"}};
		String[] answer = {};
		String start = "ICN";
		String ans = "ICN";
		visit = new boolean[tickets.length];	//티켓개수만큼
		int cnt = 0;
		dfs(start, cnt, ans, tickets);
		Collections.sort(list);
		answer = list.get(0).split(" ");
		for(String a : answer) {
			System.out.println(a);
		}
	}

	private static void dfs(String now, int cnt, String ans, String[][] tickets) {
		if(cnt == tickets.length) {
			list.add(ans);
			return;
		}
		
		for(int i=0;i<tickets.length;i++) {
			if(visit[i] == false && tickets[i][0].equals(now)) {
				visit[i] = true;
				dfs(tickets[i][1], cnt+1, ans+" "+tickets[i][1], tickets);
				visit[i] = false;
			}
		}
	}
}
