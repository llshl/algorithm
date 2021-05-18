package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class FarNode{
	int index;
	int distance;
	public FarNode(int index, int distance) {
		super();
		this.index = index;
		this.distance = distance;
	}
}
public class 트리의지름2_1167 {

	public static int N;
	public static int farNode = 0, curDistance = 0, maxDistance = 0;
	public static List<FarNode>[] graph;
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		graph = new ArrayList[N+1];	//0번 인덱스 사용x
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a =  Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int b =  Integer.parseInt(st.nextToken());
				if(b == -1) {
					break;
				}
				int c =  Integer.parseInt(st.nextToken());
				graph[a].add(new FarNode(b,c));
				//graph[b].add(new FarNode(a,c));
			}
		}
		//시작은 임의로 1번 노드에서부터 시작
		//시작노드를 방문처리한 후 시작
		visit[1] = true;
		dfs(1);
		//첫 dfs 수행 후 가장 먼 노드의 번호를 얻을 수 있다. 그 노드에서 가장 먼 노드가 가장 큰 지름
		
		visit = new boolean[N+1];
		curDistance = 0;
		maxDistance = 0;
		visit[farNode] = true;
		dfs(farNode);
		System.out.println(maxDistance);
	}
	private static void dfs(int index) {
		for(int i=0;i<graph[index].size();i++) {
			int nextNode = graph[index].get(i).index;
			if(visit[nextNode] == false) {
				visit[nextNode] = true;
				curDistance += graph[index].get(i).distance;
				dfs(nextNode);
				curDistance -= graph[index].get(i).distance;
				visit[nextNode] = false;
			}
		}
		if(maxDistance<curDistance) {
			maxDistance = curDistance;
			farNode = index;
		}
	}
}
