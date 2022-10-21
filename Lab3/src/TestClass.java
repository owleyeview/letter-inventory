public class TestClass {
    public static void main (String[] args) {
        LetterInventory inventory1 = new LetterInventory("George W. Bush");

        LetterInventory inventory2 = new LetterInventory("Hillary Clinton");

        LetterInventory inventory4 = new LetterInventory("Eastern Siberia");

        LetterInventory inventory3 = new LetterInventory("DESERT WOLFPACK");

        LetterInventory inventory5 = new LetterInventory("NestedCycles");

        LetterInventory inventory6 = new LetterInventory("DrpMstr");

        LetterInventory sum = inventory1.add(inventory2);
        LetterInventory no = inventory1.subtract(inventory1);
        LetterInventory result = inventory1.subtract(inventory2);
        LetterInventory yes = inventory1.subtract(inventory4);
        LetterInventory indeed = inventory3.subtract(inventory6);
        LetterInventory fuel = inventory5.subtract(inventory2);
        LetterInventory derp = inventory6.add(inventory6);

        System.out.println();
        System.out.println(inventory1.toString());
        System.out.println(inventory1.size());
        System.out.println(inventory2.toString());
        System.out.println(inventory2.size());
        System.out.println(sum.toString());
        System.out.println(sum.size());
        System.out.println(result.toString());
        System.out.println(result.size());
        System.out.println(no.toString());
        System.out.println(no.size());
        System.out.println(yes.toString());
        System.out.println(yes.size());
        System.out.println(indeed.toString());
        System.out.println(indeed.size());
        System.out.println(fuel.toString());
        System.out.println(fuel.size());
        System.out.println(derp.toString());
        System.out.println(derp.size());
        System.out.println();
        System.out.println(derp.get('r'));

    }
}