package All;

public class 점프와순간이동 {

}
public class Solution16 {
    public int solution(int n) {
        int ans = 0;
        int temp = n;
        int count = 0;
        if(n==1 || n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        while(true){
            if(temp == 1){
                break;
            }
            
            if(temp%2==0){
                temp = temp/2;
            }
            else{
                temp = temp-1;
                count++;
            }
            
        }
        return count+1;
    }
}
