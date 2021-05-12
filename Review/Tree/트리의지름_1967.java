package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node{
	int index;
	int weight;
	public Node(int index, int weight) {
		super();
		this.index = index;
		this.weight = weight;
	}
}
public class Ʈ��������_1967 {

	public static int N;
	public static List<Node>[] list;
	public static boolean[] visit;
	public static int distance = 0, nodeIndex = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		list = new ArrayList[N+1];	//��ȣ 1���ʹϰ� N+1
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<Node>();
		}
		for(int i=0;i<N-1;i++) {
			String[] temp = br.readLine().split(" ");
			list[Integer.valueOf(temp[0])].add(new Node(Integer.valueOf(temp[1]),Integer.valueOf(temp[2])));
			list[Integer.valueOf(temp[1])].add(new Node(Integer.valueOf(temp[0]),Integer.valueOf(temp[2])));
		}
		for(int i=0;i<list[1].size();i++) {
			findFarestNode(1,0);	//1�������� ���� �ָ��ִ� ����� �ε����� �Ÿ� ã��
		}
		visit = new boolean[N+1];
		findFarestNode(nodeIndex,0);
		System.out.println(distance);

	}
	private static void findFarestNode(int start, int weight) {
		visit[start] = true;
		for(int i=0;i<list[start].size();i++) {
			if(!visit[list[start].get(i).index]) {
				findFarestNode(list[start].get(i).index, weight+list[start].get(i).weight);
			}
		}
		//for���� if�� �� �ɷ��� ���Ⱑ ����ȴٴ°��� ����� ���簣�� ������ �Դٴ°� ���⼭ �ִ� �Ÿ� ��
		if(distance < weight) {
			distance = weight;
			nodeIndex = start;
		}
		visit[start] = false;
	}
}
