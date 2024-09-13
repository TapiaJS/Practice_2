package vehicle.state;

import vehicle.Vehiculo;

public class AlertaCombustible implements EstadoVehiculo {

    @Override
    public void esperarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede esperar un viaje, ¡el combustible es insuficiente!");
    }

    @Override
    public void comenzarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede comenzar un viaje, ¡el combustible es insuficiente!");
    }

    @Override
    public void alertaCombustible(Vehiculo vehiculo) {
        System.out.println("¡Alerta de combustible activada!");
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede finalizar el viaje, ¡el combustible es insuficiente!");
    }
}
