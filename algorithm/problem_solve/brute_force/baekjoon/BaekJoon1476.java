package problem_solve.brute_force.baekjoon;
import java.io.*;
public class BaekJoon1476{
    static int[] esm = new int[3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        for(int i=0; i < 3; i++){
            esm[i] = Integer.parseInt(line[i]);
        }

        int ans = 1;
        int e = 1; int s = 1; int m = 1;
        boolean flag = check(e, s, m);
        while(!flag){
            if(e == 15){
                e = 0;
            }
            if(s == 28){
                s = 0;
            }
            if(m == 19){
                m = 0;
            }
            ans++;
            e++; s++; m++;
            flag = check(e, s, m);
        }

        System.out.println(ans);
        br.close();
    }
    private static boolean check(int e, int s, int m){
        if(e == esm[0] && s == esm[1] && m == esm[2]){
            return true;
        }
        return false;
    }

}