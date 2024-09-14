package vehicle.modification.modifications;

import vehicle.Vehiculo;
import vehicle.modification.Modificacion;

public class FarosDeNiebla extends Modificacion {
    private int potenciaLuz;

    public FarosDeNiebla(Vehiculo vehiculoDecorado, int potenciaLuz) {
        super(vehiculoDecorado);
        this.potenciaLuz = potenciaLuz;
    }

    @Override
    public void solicitarVehiculo() {
        super.solicitarVehiculo();
        System.out.println("Faros de niebla activados con potencia de luz: " + potenciaLuz + " lúmenes.");
    }

    public void ajustarFaros(int nuevaPotencia) {
        this.potenciaLuz = nuevaPotencia;
        System.out.println("Potencia de faros ajustada a: " + nuevaPotencia + " lúmenes.");
    }
}