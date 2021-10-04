import java.util.Random;

public class Tablero {
    private int[] tablero;
    private Random random;

    public Tablero(){
        tablero = new int[100];
        random = new Random();
        generarTablero();
    }   

    private void generarTablero(){
        int tipoCelda = 1;
        int celda;
        while(tipoCelda < 5){
            for(int i = 0; i < 4; i++){
                celda = random.nextInt(99);
                if(tablero[celda] == 0){
                    tablero[celda] = tipoCelda;
                }else{
                    i--;
                }
            }
            tipoCelda++;
        }
    }

    public int getCelda(int i){
        return tablero[i];
    }
}
