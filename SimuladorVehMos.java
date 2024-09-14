import vehicle.Vehiculo;
import vehicle.vehicles.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SimuladorVehMos {
    private static final ArrayList<String> TIPOVEHICULOS = new ArrayList<>();

    private static String menuVehiculosDisponibles(){
        cargarVehiculosDisponibles(); 

        StringBuilder menu = new StringBuilder();
        menu.append("Opciones a elegir:\n");
        int i = 1;
        for (String vehiculo : TIPOVEHICULOS) {
            menu.append(i).append(". ").append(vehiculo).append("\n");
            i++;
        }

        return menu.toString();
    }

    private static void cargarVehiculosDisponibles(){
        if (TIPOVEHICULOS.isEmpty()) {
            TIPOVEHICULOS.add("Carro");
            TIPOVEHICULOS.add("Autobus");
            TIPOVEHICULOS.add("Motocicleta");
            TIPOVEHICULOS.add("Scooter");
            TIPOVEHICULOS.add("Vehículo4X4");
            Collections.sort(TIPOVEHICULOS);
        }
    }

    public static int getInt(String mensaje, int min, int max) {
        Scanner m = new Scanner(System.in);
        int valor;
        String error = "Por favor ingresa una opción válida.";
    
        while (true) {
            System.out.println(mensaje);
            if (m.hasNextInt()) {
                valor = m.nextInt();
    
                if (valor < min || max < valor) {
                    System.out.println(error);
                } else {
                    return valor;
                }
            } else {
                m.next();
                System.out.println(error);
            }
        }
    }

    public static void main(String[] args) {
        VerificacionID verificacionID = new VerificacionID();
        Scanner scanner = new Scanner(System.in);
        String idCliente;

        System.out.println("Bienvenido al simulador VehMos.");
        do {
            System.out.print("Por favor, ingresa tu ID de cliente: ");
            idCliente = scanner.nextLine();
        } while (!verificacionID.verificar(idCliente));

        Vehiculo vehiculoSeleccionado = solicitarVehiculo();
        if (vehiculoSeleccionado == null) {
            System.out.println("No se seleccionó un vehículo válido. Terminando el programa.");
            return;
        }

        if (vehiculoSeleccionado.personalizarVehiculo()) {
            System.out.println("Personalización del vehículo completada.");
        } else {
            System.out.println("No se realizaron personalizaciones.");
        }

        vehiculoSeleccionado.solicitarVehiculo();

        System.out.println("Seleccione su destino:");
        String destinoNombre = scanner.nextLine();
        vehiculoSeleccionado.seleccionarDestino(destinoNombre);
        System.out.println("Destino seleccionado: " + vehiculoSeleccionado.getDestino());

        System.out.println("Iniciando viaje...");
        vehiculoSeleccionado.comenzarViaje();

        vehiculoSeleccionado.finalizarViaje();
        System.out.println("Viaje finalizado.");
    }

    public static Vehiculo solicitarVehiculo() {
        int opcion = getInt(menuVehiculosDisponibles(), 1, TIPOVEHICULOS.size());

        switch (opcion) {
            case 1:
                return new Carro("Gasolina");
            case 2:
                return new Autobus("Diesel");
            case 3:
                return new Motocicleta("Gasolina");
            case 4:
                return new Scooter("Energía AC");
            case 5:
                return new Vehiculo4x4("Diesel");
            default:
                return null;
        }
    }
}