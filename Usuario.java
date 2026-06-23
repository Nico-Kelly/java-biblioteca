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
    
    @Override
    public boolean equals(Object otro){
        if(otro == null){
            return false;
        }
        
        if(!(otro instanceof Usuario)){
            return false;
        }
        
        Usuario otroUsuario = (Usuario) otro;
        return this.legajo.equals(otroUsuario.legajo());
    }
}