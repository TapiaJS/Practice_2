package vehicle.vehicles;

import vehicle.Vehiculo;

public class Scooter extends Vehiculo {

    public Scooter(String TIPOCOMBUSTIBLE) {
        super(TIPOCOMBUSTIBLE);
    }

    @Override
    public boolean seguirRuta(String destino) {
        String rutaSeleccionada = "ciudad";
        System.out.println("El " + getTipoVehiculo() + " ha comenzado su viaje por la " + rutaSeleccionada + "(Única ruta)");

        double velocidad = calcularVelocidad(10, 20);
        System.out.println("El " + getTipoVehiculo() + " está circulando por la ciudad. Consumo moderado de combustible.");

        return rutaPersonalizada(destino,this, velocidad, rutaSeleccionada);
    }

    //Llenará la batería por completo
    @Override
    public void recargarCombustible() {
        System.out.println("Porcentaje de" + getTIPOCOMBUSTIBLE() + ": " + getPorcentajeCombustible());

        double agregarCombustible = 100.0 - getPorcentajeCombustible();

        System.out.println("Cargando " + getTIPOCOMBUSTIBLE());
        setPorcentajeCombustible(agregarCombustible);

        System.out.println("Cantidad de " + getTIPOCOMBUSTIBLE() + " en la batería: " + getPorcentajeCombustible());
    }

    @Override
    public String getTipoVehiculo() {
        return "scooter";
    }
}
