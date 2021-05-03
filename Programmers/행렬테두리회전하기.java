package All;

import java.util.LinkedList;
import java.util.List;

class ROTA {
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        Object[] answer = {};
        int[][] arr = new int[rows+1][columns+1];
        
        for(int i=1;i<=rows;i++) {
        	for(int j=1;j<=columns;j++) {
        		arr[i][j] = ((i-1) * columns + j);
        	}
        }
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<queries.length;i++) {
        	list.add(rotation(arr,rows,columns,queries[i]));
        }
        return list;
    }

	private Integer rotation(int[][]arr, int rows, int columns, int[] range) {
		int x1 = range[0];
		int y1 = range[1];
		int x2 = range[2];
		int y2 = range[3];
		int length = ((x2-x1)+(y2-y1))*2;
		int[] oneDimension = new int[length+1];
		int index = 0;
		for(int i=y1;i<=y2;i++) {
			oneDimension[index] = arr[x1][i];
			index++;
		}
		for(int i=x1+1;i<=x2;i++) {
			oneDimension[index] = arr[i][y2];
			index++;
		}
		for(int i=y2-1;i>=y1;i--) {				//항상 왼쪽위점, 오른쪽아래점이 주어진다고했을때, 그게아니라면 x1,x2,y1,y2크기비교해서 점 위치 어딘지 파악 먼저해야할듯
			oneDimension[index] = arr[x2][i];
			index++;
		}
		for(int i=x2-1;i>=x1;i--) {
			oneDimension[index] = arr[i][y1];
			index++;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<length;i++) {
			min = Math.min(min, oneDimension[i]);
		}
		
		index = length-1;
		for(int i=y1;i<=y2;i++) {
			arr[x1][i] = oneDimension[index%length];
			index++;
		}
		for(int i=x1+1;i<=x2;i++) {
			arr[i][y2] = oneDimension[index%length];
			index++;
		}
		for(int i=y2-1;i>=y1;i--) {				//항상왼쪽위점, 오른쪽아래점이 주어진다고했을때, 그게아니라면 x1,x2,y1,y2크기비교해서 점 위치 어딘지 파악 먼저해야할듯
			arr[x2][i] = oneDimension[index%length];
			index++;
		}
		for(int i=x2-1;i>=x1;i--) {
			arr[i][y1] = oneDimension[index%length];
			index++;
		}
		return min;
	}
}


public class 행렬테두리회전하기 {

	public static void main(String[] args) {
		ROTA s = new ROTA();
		int rows = 100;
		int  columns =973;
		int[][] queries = {{1,1,100,97}};
		List<Integer> answer = s.solution(rows, columns, queries);
		for(int a : answer) {
			System.out.print(a+" ");
		}
	}
}
