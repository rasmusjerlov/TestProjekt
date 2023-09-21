package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest extends Ordination {

    private DagligFast df;
    private Laegemiddel laegemiddel;

    public DagligFastTest(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

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
    }

    @Test
    void testDoegnDosis() {
    }

    @Test
    void testGetType() {
    }

    @Test
    void getDoser() {
        //Act
        df.getDoser();

        //Assert
        assert
    }

    @Override
    public double samletDosis() {
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}