package olimp.leet;

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        while (columnNumber != 0) {
            if (columnNumber < 26) {
                stringBuilder.append((char) ((int) 'A' + columnNumber));
                return stringBuilder.toString();
            }
            stringBuilder.append((char) ((int) 'A' + (columnNumber) - 1));
        }
        return "";
    }
}