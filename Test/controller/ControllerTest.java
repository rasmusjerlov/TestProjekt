package controller;

import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller c;
    private Storage s;
    private Patient Jane ;
    private Patient Finn;
    private Patient Mikael ;
    private Patient Olga ;
    private Patient Hans ;
    private Patient Yrsa;
    private Patient p = new Patient("1234592111", "Rasmus", 85.5);

    private Laegemiddel laegemiddel;
    private PN ordination;

    @BeforeEach
    void setUp() {
        this.c = Controller.getTestController();
        this.laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        this.s = c.getStorage();
        this.Jane = c.opretPatient("121256-0512", "Jane Jensen", 63.4);
        this.Finn = c.opretPatient("070985-1153", "Finn Madsen", 83.2);
        this.Mikael = c.opretPatient("070397-0915", "Mikael Petersen", 24.0);
        this.Olga = c.opretPatient("030300-1074", "Olga Jensen", 25);
        this.Hans = c.opretPatient("090990-1369", "Hans Jensen", 120);
        this.Yrsa = c.opretPatient("010195-1286", "Yrsa Hartung", 121);


        c.opretPNOrdination(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 12),
                s.getAllPatienter().get(0), laegemiddel,
                123);



        c.opretPNOrdination(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 12),
                s.getAllPatienter().get(0), laegemiddel,
                123);

        c.opretDagligFastOrdination(LocalDate.of(2021, 1, 10),
                LocalDate.of(2021, 1, 12), s.getAllPatienter().get(1),
                laegemiddel, 2, 0, 1, 0);


    }

    @Test
    void anbefaletDosisPrDoegn_TC1() {
        //Arrange
        double dosis = c.anbefaletDosisPrDoegn(Mikael, laegemiddel);

        //Assert
        assertEquals(24.0, dosis, 1.5);
    }

    @Test
    void anbefaletDosisPrDoegn_TC2() {
        //Arrange
        double dosis = c.anbefaletDosisPrDoegn(Olga, laegemiddel);

        //Assert
        assertEquals(37.5, dosis);
    }

    @Test
    void anbefaletDosisPrDoegn_TC3() {
        //Arrange
        double dosis = c.anbefaletDosisPrDoegn(Jane, laegemiddel);

        //Assert
        assertEquals(95.1, dosis);
    }

    @Test
    void anbefaletDosisPrDoegn_TC4() {
        //Arrange
        double dosis = c.anbefaletDosisPrDoegn(Hans, laegemiddel);

        //Assert
        assertEquals(180, dosis);
    }

    @Test
    void anbefaletDosisPrDoegn_TC5() {
        //Arrange
        double dosis = c.anbefaletDosisPrDoegn(Yrsa, laegemiddel);

        //Assert
        assertEquals(242, dosis);
    }

    @Test
    void antalOrdinationerPrVægtPrLægemiddel_TC1() {
        //Arrange
        double start = 40;
        double slut = 65;


        //Act
        int ordinationer = c.antalOrdinationerPrVægtPrLægemiddel(start, slut, laegemiddel);

        //Assert
        assertEquals(2, ordinationer);
    }

    @Test
    void antalOrdinationerPrVægtPrLægemiddel_TC2() {
        //Arrange
        double start = 63.4;
        double slut = 70;

        //Act
        int ordinationer = c.antalOrdinationerPrVægtPrLægemiddel(start, slut, laegemiddel);

        //Assert
        assertEquals(2, ordinationer);
    }

    @Test
    void antalOrdinationerPrVægtPrLægemiddel_TC3() {
        //Arrange
        double start = 80;
        double slut = 110;

        //Act
        int ordinationer = c.antalOrdinationerPrVægtPrLægemiddel(start, slut, laegemiddel);

        //Assert
        assertEquals(1, ordinationer);
    }

    @Test
    void opretPatient() {
        //Arrange
        String cpr = "345678-1231";
        String navn = "Peter Petersen";
        double vaegt = 86.8;

        //Act
        Patient p = c.opretPatient(cpr, navn, vaegt);

        //Assert
        assertTrue(s.getAllPatienter().contains(p));
    }

    @Test
    void opretLaegemiddel() {
        //Arrange
        String navn = "Fenta";
        double enhedPrKgDoegnLet = 2.5;
        double enhedPrKgDoegnNormal = 5.0;
        double enhedPrKgDoegnTung = 7.5;
        String enhed = "Mg";

        //Act
        Laegemiddel L1 = c.opretLaegemiddel(navn, enhedPrKgDoegnLet, enhedPrKgDoegnNormal, enhedPrKgDoegnTung, enhed);

        //Assert
        assertTrue(s.getAllLaegemidler().contains(L1));
    }
    //public void ordinationPNAnvendt(PN ordination, LocalDate dato) {
    //		if (dato.isBefore(ordination.getStartDen())) {
    //			throw new IllegalArgumentException("Datoen er ikke indenfor ordinationens gyldighedsperiode");
    //		}
    //		if (dato.isAfter(ordination.getSlutDen())) {
    //			throw new IllegalArgumentException("Datoen er ikke indenfor ordinationens gyldighedsperiode");
    //		}
    //	}
    @Test
    void ordinationPNAnvendt_TC1() {

        //Arrange
        LocalDate start = LocalDate.of(2023, 9, 21);
        LocalDate slut = LocalDate.of(2023, 9, 24);
        double antal = 2;

        //Act
        ordination = c.opretPNOrdination(start, slut, p, laegemiddel, antal);

        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            c.ordinationPNAnvendt(ordination, LocalDate.now());
        }
    }
}