package vehicle.modification.modifications;

import vehicle.Vehiculo;
import vehicle.modification.Modificacion;

public class LlantasTodoTerreno extends Modificacion {
    private int resistencia;

    public LlantasTodoTerreno(Vehiculo vehiculoDecorado, int resistencia) {
        super(vehiculoDecorado);
        this.resistencia = resistencia;
    }

    @Override
    public void solicitarVehiculo() {
        super.solicitarVehiculo();
        System.out.println("Llantas todo terreno instaladas con resistencia de: " + resistencia + ".");
    }

    public void ajustarPresion(int nuevaPresion) {
        System.out.println("Presión de las llantas ajustada a: " + nuevaPresion + " PSI.");
    }
}