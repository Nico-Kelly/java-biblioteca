public class Revista extends Material{
    private int numero;
    private int ejemplaresDisponibles;
    
    public Revista(String titulo, int anio, int numero, int ejemplaresDisponibles){
        super(titulo, anio);
        this.numero = numero;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }
    
    public int numero(){
        return this.numero;
    }
    
    
    public int diasPrestamo(){
        return 7;
    }
    
   
    public boolean estaDisponible(){
        if(ejemplaresDisponibles > 0){
            return true;
        }
        return false;
    }
    
    
    public void prestar(){
        if (ejemplaresDisponibles > 0){
            ejemplaresDisponibles--;
        }
    }
    
    
    public void devolver(){
        ejemplaresDisponibles++;
    }
}