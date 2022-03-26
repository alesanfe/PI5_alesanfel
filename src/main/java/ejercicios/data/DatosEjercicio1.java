package main.java.ejercicios.data;

import main.java.ejercicios.classes.Fichero;
import main.java.ejercicios.classes.Memoria;
import us.lsi.common.Files2;
import us.lsi.common.List2;

import java.util.List;

/**
 * Los datos necesarios para resolver el ejercicio 1.
 */
public class DatosEjercicio1 {

    private static List<Memoria> memorias;
    private static List<Fichero> ficheros;

    /**
     * Carga los datos de un fichero.
     *
     * @param path la ruta del fichero.
     */
    public static void initDatos(String path) {
        memorias = List2.empty();
        ficheros = List2.empty();
        for (String linea : Files2.linesFromFile(path)) {
            if (linea.contains("MEM") && !linea.contains("//"))
                memorias.add(Memoria.parse(linea));
            else if (linea.contains("F") && !linea.contains("//"))
                ficheros.add(Fichero.parse(linea));
        }
    }

    // <- MÉTODOS PARA MEMORIA -> //

    /**
     * Obtiene la capacidad de una memoria.
     *
     * @param j el índice correspondiente a la memoria en la lista {@code memorias}.
     * @return la capacidad de la memoria.
     */
    public static Integer getCapacidadMemoria(Integer j) {
        return memorias.get(j).capacidad();
    }

    /**
     * Obtiene el tamaño máximo de un fichero que puede ser almacenado en la memoria.
     *
     * @param j el índice correspondiente a la memoria en la lista {@code memorias}.
     * @return el tamaño máximo que puede tener el fichero a almacenar en memoria.
     */
    public static Integer getMaxTamanoMemoria(Integer j) {
        return memorias.get(j).tamanoMaximo();
    }

    /**
     * Obtiene una instancia del tipo {@link Memoria}.
     *
     * @param j el índice correspondiente a la memoria en la lista {@code memorias}.
     * @return una instancia del tipo {@link Memoria}.
     */
    public static Memoria getMemoria(Integer j) {
        return memorias.get(j);
    }

    /**
     * Obtiene el número de memorias que disponemos.
     *
     * @return el número de memorias que disponemos.
     */
    public static Integer getNumMemoria() {
        return memorias.size();
    }

    // <- MÉTODOS PARA FICHEROS -> //

    /**
     * Obtiene la capacidad del fichero.
     *
     * @param i el índice correspondiente al en la lista {@code ficheros}.
     * @return la capacidad del fichero.
     */
    public static Integer getCapacidadFichero(Integer i) {
        return ficheros.get(i).capacidad();
    }

    /**
     * Obtiene una instancia del tipo {@link Fichero}.
     *
     * @param i el índice correspondiente al en la lista {@code ficheros}.
     * @return una instancia del tipo {@link Fichero}.
     */
    public static Fichero getFichero(Integer i) {
        return ficheros.get(i);
    }

    /**
     * Obtiene el número de ficheros que disponemos.
     *
     * @return el número de ficheros que disponemos.
     */
    public static Integer getNumFichero() {
        return ficheros.size();
    }
}
