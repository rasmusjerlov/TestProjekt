package ordination;

public class DagligFast extends Ordination{
    private Dosis dosis;
    private Dosis[] doser = new Dosis[4];

    @Override
    public double samletDosis() {
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }


    // TODO
}
