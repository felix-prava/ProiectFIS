package sample.Users;

public class Persoana {

    protected String user;
    protected String parola;
    protected String rol;

    public Persoana() {
        this.user = "";
        this.parola = "";
        this.rol = "Client";
    }

    public Persoana(String a, String b, String c) {
        this.user = a;
        this.parola = b;
        this.rol = c;
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


}
