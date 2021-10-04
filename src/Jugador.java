public class Jugador{

    private int posicion;
    private int comodin;
    private boolean ganador;
    
    public Jugador(){
        posicion = 0;
        comodin = 0;
        ganador = false;
    }
    
    public int getPosicion(){
        return posicion;
    }

    public void mover(int x){
        posicion = posicion + x;
        if(posicion >= 99){
            ganador = true;
        }
    }

    public boolean getGanador(){
        return ganador;
    }

    public int getComodin(){
        return comodin;
    }
    
    public void darComodin(){
        comodin++;
    }
}
