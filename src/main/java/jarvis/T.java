package jarvis;

import org.apache.commons.lang.StringUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by C5023792 on 11/12/2015.
 */
public class T {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        Date[] d = getDaysOfGivenMonth(new Date());
        String[] t = new String[31];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (Date date : d) {
            System.out.println(sdf.format(date));
            sb.append(sdf.format(date)).append(",");
            t[i++] = sdf.format(date);
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));

        String ss = StringUtils.chop(StringUtils.join(t, ";"));
        System.out.println(ss);


        DecimalFormat df = new DecimalFormat("00");
        ss = df.format(2);
        System.out.println(ss);
        ss = df.format(2.00);
        System.out.println(ss);
        ss = df.format(220.0);
        System.out.println(ss);
        ss = String.format("%02d", 2);
        System.out.println(ss);
        ss = String.format("%02d", 200);
        System.out.println(ss);

    }


    public static Date[] getDaysOfGivenMonth(Date month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(month);
        int min = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date[] allDays = new Date[max];
        for (int i = min - 1; i < max; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i + 1);
            allDays[i] = calendar.getTime();
        }
        return allDays;
    }
}
