import java.util.HashSet;
import java.util.Set;

public class VerificacionID {
    private static final int LONGITUD_MINIMA = 6;
    private Set<String> idsUtilizados;

    public VerificacionID() {
        this.idsUtilizados = new HashSet<>();
    }

    public boolean verificar(String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("El ID no puede estar vacío.");
            return false;
        }

        if (!id.matches("\\d+")) {
            System.out.println("El ID debe contener solo números.");
            return false;
        }

        if (id.length() < LONGITUD_MINIMA) {
            System.out.println("El ID debe tener al menos " + LONGITUD_MINIMA + " caracteres.");
            return false;
        }

        if (idsUtilizados.contains(id)) {
            System.out.println("El ID ya ha sido utilizado.");
            return false;
        }

        idsUtilizados.add(id);
        System.out.println("El ID es válido y ha sido registrado correctamente.");
        return true;
    }
}