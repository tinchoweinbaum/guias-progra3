import java.util.ArrayList;

// Preguntar en la practica si esta bien el enfoque de la clase ItemFS como padre de todos.

public class Main {
    public static void main(String[] args) {
        // 1. Crear archivos sueltos
        Archivo doc = new Archivo("documento", ".pdf", 500.0);
        Archivo foto = new Archivo("foto", ".jpg", 2048.0);
        Archivo notas = new Archivo("notas", ".txt", 12.5);

        // 2. Crear un directorio raíz y subdirectorios
        Directorio root = new Directorio("root");
        Directorio fotosFolder = new Directorio("Fotos");
        Directorio docsFolder = new Directorio("Documentos");

        // 3. Estructurar árbol
        fotosFolder.agregarItem(foto);
        docsFolder.agregarItem(doc);
        docsFolder.agregarItem(notas);

        root.agregarItem(fotosFolder);
        root.agregarItem(docsFolder);

        // 4. Crear un enlace simbólico que apunta a la carpeta de fotos
        Link accesoFotos = new Link("acceso_fotos", fotosFolder);
        root.agregarItem(accesoFotos);

        // 5. Crear un archivo comprimido (.tar) con los documentos
        ArrayList<ItemFS> paraComprimir = new ArrayList<>();
        paraComprimir.add(doc);
        paraComprimir.add(notas);

        // Tasa 0.40 (40% del tamaño original)
        ArchivoComprimido backup = new ArchivoComprimido("backup", new java.util.Date(), 0.40, paraComprimir);
        root.agregarItem(backup);

        // 6. Imprimir resultados y verificar polimorfismo
        System.out.println("====== ESTRUCTURA DEL SISTEMA DE ARCHIVOS ======");
        System.out.println(root);

        System.out.println("====== VERIFICACIÓN DE TAMAÑOS TOTALES ======");
        System.out.printf("Tamaño total de '/Fotos': %.2f KiB\n", fotosFolder.getSize());
        System.out.printf("Tamaño total de '/Documentos': %.2f KiB\n", docsFolder.getSize());
        System.out.printf("Tamaño del archivo comprimido: %.2f KiB (original: %.2f KiB)\n",
                backup.getSize(), (doc.getSize() + notas.getSize()));
        System.out.printf("Tamaño TOTAL en '/root': %.2f KiB\n", root.getSize());
    }
}