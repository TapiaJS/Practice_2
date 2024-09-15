import colors.Colors;
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

    public static int getInt(String mensaje, int min, int max) {
        Scanner m = new Scanner(System.in);
        int valor;
        String error = "Por favor ingresa una opción válida.";

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

    public static void main(String[] args) {
        // Mensaje de bienvenida
        Colors.println("¡Bienvenido al Simulador de Vehículos!", Colors.GREEN + Colors.HIGH_INTENSITY);

        // Solicitar vehículo al usuario
        Vehiculo vehiculoSeleccionado = solicitarVehiculo();

        // Verificar si se seleccionó un vehículo válido
        if (vehiculoSeleccionado != null) {
            Colors.println("Has seleccionado un " + vehiculoSeleccionado.getTipoVehiculo(), Colors.CYAN);

            // Iniciar el ciclo de vida del vehículo
            vehiculoSeleccionado.solicitarVehiculo();
        } else {
            Colors.println("No has seleccionado un vehículo válido.", Colors.RED + Colors.HIGH_INTENSITY);
        }
    }

}