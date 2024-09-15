package vehicle.state;

import vehicle.Vehiculo;

public class EsperandoViaje implements EstadoVehiculo {

    @Override
    public void esperarViaje(Vehiculo vehiculo) {
        System.out.println("El " + vehiculo.getTipoVehiculo() + " está esperando un viaje.");
    }

    @Override
    public void comenzarViaje(Vehiculo vehiculo) {
        System.out.println("El viaje ha comenzado. " + vehiculo.getTipoVehiculo() + " en camino. (puertas abiertas)");
        vehiculo.setEstado(new EnMovimiento());
    }

    @Override
    public boolean alertaCombustible(Vehiculo vehiculo) {
        if (vehiculo.getPorcentajeCombustible() < 30){
            System.out.println("¡Alerta de combustible! (en espera)");
            return true;
        }
        return false;
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("No se puede finalizar un viaje que no ha comenzado.");
    }
}

