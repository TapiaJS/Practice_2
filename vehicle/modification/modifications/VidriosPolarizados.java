package vehicle.modification.modifications;

import vehicle.Vehiculo;
import vehicle.modification.Modificacion;

public class VidriosPolarizados extends Modificacion {
    private int nivelPolarizado;

    public VidriosPolarizados(Vehiculo vehiculoDecorado, int nivelPolarizado) {
        super(vehiculoDecorado);
        this.nivelPolarizado = nivelPolarizado;
    }

    @Override
    public void solicitarVehiculo() {
        super.solicitarVehiculo();
        System.out.println("Vidrios polarizados ajustados al nivel: " + nivelPolarizado + ".");
    }

    public void ajustarPolarizado(int nuevoNivel) {
        this.nivelPolarizado = nuevoNivel;
        System.out.println("Nivel de polarización ajustado a: " + nuevoNivel + ".");
    }
}