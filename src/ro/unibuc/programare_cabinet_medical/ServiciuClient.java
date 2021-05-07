package ro.unibuc.programare_cabinet_medical;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiciuClient {
    private ArrayList<Client> clienti;
    private static ServiciuClient instance = null;

    private ServiciuClient() {
        clienti = new ArrayList<>();
    }
    public static ServiciuClient getInstance()  {
        if(instance == null) {
            instance = new ServiciuClient();
        }
        return instance;
}
    public Client searchClientByID (int id) {
        boolean found = false;
        Client as = null;
        for (Client asist:clienti) {
            if (asist.getId() == id) {
                as = asist;
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Niciun Client cu acest ID!");
        return as;
    }
    public void afisClienti() {
        for (var pat: clienti)
            System.out.println(pat);
    }

    public ArrayList<Client> getClienti(){
        ArrayList<Client> x = new ArrayList<>();

        for (var i: clienti)
            x.add(i);

        return x;
    }

    public void addClient(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Personal data");
        System.out.print("Name: ");
        String nume = scanner.next();
        System.out.print("Data nastrii: ");
        String datan= scanner.next();
        System.out.print("Addresa: ");
        String addresa= scanner.next();
        Client client = new Client(nume,datan,addresa);
        clienti.add(client);

    }
    public void addClient(Client x) {
        clienti.add(x);
    }

    public void removeClientByID() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.print("ID-ul clientului de sters");
        int del = scanner.nextInt();
        Client med = searchClientByID(del);
        if (med == null)
            return;
        clienti.remove(med);
    }

}
