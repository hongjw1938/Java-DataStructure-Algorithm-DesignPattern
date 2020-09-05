package problem_solve.brute_force.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BaekJoon1748 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long ans = 0;
        long digit = 0;
        for(int i=1; i <= 9; i++){
            long com = (long)Math.pow(10, i);
            digit++;
            if(com < n){
                ans += (digit * 9 * com/10);
            } else if(com == n){
                ans += (digit * 9 * com/10);
                ans += (digit+1);
                break;
            } else {
                ans += (digit * (n - (com/10) +1));
                break;
            }
        }
        System.out.print(ans);

        br.close();
    }

}
