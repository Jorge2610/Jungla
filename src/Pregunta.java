public class Pregunta{
    public Pregunta(){

    }
    
    public boolean lanzarPregunta(int dificultad){
        // Pendiente
        return false;
    }

    private static void iniciarTimer(int dificultad){
        for(int i = 30; i > 0; i--){
            System.out.println("Tienes " + i + " segundos para responder...");                
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){} 
            System.out.print("\033[H\033[2J");
            System.out.flush();              
        }    
    }

    public static void main(String[] args){
        iniciarTimer(2);
    }
}