package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2042 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree stree = new SegmentTree(n);

        // Tree root은 1부터 시작(안그러면 *2했을 때 idx 못 찾음)
        stree.init(arr, 1, 1, n);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < m+k; i++){
            st = new StringTokenizer(br.readLine());
            int inst = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(inst == 1){
                long diff = right - arr[left];

                // 기존의 배열을 바꾸지 않으면 다시 변경 시 diff가 달라짐
                arr[left] = right;
                stree.update(1, 1, n, left, diff);
            } else {
                sb.append(stree.sum(1, 1, n, left, right) + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

static class SegmentTree{
    long tree[];
    int treeSize;

    public SegmentTree(int arrSize){
        // Tree의 높이는 전체 배열 개수를 log화 한 것
        // Leaf는 n개이고, 전체 개수는 각 leaf를 더한 개수도 포함해야 하므로, log(n)의 높이로 구해야함(소수점이 있어 더 필요하니 ceil 사용)
        // Java의 log는 자연로그 함수이므로 log(2)를 통해 나누어 log2로 나누는 효과를 구함
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));

        // Tree에 들어가는 Node의 개수는 2의 높이+1 제곱의 미만 개이다.
        this.treeSize = (int) Math.pow(2, h+1);
        tree = new long[treeSize];
    }

    // 최초 Segment Tree를 구성하는 메소드
    public long init(int[] nums, int node_idx, int start, int end){
        // 만약 start == end라면 leaf 노드라는 의미
        // 즉, 배열의 값을 그대로 저장함
        if(start == end){
            return tree[node_idx] = nums[start];
        }

        // 위에서 return 못했다면 start != end
        // 그렇다면 좌측 노드와 우측 노드의 합으로 구해짐.
        // 좌측 노드의 idx는 *2 이며 우측은 *2+1 이 된다.
        return tree[node_idx] = init(nums, node_idx*2, start, (start+end)/2) +
                init(nums, node_idx*2+1, (start+end)/2+1 ,end);
    }

    // Segment Tree 내 값이 변경되는 경우
    public void update(int node_idx, int start, int end, int idx, long diff){
        // 만약 변경할 index 값이 범위 밖이면 해당 tree는 확인 불 필요
        if(idx < start || end < idx) return;

        // 변경된 차이만큼을 영향 받는 각 node에 더해줌
        tree[node_idx] += diff;

        // leaf 노드에 다다라야 값을 바꿀 수 있으므로 지속 진행
        if(start != end){
            update(node_idx*2, start, (start+end)/2, idx, diff); // 좌측 node로
            update(node_idx*2+1, (start+end)/2+1, end, idx, diff); // 우측 node로
        }
    }

    // 구하고자 하는 덧셈을 진행
    public long sum(int node_idx, int start, int end, int left, int right){
        // 범위를 벗어나게 되는 경우 더할 필요 없음
        if(left > end || right < start){
            return 0;
        }

        // 범위 내 완전히 포함 시에는 더 내려가지 않고 바로 리턴
        if(left <= start && end <= right){
            return tree[node_idx];
        }

        // 그 외의 경우 좌 / 우측으로 지속 탐색 수행
        return sum(node_idx*2, start, (start+end)/2, left, right)+
                sum(node_idx*2+1, (start+end)/2+1, end, left, right);
    }
}
}
