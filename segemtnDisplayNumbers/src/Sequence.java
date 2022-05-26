/**
 * sequence class where a sequence here is considered as the 3 lines creating the digits
 */
public class Sequence {
    // since each number is represented as a 3*3 cells
    private static final int NUMBER_OF_DIGITS = 9;
    private final String[] lines;

    public Sequence(String[] lines){
        this.lines = lines;

    }


    /**
     * we create a digit characters from each 3*3 characters we see from the sequence
     * @return an array of digits where each one represents the number as the characters
     */
    private Digit[] createDigits(){
        Digit[] digits = new Digit[NUMBER_OF_DIGITS];
        int i = 0;
        while (i < NUMBER_OF_DIGITS){
            int k = 0;
            char[] characters = new char[9];
            for(int j = 0 ; j < 3 ; ++ j){
                characters[k] = this.lines[j].charAt(i * 3);
                characters[k + 1] = this.lines[j].charAt(i * 3 + 1);
                characters[k + 2] = this.lines[j].charAt(i * 3 + 2);
                k += 3;
            }
            digits[i] = new Digit(characters);
            ++i;
        }

        return digits;
    }


    /**
     * we create the integer number from the digits w   here they are represented as characters
     * @return integer characters
     */
    public char[] getValueOfSequence(){
        Digit[] sequenceDigits = createDigits();
        char[] characters = new char[9];
        for(int i = 0 ; i < NUMBER_OF_DIGITS ; ++ i){
            characters[i] = sequenceDigits[i].getValue();
        }
        return characters;
    }
}
