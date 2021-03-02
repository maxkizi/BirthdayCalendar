import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static java.time.LocalDate.now;

public class Main {

    public static void main(String[] args) {


        System.out.println(collectBirthdays(1994, 04, 23));

    }

    public static String collectBirthdays(int year, int month, int day) {
        Calendar currentCalendar = Calendar.getInstance();
        String result = "";

        Calendar myCalendar = Calendar.getInstance();
        myCalendar.set(year, month - 1, day);

        int count = 0;

        while (myCalendar.get(Calendar.YEAR) <= currentCalendar.get(Calendar.YEAR)) {
            if (currentCalendar.get(Calendar.YEAR) <= myCalendar.get(Calendar.YEAR) &&
                    currentCalendar.get(Calendar.MONTH) < myCalendar.get(Calendar.MONTH) &&
                    currentCalendar.get(Calendar.DATE) <= myCalendar.get(Calendar.DATE))
                break;
            result += formatDate(count++, day, month, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.DAY_OF_WEEK));
            myCalendar.add(Calendar.YEAR, 1);
        }


        return result;
    }

    public static String dayOfWeekAsSymbol(int i) {
        switch (i) {
            case 1:
                return "Sun";
            case 2:
                return "Mon";
            case 3:
                return "Tue";
            case 4:
                return "Wen";
            case 5:
                return "Thu";
            case 6:
                return "Fri";
            case 7:
                return "Sat";
            default:
                return "Не корректный день недели";
        }
    }

    public static String formatDate(int number, int day, int month, int year, int dayOfWeek) {
        StringBuilder builder = new StringBuilder();
        builder.append(number).append(" - ");
        if (day < 10) {
            builder.append(0);
        }
        builder.append(day).append(".");
        if (month < 10) {
            builder.append(0);
        }
        builder.append(month).append(".").append(year).append(" - ").append(dayOfWeekAsSymbol(dayOfWeek)).append(System.lineSeparator());
        return builder.toString();
    }

    //TODO реализуйте метод для построения строки в следующем виде
    //0 - 31.12.1990 - Mon
    //1 - 31.12.1991 - Tue
}
