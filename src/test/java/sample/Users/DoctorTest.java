package sample.Users;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoctorTest {
    Doctor doctor = new Doctor("Felix", "felix@upt.ro", "Bucuresti", "L-V 10-18");

    @Test
    public void getProfil() {
        assertEquals("L-V 10-18", doctor.getProfil());
    }

    @Test
    public void setProfil() {
        doctor.setProfil("L-J 10-18, vineri liber");
        assertEquals("L-J 10-18, vineri liber", doctor.getProfil());
    }

    @Test
    public void getAdresa() {
        doctor.setAdresa("Arad");
        assertEquals("Arad", doctor.getAdresa());
    }

    @Test
    public void setAdresa() {
        assertEquals("Bucuresti", doctor.getAdresa());
    }

    @Test
    public void getNume() {
        assertEquals("Felix", doctor.getNume());
    }

    @Test
    public void setNume() {
        doctor.setNume("Mihai");
        assertEquals("Mihai", doctor.getNume());
    }

    @Test
    public void getEmail() {
        assertEquals("felix@upt.ro", doctor.getEmail());
    }

    @Test
    public void setEmail() {
        doctor.setEmail("felix@yahoo.com");
        assertEquals("felix@yahoo.com", doctor.getEmail());
    }
}