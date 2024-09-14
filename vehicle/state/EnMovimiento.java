package vehicle.state;

import vehicle.Vehiculo;

public class EnMovimiento implements EstadoVehiculo{

    @Override
    public void esperarViaje(Vehiculo vehiculo) {
        System.out.println("El vehículo no puede esperar un viaje mientras está en movimiento.");
    }

    @Override
    public void comenzarViaje(Vehiculo vehiculo) {
        System.out.println("El vehículo ya está en movimiento.");
    }

    @Override
    public boolean alertaCombustible(Vehiculo vehiculo) {
        if (vehiculo.getPorcentajeCombustible() < 40){
            System.out.println("¡Alerta de combustible! El vehículo está en movimiento y necesita recarga.");
            return true;
        }
        System.out.println("Nivel de combustible suficiente para continuar el viaje.");
        return false;
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("El viaje ha finalizado. Verificando destino...");
        vehiculo.setEstado(new Finalizado());
    }
}