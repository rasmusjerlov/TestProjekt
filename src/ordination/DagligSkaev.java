package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    private ArrayList<Dosis> dosis = new ArrayList<>();
    private Patient patient;

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Patient patient, ArrayList<Dosis> dosis) {
        super(startDen, slutDen, laegemiddel);
        this.dosis = dosis;
    }


    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        this.dosis.add(dosis);
    }

    @Override
    public double samletDosis() {
        double samletDosis = 0;
        for(Dosis d : dosis){
            if(d != null) {
                samletDosis += d.getAntal();
            }
        }
        return samletDosis;
    }

    @Override
    public double doegnDosis() {
        int antalDage = (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen());

        if (antalDage == 0) {
            return 0.0;
        }
        else {
            double totalDosis = 0.0;
            for (Dosis d : dosis) {
                totalDosis += d.getAntal();
            }
            return totalDosis / antalDage;
        }
    }

    @Override
    public String getType() {
        return null;
    }
}
