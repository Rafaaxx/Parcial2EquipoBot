import java.io.Serializable;

public class Tema implements Serializable {
    protected String denominacion;

    public Tema(String denominacion) {
        this.denominacion = denominacion;

    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return "El tema es "+denominacion;
    }
}
