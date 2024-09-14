package vehicle.vehicles;

import vehicle.Vehiculo;

import java.util.Random;

public class Autobus extends Vehiculo {
    private int numeroDeAsientos;

    public Autobus(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    @Override
    public void seguirRuta() {

    }

    //Puede tanto cargar el tanque lleno, como sólo uno porciento de la capacidad sobrante
    @Override
    public void recargarCombustible() {
        if (estadoActual.alertaCombustible(this)){
            System.out.println("Porcentaje de gasolina: " + getPorcentajeCombustible());

            double añadirCombustible = generarNumeroAleatorio(100.0 - getPorcentajeCombustible());

            System.out.println("Cargando gasolina");
            setPorcentajeCombustible(añadirCombustible);

            System.out.println("Cantidad de gasolina en el tanque: " + getPorcentajeCombustible());
        }
    }

    // Genera un número aleatorio en el intervalo de [1, valor recibido en el parámetro]
    private static double generarNumeroAleatorio(double maximo) {
        Random random = new Random();
        return random.nextDouble(maximo) + 1;
    }

    public boolean personalizarVehiculo(){
        String mensaje = "¿Desea agregar modificaciones al autobus?\n1. Si\n2. No";
        int decision = getInt(mensaje, 1,2);
        return decision == 1;
    }

    @Override
    public String getTipoVehiculo() {
        return "autobus";
    }

    private int getInt(String mensaje, int i, int i1) {
        return 0;
    }
}