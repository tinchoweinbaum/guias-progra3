public static void main(String[] args){
    TramoCompartido tramo = new TramoCompartido();
    new Thread(new Tren("Trencito",tramo)).start();
    new Thread(new Tren("Tren",tramo)).start();
    new Thread(new Tren("TrenAZO",tramo)).start();
    new Thread(new Tren("TrenSOTE",tramo)).start();
}