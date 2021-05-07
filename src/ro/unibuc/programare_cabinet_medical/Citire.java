package ro.unibuc.programare_cabinet_medical;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Citire {

    public static Citire serviceInstance = null;

    private Citire() {}

    public static Citire getInstance() {
        if (serviceInstance == null) {
            serviceInstance = new Citire();
        }

        return serviceInstance;
    }
    public void citMedic() throws IOException{
        ServiciuMedic medic = ServiciuMedic.getInstance();
        BufferedReader cit= new BufferedReader(new FileReader("Medic.csv"));
        String x;
        while((x = cit.readLine()) != null)
        {
            String[] a=x.split(",");
            Medic med = new Medic(a[0],a[1],a[2],Integer.parseInt(a[3]));
            medic.addMedic(med);
        }
        audit a = audit.getInstance();
        a.scrie("Citeste Medic");

    }
   public void citClienti() throws IOException{
        ServiciuClient Clienti = ServiciuClient.getInstance();
        BufferedReader cit = new BufferedReader(new FileReader("Client.csv"));
        String x;
        while((x=cit.readLine())!=null)
        {
            String[] data = x.split(",");
            Client client = new Client(data[0],data[1],data[2]);
            Clienti.addClient(client);
        }
       audit a = audit.getInstance();
       a.scrie("Citeste Client");
   }


    public void citProgramari() throws IOException {
        ServiciuProgramari Programari = ServiciuProgramari.getInstance();
        BufferedReader cit = new BufferedReader(new FileReader("Programare.csv"));
        String x;
        while ((x = cit.readLine()) != null) {
            String[] data = x.split(",");
            String timp=data[0];
            String loc=data[1];
            String client = data[2];
            String medic = data[3];
            Programare programare = new Programare(timp, loc,client, medic);
            Programari.addProgramare(programare);
        }
        cit.close();
        audit a = audit.getInstance();
        a.scrie("Citeste Programare");
    }

}