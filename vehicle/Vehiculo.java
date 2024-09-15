package vehicle;

import colors.Colors;
import vehicle.modification.modifications.*;
import vehicle.state.EsperandoViaje;
import vehicle.state.EstadoVehiculo;

import java.util.Scanner;

public abstract class Vehiculo extends Destino{
    private final String TIPOCOMBUSTIBLE;
    protected double porcentajeCombustible;
    protected EstadoVehiculo estadoActual;
    protected Vehiculo vehiculoDecorado;  // Campo para el vehículo decorado

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
            agregarModificaciones();
            System.out.println("El " + getTipoVehiculo() + " ha sido personalizado.");
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

    protected boolean personalizarVehiculo(){
        return false;
    }

    private void agregarModificaciones() {
        Vehiculo vehiculoDecorado = this; // El vehículo actual se usará para aplicar decoradores

        int decoracion = getInt("Seleccione una modificación:\n" +
                "1. Faros de Niebla\n" +
                "2. Llantas Todo Terreno\n" +
                "3. Radio\n" +
                "4. Spoiler\n" +
                "5. Turbo\n" +
                "6. Vidrios Polarizados", 1, 6);

        switch (decoracion) {
            case 1:
                int potenciaLuz = getInt("Ingrese la potencia de luz para los faros de niebla (lúmenes): ", 100, 10000);
                vehiculoDecorado = new FarosDeNiebla(vehiculoDecorado, potenciaLuz);
                break;
            case 2:
                int resistenciaLlantas = getInt("Ingrese la resistencia de las llantas todo terreno: ", 1, 100);
                vehiculoDecorado = new LlantasTodoTerreno(vehiculoDecorado, resistenciaLlantas);
                break;
            case 3:
                String frecuenciaRadio = getString("Ingrese la frecuencia de la radio: ");
                vehiculoDecorado = new RadioModificacion(vehiculoDecorado, frecuenciaRadio);
                break;
            case 4:
                String tipoSpoiler = getString("Ingrese el tipo de spoiler: ");
                vehiculoDecorado = new Spoiler(vehiculoDecorado, tipoSpoiler);
                break;
            case 5:
                vehiculoDecorado = new Turbo(vehiculoDecorado);
                break;
            case 6:
                int nivelPolarizado = getInt("Ingrese el nivel de polarización de los vidrios: ", 0, 100);
                vehiculoDecorado = new VidriosPolarizados(vehiculoDecorado, nivelPolarizado);
                break;
        }
        this.vehiculoDecorado = vehiculoDecorado;
    }

    private void encender() {
        this.puertasAbiertas = true;
        System.out.println("El " + getTipoVehiculo() + " ha sido encendido.");
    }

    private String comenzarViaje() {
        estadoActual.comenzarViaje(this);
        System.out.println("*El usuario entra*");
        estadoActual.comenzarViaje(this);
        return seleccionarDestino();
    }

    //Puede que lo mejor sea que cada vehículo herede de destino y no la plantilla
    public abstract boolean seguirRuta(String destino);

    private void finalizarViaje() {
        estadoActual.finalizarViaje(this);
        estadoActual.finalizarViaje(this);

        if (this.puertasAbiertas){
            System.out.println("*El usuario sale del " + getTipoVehiculo() + "*");
            estadoActual.esperarViaje(this);
        }

        if (estadoActual.alertaCombustible(this)){
            recargarCombustible();
        }
    }

    private void apagar(){
        System.out.println("El " + getTipoVehiculo() + " ha sido apagado.");
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

    private static String getString(String mensaje) {
        Scanner m = new Scanner(System.in);
        Colors.println(mensaje, Colors.HIGH_INTENSITY);
        return m.nextLine();
    }
}