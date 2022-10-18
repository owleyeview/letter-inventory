public class TestClass {
    public static void main (String[] args) {
        LetterInventory inventory1 = new LetterInventory("George W. Bush");

        LetterInventory inventory2 = new LetterInventory("Hillary Clinton");

        LetterInventory sum = inventory1.add(inventory2);
        System.out.println();
        System.out.println(inventory1.toString());
        System.out.println(inventory1.size());
        System.out.println(inventory2.toString());
        System.out.println(inventory2.size());
        System.out.println(sum.toString());
        System.out.println(sum.size());
        System.out.println();
        
    }
}
