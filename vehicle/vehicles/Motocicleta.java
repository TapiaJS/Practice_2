package vehicle.vehicles;

import vehicle.Vehiculo;

public class Motocicleta extends Vehiculo {
    private boolean esDeMontania;

    public Motocicleta(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    public void seguirRutaTerreceria(){

    }

    @Override
    public String getTipoVehiculo() {
        return "Motocicleta";
    }

    @Override
    public void seguirRuta() {

    }

    @Override
    public void recargarCombustible() {

    }

    public boolean personalizarVehiculo(){
        String mensaje = "¿Desea agregar modificaciones a la motocicleta?\n1. Si\n2. No";
        int decision = getInt(mensaje, 1,2);
        return decision == 1;
    }

    private int getInt(String mensaje, int i, int i1) {
        return 0;
    }
}