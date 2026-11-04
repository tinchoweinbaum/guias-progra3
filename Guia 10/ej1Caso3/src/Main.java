public static void main(String[] args){
    TramoCompartido tramo = new TramoCompartido();
    new Thread(new Tren("Trencito",false,tramo)).start();
    new Thread(new Tren("Tren",true,tramo)).start();
    new Thread(new Tren("TrenAZO",false,tramo)).start();
    new Thread(new Tren("TrenSOTE",false, tramo)).start();
}