package vehicle;

import colors.Colors;
import vehicle.state.EsperandoViaje;
import vehicle.state.EstadoVehiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Vehiculo extends Destino{
    private final String TIPOCOMBUSTIBLE;
    private double porcentajeCombustible;
    private EstadoVehiculo estadoActual;

    private boolean vehiculoEncendido = false;
    private static final ArrayList<String> TIPOVEHICULOS = new ArrayList<>();
    private static final String ERROR = "Por favor ingresa una opción válida.";

    private static Scanner m = new Scanner(System.in);

    public Vehiculo(String TIPOCOMBUSTIBLE){
        this.TIPOCOMBUSTIBLE = TIPOCOMBUSTIBLE;
        this.porcentajeCombustible = 100.0;
        this.estadoActual = new EsperandoViaje();
    }

    public void setEstado(EstadoVehiculo nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void solicitarVehiculo(){
        encender();
        if (personalizarVehiculo(ERROR)){
            //agregar los métodos necesarios para personalizar el vehículo
        }
        comenzarViaje();
        seguirRuta();
        apagar(true);
    }

    private void encender() {
        this.vehiculoEncendido = true;
        System.out.println("El vehículo ha sido encendido.");
    }

    public boolean personalizarVehiculo(String error){
        return false;
    }

    private void apagar(boolean viajeExitoso){
        if (vehiculoEncendido && viajeExitoso){
            vehiculoEncendido = false;
            System.out.println("El vehículo ha sido apagado.");
        } else {
            System.out.println("El vehículo ya estaba apagado");
        }
    }

    public void esperarViaje() {
        estadoActual.esperarViaje(this);
    }

    public void comenzarViaje() {
        estadoActual.comenzarViaje(this);
    }

    public void alertaCombustible() {
        estadoActual.alertaCombustible(this);
    }

    public void finalizarViaje() {
        estadoActual.finalizarViaje(this);
    }

    public abstract void seguirRuta();

    public abstract void recargarCombustible();

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

    private static void cargarVehiculosDisponibles(){
        TIPOVEHICULOS.add("Carro");
        TIPOVEHICULOS.add("Autobus");
        TIPOVEHICULOS.add("Motocicleta");
        TIPOVEHICULOS.add("Scooter");
        TIPOVEHICULOS.add("Vehículo4X4");
        Collections.sort(TIPOVEHICULOS);
    }

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
