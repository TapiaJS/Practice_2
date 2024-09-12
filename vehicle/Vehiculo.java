package vehicle;

import colors.Colors;
import vehicle.state.EsperandoViaje;
import vehicle.state.EstadoVehiculo;
import vehicle.vehicles.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Vehiculo extends Destino{
    private final String TIPOCOMBUSTIBLE;
    private double porcentajeCombustible;
    private boolean vehiculoEncendido;
    private EstadoVehiculo estado;
    private static final ArrayList<String> TIPOVEHICULOS = new ArrayList<>();

    static Scanner m = new Scanner(System.in);
    private static final String ERROR = "Por favor ingresa una opción válida.";

    public Vehiculo(String TIPOCOMBUSTIBLE){
        this.TIPOCOMBUSTIBLE = TIPOCOMBUSTIBLE;
        this.porcentajeCombustible = 100.0;
        this.estado = new EsperandoViaje();
    }

    private static void cargarVehiculosDisponibles(){
        TIPOVEHICULOS.add("Carro");
        TIPOVEHICULOS.add("Autobus");
        TIPOVEHICULOS.add("Motocicleta");
        TIPOVEHICULOS.add("Scooter");
        TIPOVEHICULOS.add("Vehículo4X4");
        Collections.sort(TIPOVEHICULOS);
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


    public static Vehiculo solicitarVehiculo() {
        int opcion = getInt(menuVehiculosDisponibles(), ERROR, 1, TIPOVEHICULOS.size());

        switch (opcion){
            case 1:
                Vehiculo autobus = new Autobus("Diesel");
                if (autobus.personalizarVehiculo(ERROR)){
                    System.out.println("prueba autobus");
                }
                autobus.encender();
                return autobus;
            case 2:
                Vehiculo carro = new Carro("Gasolina");
                if (carro.personalizarVehiculo(ERROR)){
                    System.out.println("prueba carro");
                }
                carro.encender();
                return carro;
            case 3:
                Vehiculo motocicleta = new Motocicleta("Gasolina");
                if (motocicleta.personalizarVehiculo(ERROR)){
                    System.out.println("prueba motocicleta");
                }
                motocicleta.encender();
                return motocicleta;
            case 4:
                Vehiculo scooter = new Scooter("Energía AC");
                if (scooter.personalizarVehiculo(ERROR)){
                    System.out.println("prueba scooter");
                }
                scooter.encender();
                return scooter;
            case 5:
                Vehiculo vehiculo4x4 = new Vehiculo4x4("Diesel");
                if (vehiculo4x4.personalizarVehiculo(ERROR)){
                    System.out.println("prueba vehículo4x4");
                }
                vehiculo4x4.encender();
                return vehiculo4x4;
        }
        return null;
    }

    public boolean personalizarVehiculo(String error){
        return false;
    }

    private void encender() {
        this.vehiculoEncendido = true;
        System.out.println("El vehículo ha sido encendido.");
    }

    private void apagar(){
        if (vehiculoEncendido){
            vehiculoEncendido = false;
            System.out.println("El vehículo ha sido apagado.");
        } else {
            System.out.println("El vehículo ya estaba apagado");
        }
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
