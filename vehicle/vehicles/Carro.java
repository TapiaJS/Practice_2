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

    public boolean personalizarVehiculo(String error){
        String mensaje = "¿Desea agregar modificaciones al carro?\n1. Si\n2. No";
        int decision = getInt(mensaje, error, 1,2);
        return decision == 1;
    }
}
