package util;

public interface RowCutter {

    static String removeCharsBeforeColon(String text) {
        return text.substring(text.indexOf(":") + 2);
    }

    static String removeCharsAfterNumber(String text) {
        return text.substring(0, text.indexOf(' '));
    }

}
