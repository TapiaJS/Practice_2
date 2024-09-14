package vehicle;

import colors.Colors;
import vehicle.state.EsperandoViaje;
import vehicle.state.EstadoVehiculo;

import java.util.Scanner;

public abstract class Vehiculo extends Destino{
    private final String TIPOCOMBUSTIBLE;
    protected double porcentajeCombustible;
    protected EstadoVehiculo estadoActual;

    private boolean vehiculoEncendido = false;

    public Vehiculo(String TIPOCOMBUSTIBLE){
        this.TIPOCOMBUSTIBLE = TIPOCOMBUSTIBLE;
        this.porcentajeCombustible = 100.0;
        this.estadoActual = new EsperandoViaje();
    }

    public double getPorcentajeCombustible(){
        return this.porcentajeCombustible;
    }

    public void setPorcentajeCombustible(double añadirCombustible){
        this.porcentajeCombustible += añadirCombustible;
    }

    public void setEstado(EstadoVehiculo nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void solicitarVehiculo(){
        esperarViaje();
        if (personalizarVehiculo()){
            //agregar los métodos necesarios para personalizar el vehículo
        }
        encender();
        comenzarViaje();
        seguirRuta();
        finalizarViaje();
        apagar();
    }

    public void esperarViaje() {
        recargarCombustible();
        estadoActual.esperarViaje(this);
    }

    public boolean personalizarVehiculo(){
        return false;
    }

    private void encender() {
        this.vehiculoEncendido = true;
        System.out.println("El vehículo ha sido encendido.");
    }

    public void comenzarViaje() {
        estadoActual.comenzarViaje(this);
    }

    //Puede que lo mejor sea que cada vehículo herede de destino y no la plantilla
    protected abstract void seguirRuta();

    public void finalizarViaje() {
        estadoActual.finalizarViaje(this);
    }

    private void apagar(){
        this.vehiculoEncendido = false;
        System.out.println("El vehículo ha sido apagado.");
    }

    public boolean alertaCombustible() {
        return estadoActual.alertaCombustible(this);
    }

    protected abstract void recargarCombustible();

    public abstract String getTipoVehiculo();

    public static int getInt(String mensaje, int min, int max) {
        Scanner m = new Scanner(System.in);
        int valor;
        String error = "Por favor ingresa una opción válida.";

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (m.hasNextInt()) {
                valor = m.nextInt();

                if (valor < min || max < valor) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return valor;
                }
            } else {
                m.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }
}
