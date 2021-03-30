package ro.unibuc.programare_cabinet_medical;

public class Medic {
    protected String nume;
    protected final int id;
    protected int nr=0;
    protected String loc;
    protected String Nrtel;
    protected double salariu;

    {
        this.id = ++nr;
    }

    public Medic(String nume, String loc, String nrtel,double sal)
    {
        this.nume = nume;
        this.loc = loc;
        this.Nrtel=nrtel;
        this.salariu=sal;
    }
    public String getnume()
    {

        return nume;
    }

    public void setnume(String nume)
    {

        this.nume = nume;
    }

    public String getloc()
    {

        return loc;
    }

    public void setloc(String loc)
    {

        this.loc = loc;
    }

    public String getNrtel() {
        return Nrtel;
    }

    public void setNrtel(String nrtel) {
        Nrtel = nrtel;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public int getId() {
        return id;
    }
}
