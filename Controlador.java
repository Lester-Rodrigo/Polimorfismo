import java.util.ArrayList;
import java.util.Comparator;

public class Controlador {
    //Arraylists para guardar cada proceso
    private ArrayList<ProcesosCPU> AllprocesosCPU = new ArrayList<>();
    private ArrayList<ProcesosEntradaySalida> AllprocesosEyS = new ArrayList<>();
    private ArrayList<ProcesosDaemon> AllprocesosDaemon = new ArrayList<>();
    // Métodos para llamar a las listas
    public ArrayList<ProcesosCPU> getAllprocesosCPU() {
        AllprocesosCPU.sort(Comparator.comparing(ProcesosCPU::getPID));
        return AllprocesosCPU;
    }
    public ArrayList<ProcesosEntradaySalida> getAllprocesosEyS() {
         AllprocesosEyS.sort(Comparator.comparing(ProcesosEntradaySalida::getPID));
        return AllprocesosEyS;
    }
    public ArrayList<ProcesosDaemon> getAllprocesosDaemon() {
         AllprocesosDaemon.sort(Comparator.comparing(ProcesosDaemon::getPID));
        return AllprocesosDaemon;
    }
    //Controlador
    public Controlador () {
    }
    // Método de creación
    public void crearProcesos (int procesoAcrear, String nombre, int PID, String entrada, String salida) {
        switch (procesoAcrear) {
            case 1:
                ProcesosCPU procesosCPU = new ProcesosCPU(nombre, PID, entrada);
                AllprocesosCPU.add(procesosCPU);
                break;
        
            case 2:
                ProcesosEntradaySalida procesosEntradaySalida = new ProcesosEntradaySalida(nombre, PID, entrada, salida);
                AllprocesosEyS.add(procesosEntradaySalida);
                break;

            case 3:
                ProcesosDaemon procesosDaemon = new ProcesosDaemon(nombre, PID);
                AllprocesosDaemon.add(procesosDaemon);
                break;
        }
    }
    //Método para ejecutar los procesos
    public String ejecutarProcesoSeleccionado (int listaArevisar, int procesoSeleccionado, String entrada) {
        switch (listaArevisar) {
            case 1:
                for (ProcesosCPU procesosCPU : AllprocesosCPU) {
                    if (procesosCPU.getPID() == procesoSeleccionado) {
                        return procesosCPU.ejecutarProceso();
                    }
                }
                break;
        
            case 2:
                for (ProcesosEntradaySalida procesosEntradaySalida : AllprocesosEyS) {
                        if (procesosEntradaySalida.getPID() == procesoSeleccionado) {
                            if (entrada == procesosEntradaySalida.getIngreso()) {
                                return procesosEntradaySalida.ejecutarProceso();
                                }
                                else {
                                return "Ingreso no válido para este proceso";
                                }
                    }
                }
                
                break;

            case 3:
                for (ProcesosDaemon procesosDaemon : AllprocesosDaemon) {
                    if (procesosDaemon.getPID() == procesoSeleccionado) {
                        return procesosDaemon.ejecutarProceso();
                    }
                }
                
                break;
        }
        return "";
    }
}
