package ro.unibuc.programare_cabinet_medical;

import java.util.Date;

public class Client {
    protected final String nume;
    protected final int id;
    protected final String datan;
    protected String adresa;
    private static int nr = 0;


    public Client(String userName, String datan, String adress) {
        this.nume = userName;
        this.datan = datan;
        this.adresa = adress;
        this.id = ++nr;
    }


    public void setAdr(String adress) {
        this.adresa = adress;
    }

    public String getUserName() {
        return nume;
    }

    public int getId() {
        return id;
    }

    public String getdatan() {
        return datan;
    }

    public String getAdress() {
        return adresa;
    }
}
