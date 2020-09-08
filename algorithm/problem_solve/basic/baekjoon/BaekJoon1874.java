package problem_solve.basic.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon1874 {
    static int[] A;
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int entry = Reader.nextInt();
        A = new int[entry+1];

        StringBuilder sb = new StringBuilder();
        int num = 1;
        int index = 0;
        for(int i=0; i < entry; i++){
            int m = Reader.nextInt();
            if(A[index] <= m){
                while(num <= m){
                    index++;
                    A[index] = num++;
                    sb.append("+\n");
                }
                index--;
                sb.append("-\n");
            } else {
                bw.write("NO");
                bw.flush();
                return;
            }
        }
        System.out.println(sb);
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
        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public static void close() {
            try{
                reader.close();
            } catch (IOException e){

            }
        }
    }
}
