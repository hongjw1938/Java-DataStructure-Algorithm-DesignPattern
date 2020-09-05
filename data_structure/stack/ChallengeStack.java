package stack;

import java.util.LinkedList;

public class ChallengeStack {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome2(String string) {
        int leng = string.length();
        ArrayBackedStack<Character> stack = new ArrayBackedStack<>(leng);
        char[] tempArray = new char[leng];
        int tempIndex = 0;
        for(int i=0; i < leng; i++){
            char val = string.charAt(i);
            if((int)val >= 97 && (int)val <= 122 ){
                stack.push(val);
                tempArray[tempIndex++] = val;
            } else if((int)val >= 65 && (int)val <= 90){
                stack.push((char)(val + 32));
                tempArray[tempIndex++] = (char)(val+32);
            } else {
                continue;
            }
        }

        tempIndex = 0;
        while(!stack.isEmpty()){
            if(tempArray[tempIndex++] != stack.pop()){
                return false;
            }
        }
        return true;
    }

    // 다른 방법
    public static boolean checkForPalindrome(String string){
        LinkedList<Character> stack = new LinkedList<>();

        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        for(int i=0; i < lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reverseString = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            reverseString.append(stack.pop());
        }

        return reverseString.toString().equals(stringNoPunctuation.toString());
    }
}
