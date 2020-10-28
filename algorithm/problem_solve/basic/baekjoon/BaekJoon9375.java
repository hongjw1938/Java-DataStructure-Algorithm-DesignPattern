package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            Map<String, ListImpl> map = new HashMap<>();


            for(int j=0; j < n; j++){
                String str[] = br.readLine().split(" ");
                if(!map.containsKey(str[1])){
                    map.put(str[1], new ListImpl());
                }
                ListImpl list = map.get(str[1]);
                list.add(str[0]);
            }

            int sum = 1;
            for(Map.Entry<String, ListImpl> entry : map.entrySet()){
                sum *= (entry.getValue().size+1);
            }
            System.out.println(sum-1);
        }

        br.close();
    }

    private static class ListImpl{
        String[] arr;
        int size;
        int lastIndex;

        public ListImpl(){
            arr = new String[30];
        }

        public void add(String str){
            arr[lastIndex++] = str;
            size++;
        }
    }
}
