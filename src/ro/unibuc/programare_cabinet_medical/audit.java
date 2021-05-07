package ro.unibuc.programare_cabinet_medical;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
public class audit {

    public static audit serviceInstance = null;
    private BufferedWriter buff;

    private audit() {
        open();
    }

    private void open(){
        try {
            FileWriter g = new FileWriter("audit.csv", true);
            buff = new BufferedWriter(g);
        } catch (IOException err) {
            System.out.println("NU se poate deschide.");
        }
    }

    public static audit getInstance() {
        if (serviceInstance == null) {
            serviceInstance = new audit();

        }

        return serviceInstance;
    }

    public void scrie(String action){
        try {
            LocalDateTime t = LocalDateTime.now();
            buff.write(action + "," + t.getDayOfMonth() + "-" + t.getMonth() + "-" + t.getYear() + " "
                    + t.getHour() + ":" + t.getMinute() + ":" + t.getSecond() + '\n');
        } catch (IOException err) {
            System.out.println("Nu sse poate scrie");
        }
    }

    public void close() {
        try {
            buff.flush();
            buff.close();
        } catch (IOException err) {
            System.out.println("Nu se poate inchide");
        }
    }
}