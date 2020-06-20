package sample.Users;

import java.util.Objects;

public class Persoana {

    protected String user;
    protected String parola;
    protected String rol;
    protected String email;
    protected String adresa;
    protected String profil;

    public Persoana() {
        this.user = "";
        this.parola = "";
        this.rol = "Client";
        this.email = "";
        this.adresa = "";
        this.profil = "";
    }

    public Persoana(String a, String b, String c) {
        this.user = a;
        this.parola = b;
        this.rol = c;
        this.email = "";
        this.adresa = "";
        this.profil = "";
    }

    public Persoana(String a, String b, String c, String d, String e, String f) {
        this.user = a;
        this.parola = b;
        this.rol = c;
        this.email = d;
        this.adresa = e;
        this.profil = f;
    }

    public boolean verificareUser(String username, String parolaIntrodusa) {
        if (getUser().equals(username) && getParola().equals(parolaIntrodusa))
            return true;
        else return false;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
        return Objects.equals(user, persoana.user) &&
                Objects.equals(parola, persoana.parola) &&
                Objects.equals(rol, persoana.rol) &&
                Objects.equals(email, persoana.email) &&
                Objects.equals(adresa, persoana.adresa) &&
                Objects.equals(profil, persoana.profil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, parola, rol, email, adresa, profil);
    }
}
