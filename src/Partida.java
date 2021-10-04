import java.util.Scanner;
import java.util.Random;

public class Partida{
    private Scanner scanner;
    private Tablero tablero;
    private Jugador[] jugadores;
    private Random random;
    private boolean hayGanador;
    private int dado;
    private int turno;
    private int dificultad;
    private Pregunta pregunta;
    
    public Partida(int dificultad){
        scanner = new Scanner(System.in);
        tablero = new Tablero();
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador();
        jugadores[1] = new Jugador();
        random = new Random();
        turno = 0;
        hayGanador = false;
        pregunta = new Pregunta();
        this.dificultad = dificultad;      
    }

    public void jugar(){
        while(!hayGanador){          
            ejecutarTurno(turno);
            if(jugadores[turno].getPosicion() < 99){
                evaluarCelda(jugadores[turno].getPosicion(), turno);
            }          
            if(jugadores[turno].getGanador()){
                hayGanador = true;
            }                                 
        }    
    }

    private void ejecutarTurno(int turno){
        dado = 1 + random.nextInt(6);
        if(turno == 0){  
            menuJugador(turno);
            jugadores[turno].mover(dado);
            System.out.println("\nSacaste " + dado + ", ahora estan en la celda Nº " + jugadores[turno].getPosicion() + ".");                                         
            turno = 1;
        }else{
            jugadores[turno].mover(dado);
            turno = 0;
        }           
    }

    private void menuJugador(int turno){
        System.out.println("---------- Turno Jugador ---------- \n");
        System.out.println("Estas en la celda Nº " + jugadores[turno].getPosicion() + ".");
        System.out.println("Tienes: " + jugadores[turno].getComodin() + " comodines.");
        System.out.println("----------------------------------- \n");
        System.out.println("Presiona 'Enter' para lanzar el dado...");
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void evaluarCelda(int i, int turno){
        int tipoCelda = tablero.getCelda(i);
        boolean respuesta;
        if(tipoCelda == 1){ // Monos
            respuesta = pregunta.lanzarPregunta(dificultad + 1);
            if(respuesta){
                jugadores[turno].mover(20);
            }
        }else if(tipoCelda == 2){ // Liana
            respuesta = pregunta.lanzarPregunta(dificultad + 1); 
            if(!respuesta){
                jugadores[turno].mover(-20);
            }   
        }else if(tipoCelda == 3){ // Comodin
            jugadores[turno].darComodin();  
        }else if(tipoCelda == 4){ // Evento
            respuesta = pregunta.lanzarPregunta(dificultad);
            if(respuesta){
                jugadores[turno].mover(3); 
            }else{
                jugadores[turno].mover(-3);   
            }        
        }    
    }
}
