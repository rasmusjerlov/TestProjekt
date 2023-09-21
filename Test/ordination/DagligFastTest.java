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
    void constructorTest(){
        assertEquals(df.getStartDen(),LocalDate.of(2023, 9, 21));
        assertEquals(df.getSlutDen(), LocalDate.of(2023,9,28));
        assertEquals(df.getLaegemiddel(), laegemiddel);

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
        assertEquals(12, dd);
    }

    @Test
    void testGetType() {
        //Act
        String name = df.getType();


        //Assert
        assertTrue("ordination.DagligFast".equals(name));

    }

    @Test
    void getDoser() {
        //Act
        Dosis[] doser = df.getDoser();

        //Assert
        assertTrue(doser.length == 4);

    }
}