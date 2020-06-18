package sample.Users;

public class Programare {
    protected String numeDoctor;
    protected String ora;
    protected String zi;
    protected String luna;
    protected String detalii;
    protected String mesaj;
    protected String status;
    protected String numeClient;

    public Programare() {
        this.numeDoctor = "";
        this.ora = "";
        this.zi = "";
        this.luna = "";
        this.detalii = "";
        this.mesaj = "";
        this.status = "";
    }

    public Programare(String a, String b, String c, String d, String e, String f, String g, String h) {
        this.numeDoctor = a;
        this.ora = b;
        this.zi = c;
        this.luna = d;
        this.detalii = e;
        this.mesaj = f;
        this.status = g;
        this.numeClient = h;
    }

    public Programare(String a, String b) {
        this.numeClient = a;
        this.ora = b;
    }


    public String getNumeDoctor() {
        return numeDoctor;
    }

    public void setNumeDoctor(String numeDoctor) {
        this.numeDoctor = numeDoctor;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public String getLuna() {
        return luna;
    }

    public void setLuna(String luna) {
        this.luna = luna;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
