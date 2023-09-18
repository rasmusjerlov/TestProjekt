package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligFast extends Ordination{

    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, Dosis dosis) {
        super(startDen, slutDen, laegemiddel);
        this.dosis = dosis;
    }

    public void opretDosis (LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        for (int i = 0; i < doser.length; i++) {
            if (doser[i] == null) {
                doser[i] = dosis;
            }
        }
    }
    @Override
    public double samletDosis() {
        double samletDosis = 0;
        for(Dosis d : doser){
            if(d != null) {
                samletDosis += d.getAntal();
            }
        }
        return samletDosis;
    }


    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);

    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        for (int i = 0; i < doser.length; i++) {
            if (doser[i] == null){
                doser[i] = dosis;
            }

        }
    }


    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {

        return this.getClass().getName();
    }
    // TODO
}
