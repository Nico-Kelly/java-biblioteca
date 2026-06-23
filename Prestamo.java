public class Prestamo {
    private Usuario usuario;
    private Material material;
    private int dias;
    
    public Prestamo(Usuario usuario, Material material){
        this.usuario = usuario;
        this.material = material;
        this.dias = 0;
    }
    
    public Usuario usuario(){
        return this.usuario;
    }
    
    public Material material(){
        return this.material;
    }
    
    public int dias(){
        return this.dias;
    }
}