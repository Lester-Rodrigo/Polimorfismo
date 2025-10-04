public class ProcesosCPU extends Procesos{
    private String operacion;

    public ProcesosCPU(String nombre, int PID, String operacion) {
        super(nombre, PID);
        this.operacion = operacion;
    }

    @Override
    public String ejecutarProceso () {
            return this.operacion;
    }
    
}
