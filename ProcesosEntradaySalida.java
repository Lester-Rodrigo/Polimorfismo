public class ProcesosEntradaySalida extends Procesos{
    private String ingreso;
    private String salida;

    public ProcesosEntradaySalida(String nombre, int PID, String ingreso, String salida) {
        super(nombre, PID);
        this.ingreso = ingreso;
        this.salida = salida;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    @Override
    public String ejecutarProceso () {
            return this.salida;
    }
}
