package sample.Users;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PersoanaTest {
    Persoana persoana = new Persoana("Felix", "test", "Client", "felix@upt.ro", "Targu-Jiu", "Necompletat");

    @Test
    public void verificareUser() {
        Persoana p2 = new Persoana("Andrei", "123", "Client", "andrei@yahoo.com", "Bucuresti", "Necompletat");
        assertFalse(p2.getUser().equals(persoana.getUser()) && p2.getParola().equals(persoana.getParola()));
    }

    @Test
    public void getUser() {
        assertEquals("Felix", persoana.getUser());
    }

    @Test
    public void setUser() {
        persoana.setUser("Andrei");
        assertEquals("Andrei", persoana.getUser());
    }

    @Test
    public void getParola() {
        assertEquals("test", persoana.getParola());
    }

    @Test
    public void setParola() {
        persoana.setParola("123");
        assertEquals("123", persoana.getParola());
    }

    @Test
    public void getRol() {
        assertEquals("Client", persoana.getRol());
    }

    @Test
    public void setRol() {
        persoana.setRol("Doctor");
        assertEquals("Doctor", persoana.getRol());
    }

    @Test
    public void getEmail() {
        assertEquals("felix@upt.ro", persoana.getEmail());
    }

    @Test
    public void setEmail() {
        persoana.setEmail("felix@yahoo.com");
        assertEquals("felix@yahoo.com", persoana.getEmail());
    }

    @Test
    public void testHashCode() {
        assertEquals(226847758, persoana.hashCode());
    }

    @Test
    public void getAdresa() {
        assertEquals("Targu-Jiu", persoana.getAdresa());
    }

    @Test
    public void setAdresa() {
        persoana.setAdresa("Timisoara");
        assertEquals("Timisoara", persoana.getAdresa());
    }

    @Test
    public void getProfil() {
        assertEquals("Necompletat", persoana.getProfil());
    }

    @Test
    public void setProfil() {
        persoana.setProfil("L-V 09-16");
        assertEquals("L-V 09-16", persoana.getProfil());
    }

    @Test
    public void testEquals() {
        Persoana p2 = new Persoana("Andrei", "123", "Client", "andrei@yahoo.com", "Bucuresti", "Necompletat");
        assertFalse(p2.equals(persoana));
    }


}