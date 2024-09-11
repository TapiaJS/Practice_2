package vehicle.vehicles;

import vehicle.Vehiculo;

public class Carro extends Vehiculo {
    private int capacidadPasajeros;

    public Carro(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    @Override
    public void seguirRuta() {

    }

    @Override
    public void recargarCombustible() {
        System.out.println();
    }
}
