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

    public boolean alertaCombustible(Vehiculo vehiculo) {
        if (vehiculo.getPorcentajeCombustible() < 10){
            System.out.println("¡Alerta de combustible! (al finalizar)");
            return true;
        }
        return false;
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        vehiculo.setPuertasAbiertas(true);
        System.out.println("El viaje ya ha sido finalizado. (puertas abiertas)");
    }
}
