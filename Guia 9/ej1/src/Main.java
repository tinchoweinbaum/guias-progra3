import java.io.*;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

public static void main(String[] args) throws FileNotFoundException {
    // --- Creación de la flota ---
    Vehiculo auto1 = new Automovil("1284",2002,"Ford","Ka","AGC928", new Motor("1234","Nafta"));
    Vehiculo auto2 = new Automovil("1293",2010,"Ford","Ecosport","AHF831", new Motor("1235","GasOil"));
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    vehiculos.add(auto1);
    vehiculos.add(auto2);
    Flota flota = new Flota("Fords",vehiculos);

    // --- Serialización y deserialización binaria ---
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("flota_test.bin"))){ // Serialización nativa de Java, usa objetos ObjectOutputStream
        oos.writeObject(flota);
        System.out.println("Flota serializada en binario.");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    flota = null; // Destruyo la referencia al objeto flota original y dejo que se lo lleve el gc;

    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("flota_test.bin"))){
        Flota flotaLeidaBin = (Flota) ois.readObject();
        System.out.println("Flota leída del binario: " + flotaLeidaBin);
    } catch (IOException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

    // --- Serialización y deserialización XML ---
    flota = new Flota("Fords",vehiculos);
    try(XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("flota_test.xml")))){
        xmlEncoder.writeObject(flota);
        System.out.println("Flota codificada en XML");
    }
    catch(Exception e){
        System.out.println("Error al codificar en XML");
    }

    flota = null; // Destruyo la referencia al objeto flota original y dejo que se lo lleve el gc;

    try(XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("flota_test.xml")))){
        flota = (Flota) xmlDecoder.readObject(); // Casteo de Object a Flota, el decoder no sabe que está leyendo hasta tiempo de ejecución.
        System.out.println("Flota decodificada en XML :D");
        System.out.println(flota);
    } catch (Exception e){
        System.out.println("Error al decodificar en xml" + e.getMessage());
    }

}