package problem_solve.basic.baekjoon;

import java.io.*;

public class BaekJoon9935{

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        String answer = solution(str, bomb);
        System.out.println((answer.length() == 0) ? "FRULA" : answer);

        br.close();
    }

    private static String solution(String str, String bomb){
        char[] result = new char[str.length()];
        int idx = 0;

        for (int i=0; i < str.length(); i++){
            result[idx] = str.charAt(i);
            if(isBomb(result, idx, bomb)){
                idx -= bomb.length();
            }
            idx++;
        }
        return String.valueOf(result, 0, idx);
    }

    private static boolean isBomb(char[] result, int idx, String bomb){
        if(idx < bomb.length() -1) return false;
        for(int i=0; i < bomb.length(); i++){
            if(bomb.charAt(i) != result[idx - bomb.length() + 1 + i]) return false;
        }
        return true;
    }
}