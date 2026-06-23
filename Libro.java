public class Libro extends Material{
    private String autor;
    private int ejemplaresDisponibles;
    
    public Libro(String titulo, int anio, String autor, int ejemplaresDisponibles){
        super(titulo, anio);
        this.autor = autor;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }
    
    public String autor(){
        return this.autor;
    }
    
    @Override
    public int diasPrestamo(){
        return 14;
    }
    
    @Override
    public boolean estaDisponible(){
        if(ejemplaresDisponibles > 0){
            return true;
        }
        return false;
    }
    
    @Override
    public void prestar(){
        if(ejemplaresDisponibles > 0){
            ejemplaresDisponibles--;            
        }
    }
    
    @Override
    public void devolver(){
        ejemplaresDisponibles++;
    }
}