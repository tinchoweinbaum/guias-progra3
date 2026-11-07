/**
 * Clase observable
 */
public class Tamagotchi implements Runnable{


    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep((int) (Math.random() * 6) + 2);
            }
            catch (InterruptedException e) {
                System.out.println("Error al generar una necesidad.");
            }
        }
    }
}
