package vehicle.state;

import vehicle.Vehiculo;

public class Finalizado implements EstadoVehiculo{
    @Override
    public void esperarViaje(Vehiculo vehiculo) {
        System.out.println("El vehículo está esperando un nuevo viaje.");
        vehiculo.setEstado(new EsperandoViaje());
    }

    @Override
    public void comenzarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede comenzar un viaje, el viaje anterior ya terminó.");
    }

    @Override
    public void alertaCombustible(Vehiculo vehiculo) {
        System.out.println("¡Alerta de combustible después de finalizar el viaje!");
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("El viaje ya ha sido finalizado.");
    }
}
