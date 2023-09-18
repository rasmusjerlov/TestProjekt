package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    private ArrayList<Dosis> doser = new ArrayList<>();
    private Patient patient;

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }


    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        this.doser.add(dosis);
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
