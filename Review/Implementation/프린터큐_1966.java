package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Printer{
	int priority;
	int number;
	public Printer(int priority, int number) {
		super();
		this.priority = priority;
		this.number = number;
	}
}
public class 프린터큐_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int t=0;t<testcase;t++) {
			int answer = 1;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			int index = 0;
			
			List<Printer> list = new LinkedList<>();
			while(st.hasMoreTokens()) {
				int nowPriority = Integer.parseInt(st.nextToken());
				list.add(new Printer(nowPriority,index++));
			}
			
			while(true) {
				boolean flag = false;
				Printer first = list.get(0);
				for(int i=1;i<list.size();i++) {
					if(first.priority < list.get(i).priority) {	//우선순위 더 높은게 있으면
						Printer temp = list.remove(0);
						list.add(temp);
						flag = true;
						break;
					}
				}
				if(!flag) {	//가장 우선순위라면
					flag = false;
					if(first.number == M) {
						System.out.println(answer);
						break;
					}
					list.remove(0);
					answer++;
				}
			}
		}
	}
}
