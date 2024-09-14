package vehicle;

import java.util.HashMap;
import java.util.Map;

public class Destino {
    private String nombre;
    private String coordenadas;
    private static final double ZOCALO_LAT = 19.432608;
    private static final double ZOCALO_LON = -99.133209;

    // Diccionario de destinos con nombre y coordenadas (latitud, longitud)
    private static final Map<String, String> destinos = new HashMap<>();

    static {
        destinos.put("Polanco", "19.43324,-99.19772");
        destinos.put("Xochimilco", "19.26290,-99.10446");
        destinos.put("Estadio Azteca", "19.30286,-99.15053");
        destinos.put("Torre Latino", "19.43315,-99.14032");
        destinos.put("Monumento a la Revolución", "19.43719,-99.15445");
        destinos.put("Auditorio Nacional", "19.42600,-99.19194");
        destinos.put("Cosmovitral", "19.28786,-99.65559");
        destinos.put("Pirámides de Teotihuacan", "19.69283,-98.84353");
        destinos.put("Tepotzotlán", "19.71961,-99.22626");
        destinos.put("Zona Arqueológica de Xochicalco", "18.80415,-99.28615");
    }

    public Destino(String nombre) {
        if (destinos.containsKey(nombre)) {
            this.nombre = nombre;
            this.coordenadas = destinos.get(nombre);
        } else {
            System.out.println("Destino no válido.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    // Método para calcular la distancia usando la fórmula de Haversine
    public double calcularDistancia() {
        if (this.coordenadas == null) {
            return 0;
        }

        String[] coords = this.coordenadas.split(",");
        double lat2 = Double.parseDouble(coords[0]);
        double lon2 = Double.parseDouble(coords[1]);

        return haversine(ZOCALO_LAT, ZOCALO_LON, lat2, lon2);
    }

    // Fórmula de Haversine para calcular la distancia entre dos puntos (en km)
    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // R de la tierra en km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    public static void mostrarDestinos() {
        System.out.println("Destinos disponibles:");
        for (String destino : destinos.keySet()) {
            System.out.println(destino);
        }
    }
}