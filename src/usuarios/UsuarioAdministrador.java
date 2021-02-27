package usuarios;

import java.util.ArrayList;

public class UsuarioAdministrador extends Usuarios{

    public String usuarioAdmin[] = new String[1000];
    public String contraseña[] = new String[1000];
    public String nombreUsuario[] = new String[1000];
    public String edadUsuario[] = new String[1000];
    
    public int posicionUsuario[] = new int[1000];
    public int posicionArreglo;
    
    //ArrayList para ir guardando el id de los eventos creados.
    public ArrayList<String> idEvento = new ArrayList<>();
    public String idEventos[] = new String[1000];
    
    
    public UsuarioAdministrador(){
        
        //Usuario que por defecto es el admin.
        usuarioAdmin[0]="admin";
        contraseña[0] = "123";
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
        return true;
    }
    

    
    
}
