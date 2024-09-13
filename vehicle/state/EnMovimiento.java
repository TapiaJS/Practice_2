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
    public void alertaCombustible(Vehiculo vehiculo) {
        System.out.println("¡Alerta de combustible mientras se mueve!");
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        System.out.println("El viaje ha finalizado. Verificando destino...");
        // Verificación del destino (simulado)
        vehiculo.setEstado(new Finalizado());
    }
}
