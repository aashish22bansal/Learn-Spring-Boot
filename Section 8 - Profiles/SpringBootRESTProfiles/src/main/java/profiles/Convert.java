package profiles;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Convert {
    public static void main(String[] args){
        Date date = new Date("04-SEP-2023 12:30:00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gmt = new Date(sdf.format(date));
        System.out.println("GMT: "+gmt);
    }
}
