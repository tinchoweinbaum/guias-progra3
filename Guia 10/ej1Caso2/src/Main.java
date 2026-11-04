public static void main(String[] args){
    TramoCompartido tramo = new TramoCompartido();
    new Thread(new Tren("Trencito",false, tramo)).start();
    new Thread(new Tren("Tren",false, tramo)).start();
    new Thread(new Tren("TrenAZO",true, tramo)).start();
    new Thread(new Tren("TrenSOTE",true, tramo)).start();
}