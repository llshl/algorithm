package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main1068dfs {

	public static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;i++) {
			graph.get(i).add(new ArrayList<Integer>());
		}

	}

}
