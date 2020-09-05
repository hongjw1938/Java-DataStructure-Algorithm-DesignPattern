package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1699 {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s[] = new int[n+1];
        
        // Bottom-up
        int square = 1;
        for(int i=1; i <= n; i++){
            int p = (int)Math.pow(square+1, 2);
            if(p == i){
                s[i] = 1;
                square++;
            } else {
                int x = square;
                while(x > 0){
                    int insert = s[i - (int)Math.pow(x, 2)] + 1;
                    if(s[i] == 0){
                        s[i] = insert;
                    }
                    s[i] = Math.min(s[i], insert);
                    x--;
                }
            }
        }
        System.out.println(s[n]);
        
        // Top-Down
        dp = new int[n+1];
        dp[1] = 1;
        System.out.println(topDown(n));
        br.close();
    }
    private static int topDown(int n){
        if(n==0) return 0;
        if(dp[n] > 0) return dp[n];
        int insert = n;
        
        for(int i=(int)Math.sqrt(n); i > 1; i--){
            int tmp = n/(i*i) + topDown(n%(i*i));
            if(insert > tmp){
                insert = tmp;
            }
        }
        return dp[n] = insert;
    }
}
