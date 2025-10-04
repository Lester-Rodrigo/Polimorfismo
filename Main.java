import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Controlador
        Controlador control = new Controlador();
        //Scanner para registrara ingresos
        Scanner input = new Scanner(System.in);
        int pagina;
        //Atributos para guardar los ingresos
        String nombre;
        int PID;
        String entrada;
        String salida;
        int procesoAejecutar;

        do {
            do {
        System.out.println("1. Crear procesos: ");
        System.out.println("2. Ejecutar procesos: ");
        System.out.println("3. Salir: ");
        System.out.println("Ingrese alguna opción (Del 1 al 3): ");
        pagina = input.nextInt();
        System.out.println("-------------------------------------------------------------"); 

        } while (pagina < 1 || pagina > 5);
        switch (pagina) {
            case 1:
                System.out.println("1. Crear proceso de CPU (Operaciones matemáticas): ");
                System.out.println("2. Crear proceso de entra y salida: ");
                System.out.println("3. Crear proceso Daemon: ");
                System.out.println("Ingrese alguna opción (Del 1 al 3): ");
                pagina = input.nextInt();
                System.out.println("-------------------------------------------------------------");
                switch (pagina) {
                    case 1:
                        Scanner datos = new Scanner(System.in);
                        System.out.println("Ingrese el nombre del nuevo proceso: ");
                        nombre = datos.nextLine();
                        System.out.println("Ingrese la opreación que realiza el proceso (ejm.: 1 + 1 = 2): ");
                        entrada = datos.nextLine();
                        System.out.println("Ingrese el PID del nuevo proceso: ");
                        PID = datos.nextInt();
                        control.crearProcesos(pagina, nombre, PID, entrada, null);
                        System.out.println("-------------------------------------------------------------");
                        break;
                
                    case 2:
                        datos = new Scanner(System.in);
                        System.out.println("Ingrese el nombre del nuevo proceso: ");
                        nombre = datos.nextLine();
                        System.out.println("Ingrese la entarda específica que debe recibir este proceso: ");
                        entrada = datos.nextLine();
                        System.out.println("Ingrese la salida que el proceso debe retornar: ");
                        salida = datos.nextLine();
                        System.out.println("Ingrese el PID del nuevo proceso: ");
                        PID = datos.nextInt();
                        control.crearProcesos(pagina, nombre, PID, entrada, salida);
                        System.out.println("-------------------------------------------------------------");
                        break;

                    case 3:
                        datos = new Scanner(System.in);
                        System.out.println("Ingrese el nombre del nuevo proceso: ");
                        nombre = datos.nextLine();
                        System.out.println("Ingrese el PID del nuevo proceso: ");
                        PID = datos.nextInt();
                        control.crearProcesos(pagina, nombre, PID, null, null);
                        System.out.println("-------------------------------------------------------------");
                        break;
                }
                break;
        
            case 2:
            Scanner procesoElegido = new Scanner(System.in);
            System.out.println("1. Ver lista de procesos de CPU disponibles: ");
                System.out.println("2. Ver lista de procesos de entra y salida disponibles: ");
                System.out.println("3. Ver lista de procesos Daemons disponibles: ");
                System.out.println("Ingrese alguna opción (Del 1 al 3): ");
                pagina = input.nextInt();
                System.out.println("-------------------------------------------------------------");
                switch (pagina) {
                    case 1:
                        for (ProcesosCPU procesosCPU : control.getAllprocesosCPU()) {
                            System.out.println(procesosCPU.getPID()+ " " + procesosCPU.getNombre());
                        }
                        System.out.println("Escoja el proceso a ejecutar segun el índice");
                        procesoAejecutar = procesoElegido.nextInt();
                        System.out.println(control.ejecutarProcesoSeleccionado(pagina, procesoAejecutar, null));
                        break;

                    case 2:
                    for (ProcesosEntradaySalida procesosEntradaySalida : control.getAllprocesosEyS()) {
                            System.out.println(procesosEntradaySalida.getPID()+ " " + procesosEntradaySalida.getNombre());
                        }
                        System.out.println("Escoja el proceso a ejecutar segun el índice");
                        procesoAejecutar = procesoElegido.nextInt();
                        Scanner entradaAingresar = new Scanner(System.in);
                        System.out.println("Ingrese la entrada correcta: ");
                        entrada = entradaAingresar.nextLine();
                        System.out.println(control.ejecutarProcesoSeleccionado(pagina, procesoAejecutar, entrada));
                        break;

                    case 3:
                    for (ProcesosDaemon procesosDaemon : control.getAllprocesosDaemon()) {
                            System.out.println(procesosDaemon.getPID()+ " " + procesosDaemon.getNombre());
                        };
                        System.out.println("Escoja el proceso a ejecutar segun el índice");
                        procesoAejecutar = procesoElegido.nextInt();
                        System.out.println(control.ejecutarProcesoSeleccionado(pagina, procesoAejecutar, null));
                        break;
                }
                
                break;

            case 3:
                System.exit(0);
                break;
        }

        } while (pagina != 3);
    }
}