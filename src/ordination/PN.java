package ordination;

import java.time.LocalDate;
import java.util.ArrayList;

public class PN extends Ordination{

    private double antalEnheder;
    private ArrayList<LocalDate> antalGivet = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;
    }



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
        //gennemsnit pr døgn


        int antalGangeGivet = getAntalGangeGivet();
        int antalDage = antalDage();

        double gennemsnitligDosisPrDag = (antalGangeGivet * antalEnheder) / antalDage;

        return gennemsnitligDosisPrDag;
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }


    public double samletDosis() {
        return getAntalGangeGivet() * antalEnheder;
    }


    public int getAntalGangeGivet() {
        return  antalGivet.size() + 1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
