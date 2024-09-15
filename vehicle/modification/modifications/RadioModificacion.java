package vehicle.modification.modifications;

import vehicle.Vehiculo;
import vehicle.modification.Modificacion;

public class RadioModificacion extends Modificacion {
    private String frecuencia;

    public RadioModificacion(Vehiculo vehiculoDecorado, String frecuencia) {
        super(vehiculoDecorado);
        this.frecuencia = frecuencia;
    }

    @Override
    public void solicitarVehiculo() {
        super.solicitarVehiculo();
        System.out.println("Radio ajustado a la frecuencia: " + frecuencia + ".");
    }

    public void cambiarFrecuencia(String nuevaFrecuencia) {
        this.frecuencia = nuevaFrecuencia;
        System.out.println("Frecuencia de la radio cambiada a: " + nuevaFrecuencia + ".");
    }
}