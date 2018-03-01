package util.log;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logcat{
    static File file;

    static FileWriter writer;

    static {
        try {
            file = new File("/log.txt");

            writer = new FileWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getCause());
        } catch (IOException e) {
            System.out.println(e.getCause());
        }
    }

    public static void log(String info){
        Date day=new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            writer.write(df.format(day));

            writer.write(':');

            writer.write(info);

            writer.write("\r\n");

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){

        }
    }

}
