package util;

public interface RowCutter {

    static String removeCharsBeforeColon(String text) {
        return text.substring(text.indexOf(":") + 2);
    }

}
