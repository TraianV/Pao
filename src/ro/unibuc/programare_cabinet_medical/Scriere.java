package ro.unibuc.programare_cabinet_medical;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Scriere {
    public static Scriere serviceInstance = null;

    private Scriere() {}

    public static Scriere getInstance() {
        if (serviceInstance == null) {
            serviceInstance = new Scriere();
        }

        return serviceInstance;
    }

    public void afisMedic(){
        ServiciuMedic serviciuMedic=ServiciuMedic.getInstance();
        try{
            FileWriter g = new FileWriter("Medic.csv");
            g.write("Nume,Locatie, Numar de telefon, Salariu\n");
            ArrayList<Medic> medici = serviciuMedic.getMedici();

            for (var medic: medici)
                g.write(medic.getnume() + "," + medic.getloc() + ','+ medic.getNrtel() + ','+ medic.getSalariu() + '\n');
            g.close();
        } catch (IOException err) {
            System.out.println("Nu se pot afisa medicii");
        }
        audit a = audit.getInstance();
        a.scrie("Scrie Medic");

    }
    public void afisClient() {
        ServiciuClient serviciuClient = ServiciuClient.getInstance();

        try {
            FileWriter g = new FileWriter("Client.csv");
            g.write("Nume, Data nasterii, Adresa \n");
            ArrayList<Client> Clienti = serviciuClient.getClienti();

            for (var Client: Clienti)
                g.write(Client.getUserName() + ','+ Client.getdatan()+',' + Client.getAdress()+'\n');
            g.close();
        } catch (IOException err) {
            System.out.println("Nu se pot afisa Clientii");
        }
        audit a = audit.getInstance();
        a.scrie("Scrie Client");
    }


    public void afisProgramari() {
        ServiciuProgramari serv_prog = ServiciuProgramari.getInstance();

        try {
            FileWriter g = new FileWriter("Programari.csv");
            g.write("Data, Locatia, Clientul, Medicul\n");
            ArrayList<Programare> programari = serv_prog.getProgramari();

            for (var programare: programari) {
                g.write(programare.getdata() + " " + programare.getLoc()+ " " + programare.getClient() + " " + programare.getMedic()+'\n');
            }
            g.close();
        } catch (IOException err) {
            System.out.println("Nu se pot afisa Programarile");
        }
        audit a = audit.getInstance();
        a.scrie("Scrie Programari");
    }
}
