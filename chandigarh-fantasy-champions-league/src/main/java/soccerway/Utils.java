package soccerway;

public class Utils {

    public static String substituteRowInTemplate(String templateXPath, int row, int tour) {
        return templateXPath.replaceAll("ROW_NUM", String.valueOf(row)).replaceAll("TOURS", String.valueOf(tour/2+1));
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
