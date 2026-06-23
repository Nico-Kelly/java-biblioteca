import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Biblioteca {
    private ArrayList<Material> materiales;
    private ArrayList<Usuario> usuarios;
    private Queue<Solicitud> solicitudesPendientes;
    private ArrayList<Prestamo> prestamosActivos;
    
    public Biblioteca(){
        materiales = new ArrayList<Material>();
        usuarios = new ArrayList<Usuario>();
        solicitudesPendientes = new LinkedList<Solicitud>();
        prestamosActivos = new ArrayList<Prestamo>();
    }
    
    public void agregarMaterial(Material material){
        materiales.add(material);
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public int cantidadDeMateriales(){
        return materiales.size();
    }
    
    public int cantidadDeUsuarios(){
        return usuarios.size();
    }
    
    public int cantidadDeSolicitudesPendientes(){
        return solicitudesPendientes.size();
    }
    
    public int cantidadDePrestamosActivos(){
        return prestamosActivos.size();
    }
    
    public void solicitarPrestamo(Usuario usuario, Material material){
        Solicitud nuevaSolicitud = new Solicitud(usuario, material);
        solicitudesPendientes.add(nuevaSolicitud);
    }
    
    public boolean procesarSiguienteSolicitud(){
        if(solicitudesPendientes.isEmpty()){
            return false;
        }
        
        Solicitud solicitud =  solicitudesPendientes.poll();
        
        Usuario usuario = solicitud.usuario();
        Material material = solicitud.material();
        
        if(material.estaDisponible()){
            material.prestar();
            Prestamo nuevoPrestamo = new Prestamo(usuario, material);
            prestamosActivos.add(nuevoPrestamo);
            return true;
        }else{
            material.reservar(usuario);
            return false;
        }
    }
    
    public ArrayList<Prestamo> prestamosDe(Usuario usuario){
        ArrayList<Prestamo> prestamosDelUsuario = new ArrayList<Prestamo>();
        for (Prestamo prestamo : prestamosActivos){
            if(prestamo.usuario().equals(usuario)){
                prestamosDelUsuario.add(prestamo);
            }
        }
        return prestamosDelUsuario;
    }
    
    public ArrayList<Material> materialesPrestadosA(Usuario usuario){
        ArrayList<Material> materialesDelUsuario = new ArrayList<Material>();
        for (Prestamo prestamo : prestamosActivos){
            if(prestamo.usuario().equals(usuario)){
                materialesDelUsuario.add(prestamo.material());
            }
        }
        return materialesDelUsuario;
    }
    
    public ArrayList<Reserva> reservasDe(Usuario usuario){
        ArrayList<Reserva> reservasDelUsuario = new ArrayList<Reserva>();
        for (Material material : materiales){
            ArrayList<Reserva> reservasDelMaterial = material.reservas();
            for(Reserva reserva : reservasDelMaterial){
                if(reserva.usuario().equals(usuario)){
                    reservasDelUsuario.add(reserva);
                }
            }
        }
        return reservasDelUsuario;
    }
    
    public ArrayList<Material> materialesReservadosPor(Usuario usuario){
        ArrayList<Material> materialesReservadosDelUsuario = new ArrayList<Material>();
        for (Material material : materiales){
            ArrayList<Reserva> reservasDelMaterial = material.reservas();
            for(Reserva reserva : reservasDelMaterial){
                if(reserva.usuario().equals(usuario)){
                    materialesReservadosDelUsuario.add(reserva.material());
                }
            }
        }
        return materialesReservadosDelUsuario;
    }
    
    public double costoTotalLicencias(){
        double total = 0;
        for (Material material : materiales){
            double costo = material.costoLicencia();
            total = total + costo;
        }
        return total;
    }
}