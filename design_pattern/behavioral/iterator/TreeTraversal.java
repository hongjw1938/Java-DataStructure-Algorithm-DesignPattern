//package behavioral.iterator;
//
//class Node<T>{
//    public T value;
//    public Node<T> left, right, parent;
//
//    public Node(T value){
//        this.value = value;
//    }
//
//    public Node(T value, Node<T> left, Node<T> right){
//        this.value = value;
//        this.left = left;
//        this.right = right;
//
//        left.parent = right.parent = this;
//    }
//
//}
//
//class InOrderIterator<T> implements Iterator<T>{
//    private Node<T> current, root;
//    private boolean yieldedStart;
//
//    public InOderInterator(Node<T> root){
//        this.root = current = root;
//
//        while(current.left != null){
//            current = current.left;
//        }
//    }
//
//    private boolean hasRightmostParent(Node<T> node){
//        if(node.parent == null) return false;
//        else{
//            return (node == node.parent.left)
//                || hasRightmostParent(node.parent);
//        }
//    }
//
//    @Override
//    public boolean hasNext(){
//        return current.left != null
//            || current.right != null
//            || hasRightmostParent(current);
//    }
//
//    @Override
//    public T next(){
//        if(!yieldedStart){
//            yieldedStart = true;
//            return current.value;
//        }
//
//        if(current.right != null){
//            current = current.right;
//            while(current.left != null){
//                current = current.left;
//            }
//            return current.value;
//        } else {
//            Node<T> p = current.parent;
//            while(p != null && current == p.right){
//                current = p;
//                p = p.parent;
//            }
//            current = p;
//            return current.value;
//        }
//    }
//}
//
//class BinaryTree<T> implements Iterable<T>{
//    private NodE<T> root;
//
//    public BinaryTree(Node<T> root){
//        this.root = root;
//    }
//
//    @Override
//    public Iterator<T> iterator(){
//        return new InOderInterator<>(root);
//    }
//
//    @Override
//    public void forEach(Consumer<? super T> action){
//        for (T item : this){
//            action.accept(item);
//        }
//    }
//
//    @Override
//    public Spliterator<T> spliterator(){
//        return null;
//    }
//}
//public class TreeTraversal{
//    public static void main(String[] args){
//        //    1
//        //   / \
//        //  2   3
//
//        // 213
//        Node<Integer> root = new Node<>(1, new Node<>(2), new Node<>(3));
//
//        InOderInterator<Integer> it = new InOderInterator<>(root);
//
//        while(it.hasNext()){
//            System.out.print("" + it.next() + ",");
//        }
//        System.out.println();
//
//        BinaryTree<Integer> tree = new BinaryTree<>(root);
//        for(int n : tree){
//            System.out.print("" + n + ",");
//        }
//        System.out.println();
//    }
//}