package ro.unibuc.programare_cabinet_medical;

import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Scanner;

public class ServiciuMedic {

    private ArrayList<Medic> medici;
    private static ServiciuMedic instance = null;

    private ServiciuMedic() {
        medici = new ArrayList<>();
    }

    public static ServiciuMedic getInstance() {
        if(instance == null) {
            instance = new ServiciuMedic();
        }
        return instance;
    }

    public Medic searchMedicByID (int id) {
        boolean found = false;
        Medic as = null;
        for (Medic asist:medici) {
            if (asist.getId() == id) {
                as = asist;
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Nu exista acest medic");
        return as;
    }

    public void afisListaMedici() {
        for (var med: medici)
            System.out.println(med);
    }
    public ArrayList<Medic> getMedici(){
        ArrayList<Medic> med = new ArrayList<>();

        for (var i: medici)
            med.add(i);

        return med;
    }
    public void addMedic(Medic med) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("Nume: ");
        String nume = scanner.next();
        System.out.print("Locatie: ");
        String loc = scanner.next();
        System.out.print("Numar de telfon: ");
        String nrtel = scanner.next();
        System.out.print("Salariu: ");
        double salariu = scanner.nextDouble();
        Medic medic = new Medic(nume,loc,nrtel,salariu);
        medici.add(medic);

    }
    public void addDoctor(Medic medic) {

        medici.add(medic);
    }
    public void removeMedicByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int del = scanner.nextInt();
        Medic med = searchMedicByID(del);
        if (med == null)
            return;
        medici.remove(med);
    }


}
