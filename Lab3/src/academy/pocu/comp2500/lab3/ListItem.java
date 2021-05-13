package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private char bulletStyle;
    private ArrayList<ListItem> sublistItems;

    public ListItem(String text) {
        this(text, '*');
    }

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
        this.sublistItems = new ArrayList<ListItem>();
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return this.bulletStyle;
    }

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public ListItem getSublistItem(int index) {
        return this.sublistItems.get(index);
    }

    public void addSublistItem(ListItem sublistItem) {
        this.sublistItems.add(sublistItem);
    }

    public void removeSublistItem(int index) {
        assert (index < this.sublistItems.size()) : "index is exceed";

        this.sublistItems.remove(index);
    }

    public String toString() {
        int blank = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%c %s\r\n", this.bulletStyle, this.text));

        recursiveString(this, sb, blank);

        return sb.toString();
    }

    private void recursiveString(ListItem listItem, StringBuilder sb, int blank) {
        String s;
        if (listItem.sublistItems.size() == 0) {
            return;
        }

        blank += 4;
        for (ListItem listItemOther : listItem.sublistItems) {
            s = String.format("%c %s\r\n", listItemOther.getBulletStyle(), listItemOther.getText());
            addBlank(sb, blank);
            sb.append(s);
            recursiveString(listItemOther, sb, blank);
        }
    }

    private void addBlank(StringBuilder sb, int blank) {
        for (int i = 0; i < blank; i++) {
            sb.append(' ');
        }
    }
}
