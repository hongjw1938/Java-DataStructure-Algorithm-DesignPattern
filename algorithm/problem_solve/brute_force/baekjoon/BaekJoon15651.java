package problem_solve.brute_force.baekjoon;

import java.io.*;

public class BaekJoon15651{
    static int num[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); int m = Integer.parseInt(s[1]);
        num = new int[m];
        getNext(0, n, m);

        br.close();
        bw.flush();
        bw.close();
    }
    private static void getNext(int index, int n, int m) throws IOException{
        if(index == m){
            for(int p : num){
                bw.write(p + " ");
            }
            bw.newLine();
            return;
        }

        for(int s = 1; s <= n; s++){
            num[index] = s;
            getNext(index+1, n, m);
        }
    }
}
