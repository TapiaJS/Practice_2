package vehicle.state;

import vehicle.Vehiculo;

public class EsperandoViaje implements EstadoVehiculo {

    @Override
    public void esperarViaje(Vehiculo vehiculo) {
        System.out.println("El vehículo ya está esperando un viaje.");
    }

    @Override
    public void comenzarViaje(Vehiculo vehiculo) {
        System.out.println("El viaje ha comenzado. Vehículo en movimiento.");
        vehiculo.setEstado(new EnMovimiento());
    }

    @Override
    public void alertaCombustible(Vehiculo vehiculo) {
        System.out.println("¡Alerta de combustible mientras espera!");
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede finalizar un viaje que no ha comenzado.");
    }
}

