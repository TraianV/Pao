package ro.unibuc.programare_cabinet_medical;
public class Programare {
    protected String data;
    protected final int id;
    protected int nr=0;
    protected final String loc;
    protected final String client;
    protected final String medic;


    {
        this.id = ++nr;
    }

    public Programare(String data, String loc, String client, String medic) {
        this.data = data;
        this.loc = loc;
        this.client = client;
        this.medic = medic;
    }

    public int getId() {
        return id;
    }

    public String getdata() {
        return data;
    }

    public String getClient() {
        return client;
    }

    public String getLoc() {
        return loc;
    }

    public String getMedic() {
        return medic;
    }

    public void setData(String data) {
        this.data = data;
    }
}
