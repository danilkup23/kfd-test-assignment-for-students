package biti.danilkup23.view.utils;

import java.time.LocalDate;

public class PrintUtil {
    public static LocalDate getLocalDate(String date) {
        String[] dateSlices = date.split("\\.");
        return LocalDate.of(Integer.parseInt(dateSlices[2]), Integer.parseInt(dateSlices[1]), Integer.parseInt(dateSlices[0]));
    }

    public static String getStringDate(LocalDate date) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(date.getDayOfMonth());
        stringBuilder.append('.');

        stringBuilder.append(date.getMonthValue());
        stringBuilder.append('.');

        stringBuilder.append(date.getYear());

        return stringBuilder.toString();
    }
}
