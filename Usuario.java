public class Usuario {
    private String nombre;
    private String legajo;
    
    public Usuario(String nombre, String legajo){
        this.nombre = nombre;
        this.legajo = legajo;
    }
    
    public String nombre(){
        return this.nombre;
    }
    
    public String legajo(){
        return this.legajo;
    }
}