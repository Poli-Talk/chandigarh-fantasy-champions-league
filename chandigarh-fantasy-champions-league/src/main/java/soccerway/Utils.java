package soccerway;

public class Utils {

    public static String substituteRowInTemplate(String templateXPath, int row) {
        return templateXPath.replaceAll("ROW_NUM", String.valueOf(row));
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
