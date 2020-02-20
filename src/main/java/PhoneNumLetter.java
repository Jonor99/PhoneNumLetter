import java.util.*;

public class PhoneNumLetter {
    Map<Integer, String> mapNumLetter;
    List<String> combLetterList;

    public PhoneNumLetter() {
        combLetterList = new ArrayList<String>();
        mapNumLetter = new HashMap<Integer, String>() {{
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }};
    }

    public void backtrack(String combination, int[] nextNum) {
        if (nextNum.length == 0) {
            combLetterList.add(combination);
        }
        else {
            int digit = nextNum[0];
            String letters = mapNumLetter.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = mapNumLetter.get(digit).substring(i, i + 1);
                backtrack(combination + letter,deleteArray(nextNum) );
            }
        }
    }

    public int[] deleteArray(int array[]) {
        int[] arrNew = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            arrNew[i]=array[i+1];
        }
        return arrNew;
    }

    public List<String> letterCombinations(int[] digits) {
        if (digits.length != 0)
            backtrack("", digits);
        return combLetterList;
    }

    public static void main(String[] args) {
        PhoneNumLetter phoneLetter=new PhoneNumLetter();
        int[] inputNum = {2,3,4};
        phoneLetter.letterCombinations(inputNum);

        for(String letter : phoneLetter.combLetterList){
            System.out.println(letter);
        }
    }
}
