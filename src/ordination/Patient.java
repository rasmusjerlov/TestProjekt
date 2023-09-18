package ordination;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Patient {
    private String cprnr;
    private String navn;
    private double vaegt;
    private ArrayList<Ordination> ordinationer = new ArrayList<>();

    public Patient(String cprnr, String navn, double vaegt) {
        this.cprnr = cprnr;
        this.navn = navn;
        this.vaegt = vaegt;
    }

    public String getCprnr() {
        return cprnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getVaegt(){
        return vaegt;
    }

    public void setVaegt(double vaegt){
        this.vaegt = vaegt;
    }
    //TODO: Metoder (med specifikation) til at vedligeholde link til Ordination

    public PN creatPn(LocalDate startDen, LocalDate slutDen,
                      Laegemiddel laegemiddel, double antal){
        PN pn = new PN(startDen, slutDen, laegemiddel, antal);
        ordinationer.add(pn);
        return pn;
    }
    public DagligFast createDagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel,
                                       double morgenAntal, double middagAntal, double aftenAntal,
                                       double natAntal){
        DagligFast df = new DagligFast(startDen, slutDen, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        ordinationer.add(df);
        return df;
    }
    public DagligSkaev createDagligSkaev(LocalDate startDen,
                                         LocalDate slutDen, Laegemiddel laegemiddel,
                                         LocalTime[] klokkeSlet, double[] antalEnheder){
        DagligSkaev ds = new DagligSkaev(startDen, slutDen, laegemiddel, klokkeSlet, antalEnheder);
        ordinationer.add(ds);
        return ds;

    }
    @Override
    public String toString(){
        return navn + "  " + cprnr;
    }
    public void addOrdination(Ordination ordination){
        ordination.setPatient(this);
    }

    public ArrayList<Ordination> getOrdinationer() {
        return ordinationer;
    }
}
