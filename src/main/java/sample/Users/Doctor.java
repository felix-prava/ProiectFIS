package sample.Users;

public class Doctor {
    private String nume;
    private String email;
    private String adresa;
    private String profil;

    public Doctor() {
        this.nume = "";
        this.email = "";
        this.adresa = "";
        this.profil = "";
    }

    public Doctor(String a, String b, String c, String d) {
        this.nume = a;
        this.email = b;
        this.adresa = c;
        this.profil = d;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

