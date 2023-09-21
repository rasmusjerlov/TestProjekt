package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {

    private DagligFast df;
    private Laegemiddel laegemiddel;

    @BeforeEach
    void setUp() {
        this.laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        this.df = new DagligFast(LocalDate.of(2023, 9, 21), LocalDate.of(2023,9,28), laegemiddel, 3, 3, 3, 3);

    }

    @Test
    void opretDosis() {
        //Arrange
        LocalTime tid = LocalTime.of(15,00);
        double antal = 4;
        Dosis dosis = new Dosis(tid, antal);

        //Act
        df.opretDosis(tid, antal);
        List liste = Arrays.asList(df.getDoser());
        //Assert

    }

    @Test
    void testSamletDosis() {
        //Arrange

        //Act
        double sd = df.samletDosis();

        //Assert
        assertEquals(96, sd);
    }

    @Test
    void testDoegnDosis() {
        //Arrange
        //LocalDate ld = LocalDate.of(2023, 9,21);

        //Act
        double dd = df.doegnDosis();


        //Assert
        assertEquals(4, dd);
    }

    @Test
    void testGetType() {
        //Act
        String name = df.getType();

        //Assert
        assertTrue("DagligFast".equals(name));

    }

    @Test
    void getDoser() {
        //Act
        df.getDoser();

        //Assert

    }
}