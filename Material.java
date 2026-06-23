import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Material {
    private String titulo;
    private int anio;
    private Queue<Reserva> reservas;
    
    public Material(String titulo, int anio){
        this.titulo = titulo;
        this.anio = anio;
        reservas = new LinkedList<Reserva>();
    }
    
    public String titulo(){
        return this.titulo;
    }
    
    public int anio(){
        return this.anio;
    }
    
    public void reservar(Usuario usuario){
        Reserva nuevaReserva = new Reserva(usuario, this);
        reservas.add(nuevaReserva);
    }
    
    public boolean tieneReservas(){
        return !reservas.isEmpty();
    }
    
    public int cantidadDeReservas(){
        return reservas.size();
    }
    
    public Usuario proximoUsuarioEnReserva(){
        if(reservas.isEmpty()){
            return null;
        }
        return reservas.peek().usuario();
    }
    
    public ArrayList<Reserva> reservas(){
        return new ArrayList<Reserva>(reservas);
    }
    
    public abstract int diasPrestamo();
    
    public abstract boolean estaDisponible();
    
    public abstract void prestar();
    
    public abstract void devolver();
    
    public double costoLicencia(){
        return 0.0;
    }
}