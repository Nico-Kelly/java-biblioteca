public class Audiolibro extends RecursoDigital{
    private int duracionMinutos;
    
    public Audiolibro(String titulo, int anio, String licencia, int licenciasDisponibles, int duracionMinutos){
        super(titulo, anio, licencia, licenciasDisponibles);
        this.duracionMinutos = duracionMinutos;
    }
    
    public int duracionMinutos(){
        return this.duracionMinutos;
    }
    
    @Override
    public double costoLicencia(){
        return 1500+duracionMinutos*10;
    }
}