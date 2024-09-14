package vehicle.state;

import vehicle.Vehiculo;

public class Finalizado implements EstadoVehiculo {
    
    @Override
    public void esperarViaje(Vehiculo vehiculo) {
        System.out.println("El vehículo está esperando un nuevo viaje.");
        vehiculo.setEstado(new EsperandoViaje());
    }

    @Override
    public void comenzarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede comenzar un nuevo viaje, el viaje anterior ya ha finalizado.");
    }

    @Override
    public boolean alertaCombustible(Vehiculo vehiculo) {
        if (vehiculo.getPorcentajeCombustible() < 40) {
            System.out.println("¡Alerta de combustible tras finalizar el viaje! Debes recargar combustible.");
            return true;
        }
        System.out.println("El nivel de combustible es adecuado tras finalizar el viaje.");
        return false;
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("El viaje ya ha sido finalizado.");
    }
}
