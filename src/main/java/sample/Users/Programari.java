package sample.Users;

public class Programari {
    protected String numeDoctor;
    protected String ora;
    protected String zi;
    protected String luna;
    protected String detalii;
    protected String mesaj;
    protected String status;

    public Programari() {
        this.numeDoctor = "";
        this.ora = "";
        this.zi = "";
        this.luna = "";
        this.detalii = "";
        this.mesaj = "";
        this.status = "";
    }

    public Programari(String a, String b, String c, String d, String e, String f, String g) {
        this.numeDoctor = a;
        this.ora = b;
        this.zi = c;
        this.luna = d;
        this.detalii = e;
        this.mesaj = f;
        this.status = g;
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
