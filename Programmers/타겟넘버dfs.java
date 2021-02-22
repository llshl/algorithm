package All;


class Target2 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }

	private int dfs(int[] numbers, int target, int index, int sum) {
		if(index == numbers.length) {
			if(sum == target) {
				return 1;
			}
			return 0;
		}
		
		int answer = 0;
		answer += dfs(numbers,target,index+1,sum+numbers[index]);
		answer += dfs(numbers,target,index+1,sum-numbers[index]);
		return answer; 
	}
}

public class Å¸°Ù³Ñ¹ödfs {

	public static void main(String[] args) {
		Target2 s = new Target2();
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		int answer = s.solution(numbers, target);
		System.out.println(answer);
	}

}
