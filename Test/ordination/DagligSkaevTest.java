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
    void constructorTest(){
        assertEquals(ds.getStartDen().equals(LocalDate.of(2023, 9, 21)));
    }

    @Test
    void samletDosis() {
        //Act
        double samlet = ds.samletDosis();

        //Assert
        assertEquals(80, samlet);
    }

    @Test
    void doegnDosis() {
        //Act
        double doegn = ds.doegnDosis();

        //Assert
        assertEquals(10, doegn);
    }

    @Test
    void getType() {
        //Act
        String type = ds.getType();

        //Assert
        assertEquals("ordination.DagligSkaev", ds.getType());
    }

    @Test
    void getDoser() {
        //Act
        Dosis[] doser = ds.getDoser();

        //Assert
        assertTrue(doser.length==4);

    }
}