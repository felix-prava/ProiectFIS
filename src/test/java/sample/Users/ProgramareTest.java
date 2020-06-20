package sample.Users;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramareTest {
    Programare programare = new Programare("Felix", "12", "24", "mai", "Control periodic", "Necompletat", "In asteptare", "Andrei");

    @Test
    public void getNumeClient() {
        assertEquals("Andrei", programare.getNumeClient());
    }

    @Test
    public void setNumeClient() {
        programare.setNumeClient("Adrian");
        assertEquals("Adrian", programare.getNumeClient());
    }

    @Test
    public void getNumeDoctor() {
        assertEquals("Felix", programare.getNumeDoctor());
    }

    @Test
    public void setNumeDoctor() {
        programare.setNumeDoctor("Bogdan");
        assertEquals("Bogdan", programare.getNumeDoctor());
    }

    @Test
    public void getOra() {
        assertEquals("12", programare.getOra());
    }

    @Test
    public void setOra() {
        programare.setOra("10:30");
        assertEquals("10:30", programare.getOra());
    }

    @Test
    public void getZi() {
        assertEquals("24", programare.getZi());
    }

    @Test
    public void setZi() {
        programare.setZi("30");
        assertEquals("30", programare.getZi());
    }

    @Test
    public void getLuna() {
    }

    @Test
    public void setLuna() {
        programare.setLuna("Ianuarie");
        assertEquals("Ianuarie", programare.getLuna());
    }

    @Test
    public void getDetalii() {
        assertEquals("Control periodic", programare.getDetalii());
    }

    @Test
    public void setDetalii() {
        programare.setDetalii("Durere masea");
        assertEquals("Durere masea", programare.getDetalii());
    }

    @Test
    public void getMesaj() {
        assertEquals("Necompletat", programare.getMesaj());
    }

    @Test
    public void setMesaj() {
        programare.setMesaj("Daca poti, vino cu 15 minute mai repede");
        assertEquals("Daca poti, vino cu 15 minute mai repede", programare.getMesaj());
    }

    @Test
    public void getStatus() {
        assertEquals("In asteptare", programare.getStatus());
    }

    @Test
    public void setStatus() {
        programare.setStatus("Acceptata");
        assertEquals("Acceptata", programare.getStatus());
    }
}