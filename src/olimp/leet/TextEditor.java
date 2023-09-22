package olimp.leet;

class TextEditor {

    public TextEditor() {
    }

    StringBuilder left = new StringBuilder();
    StringBuilder right = new StringBuilder();
    // String left="", right="";

    public void addText(String text) {
        left.append(text);
    }

    public int deleteText(int k) {
        if (left.length() <= k) {
            int size = left.length();
            left = new StringBuilder();
            return size;
        }
        left.setLength(left.length() - k);
        return k;
    }

    public String cursorLeft(int k) {
        if (k > left.length()) k = left.length();
        String tmp = left.substring(left.length() - k);
        left.setLength(left.length() - k);
        right.insert(0, tmp);
        if (left.length() <= 10) {
            return left.toString();
        }
        return left.substring(left.length() - 10);
    }

    public String cursorRight(int k) {
        if (k > right.length()) k = right.length();
        String tmp = right.substring(0, k);
        right = right.delete(0,k);
        left.append(tmp);


        if (left.length() <= 10) {
            return left.toString();
        }
        return left.substring(left.length() - 10);
    }
}

/**
 * Your leet.TextEditor object will be instantiated and called as such:
 * leet.TextEditor obj = new leet.TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */