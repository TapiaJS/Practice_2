package vehicle.vehicles;

import vehicle.Vehiculo;

import java.util.Random;

public class Autobus extends Vehiculo {
    private Random random = new Random();

    public Autobus(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    @Override
    public boolean seguirRuta(String destino) {
        String[] rutas = {"autopista", "camino rural"};

        // Simular selección aleatoria de la ruta
        String rutaSeleccionada = rutas[random.nextInt(rutas.length)];
        System.out.println("El " + getTipoVehiculo() + " ha comenzado su viaje por la " + rutaSeleccionada + "(Menos Tráfico-Mejor Opción)");

        // Calcular la disminución de combustible según la ruta
        double velocidad;
        switch (rutaSeleccionada) {
            case "autopista":
                velocidad = calcularVelocidad(30, 40);
                System.out.println("El " + getTipoVehiculo() + " está tomando la autopista. Menor consumo de combustible.");
                break;
            case "camino rural":
                velocidad = calcularVelocidad(15, 20);
                System.out.println("El " + getTipoVehiculo() + " está tomando un camino rural. Consumo de combustible moderado.");
                break;
            default:
                velocidad = 0;
        }
        return rutaPersonalizada(destino,this, velocidad, rutaSeleccionada);
    }

    //Puede tanto cargar el tanque lleno, como private Random random = new Random();sólo uno porciento de la capacidad sobrante
    @Override
    public void recargarCombustible() {
        System.out.println("Porcentaje de" + getTIPOCOMBUSTIBLE() + ": " + getPorcentajeCombustible());

        double agregarCombustible = generarNumeroAleatorio(100.0 - getPorcentajeCombustible());

        System.out.println("Cargando " + getTIPOCOMBUSTIBLE());
        setPorcentajeCombustible(agregarCombustible);

        System.out.println("Cantidad de " + getTIPOCOMBUSTIBLE() + " en el tanque: " + getPorcentajeCombustible());
    }

    // Genera un número aleatorio en el intervalo de [1, valor recibido en el parámetro]
    private double generarNumeroAleatorio(double maximo) {
        return random.nextDouble(maximo) + 1;
    }

    @Override
    protected boolean personalizarVehiculo(){
        String mensaje = "¿Desea agregar modificaciones al " + getTipoVehiculo() + "\n1. Si\n2. No";
        int decision = getInt(mensaje, 1,2);
        return decision == 1;
    }

    @Override
    public String getTipoVehiculo() {
        return "Autobus";
    }
}