package vehicle;

import colors.Colors;
import vehicle.state.EsperandoViaje;
import vehicle.state.EstadoVehiculo;

public abstract class Vehiculo {
    private final String TIPOCOMBUSTIBLE;
    protected double porcentajeCombustible;
    protected EstadoVehiculo estadoActual;
    private boolean vehiculoEncendido = false;
    private Destino destino; 

    public Vehiculo(String TIPOCOMBUSTIBLE) {
        this.TIPOCOMBUSTIBLE = TIPOCOMBUSTIBLE;
        this.porcentajeCombustible = 100.0;
        this.estadoActual = new EsperandoViaje();
    }

    public double getPorcentajeCombustible() {
        return this.porcentajeCombustible;
    }

    public void setPorcentajeCombustible(double añadirCombustible) {
        this.porcentajeCombustible += añadirCombustible;
        if (this.porcentajeCombustible > 100.0) {
            this.porcentajeCombustible = 100.0;
        } else if (this.porcentajeCombustible < 0) {
            this.porcentajeCombustible = 0;
        }
    }

    public void setEstado(EstadoVehiculo nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void solicitarVehiculo() {
        esperarViaje();
        if (personalizarVehiculo()) {
            System.out.println("El vehículo ha sido personalizado.");
        }
        encender();
        comenzarViaje();
        seguirRuta();
        finalizarViaje();
        apagar();
    }

    protected void esperarViaje() {
        recargarCombustible();
        estadoActual.esperarViaje(this);
    }

    public boolean personalizarVehiculo() {
        return false;  
    }

    private void encender() {
        if (!vehiculoEncendido && porcentajeCombustible > 0) {
            vehiculoEncendido = true;
            System.out.println("El vehículo ha sido encendido.");
        } else if (porcentajeCombustible <= 0) {
            System.out.println("No hay suficiente combustible para encender el vehículo.");
        }
    }

    public void comenzarViaje() {
        estadoActual.comenzarViaje(this);
    }

    public void seleccionarDestino(String destinoNombre) {
        this.destino = new Destino(destinoNombre);  
    }

    public String getDestino() {
        return destino != null ? destino.getNombre() : "No se seleccionó destino";
    }

    public abstract void seguirRuta();

    public void finalizarViaje() {
        estadoActual.finalizarViaje(this);
    }

    private void apagar() {
        if (vehiculoEncendido) {
            if (estadoActual instanceof EsperandoViaje) {
                vehiculoEncendido = false;
                System.out.println("El vehículo ha sido apagado.");
            } else {
                System.out.println("No se puede apagar el vehículo mientras está en movimiento.");
            }
        } else {
            System.out.println("El vehículo ya está apagado.");
        }
    }

    public boolean alertaCombustible() {
        return estadoActual.alertaCombustible(this);
    }

    public abstract void recargarCombustible();

    public abstract String getTipoVehiculo();
}