package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligFast extends Ordination{

    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double morgenAntal, double middagAntal, double aftenAntal,
                      double natAntal, Dosis dosis) {
        super(startDen, slutDen, laegemiddel);
        this.doser = doser;
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



    @Override
    public double doegnDosis() {
        double totalDosis = 0.0;
        for (Dosis dosis : doser) {
            if (dosis != null){
                totalDosis += dosis.getAntal();
            }
        }
        return totalDosis;
    }


    @Override
    public String getType() {

        return this.getClass().getName();
    }
    // TODO
}
