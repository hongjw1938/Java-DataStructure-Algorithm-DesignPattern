package problem_solve.basic.baekjoon;

import java.io.*;
import java.util.*;

public class BaekJoon5052{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            String[] phone = new String[n];

            boolean flag = true;
            for(int j=0; j < n; j++){
                phone[j] = br.readLine();
            }
            Arrays.sort(phone, new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    return s1.compareTo(s2);
                }
            });

            for(int j=1; j < n; j++){
                if(phone[j].startsWith(phone[j-1])){
                    flag=false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }

        br.close();
    }
}