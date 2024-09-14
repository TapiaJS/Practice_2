package vehicle.vehicles;

import vehicle.Vehiculo;

public class Vehiculo4x4 extends Vehiculo {
    private boolean modo4x4;

    public Vehiculo4x4(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    public void activarModo4x4(){

    }

    public void desactivarModo4x4(){

    }

    @Override
    public void seguirRuta() {

    }

    @Override
    public void recargarCombustible() {

    }

    public boolean personalizarVehiculo(){
        String mensaje = "¿Desea agregar modificaciones al vehículo4x4?\n1. Si\n2. No";
        int decision = getInt(mensaje, 1,2);
        return decision == 1;
    }
}
