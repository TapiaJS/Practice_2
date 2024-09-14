package vehicle.vehicles;

import vehicle.Vehiculo;

import java.util.Random;

public class Carro extends Vehiculo {
    private int capacidadPasajeros;

    public Carro(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    @Override
    public void seguirRuta() {

    }

    //Pueden tanto llenar el tanque por completo o mínimo la mitad del porciento que le falta el tanque por estar lleno
    @Override
    public void recargarCombustible() {
        if (estadoActual.alertaCombustible(this)){
            System.out.println("Porcentaje de gasolina: " + getPorcentajeCombustible());

            double porcentajeMaximaCombustible = 100.0 - getPorcentajeCombustible();
            System.out.println("Cargando gasolina");
            setPorcentajeCombustible(generarNumeroAleatorio(porcentajeMaximaCombustible));

            System.out.println("Cantidad de gasolina en el tanque: " + getPorcentajeCombustible());
        }
    }

    // Método genérico para generar un número aleatorio mayor a la mitad y menor que el máximo
    private static double generarNumeroAleatorio(double maximo) {

        double mitad = maximo / 2;

        // Genera número en el rango mayor a la mitad y menor que el valor máximo
        Random random = new Random();
        return random.nextDouble(maximo - mitad) + mitad + 1;
    }

    public boolean personalizarVehiculo(){
        String mensaje = "¿Desea agregar modificaciones al carro?\n1. Si\n2. No";
        int decision = getInt(mensaje, 1,2);
        return decision == 1;
    }

    @Override
    public String getTipoVehiculo() {
        return "carro";
    }
}