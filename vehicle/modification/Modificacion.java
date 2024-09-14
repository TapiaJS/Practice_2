package vehicle.modification;

import vehicle.Vehiculo;

public abstract class Modificacion extends Vehiculo {
    protected Vehiculo vehiculoDecorado;

    public Modificacion(Vehiculo vehiculoDecorado) {
        super(vehiculoDecorado.getTipoVehiculo());
        this.vehiculoDecorado = vehiculoDecorado;
    }

    @Override
    public void solicitarVehiculo() {
        vehiculoDecorado.solicitarVehiculo();
    }

    @Override
    protected void seguirRuta() {
        vehiculoDecorado.seguirRuta();
    }

    @Override
    protected void recargarCombustible() {
        vehiculoDecorado.recargarCombustible();
    }

    @Override
    public String getTipoVehiculo() {
        return vehiculoDecorado.getTipoVehiculo();
    }
}