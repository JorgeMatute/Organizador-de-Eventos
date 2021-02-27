package usuarios;

import java.util.ArrayList;

public class UsuarioContenido extends Usuarios{

    
    public String usuarioContenido[] = new String[1000];
    public String contraseñaContenido[] = new String[1000];
    public String nombreUsuario[] = new String[1000];
    public String edadUsuario[] = new String[1000];
    
    public int posicionUsuario[] = new int[1000];
    public int posicionArreglo;
    
    
    //ArrayList para ir guardando el id de los eventos creados.
    public ArrayList<String> idEvento = new ArrayList<>();
    public String idEventos[] = new String[1000];

    
    public UsuarioContenido(){
        
    }
    
    
    @Override
    public boolean permisoCrearEvento() {
        return true;
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
