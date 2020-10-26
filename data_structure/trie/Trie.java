package trie;

public class Trie {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("bar");
        trie.insert("bag");
        trie.insert("bark");
        trie.insert("dog");
        trie.insert("do");
        trie.insert("door");

        System.out.println(trie.find("bag") ? "Yes!, bag is exist!" : "No, bag does not exist..");
        System.out.println(trie.find("baga") ? "Yes!, baga is exist!" : "No, baga does not exist..");
        trie.printTrie();
    }

    Node root;
    public Trie(){
        this.root = new Node();
        this.root.isRoot = true;
        this.root.val = ' ';
    }

    private int charToInt(char c){
        return c - 'a'; // 여기서는 소문자 가정
    }

    public void insert(String str){
        int length = str.length();
        Node current = this.root;
        Node[] childs = this.root.child;
        for(int i=0; i < length; i++){
            char c = str.charAt(i);
            int num = this.charToInt(c);

            if(childs[num] == null){
                childs[num] = new Node();
                childs[num].val = c;
                current.childVals[current.childNum++] = c;
            }

            if(i == length-1){
                childs[num].isTerminal = true;
            }

            current = childs[num];
            childs = childs[num].child;
        }
    }

    public boolean find(String str){
        return this.find(this.root, str, 0);
    }

    private boolean find(Node node, String str, int idx){
        int length = str.length();
        if(length == idx && node.isTerminal){
            return true;
        }

        char c = str.charAt(idx);
        int num = this.charToInt(c);
        if(node.child[num] == null){
            return false;
        }
        return find(node.child[num], str, idx+1);
    }

    public void printTrie(){
        this.printTrie(this.root, new StringBuilder());
    }

    private void printTrie(Node node, StringBuilder sb){
        Node current = node;
        Node[] child = current.child;
        char[] childVals = current.childVals;
        StringBuilder builder = new StringBuilder(sb);

        if(!current.equals(this.root)){
            builder.append(node.val);
        }
        if(current.isTerminal){
            System.out.println(builder);
        }

        for(char c : childVals){
            if(c < 97 || c > 122){
                break;
            }
            int num = this.charToInt(c);
            printTrie(child[num], builder);
        }
    }

    private static class Node{
        Node[] child = new Node[26]; // 뒤로 연결되는 문자열 a-z 소문자를 index화하여 저장하는 배열(26개)
        boolean isRoot = false;      // 현재 노드가 Root 노드인지 여부
        boolean isTerminal = false;  // 현재 노드가 문자 완성이 되는 노드인지 여부
        int childNum = 0;            // 현재 노드에 연결된 문자열의 개수
        char val;                    // 현재 노드의 값
        char[] childVals = new char[26]; // a~z중 연결된 문자열들이 저장되는 배열
    }
}
