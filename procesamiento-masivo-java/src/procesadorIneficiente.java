import java.util.ArrayList;
import java.util.List;

class ProcesadorIneficiente {

    public static void procesar(List<Cliente> clientes) {

        long inicio = System.currentTimeMillis();

        List<String> campanias = new ArrayList<>();
        List<List<Cliente>> grupos = new ArrayList<>();

        for (Cliente c : clientes) {

            int indice = -1;

            for (int i = 0; i < campanias.size(); i++) {

                if (campanias.get(i).equals(c.campania)) {
                    indice = i;
                    break;
                }
            }

            if (indice == -1) {

                campanias.add(c.campania);

                List<Cliente> nueva = new ArrayList<>();
                nueva.add(c);

                grupos.add(nueva);

            } else {

                grupos.get(indice).add(c);
            }
        }

        long fin = System.currentTimeMillis();

        System.out.println("===== VERSION INEFICIENTE =====");
        System.out.println("Campañas: " + campanias.size());
        System.out.println("Tiempo: " + (fin - inicio) + " ms");
    }
}