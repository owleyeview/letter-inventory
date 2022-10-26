/*
Rashaan, Nathan, Derek and Cece
10/25/2022
CS 145
Lab 3: Letter Inventory
LetterInventory.java
*/

// A class that can be used to keep track of
// an inventory of letters of the alphabet
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
                    letterCount[character - 97] = 
                                            letterCount[character - 97] + 1;
                    // increment the total size of the letter inventory
                    totalSize++; 
                }
            }
        }
    }

    // 0 argument constructor
    public LetterInventory() {
        this.isEmpty = true;
        this.totalSize = 0;
    }

    // takes a character and returns the number of that character currently in
    // the inventory.
    public int get (char letter) throws IllegalArgumentException {
        letter = Character.toLowerCase(letter);
        if (letter >= 97 && letter <= 122) {
            return letterCount[letter - 97];
        } else {
            throw new IllegalArgumentException("Invalid character");
        }
    }

    // takes a character and an int and sets that characters count
    // to the new value
    public void set (char letter, int value) throws IllegalArgumentException {
        if (letter >= 97 && letter <= 122) {
            int oldValue = letterCount[letter - 97];
            letterCount[letter - 97] = value;
            totalSize = totalSize + (value - oldValue);
        } else {
            throw new IllegalArgumentException("Invalid character");
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
            // loop through the inventory array and concatenate (create) 
            // a string with characters from each index
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
    public LetterInventory add (LetterInventory other) {
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

    /* Given a LetterInventory object, subtracts its containing letters from 
    this LetterInventory and returns a new LetterInventory object that 
    contains the remaining letters */
    public LetterInventory subtract (LetterInventory other) {
        LetterInventory result = new LetterInventory();
        if (other.isEmpty()) {
            result.isEmpty = this.isEmpty;
            result.totalSize = this.totalSize;
            result.letterCount = this.letterCount;
            return result;
        } else {
            int lettersRemoved = 0;
            //subtracts letters that are contained in both
            for (int i = 0; i < LETTERS; i++) {
                if (this.letterCount[i] - other.letterCount[i] < 0) {
                    result.letterCount[i] = 0;
                    lettersRemoved += this.letterCount[i];
                } else {
                    result.letterCount[i] = this.letterCount[i] 
                                                - other.letterCount[i];
                    lettersRemoved += other.letterCount[i];
                }
            }
            // keeping track of the total letters in this LetterInventory
            if (lettersRemoved >= this.totalSize) {
                result.isEmpty = true;
            } else {
                result.isEmpty = false;
            }
            result.totalSize = this.totalSize - lettersRemoved;
            return result;
        }
    }
}