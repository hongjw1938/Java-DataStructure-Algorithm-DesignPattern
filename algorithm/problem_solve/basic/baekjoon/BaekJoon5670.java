package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon5670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = null;
        StringBuilder sb = new StringBuilder();
        while((start = br.readLine()) != null) {
            int n = Integer.parseInt(start);
            TrieImpl trie = new TrieImpl();
            String[] arr = new String[n];

            for(int i=0; i < n; i++){
                String str = br.readLine();
                trie.insert(str);
                arr[i] = str;
            }

            int sum = 0;
            for(int i=0; i < arr.length; i++){
                sum += trie.check(arr[i]);
            }

            double d = (double)sum / n;
            sb.append(String.format("%.2f", d)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static class TrieImpl{
        Node root;
        public TrieImpl(){
            this.root = new Node();
            root.c = ' ';
        }

        private int charToInt(char c){
            return c - 'a';
        }

        public void insert(String str){
            Node current = this.root;
            Node[] child = current.child;
            int length = str.length();

            for(int i=0; i < length; i++){
                char c = str.charAt(i);
                int num = this.charToInt(c);

                if(child[num] == null){
                    child[num] = new Node();
                    child[num].c = c;
                    current.childVal[current.childNum++] = c;
                }

                if(i == length-1){
                    child[num].isTermial = true;
                }
                current = child[num];
                child = child[num].child;
            }
        }

        public int check(String str){
            return this.check(str, this.root);
        }

        private int check(String str, Node node){
            Node current = node;
            Node[] child = current.child;
            int length = str.length();

            int retVal = 0;
            for(int i=0; i < length; i++){
                char c = str.charAt(i);
                int num = this.charToInt(c);

                if(current.equals(this.root)){
                    current = child[num];
                    child = child[num].child;
                    retVal++;
                    continue;
                }

                if(current.childNum > 1) {
                    retVal++;
                } else {
                    if(current.isTermial){
                        retVal++;
                    }
                }
                current = child[num];
                child = child[num].child;
            }

            return retVal;
        }
    }

    static class Node{
        Node child[] = new Node[26];
        char childVal[] = new char[26];
        boolean isTermial = false;
        char c;
        int childNum = 0;
    }
}
