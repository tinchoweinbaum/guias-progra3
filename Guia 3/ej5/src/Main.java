public static void main(String[] args){
    Automovil autoMan = new AutomovilManual("AA999AA", 180);
    Automovil autoAuto = new AutomovilAutomatico("BB000BB");

    autoAuto.acelerar(100);

    autoMan.acelerar(40);
    autoMan.setMarcha(3);

}