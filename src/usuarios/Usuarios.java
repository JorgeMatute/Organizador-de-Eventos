package usuarios;

public abstract class Usuarios {
 
    
    public abstract boolean permisoCrearEvento(); //Sólo el límitado no puede.
     
    public abstract boolean verEvento(); //Todos los usuarios tienen permitido.
    
    public abstract boolean administrarUsuarios(); //Sólo está disponible para usuarios administradores.
    
    
}
