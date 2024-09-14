package vehicle.vehicles;

import vehicle.Vehiculo;

public class Scooter extends Vehiculo {
    private String tipoBateria;

    public Scooter(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    @Override
    public String getTipoVehiculo() {
        return "Scooter";
    }

    public void recargarBateria(){

    }

    @Override
    public void seguirRuta() {

    }

    @Override
    public void recargarCombustible() {

    }

    private int getInt(String mensaje, int i, int i1) {
        return 0;
    }
}