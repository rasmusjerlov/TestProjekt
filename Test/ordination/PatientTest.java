package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
    private Patient patient = new Patient("123452-3412", "Susan", 65.3);

    @Test
    void createPn() {
        //Arrange
        LocalDate start = LocalDate.of(2023,9,21);
        LocalDate slut = LocalDate.of(2023,9,24);
        double antal = 2;

        //Act
        PN pn = patient.createPn(start, slut, laegemiddel, antal);

        //Assert
        assertTrue(patient.getOrdinationer().contains(pn));
    }

    @Test
    void createDagligFast() {
        //Arrange
        LocalDate start = LocalDate.of(2023,9,21);
        LocalDate slut = LocalDate.of(2023,9,28);
        double morgenAntal = 3;
        double middagAntal = 3;
        double aftenAntal = 3;
        double natAntal = 3;

        //Act
        DagligFast df = patient.createDagligFast(start, slut, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);

        //Assert
        assertTrue(patient.getOrdinationer().contains(df));
    }

    @Test
    void createDagligSkaev() {
        //Arrange
        LocalDate start = LocalDate.of(2023,9,21);
        LocalDate slut = LocalDate.of(2023,9,28);
        LocalTime[] kl = { LocalTime.of(8, 30), LocalTime.of(12, 45),
                LocalTime.of(17, 30), LocalTime.of(20, 00) };
        double[] antal = { 2, 3, 2, 3};

        //Act
        DagligSkaev ds = patient.createDagligSkaev(start, slut, laegemiddel, kl, antal);

        //Assert
        assertTrue(patient.getOrdinationer().contains(ds));

    }

    @Test
    void getOrdinationer() {
        assertNotNull(patient.getOrdinationer());
    }
}