package vehicle.state;

import vehicle.Vehiculo;

public class EsperandoViaje implements EstadoVehiculo {

    @Override
    public void esperarViaje(Vehiculo vehiculo) {
        System.out.println("El vehículo ya está esperando un viaje.");
    }

    @Override
    public void comenzarViaje(Vehiculo vehiculo) {
        System.out.println("El viaje ha comenzado. El vehículo está en movimiento.");
        vehiculo.setEstado(new EnMovimiento());
    }

    @Override
    public boolean alertaCombustible(Vehiculo vehiculo) {
        if (vehiculo.getPorcentajeCombustible() < 40) {
            System.out.println("¡Alerta de combustible mientras el vehículo espera! Es necesario recargar.");
            return true;
        }
        System.out.println("El nivel de combustible es adecuado para comenzar el viaje.");
        return false;
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede finalizar un viaje que aún no ha comenzado.");
    }
}