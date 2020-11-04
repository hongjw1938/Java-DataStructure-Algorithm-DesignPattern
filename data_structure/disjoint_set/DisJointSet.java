package disjoint_set;

public class DisJointSet {
    public static void main(String[] args){
        DisJointSet set = new DisJointSet();
        set.initialize(10);

        set.union(1, 3);
        set.union(2, 4);
        set.union(5, 6);
        set.union(7, 10);
        set.union(1, 7);
        set.union(2, 6);

        StringBuilder sb = new StringBuilder();
        sb.append("원소 1과 5는 같은 집합인가 ? ").append(set.find(1) == set.find(5) ? "YES" : "NO").append("\n");
        sb.append("원소 1과 10는 같은 집합인가 ? ").append(set.find(1) == set.find(10) ? "YES" : "NO").append("\n");
        sb.append("원소 2과 5는 같은 집합인가 ? ").append(set.find(2) == set.find(5) ? "YES" : "NO").append("\n");
        sb.append("원소 3과 7는 같은 집합인가 ? ").append(set.find(3) == set.find(7) ? "YES" : "NO").append("\n");
        sb.append("원소 3과 10는 같은 집합인가 ? ").append(set.find(3) == set.find(10) ? "YES" : "NO").append("\n");
        sb.append("원소 7과 10는 같은 집합인가 ? ").append(set.find(7) == set.find(10) ? "YES" : "NO").append("\n");

        System.out.println(sb);
    }

    static int parent[];

    // ① 초기화 연산 : 1~n 까지의 숫자가 주어진다고 가정하고 초기화
    public void initialize(int n){
        this.parent = new int[n+1];
        for(int i=1; i <= n; i++){
            this.parent[i] = i;
        }
    }

    // ② 찾기 연산 : 각 원소가 어느 집합에 속한지를 확인한다.
    // 원소의 번호를 전달하면 그것들 재귀적으로 알아낼 수 있다.
    public int find(int e){

        // 루트 노드는 자기 자신을 가리키며, 그것이 대표 집합의 번호가 된다.
        if(this.parent[e] == e) return e;

        // 자신이 가리키는 부모 집합을 찾아간다.
        return find(this.parent[e]);
    }

    // ③ 합 연산 : 전달된 두 개의 원소의 대표 집합을 동일하게 만든다.(합친다.)
    public void union(int e1, int e2){

        // 각 원소의 대표 집합을 찾아낸다.
        e1 = find(e1);
        e2 = find(e2);

        // 같은 집합인 상태라면 불 필요하다.
        if(e1 == e2) return;

        // 다른 집합이라면 더 작은 쪽으로 한 쪽의 번호를 바꾼다.
        if(e1 < e2){
            this.parent[e2] = e1;
        } else {
            this.parent[e1] = e2;
        }
    }
}
