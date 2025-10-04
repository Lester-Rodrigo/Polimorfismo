public class ProcesosDaemon extends Procesos{
    private int contador = 0;

    public ProcesosDaemon(String nombre, int PID) {
        super(nombre, PID);
    }
    
    @Override
    public String ejecutarProceso () {
        contador += 1;
        return ("Ha ejecutado este proceso " + contador + " vez/veces");
    }
}
