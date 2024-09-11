package vehicle;

import colors.Colors;
import vehicle.state.EsperandoViaje;
import vehicle.state.EstadoVehiculo;
import vehicle.vehicles.Autobus;
import vehicle.vehicles.Carro;

import java.util.HashSet;
import java.util.Scanner;

public abstract class Vehiculo extends Destino{
    private final String TIPOCOMBUSTIBLE;
    private static final HashSet<String> TIPOVEHICULOS = new HashSet<>();
    private double porcentajeCombustible;
    private EstadoVehiculo estado;

    static Scanner m = new Scanner(System.in);

    public Vehiculo(String TIPOCOMBUSTIBLE){
        this.TIPOCOMBUSTIBLE = TIPOCOMBUSTIBLE;
        this.TIPOVEHICULOS.add(this.getClass().getSimpleName());
        this.porcentajeCombustible = 100.0;
        this.estado = new EsperandoViaje();
    }

    private static void cargarVehiculosDisponibles(){
        new Carro("Gasolina");
        new Autobus("Gasolina");
    }

    private static String menuVehiculosDisponibles(){
        StringBuilder menu = new StringBuilder();
        cargarVehiculosDisponibles();

        menu.append("Opciones a elegir:\n");
        int i = 0;
        for (String vehiculo : TIPOVEHICULOS) {
            i++;
            menu.append(i + ". " + vehiculo + "\n");
        }

        return menu.toString();
    }

    public static void solicitarVehiculo() {
        String error = "Por favor ingresa una opción válida.";
        int opcion = getInt(menuVehiculosDisponibles(), error, 1, TIPOVEHICULOS.size());

        switch (opcion){
            case 1:
                System.out.println("Acaba de elegir como vehículo el carro");
                String mensaje = "Desea agregar modificaciones al auto\n1. Si\n2. No";
                int decision = getInt(mensaje, error, 1,2);
                if (decision==1){
                    //agregar modificaciones    
                }
                break;
        }
    }

    private void encender() {
        System.out.println("El vehículo ha sido encendido.");
    }

    private void apagar(){
        System.out.println("El vehículo ha sido apagado.");
    }

    private void comenzarViaje(){
//        if (!estado.esperarViaje()) {
//            encender();
//        }
    }

    private void finalizarViaje(){
        if (this.porcentajeCombustible < 40.0){
            recargarCombustible();
            this.porcentajeCombustible = 100.0;
        }
    }

    public abstract void seguirRuta();
    public abstract void recargarCombustible();

    public static int getInt(String mensaje, String error, int min, int max) {
        int valor;

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (m.hasNextInt()) {
                valor = m.nextInt();

                if (valor < min || max < valor) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return valor;
                }
            } else {
                m.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }
}
