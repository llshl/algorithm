package All;

class Tri {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] stage = new int[5][5];	//dp기록용 배열
        stage[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++) {
        	for(int j=0;j<triangle[i].length;j++) {
        		if(j==0) {
        			stage[i][j] = triangle[i][j] + stage[i-1][j];
        			continue;
        		}
        		stage[i][j] = Math.max(stage[i-1][j-1] + triangle[i][j] , stage[i-1][j] + triangle[i][j]); 
        	}
        }        
        for(int i=0;i<triangle[triangle.length-1].length;i++) {	//마지막줄에 대해 반복
        	if(answer < stage[triangle.length-1][i]) {
        		answer = stage[triangle.length-1][i];
        	}
        }
        return answer;
    }
}

public class 정수삼각형 {

	public static void main(String[] args) {
		Tri s = new Tri();
		int[][] tri = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(s.solution(tri));
	}
}
