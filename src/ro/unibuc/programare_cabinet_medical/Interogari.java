package ro.unibuc.programare_cabinet_medical;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Interogari {
    ArrayList<Medic> medici = new ArrayList<>();
    ArrayList<Client> clienti = new ArrayList<>();
    ArrayList<Programare> programari = new ArrayList<>();

    void addMedic(Scanner cin){
        System.out.println("Nume");
        String nume = cin.next();
        System.out.println("Locul cabinetului");
        String loc = cin.next();
        System.out.println("Numar de telefon");
        String nrtel = cin.next();
        System.out.println("Salariu:");
        double salariu = cin.nextDouble();
        Medic medic = new Medic(nume, loc, nrtel,salariu);
        medici.add(medic);
    }

    void addClient(Scanner cin){
        System.out.println("Nume");
        String nume = cin.next();
        System.out.println("Data nasterii:");
        String datan = cin.next();
        System.out.println("Adresa:");
        String adresa = cin.next();
        Client client = new Client(nume, datan, adresa);
        clienti.add(client);
    }

    void addProgramare(Scanner cin){
        System.out.println("Data:");
        String data = cin.next();
        System.out.println("Adresa:");
        String loc = cin.next();
        System.out.println("Client:");
        String client = cin.next();
        System.out.println("Medic:");
        String medic = cin.next();
        Programare programare = new Programare(data,loc,client,medic);
        programari.add(programare);
    }

    Medic findMedic(int MedicId){
        for (Medic medic : medici) {
            if (medic.getId() == MedicId)
                return medic;
        }
        return null;
    }

    Client findClient(int ClientId){
        for (Client client : clienti) {
            if (client.getId() == ClientId)
                return client;
        }
        return null;
    }

    Programare findProgramare(int ProgramareId){
        for (Programare progr : programari) {
            if (progr.getId() == ProgramareId)
                return progr;
        }
        return null;
    }

    void afismedic(){
        for(Medic medic:medici)
            System.out.println(medic.getnume()+" "+medic.getId()+" "+medic.getloc()+" "+medic.getNrtel()+" "+medic.getSalariu()+"\n");
    }

    void afisClient(){
        for(Client client:clienti)
            System.out.println(client.getUserName()+" "+client.getId()+" "+client.getAdress()+" "+client.getdatan()+"\n");
    }

    void afisProgram(){
        for(Programare progr:programari)
            System.out.println(progr.getdata()+" "+progr.getId()+" "+progr.getLoc()+" "+progr.getMedic()+" "+progr.getClient()+"\n");
    }
}

