package ro.unibuc.programare_cabinet_medical;


import ro.unibuc.programare_cabinet_medical.et3.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int i;

        Scanner in = new Scanner(System.in);
        DAOClienti daoClienti = DAOClienti.getDaoClienti();
        daoClienti.read();
        DAOMedici daoMedici = DAOMedici.getDaoMedici();
        daoMedici.read();
        DAOProgramare daoProgramare = DAOProgramare.getDaoProgramare();
        daoProgramare.read();
        Interogari interogations = new Interogari();
        System.out.println("Scrieti comanda");
        i=in.nextInt();

        while (i>0)
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
            System.out.println("Scrieti alta comanda");
            i=in.nextInt();

        }
    }
}
