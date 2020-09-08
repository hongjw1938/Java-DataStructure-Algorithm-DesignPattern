package problem_solve.basic.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon9012 {
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Reader.nextInt();
        while(T > 0){
            char[] line = Reader.nextLine().toCharArray();
            int left_parenthesis = 0;
            T--;
            boolean flag = false;
            for(int i=0; i < line.length; i++){
                if(line[i] == '('){
                    left_parenthesis++;
                } else {
                    if(left_parenthesis == 0){
                        break;
                    } else if(i == line.length - 1 && left_parenthesis == 1){
                        flag = true;
                    } else {
                        left_parenthesis--;
                    }
                }
            }
            if(flag){
                writer.write("YES\n");
            } else {
                writer.write("NO\n");
            }
            writer.flush();
        }
        Reader.close();

    }

    static class Reader{
        static BufferedReader reader;
        static StringTokenizer token;
        public static void init(InputStream input){
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public static String nextLine() throws IOException {
            return reader.readLine();
        }

        public static String next() throws IOException{
            while(token == null || !token.hasMoreTokens()){
                token = new StringTokenizer(reader.readLine());
            }
            return token.nextToken();
        }
        public static int nextInt() throws IOException{
            return Integer.parseInt(next());
        }

        public static void close(){
            try{
                reader.close();
            } catch(IOException e){

            }
        }
    }
}

