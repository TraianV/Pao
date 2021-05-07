package ro.unibuc.programare_cabinet_medical;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class ServiciuProgramari {
    private ArrayList<Programare> Programari;
    private static ServiciuProgramari instance = null;

    private ServiciuProgramari() {
        Programari = new ArrayList<>();
    }

    public static ServiciuProgramari getInstance() {
        if(instance == null) {
            instance = new ServiciuProgramari();
        }
        return instance;
}

    public Programare searchProgramareByID (int id) {
        boolean found = false;
        Programare as = null;
        for (Programare asist:Programari) {
            if (asist.getId() == id) {
                as = asist;
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Nicio programare cu acest ID!");
        return as;
    }
    public void addProgramre() throws ParseException {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Date (Format as dd/mm/yyyy) : ");
        String date1 = scanner.next();
        System.out.println("Locul: ");
        String loc = scanner.next();
        System.out.println("Client: ");
        String Client = scanner.next();
        System.out.println("Medic: ");
        String Medic = scanner.next();

        Programare prog = new Programare(date1,loc,Client,Medic);
        Programari.add(prog);

        System.out.println("Success!");
    }
    public void addProgramare(Programare programare) {
        Programari.add(programare);
    }
    public ArrayList<Programare> getProgramari(){
        ArrayList<Programare> prog = new ArrayList<>();

        for (var i: Programari)
            prog.add(i);

        return prog;
    }
    public void removeProgramariByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Type ID for the Programari you want to remove:");
        int del = scanner.nextInt();
        Programare med = searchProgramareByID(del);
        if (med == null)
            return;
        Programari.remove(med);
    }



}
