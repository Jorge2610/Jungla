import java.util.Scanner;

public class Jungla {
    static Scanner scanner = new Scanner(System.in);
    static int dificultad = 2;
    public static void main(String[] args){
        mostrarMenu();
    }
    
    public static void mostrarMenu(){
        int opcionElegida;
        System.out.println("---------- JUNGLA ---------- \n");
        System.out.println("1.- Iniciar nueva partida.");
        System.out.println("2.- Cambiar dificultad.");
        System.out.println("3.- Salir. \n");
        System.out.println("---------------------------- \n");
        System.out.print("Ingrese una opción: ");
        opcionElegida = scanner.nextInt(); //Falta manejo de excepciones.
        if(opcionElegida == 1){
            iniciarPartida();
            mostrarMenu();
        }else if(opcionElegida == 2){
            menuDificultad();
        }else{
            System.exit(0);
        }
    }

    public static void menuDificultad(){
        System.out.println("---------- DIFICULTAD ---------- \n");
        System.out.println("1.- Facil.");
        System.out.println("2.- Normal.");
        System.out.println("3.- Dificil. \n");
        System.out.println("-------------------------------- \n");
        System.out.print("Ingrese una opción: ");
        dificultad = scanner.nextInt(); //Falta manejo de excepciones.
        mostrarMenu();
    }

    public static void iniciarPartida(){
        Partida partida = new Partida(dificultad);
        partida.jugar();
    }    
}
