package vehicle.state;

public interface EstadoVehiculo {
    void esperarViaje();
    void comenzarViaje();
    void finalizarViaje();
    void alertaCombustible();
}
