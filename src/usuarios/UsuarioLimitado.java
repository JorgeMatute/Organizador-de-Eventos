package usuarios;

import java.util.ArrayList;

public class UsuarioLimitado extends Usuarios{

    public String usuarioLimitado[] = new String[1000];
    public String contraseñaLimitado[] = new String[1000];
    public String nombreUsuario[] = new String[1000];
    public String edadUsuario[] = new String[1000];
    
    public int posicionUsuario[] = new int[1000];
    public int posicionArreglo;        

    
    public UsuarioLimitado(){
        
    }
    
    
    @Override
    public boolean permisoCrearEvento() {
        return false;
    }

    @Override
    public boolean verEvento() {
        return true;
    }

    @Override
    public boolean administrarUsuarios() {
        return false;
    }

}
