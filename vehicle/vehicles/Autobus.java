package vehicle.vehicles;

import vehicle.Vehiculo;

public class Autobus extends Vehiculo {
    private int numeroDeAsientos;

    public Autobus(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    @Override
    public void seguirRuta() {

    }

    @Override
    public void recargarCombustible() {

    }

    public boolean personalizarVehiculo(String error){
        String mensaje = "¿Desea agregar modificaciones al autobus?\n1. Si\n2. No";
        int decision = getInt(mensaje, error, 1,2);
        return decision == 1;
    }
}
