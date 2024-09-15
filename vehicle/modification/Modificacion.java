package vehicle.modification;

import vehicle.Vehiculo;

public abstract class Modificacion extends Vehiculo {
    public Vehiculo vehiculoDecorado;

    public Modificacion(Vehiculo vehiculoDecorado) {
        super(vehiculoDecorado.getTIPOCOMBUSTIBLE());
        this.vehiculoDecorado = vehiculoDecorado;
    }

    @Override
    public void solicitarVehiculo() {
        vehiculoDecorado.solicitarVehiculo();
    }

    @Override
    public boolean seguirRuta(String destino) {
        return this.vehiculoDecorado.seguirRuta(destino);
    }

    @Override
    public void recargarCombustible() {
        this.vehiculoDecorado.recargarCombustible();
    }

    @Override
    public String getTipoVehiculo() {
        return vehiculoDecorado.getTipoVehiculo();
    }

}