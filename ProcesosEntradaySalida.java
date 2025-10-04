public class ProcesosEntradaySalida extends Procesos{
    private String ingreso;
    private String salida;

    public ProcesosEntradaySalida(String nombre, int PID, String ingreso, String salida) {
        super(nombre, PID);
        this.ingreso = ingreso;
        this.salida = salida;
    }
    
    public String ejecutarProceso (String ingreso) {
            if (ingreso == this.ingreso) {
            return this.salida;
            }
            else {
               return "Ingreso no válido para este proceso";
            }
    }
}
