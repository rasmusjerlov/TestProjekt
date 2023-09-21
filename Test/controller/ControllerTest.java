package controller;

import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller c = Controller.getTestController();
    private Storage s = c.getStorage();
    private Patient Jane = c.opretPatient("121256-0512", "Jane Jensen", 63.4);
    private Patient Mikael = c.opretPatient("070397-0915", "Mikael Petersen", 24.0);
    private Patient Olga = c.opretPatient("030300-1074", "Olga Jensen", 25);
    private Patient Hans = c.opretPatient("090990-1369", "Hans Jensen", 120);
    private Patient Yrsa = c.opretPatient("010195-1286", "Yrsa Hartung", 121);

    private Laegemiddel laegemiddel = c.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");

    @Test
    void anbefaletDosisPrDoegn_TC1() {
        //Arrange
        double dosis = c.anbefaletDosisPrDoegn(Mikael, laegemiddel);

        //Assert
        assertEquals(24, dosis);
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
}