public class Reserva {
    private Usuario usuario;
    private Material material;
    
    public Reserva(Usuario usuario, Material material){
        this.usuario = usuario;
        this.material = material;
    }
    
    public Usuario usuario(){
        return this.usuario;
    }
    
    public Material material(){
        return this.material;
    }
}