public class Procesos {
    protected String nombre;
    protected int PID;

    public Procesos (String nombre, int PID) {
        this.nombre = nombre;
        this.PID = PID;
    }

    public String ejecutarProceso () {
        String retorno = " "; 
        return retorno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }
}
