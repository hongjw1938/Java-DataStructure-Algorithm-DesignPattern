package tree;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int value){
        // root가 없다면
        if(root == null){
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public TreeNode get(int value){
        if(root != null){
            return root.get(value);
        }

        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value){

        if(subtreeRoot == null){
            return subtreeRoot;
        }

        // 찾는 value가 subtreeRoot의 data보다 작다면, left로 이동
        if(value < subtreeRoot.getData()){
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if(value > subtreeRoot.getData()){
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        // 삭제할 노드가 현재 subtreeRoot라면
        } else {
            // Case 1, 2 : child가 없거나 1개인 경우
            if(subtreeRoot.getLeftChild() == null){
                return subtreeRoot.getRightChild();
            } else if(subtreeRoot.getRightChild() == null){
                return subtreeRoot.getLeftChild();
            }

            // Case 3 : Node가 child를 2 갖는 경우
            // 대체할 노드를 우측의 가장 작은 노드로 지정하였음
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // 대체할 노드를 지정했으니 해당 대체 노드를 삭제해야 함
            // 우측 subtree에서 해당 현재 subtree로 대체된 값을 가진 Node를 삭제함
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }

        return subtreeRoot;
    }

    public int min(){
        if(root == null){
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max(){
        if(root == null){
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    public void traverseInOrder(){
        if(root != null){
            root.traverseInOrder();
        }
    }

    public void traversePreOrder(){
        if(root != null){
            root.traversePreOder();
        }
    }

    public void traversePostOrder(){
        if(root != null){
            root.traversePostOrder();
        }
    }
}
