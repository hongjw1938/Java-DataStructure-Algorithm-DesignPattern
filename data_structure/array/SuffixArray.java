package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SuffixArray {
    public static void main(String[] args){
        String text = "banana";
        ArrayList<Integer> suffixes = makeSuffixArray(text); // 접미사 배열을 생성함
        printSuffixes(text, suffixes); // 콘솔에 출력

        //patternSearch(suffixes, "nan"); // 패턴 찾기

    }

    // 접미사 배열을 만드는 메소드
    public static ArrayList<Integer> makeSuffixArray(String text){
        int len = text.length();

        // 접미사 내역을 저장하는 배열을 생성, 길이는 현재 text의 길이만큼만 하면 모두 저장이 가능함함
        // index값만 저장함으로써 메모리 낭비를 막을 수 있음
        // String 값을 모두 저장 시, 글자가 크면 클수록 메모리 낭비가 심함(N^2 수준)
        ArrayList<Integer> suffixes = new ArrayList<>();
        for(int i=0; i < len; i++){
            suffixes.add(i);
        }

        // Index만 String 값 기반으로 정렬하여 사용할 것임.
        // Collections.sort를 사용하여 O(nlogn)의 시간복잡도를 갖는 정렬 방식 사용
        // Comparator를 구현하여 index값에 해당하는 substring된 문자열을 비교함.
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = text.substring(o1);
                String b = text.substring(o2);
                return a.compareTo(b);
            }
        };
        Collections.sort(suffixes, comp);
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

    // 접미사 배열 안에서 패턴이 존재하는지 찾는 메소드
    public static boolean patternSearch(String[] suffixes, String pattern){
        int len = pattern.length();
        int left = 0; int right = suffixes.length;

        while(left < right){
            int mid = (left + right) / 2;
            int comparison = pattern.compareTo(suffixes[mid]); // 패턴값과 비교

            // 0이라면 일치하는 값이 있음을 의미
            if(comparison == 0){
                System.out.println("Pattern : " + pattern + " is found at index : " + mid);
                return true;
            }

            if(comparison < 0) right = mid;
            else left = mid + 1;
        }
        System.out.println("Pattern : " + pattern + " is not exist");
        return false;
    }
}
