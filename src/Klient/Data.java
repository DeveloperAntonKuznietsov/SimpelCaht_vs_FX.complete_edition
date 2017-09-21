package Klient;

import javax.swing.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;

public class Data{
    private String s;
    public String data() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
       return s = simpleDateFormat.format(calendar.getTime());
    }

}
