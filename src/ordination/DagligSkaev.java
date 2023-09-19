package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    private ArrayList<Dosis> doser = new ArrayList<>();


    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, LocalTime[] klokkeSlet, double[] antalEnheder) {
        super(startDen, slutDen, laegemiddel);
        for (int i = 0; i < klokkeSlet.length; i++) {
            opretDosis(klokkeSlet[i], antalEnheder[i]);

        }
    }


    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        this.doser.add(dosis);
    }

    @Override
    public double samletDosis() {
        return doegnDosis() * super.antalDage();
    }

    @Override
    public double doegnDosis() {
        int antalDage = super.antalDage();
        if (antalDage == 0) {
            return 0.0;
        } else {
            double totalDosis = 0.0;
            for (Dosis d : doser) {
                totalDosis += d.getAntal();
            }
            return totalDosis;
        }
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }

    public Dosis[] getDoser() {
        Dosis[] doserArray = new Dosis[doser.size()];
        doser.toArray(doserArray);
        return doserArray;
    }
}
