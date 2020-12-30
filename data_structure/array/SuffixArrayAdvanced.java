package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SuffixArrayAdvanced {
    public static void main(String[] args){
        String text = "banana";
        ArrayList<Integer> suffixes = makeSuffixArray(text); // 접미사 배열을 생성함
        printSuffixes(text, suffixes); // 콘솔에 출력
    }

    // 접미사 배열을 만드는 메소드
    public static ArrayList<Integer> makeSuffixArray(String text){

        // 이 값은 문자열의 0, 1, 3, 7번째를 비교하기 위해 사용함.
        // 처음에는 0번째에서 시작한 뒤, t를 더해 1번째로 넘어갈 것임. 아래에서 t*2를 수행하여 이동하는 코드를 추가함
        int t = 1;

        int n = text.length();

        // 접미사 내역을 저장하는 배열을 생성, 길이는 현재 text의 길이만큼만 하면 모두 저장이 가능함함
        // index값만 저장함으로써 메모리 낭비를 막을 수 있음
        // String 값을 모두 저장 시, 글자가 크면 클수록 메모리 낭비가 심함(N^2 수준)
        ArrayList<Integer> suffixes = new ArrayList<>();

        // group은 각 문자열을 잘라낸 후 해당 문자열이 속할 group을 지정하기 위해 사용
        // 결국 1개씩 각각 모든 그룹에 속할 것이므로 group도 len 만큼 생성함
        int[] group = new int[n];

        for(int i=0; i < n; i++){
            // 각 index 값을 array list에 넣는다.
            suffixes.add(i);

            // 각 index에 해당하는 문자열의 그룹을 초기에는 각 접미사의 첫 글자를 기준으로 설정
            // 모두 소문자만 제공된다고 가정함
            group[i] = text.charAt(i) - 'a';
        }

        // 비교할 위치를 지정하는 t의 값이 전체 문자열의 길이를 넘지 못해야 한다.
        while(t < n){
            // Comparator inner class에서 참조하기 위해서 finalGroup, finalT으로 복제
            int[] finalGroup = group;
            int finalT = t;

            // Index만 String 값 기반으로 정렬하여 사용할 것임.
            // Comparator를 구현하여 index값에 해당하는 substring된 문자열을 비교함.
            Comparator<Integer> comp = new Comparator<Integer>() {
                @Override
                public int compare(Integer index1, Integer index2) {
                    // index1의 접미사와 index2의 접미사의 그룹이 다르다면
                    // 그룹 번호가 더 큰 것이 더 뒤의 문자임. 따라서 그 크기를 비교하여 반환
                    if(finalGroup[index1] != finalGroup[index2]){
                        return finalGroup[index1] - finalGroup[index2];
                    }

                    // 만약 두 index의 접미사가 그룹이 같다면
                    // 현재 위치의 문자로는 비교가 불가하므로 다음 비교할 문자의 group을 기준으로 비교함
                    // t를 더함으로써 전체 길이와 같거나 넘어가면 -1로 설정하여, 문자가 완료되었음을 표시한다.
                    int left = index1 + finalT >= n ? -1 : index1 + finalT;
                    int right = index2 + finalT >= n ? -1 : index2 + finalT;
                    return left - right;
                }
            };

            // Collections.sort를 사용하여 O(nlogn)의 시간복잡도를 갖는 정렬 방식 사용
            Collections.sort(suffixes, comp);

            // 정렬을 진행한 뒤에는 현재 정렬된 상태의 내역들을 각 그룹으로 묶어줄 값을 저장해야함
            int[] newGroup = new int[n];

            // ArrayList의 제일 첫 번째에 있다는 것은 현재 비교된 문자를 기준으로 가장 앞에 있다는 의미이므로
            // 0번 그룹으로 매칭
            newGroup[suffixes.get(0)] = 0;

            for(int i=1; i < n; i++){
                // i-1번째의 접미사가 i번째의 접미사보다 더 그룹 번호가 크다면, i-1번째 그룹의 +1의 그룹으로 속하도록 함
                if(group[suffixes.get(i-1)] < group[suffixes.get(i)]){
                    newGroup[suffixes.get(i)] = newGroup[suffixes.get(i-1)] + 1;
                // 아니라면 같은 그룹으로 속하도록 함
                } else {
                    newGroup[suffixes.get(i)] = newGroup[suffixes.get(i-1)];
                }
            }
            group = newGroup; // 새로 지정된 그룹을 최신 그룹으로 지정함
            t *= 2; // t값에 2를 곱함
        }

        return suffixes;
    }

    // 접미사 내역을 printing
    public static void printSuffixes(String text, ArrayList<Integer> suffixes){
        // 정렬된 Index 출력
        for(int i : suffixes){
            System.out.print(i + ", ");
        }
        System.out.println();

        // 정렬된 Index를 가진 ArrayList를 기반으로 String을 SubString하여 출력
        for(int i : suffixes){
            System.out.print(text.substring(i) + ", ");
        }
        System.out.println();
    }
}
