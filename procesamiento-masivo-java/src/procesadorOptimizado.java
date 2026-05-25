import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ProcesadorOptimizado {

    public static void procesar(List<Cliente> clientes) {

        long inicio = System.currentTimeMillis();

        HashMap<String, List<Cliente>> campanias = new HashMap<>();

        for (Cliente c : clientes) {

            campanias.putIfAbsent(c.campania, new ArrayList<>());

            campanias.get(c.campania).add(c);
        }

        long fin = System.currentTimeMillis();

        System.out.println("===== VERSION OPTIMIZADA =====");
        System.out.println("Campañas: " + campanias.size());
        System.out.println("Tiempo: " + (fin - inicio) + " ms");

        for (String nombre : campanias.keySet()) {

            System.out.println(
                nombre + " -> " +
                campanias.get(nombre).size() +
                " clientes"
            );
        }
    }
}