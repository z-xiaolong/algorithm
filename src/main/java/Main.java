import org.apache.commons.lang3.builder.ToStringExclude;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        boolean[] tree = new boolean[3];
        System.out.println(tree[0]);
    }

    public int daysBetweenDates1(String date1, String date2) {
        int result = 0;
        String[] str1 = date1.split("-");
        String[] str2 = date2.split("-");
        int year1 = Integer.parseInt(str1[0]);
        int year2 = Integer.parseInt(str2[0]);
        int month1 = Integer.parseInt(str1[1]);
        int month2 = Integer.parseInt(str2[1]);
        int day1 = Integer.parseInt(str1[2]);
        int day2 = Integer.parseInt(str2[2]);
        int year = year1 - year2;
        int month = month1 - month2;
        int day = day1 - day2;
        return result;
    }




}
