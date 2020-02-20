public class MainTest {
    public static void main(String[] args) {
        PhoneNumLetter phoneLetter=new PhoneNumLetter();
        int[] inputNum = {2,3,4};
        phoneLetter.letterCombinations(inputNum);

        for(String letter : phoneLetter.combLetterList){
            System.out.println(letter);
        }
    }
}
