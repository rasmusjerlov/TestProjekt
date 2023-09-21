package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        if((givesDen.isAfter(start) || givesDen.equals(start)) && (givesDen.equals(end) || givesDen.isBefore(end))){
            antalGivet.add(givesDen);
            return true;
        }
        return false;
    }

    public double doegnDosis() {
        //gennemsnit pr døgn

        LocalDate sidste = antalGivet.get(antalGivet.size()-1);
        int antalGangeGivet = getAntalGangeGivet();
        int antalDage = (int) ChronoUnit.DAYS.between(getStartDen(), sidste)+1;

        double gennemsnitligDosisPrDag = (antalGangeGivet * antalEnheder) /  antalDage;

        return gennemsnitligDosisPrDag;
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }


    public double samletDosis() {
        return getAntalGangeGivet() * antalEnheder;
    }

    public ArrayList<LocalDate> getAntalGivet() {
        return new ArrayList<>(antalGivet);
    }

    public int getAntalGangeGivet() {
        return  antalGivet.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
