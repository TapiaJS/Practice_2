import vehicle.Vehiculo;
import vehicle.vehicles.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SimuladorVehMos{
    private static final ArrayList<String> TIPOVEHICULOS = new ArrayList<>();

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


    public static void main(String[] args) {

    }
}
//public Vehiculo solicitarVehiculo() {
//    int opcion = getInt(menuVehiculosDisponibles(), ERROR, 1, TIPOVEHICULOS.size());
//
//    switch (opcion){
//        case 1:
//            Vehiculo autobus = new Autobus("Diesel");
//            if (autobus.personalizarVehiculo(ERROR)){
//                System.out.println("prueba autobus");
//            }
//            autobus.encender();
//            return autobus;
//        case 2:
//            Vehiculo carro = new Carro("Gasolina");
//            if (carro.personalizarVehiculo(ERROR)){
//                System.out.println("prueba carro");
//            }
//            carro.encender();
//            return carro;
//        case 3:
//            Vehiculo motocicleta = new Motocicleta("Gasolina");
//            if (motocicleta.personalizarVehiculo(ERROR)){
//                System.out.println("prueba motocicleta");
//            }
//            motocicleta.encender();
//            return motocicleta;
//        case 4:
//            Vehiculo scooter = new Scooter("Energía AC");
//            if (scooter.personalizarVehiculo(ERROR)){
//                System.out.println("prueba scooter");
//            }
//            scooter.encender();
//            return scooter;
//        case 5:
//            Vehiculo vehiculo4x4 = new Vehiculo4x4("Diesel");
//            if (vehiculo4x4.personalizarVehiculo(ERROR)){
//                System.out.println("prueba vehículo4x4");
//            }
//            vehiculo4x4.encender();
//            return vehiculo4x4;
//    }
//    return null;
//}