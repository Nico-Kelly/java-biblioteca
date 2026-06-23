public class Tesis extends Material{
    private String carrera;
    private int ejemplaresDisponibles;
    
    public Tesis(String titulo, int anio, String carrera, int ejemplaresDisponibles){
        super(titulo, anio);
        this.carrera = carrera;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }
    
    public String carrera(){
        return this.carrera;
    }
    
    @Override
    public int diasPrestamo(){
        return 21;
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
        ejemplaresDisponibles--;
    }
    
    @Override
    public void devolver(){
        ejemplaresDisponibles++;
    }
}