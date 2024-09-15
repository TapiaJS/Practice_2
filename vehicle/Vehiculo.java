package vehicle;

import colors.Colors;
import vehicle.state.EsperandoViaje;
import vehicle.state.EstadoVehiculo;

import java.util.Scanner;

public abstract class Vehiculo extends Destino{
    private final String TIPOCOMBUSTIBLE;
    protected double porcentajeCombustible;
    protected EstadoVehiculo estadoActual;

    protected boolean puertasAbiertas;

    public Vehiculo(String TIPOCOMBUSTIBLE){
        this.TIPOCOMBUSTIBLE = TIPOCOMBUSTIBLE;
        this.porcentajeCombustible = 100.0;
        this.estadoActual = new EsperandoViaje();
    }

    public String getTIPOCOMBUSTIBLE(){
        return this.TIPOCOMBUSTIBLE;
    }

    public double getPorcentajeCombustible(){
        return this.porcentajeCombustible;
    }

    public void setPorcentajeCombustible(double agregarCombustible){
        this.porcentajeCombustible += agregarCombustible;
        if (porcentajeCombustible > 100){
            this.porcentajeCombustible = 100;
        }
        if (estadoActual.alertaCombustible(this)){
            System.out.println("Es necesario desviarse de la ruta por un momento.");
            recargarCombustible();
        }
    }

    public void setEstado(EstadoVehiculo nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void setPuertasAbiertas(boolean estado){
        this.puertasAbiertas = estado;
    }

    public void solicitarVehiculo(){
        esperarViaje();
        if (personalizarVehiculo()) {
            //Agregar lógica
            System.out.println("El vehículo ha sido personalizado.");
        }
        encender();
        String destino = comenzarViaje();
        Boolean viajeExitoso = seguirRuta(destino);
        if (viajeExitoso){
            finalizarViaje();
            apagar();
        }
    }

    private void esperarViaje() {
        if (estadoActual.alertaCombustible(this)){
            recargarCombustible();
        }
        estadoActual.esperarViaje(this);
    }

    private boolean personalizarVehiculo(){
        return false;
    }

    private void encender() {
        this.puertasAbiertas = true;
        System.out.println("El vehículo ha sido encendido.");
    }

    private String comenzarViaje() {
        estadoActual.comenzarViaje(this);
        estadoActual.comenzarViaje(this);
        return seleccionarDestino();
    }

    //Puede que lo mejor sea que cada vehículo herede de destino y no la plantilla
    public abstract boolean seguirRuta(String destino);

    private void finalizarViaje() {
        estadoActual.finalizarViaje(this);
        estadoActual.finalizarViaje(this);

        if (this.puertasAbiertas){
            System.out.println("El usuario sale del " + getTipoVehiculo());
            estadoActual.esperarViaje(this);
        }

        if (estadoActual.alertaCombustible(this)){
            recargarCombustible();
        }
    }

    private void apagar(){
        System.out.println("El vehículo ha sido apagado.");
        this.puertasAbiertas = false;
    }

    public abstract void recargarCombustible();

    public abstract String getTipoVehiculo();

    // Método para calcular la velocidad dentro de un intervalo
    protected double calcularVelocidad(int minimo, int maximo) {
        return minimo + (Math.random() * (maximo - minimo));
    }

    protected static int getInt(String mensaje, int min, int max) {
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