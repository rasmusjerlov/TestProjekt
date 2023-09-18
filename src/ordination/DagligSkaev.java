package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    private ArrayList<Dosis> dosis = new ArrayList<>();
    private Patient patient;

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Patient patient, ArrayList<Dosis> dosis) {
        super(startDen, slutDen, laegemiddel, patient);
        this.dosis = dosis;
    }


    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        this.dosis.add(dosis);
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
