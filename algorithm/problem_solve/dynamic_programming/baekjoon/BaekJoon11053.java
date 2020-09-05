package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11053 {
    static int[] a;
    static int[] b;
    static int[] t_a;
    static int[] t_b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        b = new int[n+1];

        t_a = new int[n+1];
        t_b = new int[n+1];
        int max_idx = 0;
        String[] s = br.readLine().split(" ");
        // Bottom-up
        for(int i=1; i <= n; i++){
            // 차례로 다음 수를 저장
            a[i] = Integer.parseInt(s[i-1]);

            int m = 0;

            // i값부터 시작해서 0보다 큰(i값이 1부터 시작) idx까지 비교
            for(int j=i; j > 0; j--){
                // 현재 추가된 수가 j index 값보다 크고
                // 부분 수열의 개수가 m index보다 j가 더 큰 경우
                if(a[i] > a[j] && b[m] < b[j]){
                    // 더 큰 부분수열의 index 값을 저장
                    m = j;
                    // 부분수열 개수가 저장된 배열의 최대값이 저장된 max_idx와 j값이 동일해지면
                    if(max_idx == j){
                        break;
                    }
                }
            }
            b[i] = b[m] + 1;
            if(b[max_idx] < b[i]){
                max_idx = i;
            }
        }
        System.out.println(b[max_idx]);

        // Top-Down
        for(int i=1; i < t_a.length; i++){
            t_a[i] = Integer.parseInt(s[i-1]);
        }
        t_b[1] = 1;
        for(int i=n-1; i >= 1; i--){
            t_b[n] = Math.max(t_b[n], topDown(t_a[n], i));
        }

        int max = 0;
        for(int i=1; i <= n; i++){
            System.out.print(t_b[i] + ", ");
            max = Math.max(max, t_b[i]);
        }
        System.out.println(max);
        br.close();
    }
    private static int topDown(int val, int i){
        if(t_b[i] > 0 && val > t_a[i]) return 1;
        if(t_b[i] > 0 && val == t_a[i]) return t_b[i];
        if(val > t_a[i] && t_b[i] > 0) return t_b[i] + 1;

        int current = t_a[i];
        for(int j=i-1; j >= 1; j--){
            t_b[i] = Math.max(t_b[i], topDown(current, j));
        }
        return 1;
    }
}
