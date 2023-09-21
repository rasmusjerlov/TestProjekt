package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {
    private Laegemiddel laegemiddel;
    private DagligSkaev ds;
    @BeforeEach
    void setUp() {
        LocalTime[] kl = { LocalTime.of(8, 30), LocalTime.of(12, 45),
                LocalTime.of(17, 30), LocalTime.of(20, 00) };
        double[] antal = { 2, 3, 2, 3 };
        laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        ds = new DagligSkaev(LocalDate.of(2023, 9, 21), LocalDate.of(2023,9,28), laegemiddel, kl, antal);

    }

    @Test
    void samletDosis() {
        assertEquals(80, ds.samletDosis());
    }

    @Test
    void doegnDosis() {
        assertEquals(10, ds.doegnDosis());
    }

    @Test
    void getType() {
        assertEquals("ordination.DagligSkaev", ds.getType());
    }

    @Test
    void getDoser() {

        ds.getDoser();
        assertTrue(ds.getDoser().length==4);

    }
}