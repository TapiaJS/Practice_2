package vehicle.vehicles;

import vehicle.Vehiculo;

import java.util.Random;

public class Carro extends Vehiculo {
    private Random random = new Random();

    public Carro(String TIPOCOMBUSTIBLE) {
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
                velocidad = calcularVelocidad(80, 120);
                System.out.println("El " + getTipoVehiculo() + " está tomando la autopista. Menor consumo de combustible.");
                break;
            case "camino rural":
                velocidad = calcularVelocidad(40, 60);
                System.out.println("El " + getTipoVehiculo() + " está tomando un camino rural. Consumo de combustible moderado.");
                break;
            case "ciudad":
                velocidad = calcularVelocidad(10, 30);
                System.out.println("El " + getTipoVehiculo() + " está circulando por la ciudad. Mayor consumo de combustible.");
                break;
            default:
                velocidad = 0;
        }
        return rutaPersonalizada(destino,this, velocidad, rutaSeleccionada);
    }

    //Pueden tanto llenar el tanque por completo o mínimo la mitad del porciento que le falta el tanque por estar lleno
    @Override
    public void recargarCombustible() {
        System.out.println("Porcentaje de " + getTIPOCOMBUSTIBLE() + ": " + getPorcentajeCombustible());

        System.out.println("Cargando " + getTIPOCOMBUSTIBLE());
        setPorcentajeCombustible(generarNumeroAleatorio(100.0 - getPorcentajeCombustible()));

        System.out.println("Cantidad de " + getTIPOCOMBUSTIBLE() + " en el tanque: " + getPorcentajeCombustible());
    }

    // Método genérico para generar un número aleatorio mayor a la mitad y menor que el máximo
    private double generarNumeroAleatorio(double maximo) {
        double mitad = maximo / 2;
        // Genera número en el rango mayor a la mitad y menor que el valor máximo
        return random.nextDouble(maximo - mitad) + mitad + 1;
    }

    public boolean personalizarVehiculo(){
        String mensaje = "¿Desea agregar modificaciones al " + getTipoVehiculo() + "?\n1. Si\n2. No";
        int decision = getInt(mensaje, 1,2);
        return decision == 1;
    }

    @Override
    public String getTipoVehiculo() {
        return "carro";
    }
}