package vehicle.state;

import vehicle.Vehiculo;

public interface EstadoVehiculo {
    void esperarViaje(Vehiculo vehiculo);
    void comenzarViaje(Vehiculo vehiculo);
    void alertaCombustible(Vehiculo vehiculo);
    void finalizarViaje(Vehiculo vehiculo);
}
