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
    public boolean alertaCombustible(Vehiculo vehiculo) {
        System.out.println("¡Alerta de combustible activada! Es necesario recargar combustible.");
        return true;  
        // Devuelve verdeadero ya que hay alerta de combustible
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede finalizar el viaje, ¡el combustible es insuficiente!");
    }
}