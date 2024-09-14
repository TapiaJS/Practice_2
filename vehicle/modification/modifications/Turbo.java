package vehicle.modification.modifications;

import vehicle.Vehiculo;
import vehicle.modification.Modificacion;

public class Turbo extends Modificacion {
    private int boost;

    public Turbo(Vehiculo vehiculoDecorado) {
        super(vehiculoDecorado);
    }

    @Override
    public void solicitarVehiculo() {
        super.solicitarVehiculo();
        System.out.println("Turbo activado. ¡Velocidad incrementada!");
    }

    public void ajustarBoost(int boost) {
        this.boost = boost;
        System.out.println("Boost ajustado a: " + boost);
    }
}