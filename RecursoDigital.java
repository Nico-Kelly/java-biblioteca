public class RecursoDigital extends Material{
    private String licencia;
    private int licenciasDisponibles;
    
    public RecursoDigital(String titulo, int anio, String licencia, int licenciasDisponibles){
        super(titulo, anio);
        this.licencia = licencia;
        this.licenciasDisponibles = licenciasDisponibles;
    }
    
    public String licencia(){
        return this.licencia;
    }
    
    @Override
    public int diasPrestamo(){
        return 7;
    }
    
    @Override
    public boolean estaDisponible(){
        if(licenciasDisponibles > 0){
            return true;
        }
        return false;
    }
    
    @Override
    public void prestar(){
        licenciasDisponibles--;
    }
    
    @Override
    public void devolver(){
        licenciasDisponibles++;
    }
    
    @Override
    public double costoLicencia(){
        return 1.0;
    }
}