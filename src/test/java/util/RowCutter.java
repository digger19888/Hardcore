package util;

public interface RowCutter {

    static String removeCharsBeforeColon(String text){
        return text.substring(text.indexOf(":") + 2);
    }

    static String getValueFromJsonRow(String jsonRow){
        return jsonRow
                .replaceAll("\\{\"address\":\"", "")
                .replaceAll("\"}", "");
    }

}
