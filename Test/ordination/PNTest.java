package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {
    private Laegemiddel laegemiddel;
    private PN pn;
    @BeforeEach
    void setUp() {

        laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        this.pn = new PN(LocalDate.of(2023, 9, 21), LocalDate.of(2023, 9,24), laegemiddel, 2.0);

    }
    void constructorTest(){
        assertEquals(pn.getStartDen(),LocalDate.of(2023, 9, 21));
        assertEquals(pn.getSlutDen(), LocalDate.of(2023,9,24));
        assertEquals(pn.getLaegemiddel(), laegemiddel);
    }

    @Test
    void test_givDosis_TC1() {
        //Arrange
        LocalDate ld = LocalDate.of(2023,9,21);

        //Act
        pn.givDosis(ld);

        //assert
        assertEquals(ld, pn.getAntalGivet().get(0));
    }

    @Test
    void test_givDosis_Tc2() {
        //Arrange
        LocalDate ld = LocalDate.of(2023,9,23);

        //Act
        pn.givDosis(ld);

        //assert
        assertEquals(ld, pn.getAntalGivet().get(0));
    }

    @Test
    void test_givDosis_Tc3() {
        //Arrange
        LocalDate ld = LocalDate.of(2023,9,24);

        //Act
        pn.givDosis(ld);

        //assert
        assertEquals(ld, pn.getAntalGivet().get(0));
    }
    @Test
    void test_givDosis_Tc4() {
        //Arrange
        LocalDate ld = LocalDate.of(2023,9,26);

        //Act
       boolean bool = pn.givDosis(ld);

        //assert
        assertEquals(false, bool);
    }

    @Test
    void test_doegnDosis_tc1() {
        //arrange
        pn.givDosis( LocalDate.of(2023,9,21));
        pn.givDosis( LocalDate.of(2023,9,23));
        pn.givDosis( LocalDate.of(2023,9,24));

        //Act
       double dd =  pn.doegnDosis();

        //assert
        assertEquals(1.5, dd, 0.01);


    }
    @Test
    void test_doegnDosis_tc2() {
        //arrange
        pn.givDosis( LocalDate.of(2023,9,21));
        pn.givDosis( LocalDate.of(2023,9,21));


        //Act
        double dd =  pn.doegnDosis();

        //assert
        assertEquals(4, dd, 0.01);


    }


    @Test
    void getType() {
        //act
        String type = pn.getType();

        //Assert
        assertEquals("ordination.PN", pn.getType());
    }

    @Test
    void samletDosis_TC1() {
        pn.givDosis( LocalDate.of(2023,9,21));
        pn.givDosis( LocalDate.of(2023,9,23));
        pn.givDosis( LocalDate.of(2023,9,24));

        //Act
        double sd = pn.samletDosis();

        //assert
        assertEquals(6, sd, 0.01);

    }
    @Test
    void samletDosis_TC2() {
        pn.givDosis( LocalDate.of(2023,9,21));
        pn.givDosis( LocalDate.of(2023,9,21));

        //Act
        double sd = pn.samletDosis();

        //assert
        assertEquals(4, sd, 0.01);

    }


    @Test
    void getAntalGangeGivet() {

        pn.givDosis( LocalDate.of(2023,9,21));
        pn.givDosis( LocalDate.of(2023,9,23));
        pn.givDosis( LocalDate.of(2023,9,24));


        int agg = pn.getAntalGangeGivet();

        //assert
        assertEquals(3, agg);

    }

    @Test
    void getAntalEnheder() {

        //act
        double ae = pn.getAntalEnheder();

        //assert
        assertEquals(2, ae, 0.01);
    }
}