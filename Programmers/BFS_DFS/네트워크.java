package BFS_DFS;

public class 네트워크 {

	public static boolean[][] visit;
	public static boolean[] check;
	public static int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};
	public static void main(String[] args) {
		int n = 3;
		int answer = 0;
		check = new boolean[n];
		for(int i=0;i<arr.length;i++) {
			if(check[i] == false) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void dfs(int x) {
		check[x] = true;
		
		for(int i=0;i<arr.length;i++) {	//가로로이동
			if(arr[x][i] == 1 && check[i] == false) {
				dfs(i);
			}
		}
	}
}
