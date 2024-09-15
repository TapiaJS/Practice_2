package vehicle.modification.modifications;

import vehicle.Vehiculo;
import vehicle.modification.Modificacion;

public class Spoiler extends Modificacion {
    private String tipoSpoiler;

    public Spoiler(Vehiculo vehiculoDecorado, String tipoSpoiler) {
        super(vehiculoDecorado);
        this.tipoSpoiler = tipoSpoiler;
    }

    @Override
    public void solicitarVehiculo() {
        super.solicitarVehiculo();
        System.out.println("Spoiler aerodinámico de tipo: " + tipoSpoiler + " ajustado.");
    }

    public void ajustarSpoiler(String nuevoTipo) {
        this.tipoSpoiler = nuevoTipo;
        System.out.println("Spoiler ajustado a tipo: " + nuevoTipo + ".");
    }
}