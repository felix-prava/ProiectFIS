package sample.Users;

import java.util.Objects;

public class Persoana {

    protected String nume_de_utilizator;
    protected String parola;
    protected String rol;
    protected String email;
    protected String adresa;
    protected String profil;

    public Persoana() {
        this.nume_de_utilizator = "";
        this.parola = "";
        this.rol = "Client";
        this.email = "";
        this.adresa = "";
        this.profil = "";
    }

    public Persoana(String a, String b, String c) {
        this.nume_de_utilizator = a;
        this.parola = b;
        this.rol = c;
        this.email = "";
        this.adresa = "";
        this.profil = "";
    }

    public Persoana(String a, String b, String c, String d, String e, String f) {
        this.nume_de_utilizator = a;
        this.parola = b;
        this.rol = c;
        this.email = d;
        this.adresa = e;
        this.profil = f;
    }

    public boolean verificareUser(String username, String parolaIntrodusa) {
        return getUser().equals(username) && getParola().equals(parolaIntrodusa);
    }

    public String getUser() {
        return nume_de_utilizator;
    }

    public void setUser(String user) {
        this.nume_de_utilizator = user;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return Objects.equals(nume_de_utilizator, persoana.nume_de_utilizator) &&
                Objects.equals(parola, persoana.parola) &&
                Objects.equals(rol, persoana.rol) &&
                Objects.equals(email, persoana.email) &&
                Objects.equals(adresa, persoana.adresa) &&
                Objects.equals(profil, persoana.profil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume_de_utilizator, parola, rol, email, adresa, profil);
    }
}
