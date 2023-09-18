package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    private double morgenAntal, middagAntal, aftenAntal, natAntal;
    private Patient patient;
    private Dosis dosis;
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel,
                      double morgenAntal, double middagAntal, double aftenAntal,
                      double natAntal, Dosis dosis, Patient patient) {
        super(startDen, slutDen, laegemiddel);
        this.morgenAntal = morgenAntal;
        this.middagAntal = middagAntal;
        this.aftenAntal = aftenAntal;
        this.natAntal = natAntal;
        this.dosis = dosis;
        this.patient = patient;
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
        return 0;
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
        return null;
    }


    // TODO
}
