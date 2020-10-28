package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11438 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        TreeImpl tree = new TreeImpl();
        for(int i=0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree.add(left, right);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sb.append(tree.getUnion(left, right).n).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static class TreeImpl{
        Node root;
        int size = 0;

        public TreeImpl(){
            this.root = new Node(1, 1);
            this.root.parent = null;
            this.size++;
        }

        public void add(int a, int b){
            Node parent = this.find(this.root, a);
            Node newNode = null;
            if(parent == null){
                parent = this.find(this.root, b);
                newNode = new Node(a, parent.depth+1);
            } else {
                newNode = new Node(b, parent.depth+1);
            }
            newNode.parent = parent;
            parent.childs.add(newNode);
            this.size++;
        }

        public Node find(Node node, int n){
            Node start = node;
            if(start == null){
                return null;
            }

            if(start.n == n){
                return start;
            }

            Node retNode = null;
            for(Node nd : start.childs.node){
                retNode = find(nd, n);
                if(retNode != null){
                    break;
                }
            }
            return retNode;
        }

        public boolean isEmpty(){
            return this.size == 0;
        }

        public Node getUnion(int a, int b){
            Node leftNode = this.find(this.root, a);
            Node rightNode = this.find(this.root, b);

            while(leftNode.depth > rightNode.depth){
                leftNode = leftNode.parent;
            }
            while(rightNode.depth > leftNode.depth){
                rightNode = rightNode.parent;
            }
            while(!leftNode.equals(rightNode)){
                leftNode = leftNode.parent;
                rightNode = rightNode.parent;
            }
            return leftNode;
        }
    }

    private static class Node{
        int n;
        int depth;
        Node parent;
        ListImpl childs;
        public Node(int n, int depth){
            this.n = n;
            this.childs = new ListImpl();
            this.depth = depth;
        }
    }

    private static class ListImpl{
        Node node[];
        int size = 0;
        int capacity;
        int lastIndex = 0;

        public ListImpl(){
            this.node = new Node[10];
            this.capacity = 10;
        }
        public void add(Node node){
            if(this.size == this.capacity){
                this.toDouble();
            }
            this.node[lastIndex++] = node;
        }

        public void toDouble(){
            Node[] newArr = new Node[this.capacity*2];
            System.arraycopy(this.node, 0, newArr, 0, node.length);
            this.node = newArr;
            this.capacity *= 2;
        }
    }
}
