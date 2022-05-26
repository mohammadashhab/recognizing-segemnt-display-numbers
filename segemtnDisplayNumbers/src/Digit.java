/**
 * class in order to obtain the value of each digits and get its value and realize if its illegal
 */
public class Digit {

    private final char[] chars;


    public Digit(char[] characters){
        this.chars = characters;
    }

    /**
     * realize the number from the characters in the digit
     * @return the character that matches the digit
     */
    public char getValue(){
        if (!hasTop()){
            if (isSix()){
                return '6';
            }
            else if (isOne()){
                return '1';
            }


            if (hasLeftTop()){
                return ((isFour()) ? '4' : '?');
            }
            return ((isOne()) ? '1' : '?');

        }
        if (!hasMid()){
            if (!hasLeftTop()){
                return ((isSeven()) ? '7' : '?');
            }
            return ((isZero() ? '0' : '?'));

        }

        if (!hasRightBottom()){
            return ((isTwo()) ? '2' : '?');
        }

        if (!hasLeftTop()){
            return (isThree() ? '3' : '?');
        }

        if (!hasRightTop()){
            if(hasLeftBottom()){
                return ((isSix()) ? '6': '?');
            }
            return ((isFive()) ? '5' : '?');
        }

        if (hasLeftBottom()){
            return ((isEight()) ? '8' : '?');
        }
        return ((isNine()) ? '9' : '?');
    }

    /**
     *
     * @return true if number is zero false otherwise
     */
    private boolean isZero(){
        int[] indices = {0, 2, 4};
        return this.hasTop() && this.hasRightTop() &&
                this.hasLeftBottom() && hasLeftTop() &&
                this.chars[7] == '_' && checkEmpty(indices);
    }

    /**
     *
     * @return true if number is two false otherwise
     */
    private boolean isOne(){
        int[] indices = {0, 1, 2, 4, 7};
        return ((this.hasRightTop() && this.hasRightBottom()) || (this.hasLeftBottom() && this.hasLeftTop())) &&
                checkEmpty(indices);
    }

    /**
     *
     * @return true if number is three false otherwise
     */
    private boolean isTwo(){
        int[] indices = {0, 2, 3, 8};
        return this.hasTop() && this.hasRightTop() &&
                this.hasMid() && this.hasLeftBottom() &&
                this.chars[7] == '_' && checkEmpty(indices);
    }

    /**
     *
     * @return true if number is three false otherwise
     */
    private boolean isThree(){
        int[] indices = {0, 2, 3, 6};
        return hasTop() && hasMid()
                && hasRightTop()&& chars[7] == '_'
                && hasRightBottom() && checkEmpty(indices);
    }

    /**
     *
     * @return true if number is four false otherwise
     */
    private boolean isFour(){
        int[] indices = {0, 1, 2, 6, 7};
        return this.hasRightTop() && this.hasRightBottom()
                && hasLeftTop() && hasMid()
                && checkEmpty(indices);
    }

    /**
     *
     * @return true if number is five false otherwise
     */
    private boolean isFive(){
        int[] indices = {0, 2, 5, 6};
        return hasTop() && hasLeftTop() &&
                hasMid() && hasBottom() &&
                hasRightBottom() && checkEmpty(indices);
    }


    /**
     *
     * @return true if number is six false otherwise
     */
    private boolean isSix(){
        int[] indices = {0, 2, 5};
        return  hasLeftTop() &&
                hasMid() && hasBottom() &&
                hasRightBottom() && hasLeftBottom() &&
                checkEmpty(indices);
    }

    /**
     *
     * @return true if number is seven false otherwise
     */
    private boolean isSeven(){
        int[] indices = {0, 2, 3, 4, 6, 7};
        return this.hasRightTop() && this.hasRightBottom()
                && hasTop() && checkEmpty(indices);

    }

    /**
     *
     * @return true if number is eight false otherwise
     */
    private boolean isEight(){
        int[] indices = {0, 2};
        return hasTop() && hasLeftTop() &&
                hasMid() && hasBottom() &&
                hasRightBottom() && hasLeftBottom()&&
                hasRightTop() && checkEmpty(indices);
    }

    /**
     *
     * @return true if number is nine false otherwise
     */
    private boolean isNine(){
        int[] indices = {0, 2, 6};
        return hasTop() && hasLeftTop() &&
                hasMid() && hasBottom() &&
                hasRightBottom() && hasRightTop() &&
                checkEmpty(indices);
    }


    /**
     * check if the specified index is empty or contain a character
     * @param indices specific indices we want to check if they contain a character or empty
     * @return true if empty false otherwise
     */
    private boolean checkEmpty(int[] indices){
        for(Integer index : indices){
            if(this.chars[index] != ' '){
                return false;
            }
        }
        return true;
    }


    /**
     * check
     * @return true if the digit has a '_' at the top, false other wise
     */
    private boolean hasTop(){
        return chars[1] == '_';
    }
    /**
     * check
     * @return true if the digit has a '|' at the left top, false other wise
     */
    private boolean hasLeftTop(){
        return chars[3] == '|';
    }
    /**
     *
     * @return true if the digit has a '_' in the middle, false other wise
     */
    private boolean hasMid(){
        return chars[4] == '_';
    }

    /**
     *
     * @return true if the digit has a '|' in the right top, false other wise
     */
    private boolean hasRightTop(){ return chars[5] == '|'; }
    /**
     *
     * @return true if the digit has a '|' in the left bottom, false other wise
     */
    private boolean hasLeftBottom(){
        return chars[6] == '|';
    }
    /**
     *
     * @return true if the digit has a '_' in the bottom, false other wise
     */
    private boolean hasBottom(){
        return chars[7] == '_';
    }
    /**
     *
     * @return true if the digit has a '|' in the right bottom, false other wise
     */
    private boolean hasRightBottom(){
        return chars[8] == '|';
    }
}
