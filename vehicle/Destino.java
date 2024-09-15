
package vehicle;

import colors.Colors;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Destino {
    private static final Map<String, double[]> puntosInteres = new HashMap<>();

    static {
        puntosInteres.put("Polanco", new double[]{19.4326, -99.2007});
        puntosInteres.put("Xochimilco", new double[]{19.2625, -99.1039});
        puntosInteres.put("Estadio Azteca", new double[]{19.3029, -99.1506});
        puntosInteres.put("Torre Latino", new double[]{19.4339, -99.1400});
        puntosInteres.put("Monumento a la Revolución", new double[]{19.4363, -99.1530});
        puntosInteres.put("Auditorio Nacional", new double[]{19.4256, -99.1913});
        puntosInteres.put("Cosmovitral, Toluca", new double[]{19.2843, -99.6551});
        puntosInteres.put("Pirámides de Teotihuacan", new double[]{19.6925, -98.8430});
        puntosInteres.put("Tepotzotlán", new double[]{19.7117, -99.2181});
        puntosInteres.put("Xochicalco", new double[]{18.7972, -99.2978});
    }

    private static final double[] ZOCALO = {19.4326, -99.1332};

    protected boolean rutaPersonalizada(String destino, Vehiculo vehiculo, double velocidad, String ruta){
        boolean viajeExitoso = false;
        double[] coordenadasDestino = puntosInteres.get(destino);
        if (coordenadasDestino != null) {
            double distancia = calcularDistancia(ZOCALO, coordenadasDestino);
            System.out.println("Viajando del Zócalo a " + destino + ". Distancia: " + distancia + " km.");

            double tiempoViaje = distancia / velocidad;
            System.out.println("El viaje tardará aproximadamente " + tiempoViaje + " horas.");

            // Consumo de combustible
            double consumoCombustible = distancia * 0.1; // Ejemplo: 0.1% por kilómetro
            while (distancia > 0) {
                // Disminuir distancia y combustible conforme se avanza
                distancia -= 10; // Suponiendo 10 km por iteración
                vehiculo.setPorcentajeCombustible(-consumoCombustible);
                System.out.println("Quedan " + distancia + " km. Combustible restante: " +
                        vehiculo.getPorcentajeCombustible() + "%" + vehiculo.getTIPOCOMBUSTIBLE());
            }
            System.out.println("El " + vehiculo.getTipoVehiculo() + " ha llegado a " + destino + ".");
            viajeExitoso = true;
        } else {
            System.out.println("Destino no válido.");
        }
        return viajeExitoso;
    }

    protected String seleccionarDestino() {
        // Simula la selección de destino por parte del usuario
        System.out.println("Selecciona el destino:");
        int i = 1;
        for (String destino : puntosInteres.keySet()) {
            System.out.println(i + ". " + destino);
            i++;
        }
        int seleccion = getInt("Ingresa el número del destino: ", 1, puntosInteres.size());
        return (String) puntosInteres.keySet().toArray()[seleccion - 1];
    }

    private double calcularDistancia(double[] origen, double[] destino) {
        double lat1 = Math.toRadians(origen[0]);
        double lon1 = Math.toRadians(origen[1]);
        double lat2 = Math.toRadians(destino[0]);
        double lon2 = Math.toRadians(destino[1]);

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double radioTierra = 6371;
        return radioTierra * c;
    }

    private static int getInt(String mensaje, int min, int max) {
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