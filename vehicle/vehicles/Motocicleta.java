package vehicle.vehicles;

import vehicle.Vehiculo;

import java.util.Random;

public class Motocicleta extends Vehiculo {
    private Random random = new Random();

    public Motocicleta(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    @Override
    public boolean seguirRuta(String destino) {
        String[] rutas = {"autopista", "camino rural", "ciudad"};

        // Simular selección aleatoria de la ruta
        String rutaSeleccionada = rutas[random.nextInt(rutas.length)];
        System.out.println("El " + getTipoVehiculo() + " ha comenzado su viaje por la " + rutaSeleccionada + "(Menos Tráfico-Mejor Opción)");

        // Calcular la disminución de combustible según la ruta
        double velocidad;
        switch (rutaSeleccionada) {
            case "autopista":
                velocidad = calcularVelocidad(70, 100);
                System.out.println("El " + getTipoVehiculo() + " está tomando la autopista. Menor consumo de combustible.");
                break;
            case "camino rural":
                velocidad = calcularVelocidad(50, 55);
                System.out.println("El " + getTipoVehiculo() + " está tomando un camino rural. Consumo de combustible moderado.");
                break;
            case "ciudad":
                velocidad = calcularVelocidad(20, 40);
                System.out.println("El " + getTipoVehiculo() + " está circulando por la ciudad. Mayor consumo de combustible.");
                break;
            default:
                velocidad = 0;
        }
        return rutaPersonalizada(destino,this, velocidad, rutaSeleccionada);
    }

    //Cuando tenga que cargar gasolina, llenará el tanque
    @Override
    public void recargarCombustible() {
        System.out.println("Porcentaje de" + getTIPOCOMBUSTIBLE() + ": " + getPorcentajeCombustible());

        double agregarCombustible = 100.0 - getPorcentajeCombustible();

        System.out.println("Cargando " + getTIPOCOMBUSTIBLE());
        setPorcentajeCombustible(agregarCombustible);

        System.out.println("Cantidad de " + getTIPOCOMBUSTIBLE() + " en el tanque: " + getPorcentajeCombustible());
    }

    public boolean personalizarVehiculo(){
        String mensaje = "¿Desea agregar modificaciones a la motocicleta?\n1. Si\n2. No";
        int decision = getInt(mensaje, 1,2);
        return decision == 1;
    }

    @Override
    public String getTipoVehiculo() {
        return "motocicleta";
    }
}
