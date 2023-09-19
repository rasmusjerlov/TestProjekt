package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligFast extends Ordination{
    private double morgenAntal, middagAntal, aftenAntal, natAntal;
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double morgenAntal, double middagAntal, double aftenAntal,
                      double natAntal) {
        super(startDen, slutDen, laegemiddel);
        opretDosis(LocalTime.of(8,00), morgenAntal);
        opretDosis(LocalTime.of(12,00), middagAntal);
        opretDosis(LocalTime.of(16,00), aftenAntal);
        opretDosis(LocalTime.of(20,00), natAntal);

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
        return doser;
    }
    // TODO
}
