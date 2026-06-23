public class CursoCompleto extends RecursoDigital{
    private int duracionMinutos;
    private int cantidadModulos;
    
    public CursoCompleto(String titulo, int anio, String licencia, int licenciasDisponibles, int duracionMinutos, int cantidadModulos){
        super(titulo, anio, licencia, licenciasDisponibles);
        this.duracionMinutos = duracionMinutos;
        this.cantidadModulos = cantidadModulos;
    }
    
    public int duracionMinutos(){
        return this.duracionMinutos;
    }
    
    public int cantidadModulos(){
        return this.cantidadModulos;
    }
    
    @Override
    public double costoLicencia(){
        return 5000 + cantidadModulos * 1200;
    }
}