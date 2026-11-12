public static void main(String[] args){
    ObserverMascotas obsMascotas = new ObserverMascotas();

    Mascota mascotaA = new Mascota("Wachin", obsMascotas);
    Mascota mascotaB = new Mascota("Peke77", obsMascotas);
    Mascota mascotaC = new Mascota("Pollón", obsMascotas);
    Mascota mascotaD = new Mascota("Pitbull asesino", obsMascotas);

    obsMascotas.agregarMascota(mascotaA);
    obsMascotas.agregarMascota(mascotaB);
    obsMascotas.agregarMascota(mascotaC);
    obsMascotas.agregarMascota(mascotaD);

    new Thread(mascotaA).start();
    new Thread(mascotaB).start();
    new Thread(mascotaC).start();
    new Thread(mascotaD).start();
}