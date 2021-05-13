package academy.pocu.comp2500.lab3.app;

import academy.pocu.comp2500.lab3.ListItem;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        //ToStringWithEmptyListTest();
        /*
        testListItemString();
        testListItemStringChar();
        testAddSublistItem();
        testGetSublistItem();
        testRemoveSublistItem();
        testGetText();
        testSetText();
        testGetBulletStyle();
        testSetBulletStyle();
        testToString();
         */

        testMultiLevelList();
    }

    public static void DefaultTest() {
        System.out.println("[Default Test]");

        ListItem item = new ListItem("This is item");

        item.addSublistItem(new ListItem("This is sublist item1"));
        item.addSublistItem(new ListItem("This is sublist item2"));

        String s = item.toString();
        System.out.print(s);

        item.removeSublistItem(0);

        s = item.toString();
        System.out.print(s);
        System.out.println();
    }

    public static void testMultiLevelList() {
        ListItem item1 = new ListItem("Let the cat out of the bag");

        ListItem item2 = new ListItem("Call spade a space");
        ListItem item3 = new ListItem("Blast from the past - A");
        item1.addSublistItem(item2);
        item1.addSublistItem(item3);

        ListItem item4 = new ListItem("Share and alike");
        ListItem item5 = new ListItem("Christmas card verses");
        item3.addSublistItem(item4);
        item3.addSublistItem(item5);

        ListItem item6 = new ListItem("High and mighty");
        item5.addSublistItem(item6);

        ListItem item7 = new ListItem("Let not poor Nelly starve");
        item6.addSublistItem(item7);

        ListItem item8 = new ListItem("Stump up");
        ListItem item9 = new ListItem("Contry bumpkin");
        item5.addSublistItem(item8);
        item5.addSublistItem(item9);

        ListItem item10 = new ListItem("Al fresco");
        item9.addSublistItem(item10);

        ListItem item11 = new ListItem("Don't get mad, get even");
        ListItem item12 = new ListItem("Cat's pajamas - The");
        item10.addSublistItem(item11);
        item10.addSublistItem(item12);

        ListItem item13 = new ListItem("Can't hold a candle to");
        item5.addSublistItem(item13);


        String s = item1.toString();
        System.out.print(s);
    }

    public static void ToStringWithEmptyListTest() {
        System.out.println("[ToStringWithEmptyList Test]");

        ListItem item = new ListItem("This is item");

        item.addSublistItem(null);
        item.addSublistItem(new ListItem("hihi"));

        String s = item.toString();

        System.out.println(s);
    }

    public static void testListItemString() {
        ListItem item1 = new ListItem("This is item1");
        String s = item1.toString();
        assertEquals("* This is item1\r\n", s);
    }

    public static void testListItemStringChar() {
        ListItem item1 = new ListItem("This is item1", '1');
        String s = item1.toString();
        assertEquals("1 This is item1\r\n", s);
    }

    public static void testAddSublistItem() {
        ListItem item1 = new ListItem("This is item1");

        item1.addSublistItem(new ListItem("This is sublist item1"));
        String s = item1.toString();
        assertEquals("* This is item1\r\n    * This is sublist item1\r\n", s);
    }

    public static void testGetSublistItem() {
        ListItem item1 = new ListItem("This is item1");

        item1.addSublistItem(new ListItem("This is sublist item1"));

        ListItem sublistItem1 = item1.getSublistItem(0);
        String s = sublistItem1.getText(); // s: This is sublist item1
        System.out.println(s);
        assertEquals("This is sublist item1", s);
    }

    public static void testRemoveSublistItem() {
        ListItem item = new ListItem("This is item");

        item.addSublistItem(new ListItem("This is sublist item1"));
        item.addSublistItem(new ListItem("This is sublist item2"));

        String s = item.toString();
        /*
         * This is item
         * This is sublist item1
         * This is sublist item2
         */
        System.out.println(s);
        item.removeSublistItem(0);

        s = item.toString();
        /*
         * This is item
         * This is sublist item2
         */
        System.out.println(s);
        assertEquals(
                "* This is item\r\n" +
                        "    * This is sublist item2\r\n", s);
    }

    public static void testGetText() {
        ListItem item1 = new ListItem("This is item1");
        String s = item1.getText(); // s: This is item1
        System.out.println(s);
        assertEquals("This is item1", s);
    }

    public static void testSetText() {
        ListItem item1 = new ListItem("This is item1");
        String s = item1.getText(); // s: This is item1

        item1.setText("This is updated item1");
        s = item1.getText(); // s: This is updated item1
        System.out.println(s);
        assertEquals("This is updated item1", s);
    }

    public static void testGetBulletStyle() {
        ListItem item1 = new ListItem("This is item1");
        char c = item1.getBulletStyle(); // c: *
        System.out.println(c);
        assertEquals('*', c);
    }

    public static void testSetBulletStyle() {
        ListItem item1 = new ListItem("This is item1");
        char c = item1.getBulletStyle(); // s: This is item1
        item1.setBulletStyle('>');
        c = item1.getBulletStyle(); // c: >
        System.out.println(c);
        assertEquals('>', c);
    }

    public static void testToString() {
        ListItem item1 = new ListItem("This is item1");
        ListItem sublistItem1 = new ListItem("This is sublist item1");
        ListItem subSublistItem1 = new ListItem("This is sub-sublist item1");
        ListItem subSublistItem2 = new ListItem("This is sub-sublist item2");

        sublistItem1.addSublistItem(subSublistItem1);
        sublistItem1.addSublistItem(subSublistItem2);
        item1.addSublistItem(sublistItem1);

        String s = item1.toString();
        System.out.println(s);
        assertEquals(
                "* This is item1\r\n" +
                        "    * This is sublist item1\r\n" +
                        "        * This is sub-sublist item1\r\n" +
                        "        * This is sub-sublist item2\r\n", s);
    }

    private static void assertEquals(char c1, char c2) {
        assert (c1 == c2) : "char is not equal";
    }

    private static void assertEquals(String s1, String s2) {
        assert (s1.equals(s2)) : "String is not equal";
    }
}