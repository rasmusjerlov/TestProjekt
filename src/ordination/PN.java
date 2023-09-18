package ordination;

import java.time.LocalDate;
import java.util.ArrayList;

public class PN extends Ordination{

    private double antalEnheder;
    private ArrayList<LocalDate> antalGivet = new ArrayList<>();



    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */

    public boolean givDosis(LocalDate givesDen) {
        LocalDate start = super.getStartDen();
        LocalDate end = super.getSlutDen();
        if(givesDen.isAfter(start) || givesDen.equals(start) && givesDen.equals(end) || givesDen.isBefore(end)){
            antalGivet.add(givesDen);
            return true;
        }
        return false;
    }

    public double doegnDosis() {
        // TODO
            return 0.0;
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }


    public double samletDosis() {
        return getAntalGangeGivet() * antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return  antalGivet.size() + 1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
