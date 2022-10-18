

public class LetterInventory {
    public static final int LETTERS = 26;
    private boolean isEmpty;  // tracking if the inventory is empty
    private int totalSize;    // total letters in the inventory
    private int[] letterCount = new int[LETTERS];
 
    // 1 argument constructor.  Given a String, creates a LetterInventory object
    public LetterInventory(String letterString) {
        if (letterString.isEmpty()) {
            this.isEmpty = true;
            this.totalSize = 0;
        } else {
            letterString = letterString.toLowerCase();
            for (int i = 0; i < letterString.length(); i++) {
                char character = letterString.charAt(i);
                // if the character is a letter
                if (character >= 97 && character <= 122) { 
                    letterCount[character - 97] = letterCount[character - 97] + 1;
                    totalSize++; // increment the total size of the letter inventory
                }
            }
        }
    }

    public LetterInventory() {
        this.isEmpty = true;
        this.totalSize = 0;
    }

    // takes a character and returns the number of that character currently in 
    // the inventory.
    public int get (char letter) {
        letter = Character.toLowerCase(letter);
        if (letter >= 97 && letter <= 122) {
            return letterCount[letter - 97];
        } else {
            return 0;
            // **** need to make this throw an exception ****
        }
    }

    // takes a character and an int and sets that characters count
    // to the new value
    public void set (char letter, int value) {
        if (letter >= 97 && letter <= 122) {
            int oldValue = letterCount[letter - 97];
            letterCount[letter - 97] = value;
            totalSize = totalSize + (value - oldValue);
        } else {
            return;
            //  **** need to make this throw an exception ****
        }
    }

    // returns the total number of characters in the inventory
    public int size () {
        return totalSize;
    }

    // returns a boolean indicating if the inventory is empty
    public boolean isEmpty() {
        return isEmpty;
    }

    // returns a string representation of the inventory
    public String toString() {
        if (isEmpty) {
            return "[]";
        } else {
            // **** loop through the inventory array and concatonate a string with characters from each index
            String characters = "";
            for (int i = 0; i < LETTERS; i++) {
                int n = letterCount[i];
                char c = (char)(i + 97);
                for (int j = 0; j < n; j++) {
                    characters = characters + c;
                }
            }
            return "[" + characters + "]";
        } 
    }

    /* given a LetterInventory object, returns a new LetterInventory 
    object that contains the sum of the letters from this LetterInventory 
    and the given one */ 
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory();
        if (other.isEmpty()) {
            sum.isEmpty = this.isEmpty;
            sum.totalSize = this.totalSize;
            sum.letterCount = this.letterCount;
            return sum;
        } else {
            sum.totalSize = this.totalSize + other.totalSize;
            sum.isEmpty = false;
            for (int i = 0; i < LETTERS; i++) {
                sum.letterCount[i] = this.letterCount[i] + other.letterCount[i];
            }
            return sum;
        }
    }

    
    // public LetterInventory subtract(LetterInventory other) {


    // // **** after subtraction, check if the inventory is empty
    // }
}
