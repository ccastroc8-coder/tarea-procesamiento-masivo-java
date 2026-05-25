import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Nombre: Carlos Daniel Castro Caceres");
        System.out.println("Carnet: 9941-24-10004");

        long inicioGeneracion = System.currentTimeMillis();

        List<Cliente> clientes = new ArrayList<>();

        String[] campanias = {
            "Campania A",
            "Campania B",
            "Campania C",
            "Campania D",
            "Campania E"
        };

        Random random = new Random();

        for (int i = 1; i <= 1000000; i++) {

            clientes.add(
                new Cliente(
                    i,
                    "Cliente " + i,
                    campanias[random.nextInt(campanias.length)]
                )
            );
        }

        long finGeneracion = System.currentTimeMillis();

        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        long memoria =
            (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);

        System.out.println("Clientes generados: " + clientes.size());
        System.out.println("Tiempo generación: " +
            (finGeneracion - inicioGeneracion) + " ms");

        System.out.println("Memoria usada: " + memoria + " MB");

        ProcesadorIneficiente.procesar(clientes);

        ProcesadorOptimizado.procesar(clientes);
    }
}