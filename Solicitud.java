public class Solicitud {
    private Usuario usuario;
    private Material material;
    
    public Solicitud(Usuario usuario, Material material){
        this.usuario = usuario;
        this.material = material;
    }
    
    public Usuario usuario(){
        return this.usuario;
    }
    
    public Material material(){
        return this.material;
    }
    
    public boolean puedeProcesarse(){
        return material.estaDisponible();
    }
}