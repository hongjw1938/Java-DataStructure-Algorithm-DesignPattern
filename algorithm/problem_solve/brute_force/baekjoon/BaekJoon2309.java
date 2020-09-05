package problem_solve.brute_force.baekjoon;
import java.io.*;
public class BaekJoon2309{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] h = new int[9];
        boolean[] f = new boolean[9];
        int total = 0;
        for(int i=0; i < 9; i++){
            h[i] = Integer.parseInt(br.readLine());
            total += h[i];
            int idx = i;
            for(int j=idx-1; j >= 0; j--){
                if(h[j] > h[idx]){
                    int temp = h[j];
                    h[j] = h[idx];
                    h[idx] = temp;
                    idx = j;
                }
            }
        }

        int surpass = total - 100;
        for(int i=0; i < 9; i++){
            int i_val = h[i];
            int j = i+1;
            for(; j < 9; j++){
                int j_val = h[j];

                if(i_val + j_val == surpass){
                    f[i] = f[j] = true;
                    break;
                }
            }
            if(f[i]==true && f[j]==true){
                break;
            }
        }

        for(int i=0; i < 9; i++){
            if(!f[i] == true){
                System.out.println(h[i]);
            }
        }

        br.close();
    }
}