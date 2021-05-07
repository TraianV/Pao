package ro.unibuc.programare_cabinet_medical;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        ServiciuProgramari programari = ServiciuProgramari.getInstance();
        ServiciuMedic doctors = ServiciuMedic.getInstance();
        ServiciuClient clienti = ServiciuClient.getInstance();

        Citire f = Citire.getInstance();
        Scriere g = Scriere.getInstance();

        audit a = audit.getInstance();

        f.citMedic();
        f.citClienti();
        f.citProgramari();
        Interogari interogations = new Interogari();

        /*while (i>0)
        {
            if(i == 1){
            interogations.addMedic(in);
        }

            if(i == 2)
            {
                interogations.addClient(in);
            }

            if(i == 3)
            {
                interogations.addProgramare(in);
            }

            if(i == 4)
            {
                Medic medic=interogations.findMedic(in.nextInt());
                System.out.println(medic.getnume()+" "+medic.getId()+" "+medic.getloc()+" "+medic.getNrtel()+" "+medic.getSalariu()+"\n");
            }

            if(i == 5)
            {
                Client client=interogations.findClient(in.nextInt());
                System.out.println(client.getUserName()+" "+client.getId()+" "+client.getAdress()+" "+client.getdatan()+"\n");
            }

            if(i == 6)
            {
                Programare progr=interogations.findProgramare(in.nextInt());
                System.out.println(progr.getdata()+" "+progr.getId()+" "+progr.getLoc()+" "+progr.getMedic()+" "+progr.getClient()+"\n");
            }

            if(i == 7)
            {
                interogations.afismedic();
            }
            if(i == 8)
            {
                interogations.afisClient();
            }
            if(i == 9)
            {
                interogations.afisProgram();
            }
            i=in.nextInt();*/
        g.afisMedic();
        g.afisClient();
        g.afisProgramari();

        }
    }

