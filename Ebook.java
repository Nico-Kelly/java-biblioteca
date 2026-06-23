public class Ebook extends RecursoDigital{
    private int cantidadPaginas;
    
    public Ebook(String titulo, int anio, String licencia, int licenciasDisponibles, int cantidadPaginas){
        super(titulo, anio, licencia, licenciasDisponibles);
        this.cantidadPaginas = cantidadPaginas;
    }
    
    public int cantidadPaginas(){
        return this.cantidadPaginas;
    }
    
    @Override
    public double costoLicencia(){
        return 1000+cantidadPaginas*5;
    }
}