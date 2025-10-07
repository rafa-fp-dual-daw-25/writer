import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcome();
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                System.out.println("Nombre del archivo");
                String fileName = sc.nextLine();
                System.out.println("Texto: ");
                String message = sc.nextLine();
                writeFile(fileName, message);
                break;
            case 2:
                System.out.println("Nombre del archivo a leer:");
                String fileNameRead = sc.nextLine();
                readFile(fileNameRead);
                break;
            case 3:
                System.out.println("Nombre del archivo a eliminar:");
                String fileNameDel = sc.nextLine();
                deleteFile(fileNameDel);
                break;
            case 4:
                System.out.println("Directorio a listar (dejar vacío para actual):");
                String directory = sc.nextLine();
                if (directory.isEmpty()) {
                    System.out.println("Directorio vacio.");
                } else {
                    listFiles();
                }
                break;
            default:
                System.out.println("Opción no válida");
        }
    }


    public static void welcome() {
        System.out.println();
        System.out.println("############ Writer ############");
        System.out.println("################################");
        System.out.println("1 . Escribir en un archivo");
        System.out.println("2 . Leer un archivo");
        System.out.println("3 . Borrar un archivo");
        System.out.println("4 . Listar ficheros de un directorio");
        System.out.println("5 . Establecer directorio de trabajo");
        System.out.println("0 . Salir");
        System.out.println("################################");
    }

    public static void writeFile(String fileName, String message) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(message);
            System.out.println("Archivo '" + fileName + "' escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            int character;
            System.out.println("Contenido del archivo '" + fileName + "':");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void deleteFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.delete()) {
                System.out.println("Archivo '" + fileName + "' eliminado correctamente.");
            } else {
                System.out.println("Error: No se pudo eliminar el archivo '" + fileName + "'");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el archivo: " + e.getMessage());
        }
    }

    public static void listFiles() {
        try {
            Files.list(Path.of("."))
                    .forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            System.out.println("Error al listar el directorio: " + e.getMessage());
        }
    }
}
