public class Ejemplo8 extends Thread {
    public static void main(String args[]) {
        Recurso a = new Recurso();
        Recurso b = new Recurso();
        Hilo h1 = new Hilo(a, b, "uno");
        Hilo h2 = new Hilo(a, b, "dos");
//      he cambiado b, a por a, b, haciendo que hasta que h1 no termine con "a" h2 no pueda empezar a hacer nada
        h1.start();
        h2.start();
    }
}
//Hilo.java
class Hilo extends Thread {
    Recurso a;
    Recurso b;
    public Hilo(Recurso a, Recurso b,String nombre) {
        super(nombre);
        this.a = a;
        this.b = b;
    }
    public void run(){
        System.out.println("Hilo " + this.getName() + " comienza");
        synchronized(a) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(b) {
            }
            System.out.println("Hilo " + this.getName() + " ha terminado");
        }
    }
}
class Recurso{
}
