package ventanaTicket;

import eventos.Deportivo;
import eventos.Deportivo.TipoDeporte;
import static eventos.Deportivo.TipoDeporte.BASEBALL;
import static eventos.Deportivo.TipoDeporte.FUTBOL;
import static eventos.Deportivo.TipoDeporte.RUGBY;
import static eventos.Deportivo.TipoDeporte.TENIS;
import eventos.Eventos;
import eventos.Musical;
import eventos.Musical.TipoMusica;
import static eventos.Musical.TipoMusica.CLASICA;
import static eventos.Musical.TipoMusica.OTRO;
import static eventos.Musical.TipoMusica.POP;
import static eventos.Musical.TipoMusica.RAP;
import static eventos.Musical.TipoMusica.REGGAETON;
import static eventos.Musical.TipoMusica.ROCK;
import eventos.Religioso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import usuarios.UsuarioAdministrador;
import usuarios.UsuarioContenido;
import usuarios.UsuarioLimitado;
import usuarios.Usuarios;
import ventanasadministracioneventos.CrearEvento;
import ventanasadministracioneventos.EditarEvento;
import ventanasadministracioneventos.EliminarEvento;
import ventanasadministracioneventos.VerEvento;
import ventanasadministradorusuarios.Borrar;
import ventanasadministradorusuarios.Crear;
import ventanasadministradorusuarios.Editar;
import ventanasmenuprincipal.AdministrarEventos;
import ventanasmenuprincipal.AdministrarUsers;
import ventanasmenuprincipal.Reportes;
import ventanasreportes.IngresoGeneradoFecha;
import ventanasreportes.ListarEventosCancelados;
import ventanasreportes.ListarEventosFuturos;
import ventanasreportes.ListarEventosRealizados;
import ventanasreportes.VerPerfilUsuario;



//Utilizo el final para que no se puedan heredar funciones ni elementos porque ésta es la principal, después del main.
public final class VentanaPrincipal extends JFrame implements ActionListener {

    //Objetos/atributos.
    Login ventanaLogin = new Login();
    
    MenuPrincipal menuPrincipal = new MenuPrincipal();
    
    AdministrarEventos administrarEventos = new AdministrarEventos();
    CrearEvento crearEvento = new CrearEvento();
    EditarEvento editarEvento = new EditarEvento();
    EliminarEvento eliminarEvento = new EliminarEvento();
    VerEvento verEvento = new VerEvento();
    
    AdministrarUsers administrarUsers = new AdministrarUsers();
    Crear crearUser = new Crear();
    Borrar borrarUser = new Borrar();
    Editar editarUser = new Editar();
    
    Reportes reportes = new Reportes();
    ListarEventosRealizados listarEventosRealizados = new ListarEventosRealizados();
    ListarEventosFuturos listarEventosFuturos = new ListarEventosFuturos();
    ListarEventosCancelados listarEventosCancelados = new ListarEventosCancelados();
    IngresoGeneradoFecha ingresoGenerado = new IngresoGeneradoFecha();
    VerPerfilUsuario perfilUsuario = new VerPerfilUsuario();
    
    //Objetos para la creación de usuarios.
    UsuarioAdministrador claseUserAdmin = new UsuarioAdministrador();
    UsuarioContenido claseUserContenido = new UsuarioContenido();
    UsuarioLimitado claseUsuarioLimitado = new UsuarioLimitado();
    
    //Arreglos para almacenar los eventos.
    Eventos eventoDeportivo[] = new Deportivo[1000];
    Eventos eventoMusical[] = new Musical[1000];
    Eventos eventoReligioso[] = new Religioso[1000];
    
    boolean crearEventoPermiso;
    boolean editarEventoPermiso;
    boolean eliminarEventoPermiso;
    
    int indiceAdminLoggedIn;
    int indiceContenidoLoggedIn;
    int indiceLimitadoLoggedIn;
    boolean adminLogged;
    boolean contenidoLogged;
    boolean limitadoLogged;
    
    int indiceAdminEvento = 0;
    int indiceConteEvento = 0;
    
    //Constructor.
    public VentanaPrincipal(){
        
        setSize(800,700);
        setVisible(true);
        setTitle("JAVA TICKET");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        //Boton de login.
        ventanaLogin.botonLogin.addActionListener(this);
        
        //Botones del menú principal.
        menuPrincipal.botonAdministrarEventos.addActionListener(this);
        menuPrincipal.botonAdministrarUsers.addActionListener(this);
        menuPrincipal.botonReportes.addActionListener(this);
        menuPrincipal.botonCerrarSesion.addActionListener(this);
        menuPrincipal.botonSalir.addActionListener(this);
        
        //Botones de la ventana de administracin de eventos.
        administrarEventos.botonCrearEvento.addActionListener(this);
        administrarEventos.botonEliminarEvento.addActionListener(this);
        administrarEventos.botonEditarEvento.addActionListener(this);
        administrarEventos.botonVerEvento.addActionListener(this);
        administrarEventos.botonRegresarMenu.addActionListener(this);
        
        //Botones de la ventana de administra users.
        administrarUsers.botonCrear.addActionListener(this);
        administrarUsers.botonEditar.addActionListener(this);
        administrarUsers.botonBorrar.addActionListener(this);
        administrarUsers.botonRegresar.addActionListener(this);
        
        //Botones de la ventana de reportes.
        reportes.botonEventosRealizados.addActionListener(this);
        reportes.botonEventosFuturos.addActionListener(this);
        reportes.botonEventosCancelados.addActionListener(this);
        reportes.botonIngresosFecha.addActionListener(this);
        reportes.botonVerPerfil.addActionListener(this);
        reportes.botonRegresar.addActionListener(this);
        
        
        //Botones de las ventana CrearEvento/EditarEvento/EliminarEvento/VerEvento.
        crearEvento.botonRegresar.addActionListener(this);
        editarEvento.botonRegresar.addActionListener(this);
        eliminarEvento.botonRegresar.addActionListener(this);
        verEvento.botonRegresar.addActionListener(this);
        
        //Botones de las ventanas Crear/Editar/Borrar.
        crearUser.botonRegresar.addActionListener(this);
        editarUser.botonRegresar.addActionListener(this);
        borrarUser.botonRegresar.addActionListener(this);
        
        //Botones de las ventanas eventosRealizados/eventosFuturos/eventosCancelados/Ingresos/perfilUsuario.
        listarEventosRealizados.botonRegresar.addActionListener(this);
        listarEventosFuturos.botonRegresar.addActionListener(this);
        listarEventosCancelados.botonRegresar.addActionListener(this);
        ingresoGenerado.botonRegresar.addActionListener(this);
        perfilUsuario.botonRegresar.addActionListener(this);
        
        
        //Botón de crear usuario.
        crearUser.botonCrearUsuario.addActionListener(this);
        
        //Botón para borrar usuario.
        borrarUser.botonConfirmarBorrar.addActionListener(this);
        
        
        //Botón para editar user.
        editarUser.botonModificarUsuario.addActionListener(this);
        
        //Botón para crear eventos.
        crearEvento.botonCrear.addActionListener(this);
        crearEvento.seleccionCombo.addActionListener(this);
        
        //Botones para eliminar eventos.
        eliminarEvento.botonConfirmarBorrar.addActionListener(this);
         
        //Botones de editar evento.
        editarEvento.seleccionCombo.addActionListener(this);
        editarEvento.botonEditar.addActionListener(this);
        
        //Botones de ver eventos.
        verEvento.botonVerEvento.addActionListener(this);
        
        //Boton de los ingresos generados.
        ingresoGenerado.botonVerIngresos.addActionListener(this);
        
        add(ventanaLogin);

    }
    
    
    //Eventos para los botones.
    @Override
    public void actionPerformed(ActionEvent ae) {

      
        Object botonSeleccionado = ae.getSource();
        
        
        
        //Botón de login.
        if (botonSeleccionado == ventanaLogin.botonLogin) {
            
            String usuarioIngresado = ventanaLogin.campoUsuario.getText();
            String contraseñaIngresada = ventanaLogin.campoContraseña.getText();
            
            if (usuarioIngresado.equals("")==false || contraseñaIngresada.equals("")==false) {
                
                for (int x = 0; x < claseUserAdmin.usuarioAdmin.length; x++) {
                    
                    if (usuarioIngresado.equals(claseUserAdmin.usuarioAdmin[x]) && contraseñaIngresada.equals(claseUserAdmin.contraseña[x])) {
                        
                           add(menuPrincipal);
                           menuPrincipal.setVisible(true);
                           menuPrincipal.botonAdministrarUsers.setEnabled(false); //Todos están en false, pero entrarán al if si tienen el permiso, 
                           ventanaLogin.setVisible(false);                        //según lo que su función abstract diga...
                           
                           
                           crearEventoPermiso = true;
                           editarEventoPermiso = true;
                           eliminarEventoPermiso = true;
                           
                           indiceAdminLoggedIn = x;
                           adminLogged = true;
                           contenidoLogged = false;
                           limitadoLogged = false;
                           
                           if (claseUserAdmin.administrarUsuarios() == true) { 
                               menuPrincipal.botonAdministrarUsers.setEnabled(true);
                        }
                        
                    }else{
                        ventanaLogin.noExisteEquivocado.setVisible(true);
                    }
                }
            }
            
            
            
            if (usuarioIngresado.equals("")== false || contraseñaIngresada.equals("") == false) {
                
                for (int i = 0; i < claseUserContenido.usuarioContenido.length; i++) {
                    
                    if (usuarioIngresado.equals(claseUserContenido.usuarioContenido[i]) && contraseñaIngresada.equals(claseUserContenido.contraseñaContenido[i])) {
                      
                        add(menuPrincipal);
                        menuPrincipal.setVisible(true);
                        menuPrincipal.botonAdministrarUsers.setEnabled(false);
                        ventanaLogin.setVisible(false);
                        
                        crearEventoPermiso = true;
                        editarEventoPermiso = true;
                        eliminarEventoPermiso = true;
                        
                        indiceContenidoLoggedIn = i;
                        adminLogged = false;
                        contenidoLogged = true;
                        limitadoLogged = false;
                        
                        //Si es un tipo de usuario que puede administrar los usuarios, entrará a la instrucción del if, 
                        //dependiendo de la instrucción de su método abstracto.
                        if (claseUserContenido.administrarUsuarios() == true) { 
                            menuPrincipal.botonAdministrarUsers.setEnabled(true);
                        }
                        
                        
                    }else{
                        ventanaLogin.noExisteEquivocado.setVisible(true);
                    }
                }
                
            }
            
            
            if (usuarioIngresado.equals("")== false || contraseñaIngresada.equals("") == false) {
                
                for (int j = 0; j < claseUsuarioLimitado.usuarioLimitado.length; j++) {
                    
                    if (usuarioIngresado.equals(claseUsuarioLimitado.usuarioLimitado[j]) && contraseñaIngresada.equals(claseUsuarioLimitado.contraseñaLimitado[j])) {
                        
                        add(menuPrincipal);
                        menuPrincipal.setVisible(true);
                        menuPrincipal.botonAdministrarUsers.setEnabled(false);
                        ventanaLogin.setVisible(false);
                        
                        crearEventoPermiso = false;
                        editarEventoPermiso = false;
                        eliminarEventoPermiso = false;

                        indiceLimitadoLoggedIn = j;
                        adminLogged = false;
                        contenidoLogged = false;
                        limitadoLogged = true;
                        
                        if (claseUsuarioLimitado.administrarUsuarios() == true) { 
                            menuPrincipal.setEnabled(true);
                        }
                    }else{
                        ventanaLogin.noExisteEquivocado.setVisible(true);
                    }
                }
            }
            
             
        }
        
        
        
        
        
        
        
        //Botones de la ventana del menú principal.
        if (botonSeleccionado == menuPrincipal.botonAdministrarEventos) {
            
            //Aquí le damos permiso de que pueda entrar o no la opción de crear eventos.
            if (crearEventoPermiso == false) {
                administrarEventos.botonCrearEvento.setEnabled(false);
            }else{
                administrarEventos.botonCrearEvento.setEnabled(true);
            }
            
            if (editarEventoPermiso == false) {
                administrarEventos.botonEditarEvento.setEnabled(false);
            }else{
                administrarEventos.botonEditarEvento.setEnabled(true);
            }
            
            if (eliminarEventoPermiso == false) {
                administrarEventos.botonEliminarEvento.setEnabled(false);
            }else{
                administrarEventos.botonEliminarEvento.setEnabled(true);
            }
            
            
            
            add(administrarEventos); 
            administrarEventos.setVisible(true);
            menuPrincipal.setVisible(false);
            
        }
        
        if (botonSeleccionado == menuPrincipal.botonAdministrarUsers) {
            add(administrarUsers);
            administrarUsers.setVisible(true);
            menuPrincipal.setVisible(false);
        }
        
        
        if (botonSeleccionado == menuPrincipal.botonReportes) {
            add(reportes);
            reportes.setVisible(true);
            menuPrincipal.setVisible(false);
        }
        
        if (botonSeleccionado == menuPrincipal.botonCerrarSesion) { 
            add(ventanaLogin);
            ventanaLogin.setVisible(true);
            ventanaLogin.campoUsuario.setText(null);
            ventanaLogin.campoContraseña.setText(null);
            ventanaLogin.noExisteEquivocado.setVisible(false);
            menuPrincipal.setVisible(false);
            
        }
        
        if (botonSeleccionado == menuPrincipal.botonSalir) {
            System.exit(0);
        }
        
        
        
        
        
        //Botones de la ventana de administración de eventos.
        if (botonSeleccionado == administrarEventos.botonCrearEvento) {
            add(crearEvento);
            crearEvento.setVisible(true);
            crearEvento.eventoCreado.setVisible(false);
            crearEvento.eventoNoCreado.setVisible(false);
            crearEvento.espacioNombresEquipos.setVisible(true);
            crearEvento.comboDeporte.setVisible(true);
            crearEvento.comboMusica.setVisible(false);
            crearEvento.etiquetaNombresEquipos.setVisible(true);
            crearEvento.etiquetaDeporteEscogido.setVisible(true);
            crearEvento.etiquetaGeneroEscogido.setVisible(false);
            
            crearEvento.cantidadPersonasIncorrecta.setVisible(false);
            crearEvento.codigoRepetido.setVisible(false);
            crearEvento.fechaIncorrecta.setVisible(false);
            
            crearEvento.espacioAño.setText("0");
            crearEvento.espacioCodigo.setText(null);
            crearEvento.espacioDeporteEscogido.setText(null);
            crearEvento.espacioDescripcion.setText(null);
            crearEvento.espacioDia.setText("0");
            crearEvento.espacioGeneroEscogido.setText(null);
            crearEvento.espacioMaximoPersonas.setText("0");
            crearEvento.espacioMes.setText("0");
            crearEvento.espacioMonto.setText("0");
            crearEvento.espacioNombresEquipos.setText(null);
            crearEvento.espacioTitulo.setText(null);
            
            crearEvento.seleccionCombo.setSelectedIndex(0);
            crearEvento.botonCrear.setVisible(true);
                    
            administrarEventos.setVisible(false);
        }
        
        
        if (botonSeleccionado == crearEvento.botonCrear) {

            crearEvento.fechaIncorrecta.setVisible(false);
            crearEvento.codigoRepetido.setVisible(false);
            crearEvento.eventoNoCreado.setVisible(false);
            crearEvento.cantidadPersonasIncorrecta.setVisible(false);
            crearEvento.eventoCreado.setVisible(false);
            
            String deseadoCodigo = crearEvento.espacioCodigo.getText();
            String deseadoTitulo = crearEvento.espacioTitulo.getText();
            String deseadoDescripcion = crearEvento.espacioDescripcion.getText();
            
            
            String deseadoCantidadPersonas = crearEvento.espacioMaximoPersonas.getText();
            String deseadoMonto = crearEvento.espacioMonto.getText();
            
            
            //Asegurarnos que la fecha es correcta y posible.
            String deseadoDia = crearEvento.espacioDia.getText();
            String deseadoMes = crearEvento.espacioMes.getText();
            String deseadoAño = crearEvento.espacioAño.getText();
           
            //Convertimos los Strings a int para poder trabajarlos como números.
            int cantidadPersonas = Integer.parseInt(deseadoCantidadPersonas);
            int monto = Integer.parseInt(deseadoMonto);
            int dia = Integer.parseInt(deseadoDia);
            int mes = Integer.parseInt(deseadoMes);
            int año = Integer.parseInt(deseadoAño);
            boolean fechaCorrecta = false;
            
            Calendar fechaEvento = Calendar.getInstance(); 
            fechaEvento.set(año, mes-1, dia);
            
            if ((dia>0 && dia<32)&&(mes>=0 && mes<=11)) {
                fechaCorrecta = true;
            }
            
            Calendar fechaHoy = Calendar.getInstance();
            
            boolean futuro = false;
            boolean cancelado = false;
            
            /*
            Comparamos la fecha del día en que se ejecuta el programa con la del evento
            para así saber si el evento es futuro o no.
            */
            
            if (fechaHoy.getTimeInMillis() < fechaEvento.getTimeInMillis()) {
                futuro = true;
            }
            
            
            
            
            //Para casos de deporte.
            String deseadoNombresEquipos = crearEvento.espacioNombresEquipos.getText();
            String deseadoDeporte = null;
            
            if (crearEvento.comboDeporte.getSelectedIndex()==0) {
                deseadoDeporte = "FUTBOL";
            }
            if (crearEvento.comboDeporte.getSelectedIndex()==1) {
                deseadoDeporte = "BASEBALL";
            }
            if (crearEvento.comboDeporte.getSelectedIndex()==2) {
                deseadoDeporte = "TENIS";
            }
            if (crearEvento.comboDeporte.getSelectedIndex()==3) {
                deseadoDeporte = "RUGBY";
            }
            
  
            TipoDeporte variableEnumDeportes = null;
            
            if (deseadoDeporte.equals("FUTBOL")) {
                variableEnumDeportes = variableEnumDeportes.FUTBOL;
            }
            if (deseadoDeporte.equals("BASEBALL")) {
                variableEnumDeportes = variableEnumDeportes.BASEBALL;
            }
            if (deseadoDeporte.equals("RUGBY")) {
                variableEnumDeportes = variableEnumDeportes.RUGBY;
            }
            if (deseadoDeporte.equals("TENIS")) {
                variableEnumDeportes = variableEnumDeportes.TENIS;
            }
            
            

            //Para casos de música.
            String deseadoGenero = null;
            if (crearEvento.comboMusica.getSelectedIndex()==0) {
                deseadoGenero="POP";
            }
            if (crearEvento.comboMusica.getSelectedIndex()==1) {
                deseadoGenero="ROCK";
            }
            if (crearEvento.comboMusica.getSelectedIndex()==2) {
                deseadoGenero="CLASICA";
            }
            if (crearEvento.comboMusica.getSelectedIndex()==3) {
                deseadoGenero="RAP";
            }if (crearEvento.comboMusica.getSelectedIndex()==4) {
                deseadoGenero="REGGAETON";
            }
            if (crearEvento.comboMusica.getSelectedIndex()==5) {
                deseadoGenero="OTRO";
            }
            
            
            TipoMusica variableEnumMusica = null;
            
            if (deseadoGenero.equals("POP")) {
                variableEnumMusica = variableEnumMusica.POP;
            }
            
            if (deseadoGenero.equals("ROCK")) {
                variableEnumMusica = variableEnumMusica.ROCK;
            }
            
            if (deseadoGenero.equals("CLASICA")) {
                variableEnumMusica = variableEnumMusica.CLASICA;
            }
            
            if (deseadoGenero.equals("REGGAETON")) {
                variableEnumMusica = variableEnumMusica.REGGAETON;
            }
            
            if (deseadoGenero.equals("RAP")) {
                variableEnumMusica = variableEnumMusica.RAP;
            }
            
            if (deseadoGenero.equals("OTRO")) {
                variableEnumMusica = variableEnumMusica.OTRO;
            }
            

            
            boolean codigoUnico = true;
            
            Calendar fecha = Calendar.getInstance();
            fecha.set(0, 0, 0);
            
            boolean cantidadPersonasCorrecta = false;
            
            if(fechaCorrecta == true){
                
                if ((crearEvento.posicionEventoDeportivo<1000) && (crearEvento.seleccionCombo.getSelectedIndex()==0)) {

                    
                    //Verificamos si la cantidad de personas es posible.
                    if (cantidadPersonas <= 20000) {
                        cantidadPersonasCorrecta  = true;
                    }else{
                        crearEvento.cantidadPersonasIncorrecta.setVisible(true);
                    }
                    
                    //Objetos y variables sólo para inicializar en 0 el arreglo de eventos deportivos.
                    eventoDeportivo[0] = new Deportivo(FUTBOL, " ", ""," "," ", fecha, 0, 0, false, false);

                    //Ciclo para buscar en el arreglo el mismo código y ver si está o no repetido.
                    for (int i = 0; i < crearEvento.posicionEventoDeportivo+1; i++) {

                        if (deseadoCodigo.equals(eventoDeportivo[i].getCodigoUnico())) {
                            codigoUnico = false;
                        }

                    }

                    if (codigoUnico == true && cantidadPersonasCorrecta==true) {

                        //Aquí hacemos creamos el objeto y guardamos sus datos - Solamente si su código es único...
                        crearEvento.posicionEventoDeportivo++;

                        if (variableEnumDeportes == variableEnumDeportes.FUTBOL) {
                            eventoDeportivo[crearEvento.posicionEventoDeportivo] = new Deportivo(FUTBOL,deseadoNombresEquipos, deseadoCodigo, deseadoTitulo, deseadoDescripcion,
                            fechaEvento, monto, cantidadPersonas, futuro, cancelado);
                            
                            eventoDeportivo[crearEvento.posicionEventoDeportivo].montoRenta = monto;
                            eventoDeportivo[crearEvento.posicionEventoDeportivo].maximoGente = cantidadPersonas;
                        }

                        if (variableEnumDeportes == variableEnumDeportes.BASEBALL) {

                            eventoDeportivo[crearEvento.posicionEventoDeportivo] = new Deportivo(BASEBALL,deseadoNombresEquipos, deseadoCodigo, deseadoTitulo, deseadoDescripcion,
                            fechaEvento, monto, cantidadPersonas, futuro, cancelado);
                            eventoDeportivo[crearEvento.posicionEventoDeportivo].montoRenta = monto;
                            eventoDeportivo[crearEvento.posicionEventoDeportivo].maximoGente = cantidadPersonas;

                            }

                        if (variableEnumDeportes == variableEnumDeportes.TENIS) {

                            eventoDeportivo[crearEvento.posicionEventoDeportivo] = new Deportivo(TENIS,deseadoNombresEquipos, deseadoCodigo, deseadoTitulo, deseadoDescripcion,
                            fechaEvento, monto, cantidadPersonas, futuro, cancelado);
                            eventoDeportivo[crearEvento.posicionEventoDeportivo].montoRenta = monto;
                            eventoDeportivo[crearEvento.posicionEventoDeportivo].maximoGente = cantidadPersonas;
                            
                            }

                        if (variableEnumDeportes == variableEnumDeportes.RUGBY) {

                            eventoDeportivo[crearEvento.posicionEventoDeportivo] = new Deportivo(RUGBY,deseadoNombresEquipos, deseadoCodigo, deseadoTitulo, deseadoDescripcion,
                            fechaEvento, monto, cantidadPersonas, futuro, cancelado);
                            eventoDeportivo[crearEvento.posicionEventoDeportivo].montoRenta = monto;
                            eventoDeportivo[crearEvento.posicionEventoDeportivo].maximoGente = cantidadPersonas;
                            
                            }


                        crearEvento.eventoCreado.setVisible(true);
                        crearEvento.fechaIncorrecta.setVisible(false);
                        crearEvento.codigoRepetido.setVisible(false);
                        crearEvento.eventoNoCreado.setVisible(false);
                        crearEvento.cantidadPersonasIncorrecta.setVisible(false);
                        crearEvento.botonCrear.setVisible(false);
                        
                        //Agregamos los eventos creados al usuario logged.
                        if (indiceAdminLoggedIn > -1 && adminLogged == true) {
                            claseUserAdmin.idEventos[indiceAdminEvento] = "Código del evento: "+deseadoCodigo+" ------ Tipo: Deportivo ------ Título: "+deseadoTitulo+" ------ Monto: "+deseadoMonto+" Lps.";
                            indiceAdminEvento++;
                        }


                        if (indiceContenidoLoggedIn > -1 && contenidoLogged == true) {
                            claseUserContenido.idEventos[indiceConteEvento] = "Código del evento: "+deseadoCodigo+" ------ Tipo: Deportivo ------ Título: "+deseadoTitulo+" ------ Monto: "+deseadoMonto+" Lps.";
                            indiceConteEvento++;
                            
                         }
                        
                        

                    }else{
                        crearEvento.codigoRepetido.setVisible(true);
                    }



                }


                if ((crearEvento.posicionEventoMusical<1000) && (crearEvento.seleccionCombo.getSelectedIndex()==1)) {
                    
                    if (cantidadPersonas <= 25000) {
                        cantidadPersonasCorrecta = true;
                    }else{
                        crearEvento.cantidadPersonasIncorrecta.setVisible(true);
                    }
                    
                    //Objetos y variables sólo para inicializar en 0 el arreglo de eventos deportivos.
                    eventoMusical[0] = new Musical(CLASICA,"","","",fecha,0,0, false, false);
                    
                    for (int i = 0; i < crearEvento.posicionEventoMusical+1; i++) {

                        //¡FUNCIONA!
                        if (deseadoCodigo.equals(eventoMusical[i].getCodigoUnico())) {
                            codigoUnico = false;
                        }

                    }

                    //Aquí puedo ir poniendo restricciones de cantidad de monto, personas, etc...
                    if (codigoUnico == true && cantidadPersonasCorrecta == true) {

                        crearEvento.posicionEventoMusical++;

                        if (variableEnumMusica == variableEnumMusica.RAP) {
                            eventoMusical[crearEvento.posicionEventoMusical] = new Musical(RAP, deseadoCodigo, deseadoTitulo, deseadoDescripcion, fechaEvento,
                            monto, cantidadPersonas, futuro, cancelado);
                            eventoMusical[crearEvento.posicionEventoMusical].montoRenta = monto;
                            eventoMusical[crearEvento.posicionEventoMusical].maximoGente = cantidadPersonas;
                            
                        }

                        if (variableEnumMusica == variableEnumMusica.POP) {

                            eventoMusical[crearEvento.posicionEventoMusical] = new Musical(POP, deseadoCodigo, deseadoTitulo, deseadoDescripcion, fechaEvento,
                            monto, cantidadPersonas, futuro, cancelado);
                            eventoMusical[crearEvento.posicionEventoMusical].montoRenta = monto;
                            eventoMusical[crearEvento.posicionEventoMusical].maximoGente = cantidadPersonas;
                            
                       }

                        if (variableEnumMusica == variableEnumMusica.REGGAETON) {

                            eventoMusical[crearEvento.posicionEventoMusical] = new Musical(REGGAETON, deseadoCodigo, deseadoTitulo, deseadoDescripcion, fechaEvento,
                            monto, cantidadPersonas, futuro, cancelado);
                            eventoMusical[crearEvento.posicionEventoMusical].montoRenta = monto;
                            eventoMusical[crearEvento.posicionEventoMusical].maximoGente = cantidadPersonas;
                            
                        }

                        if (variableEnumMusica == variableEnumMusica.CLASICA) {

                            eventoMusical[crearEvento.posicionEventoMusical] = new Musical(CLASICA, deseadoCodigo, deseadoTitulo, deseadoDescripcion, fechaEvento,
                            monto, cantidadPersonas, futuro, cancelado);
                            eventoMusical[crearEvento.posicionEventoMusical].montoRenta = monto;
                            eventoMusical[crearEvento.posicionEventoMusical].maximoGente = cantidadPersonas;
                            
                        }

                        if (variableEnumMusica == variableEnumMusica.ROCK) {

                            eventoMusical[crearEvento.posicionEventoMusical] = new Musical(ROCK, deseadoCodigo, deseadoTitulo, deseadoDescripcion, fechaEvento,
                            monto, cantidadPersonas, futuro, cancelado);
                            eventoMusical[crearEvento.posicionEventoMusical].montoRenta = monto;
                            eventoMusical[crearEvento.posicionEventoMusical].maximoGente = cantidadPersonas;
                            
                        }

                        if (variableEnumMusica == variableEnumMusica.RAP) {

                            eventoMusical[crearEvento.posicionEventoMusical] = new Musical(RAP, deseadoCodigo, deseadoTitulo, deseadoDescripcion, fechaEvento,
                            monto, cantidadPersonas, futuro, cancelado);
                            eventoMusical[crearEvento.posicionEventoMusical].montoRenta = monto;
                            eventoMusical[crearEvento.posicionEventoMusical].maximoGente = cantidadPersonas;
                            
                        }

                        if (variableEnumMusica == variableEnumMusica.OTRO) {

                            eventoMusical[crearEvento.posicionEventoMusical] = new Musical(OTRO, deseadoCodigo, deseadoTitulo, deseadoDescripcion, fechaEvento,
                            monto, cantidadPersonas, futuro, cancelado);
                            eventoMusical[crearEvento.posicionEventoMusical].montoRenta = monto;
                            eventoMusical[crearEvento.posicionEventoMusical].maximoGente = cantidadPersonas;
                            
                        }

                        crearEvento.eventoCreado.setVisible(true);
                        crearEvento.fechaIncorrecta.setVisible(false);
                        crearEvento.codigoRepetido.setVisible(false);
                        crearEvento.eventoNoCreado.setVisible(false);
                        crearEvento.cantidadPersonasIncorrecta.setVisible(false);
                        crearEvento.botonCrear.setVisible(false);
                        
                        
                        //Guardamos en el arreglo del usuario el evento creado.
                        if (indiceAdminLoggedIn > -1 && adminLogged == true) {
                            claseUserAdmin.idEventos[indiceAdminEvento] = "Código del evento: "+deseadoCodigo+" ------ Tipo: Musical ------ Título: "+deseadoTitulo+" ------ Monto: "+deseadoMonto+" Lps.";
                            indiceAdminEvento++;
                        }


                        if (indiceContenidoLoggedIn > -1 && contenidoLogged == true) {
                            claseUserContenido.idEventos[indiceConteEvento] = "Código del evento: "+deseadoCodigo+" ------ Tipo: Musical ------ Título: "+deseadoTitulo+" ------ Monto: "+deseadoMonto+" Lps.";
                            indiceConteEvento++;
                            
                        }
                        
                        
                    }else{
                        crearEvento.codigoRepetido.setVisible(true);
                    }


                }



                if ((crearEvento.posicionEventoReligioso<1000) && (crearEvento.seleccionCombo.getSelectedIndex()==2)) {

                    if (cantidadPersonas <= 30000) {
                        cantidadPersonasCorrecta = true;
                    }else{
                        crearEvento.cantidadPersonasIncorrecta.setVisible(true);
                    }
                    
                     //Objetos y variables sólo para inicializar en 0 el arreglo de eventos deportivos.
                    eventoReligioso[0] = new Religioso("","","",fecha,0,0, false, false );


                    for (int i = 0; i < crearEvento.posicionEventoReligioso+1; i++) {


                        if (deseadoCodigo.equals(eventoReligioso[i].getCodigoUnico())) {
                            codigoUnico = false;
                        }


                    }

                    if (codigoUnico == true && cantidadPersonasCorrecta == true) {

                        crearEvento.posicionEventoReligioso++;
                        eventoReligioso[crearEvento.posicionEventoReligioso] = new Religioso(deseadoCodigo, deseadoTitulo, deseadoDescripcion, fechaEvento, monto, cantidadPersonas, futuro, cancelado);
                        eventoReligioso[crearEvento.posicionEventoReligioso].montoRenta=monto;
                        eventoReligioso[crearEvento.posicionEventoReligioso].maximoGente = cantidadPersonas;
                        
                        crearEvento.eventoCreado.setVisible(true);
                        crearEvento.fechaIncorrecta.setVisible(false);
                        crearEvento.codigoRepetido.setVisible(false);
                        crearEvento.eventoNoCreado.setVisible(false);
                        crearEvento.cantidadPersonasIncorrecta.setVisible(false);
                        crearEvento.botonCrear.setVisible(false);
                        
                        
                        //Guardamos en el arreglo del usuario el evento creado.
                        if (indiceAdminLoggedIn > -1 && adminLogged == true) {
                            claseUserAdmin.idEventos[indiceAdminEvento] = "Código del evento: "+deseadoCodigo+" ------ Tipo: Religioso ------ Título: "+deseadoTitulo+" ------ Monto: "+deseadoMonto+" Lps.";
                            indiceAdminEvento++;
                        }


                        if (indiceContenidoLoggedIn > -1 && contenidoLogged == true) {
                            claseUserContenido.idEventos[indiceConteEvento] = "Código del evento: "+deseadoCodigo+" ------ Tipo: Religioso ------ Título: "+deseadoTitulo+" ------ Monto: "+deseadoMonto+" Lps.";
                            indiceConteEvento++;
                        }
                        
                        
                        
                    }else{
                        crearEvento.codigoRepetido.setVisible(true);
                    }



                 }
            

            
            }else{
                crearEvento.fechaIncorrecta.setVisible(true);
            }
            
            
            
        }
        
        
        
        
        //Eventos del JComboBox en la parte de creación de eventos.
        if (botonSeleccionado == crearEvento.seleccionCombo) {
            
            if (crearEvento.seleccionCombo.getSelectedIndex()==0) {
                
                crearEvento.etiquetaNombresEquipos.setVisible(true);
                crearEvento.etiquetaDeporteEscogido.setVisible(true);
                crearEvento.espacioNombresEquipos.setVisible(true);
                crearEvento.comboDeporte.setVisible(true);
                
                crearEvento.etiquetaGeneroEscogido.setVisible(false);
                crearEvento.comboMusica.setVisible(false);
            }
            
            
            if (crearEvento.seleccionCombo.getSelectedIndex()==1) {
                
                crearEvento.etiquetaNombresEquipos.setVisible(false);
                crearEvento.etiquetaDeporteEscogido.setVisible(false);
                crearEvento.espacioNombresEquipos.setVisible(false);
                crearEvento.comboDeporte.setVisible(false);
                
                crearEvento.etiquetaGeneroEscogido.setVisible(true);
                crearEvento.comboMusica.setVisible(true);
            }
            
            if (crearEvento.seleccionCombo.getSelectedIndex()==2) {
                
                crearEvento.etiquetaNombresEquipos.setVisible(false);
                crearEvento.etiquetaDeporteEscogido.setVisible(false);
                crearEvento.espacioNombresEquipos.setVisible(false);
                crearEvento.comboDeporte.setVisible(false);
                
                crearEvento.etiquetaGeneroEscogido.setVisible(false);
                crearEvento.comboMusica.setVisible(false);
            }
        }
        
        
        
        
          //Su botón para regresar.
        if (botonSeleccionado == crearEvento.botonRegresar) {
            add(administrarEventos);
            administrarEventos.setVisible(true);
            crearEvento.setVisible(false);
        }
  
        
 
        
        
        
        
        if (botonSeleccionado == administrarEventos.botonEliminarEvento) {
            add(eliminarEvento);
            eliminarEvento.setVisible(true);
            eliminarEvento.eventoNoEncontrado.setVisible(false);
            eliminarEvento.borradoExitoso.setVisible(false);
            eliminarEvento.espacioCodigo.setText(null);
            
            administrarEventos.setVisible(false);
        }
        
        
        
        
        if (botonSeleccionado == eliminarEvento.botonConfirmarBorrar) {
            
            String codigoEventoABorrar = eliminarEvento.espacioCodigo.getText();
            Calendar fechaHoy = Calendar.getInstance();
            
            
             boolean eventoEncontrado = false;
             
            
            //Con el for buscamos en cada tipo de evento el código paral uego mostrar sus datos.
            for (int i = 0; i < crearEvento.posicionEventoDeportivo+1; i++) {

            
                    if(crearEvento.posicionEventoDeportivo > 0){

                        if (codigoEventoABorrar.equals(eventoDeportivo[i].getCodigoUnico())) {

                            if (fechaHoy.getTime().getDay()-1 == eventoDeportivo[i].fechaEvento.getTime().getDay()
                                    && fechaHoy.getTime().getMonth() == eventoDeportivo[i].fechaEvento.getTime().getMonth()
                                    && fechaHoy.getTime().getYear() == eventoDeportivo[i].fechaEvento.getTime().getYear()) {
                                
                                //Si es un día antes, se le cobra el 50% de indemnización.
                                eventoDeportivo[i].montoRenta = eventoDeportivo[i].montoRenta * 0.50;
                            }
                            
                            eventoDeportivo[i].cancelado = true;
                            eventoEncontrado = true;
                        }

                    }
            }        
            
            
            for (int i = 0; i < crearEvento.posicionEventoMusical+1; i++) {
                    if(crearEvento.posicionEventoMusical > 0){
                        
                        if (codigoEventoABorrar.equals(eventoMusical[i].getCodigoUnico())) {

                            if (fechaHoy.getTime().getDay()-1 == eventoMusical[i].fechaEvento.getTime().getDay()
                                    && fechaHoy.getTime().getMonth() == eventoMusical[i].fechaEvento.getTime().getMonth()
                                    && fechaHoy.getTime().getYear() == eventoMusical[i].fechaEvento.getTime().getYear()) {
                                
                                //Si es un día antes, se le cobra el 50% de indemnización.
                                eventoMusical[i].montoRenta = eventoMusical[i].montoRenta * 0.50;
                            }
                            
                            eventoMusical[i].cancelado = true;
                            eventoEncontrado = true;

                        }
                    }
                    
            }
                    

            for (int i = 0; i < crearEvento.posicionEventoReligioso+1; i++) {
                    if(crearEvento.posicionEventoReligioso > 0){
                        
                        if (codigoEventoABorrar.equals(eventoReligioso[i].getCodigoUnico())) {

                            //Se establece que el costo de cancelación es igual a 0 por ser un evento religioso.
                            eventoReligioso[i].montoRenta = 0;
                            eventoReligioso[i].cancelado = true;
                            eventoEncontrado = true;


                        }
                    }

            }
                
                
            if (eventoEncontrado == false) {
                //Si el evento no se encuentra --> aviso de no encontrado.
                eliminarEvento.eventoNoEncontrado.setVisible(true);
                eliminarEvento.borradoExitoso.setVisible(false);
            }else{
                eliminarEvento.borradoExitoso.setVisible(true);
                eliminarEvento.eventoNoEncontrado.setVisible(false);
            }
            
              
                
           
            

             
        }
        
        
        
        
        
        
          //Su botón para regresar.
        if (botonSeleccionado == eliminarEvento.botonRegresar) {
            add(administrarEventos);
            administrarEventos.setVisible(true);
            eliminarEvento.setVisible(false);
        }
        
        
        
        
        

        
        
        
   
        if (botonSeleccionado == administrarEventos.botonEditarEvento) {
            add(editarEvento);
            editarEvento.setVisible(true);
            editarEvento.botonEditar.setVisible(true);
            editarEvento.botonRegresar.setVisible(true);
            
            editarEvento.cantidadPersonasIncorrecta.setVisible(false);
            editarEvento.codigoIncorrecto.setVisible(false);
            
            editarEvento.seleccionCombo.setVisible(true);
            editarEvento.comboDeporte.setVisible(true);
            editarEvento.comboMusica.setVisible(false);
            
            editarEvento.etiquetaDeporteEscogido.setVisible(true);
            editarEvento.etiquetaNombresEquipos.setVisible(true);
            
            editarEvento.indicarJugadoresEquipo1.setVisible(true);
            editarEvento.indicarJugadoresEquipo2.setVisible(true);
            editarEvento.espacioJugadoresEquipo1.setVisible(true);
            editarEvento.espacioJugadoresEquipo2.setVisible(true);
            
            editarEvento.espacioGeneroEscogido.setVisible(false);
            editarEvento.etiquetaGeneroEscogido.setVisible(false);
            
            editarEvento.indicarMusicos.setVisible(false);
            editarEvento.espacioMusicos.setVisible(false);
            
            editarEvento.indicarPersonasConvertidas.setVisible(false);
            editarEvento.espacioPersonasConvertidas.setVisible(false);
            
            editarEvento.seleccionCombo.setSelectedIndex(0);
            
            editarEvento.fechaIncorrecta.setVisible(false);
            editarEvento.cantidadPersonasIncorrecta.setVisible(false);
            editarEvento.codigoIncorrecto.setVisible(false); 
            editarEvento.eventoEditado.setVisible(false);
            
            editarEvento.etiquetaSiNo.setVisible(true);
            editarEvento.comboSiNo.setVisible(true);
            
            editarEvento.espacioDia.setText("0");
            editarEvento.espacioMes.setText("0");
            editarEvento.espacioAño.setText("0");
            editarEvento.espacioMaximoPersonas.setText("0");
            editarEvento.espacioMonto.setText("0");
            editarEvento.espacioPersonasConvertidas.setText("0");
            
            editarEvento.espacioCodigo.setText(null);
            editarEvento.espacioCodigoVerificar.setText(null);
            editarEvento.espacioDescripcion.setText(null);
            editarEvento.espacioGeneroEscogido.setText(null);
            editarEvento.espacioJugadoresEquipo1.setText(null);
            editarEvento.espacioJugadoresEquipo2.setText(null);
            editarEvento.espacioDeporteEscogido.setText(null);
            editarEvento.espacioTitulo.setText(null);
            editarEvento.espacioNombresEquipos.setText(null);
            editarEvento.espacioPersonasConvertidas.setText(null);
            editarEvento.espacioMusicos.setText(null);
            
            editarEvento.comboSiNo.setSelectedIndex(1);
            
            administrarEventos.setVisible(false);
        }
        
        
        if (botonSeleccionado == editarEvento.botonEditar) {
            
            boolean futuro = false;
            boolean cancelado = false;
            int indiceGuardar = 0;
            boolean eventoEncontrado = false;
            
            if (editarEvento.comboSiNo.getSelectedIndex() == 0) {
                cancelado = true;
            }else{
                cancelado = false;
            }
            
            
            String nuevoCantidadPersonasString = editarEvento.espacioMaximoPersonas.getText();
            String nuevoMontoString = editarEvento.espacioMonto.getText();
            String codigoBuscarEditar = editarEvento.espacioCodigoVerificar.getText();
            
            String nuevoCodigo = editarEvento.espacioCodigo.getText();
            String nuevoTitulo = editarEvento.espacioTitulo.getText();
            int nuevoCantidadPersonas = Integer.parseInt(nuevoCantidadPersonasString);
            int nuevoMonto = Integer.parseInt(nuevoMontoString);
            String nuevaDescripcion = editarEvento.espacioDescripcion.getText();
            
            String nuevoDeporte = null;
            if (editarEvento.seleccionCombo.getSelectedIndex()==0) {
                nuevoDeporte="FUTBOL";
            }
            if (editarEvento.seleccionCombo.getSelectedIndex()==1) {
                nuevoDeporte="BASEBALL";
            }
            if (editarEvento.seleccionCombo.getSelectedIndex()==2) {
                nuevoDeporte="TENIS";
            }
            if (editarEvento.seleccionCombo.getSelectedIndex()==3) {
                nuevoDeporte="RUGBY";
            }
            
            String nuevoNombresEquipos = editarEvento.espacioNombresEquipos.getText();
            
            //Asegurarnos que la fecha es correcta y posible.
            String deseadoDia = editarEvento.espacioDia.getText();
            String deseadoMes = editarEvento.espacioMes.getText();
            String deseadoAño = editarEvento.espacioAño.getText();
           
            //Convertimos los Strings a int para poder trabajarlos como números.
            int dia = Integer.parseInt(deseadoDia);
            int mes = Integer.parseInt(deseadoMes);
            int año = Integer.parseInt(deseadoAño);
            boolean fechaCorrecta = false;
            
            Calendar nuevaFechaEvento = Calendar.getInstance(); //Con el getInstance creo que le puedo dar otro formato... Buscar.
            nuevaFechaEvento.set(año, mes-1, dia);
            
            if ((dia>0 && dia<32)&&(mes>=0 && mes<=11)) {
                fechaCorrecta = true;
            }
            
            //Verificamos si la fecha es en el futuro o no.
            Calendar fechaHoy = Calendar.getInstance();
            if (fechaHoy.getTimeInMillis() < nuevaFechaEvento.getTimeInMillis()) {
                futuro = true;
            }
            
             
            
            String nuevoNombresJugadoresEquipo1 = editarEvento.espacioJugadoresEquipo1.getText();
            String nuevoNombresJugadoresEquipo2 = editarEvento.espacioJugadoresEquipo2.getText(); 
            
            
            //Ahora todo lo relacionado a eventos musicales:
            //Para casos de música.
            String nuevoGenero = null;
            if (editarEvento.comboMusica.getSelectedIndex()==0) {
                nuevoGenero="POP";
            }
            if (editarEvento.comboMusica.getSelectedIndex()==1) {
                nuevoGenero="ROCK";
            }
            if (editarEvento.comboMusica.getSelectedIndex()==2) {
                nuevoGenero="CLASICA";
            }
            if (editarEvento.comboMusica.getSelectedIndex()==3) {
                nuevoGenero="RAP";
            }if (editarEvento.comboMusica.getSelectedIndex()==4) {
                nuevoGenero="REGGAETON";
            }
            if (editarEvento.comboMusica.getSelectedIndex()==5) {
                nuevoGenero="OTRO";
            }
            
            String nuevoNombresParticipantes = editarEvento.espacioMusicos.getText();
            
            
            //Todo lo que es nada más para el evento religioso.
            String nuevoPersonasConvertidas = editarEvento.espacioPersonasConvertidas.getText();
            
            
            
            
            boolean cantidadPersonasCorrectas = false;
            
            if(fechaCorrecta == true){    

                //Primero buscamos entre todos los eventos deportivos el código.
                if (editarEvento.seleccionCombo.getSelectedIndex()==0) {

                    //Verificamos si la cantidad de personas es posible.
                    if (nuevoCantidadPersonas <= 20000) {
                        cantidadPersonasCorrectas  = true;
                    }else{
                        editarEvento.cantidadPersonasIncorrecta.setVisible(true);
                    }
                    
                    
                    for (int i = 0; i < crearEvento.posicionEventoDeportivo+1; i++) {

                        if (codigoBuscarEditar.equals(eventoDeportivo[i].getCodigoUnico()) && cantidadPersonasCorrectas == true) {

                            eventoDeportivo[i].codigoUnico = nuevoCodigo;
                            eventoDeportivo[i].tituloEvento = nuevoTitulo;
                            eventoDeportivo[i].maximoGente = nuevoCantidadPersonas;
                            eventoDeportivo[i].montoRenta = nuevoMonto;
                            eventoDeportivo[i].descripcionEvento = nuevaDescripcion;

                            eventoDeportivo[i].fechaEvento = nuevaFechaEvento;
                            eventoDeportivo[i].futuro = futuro;
                            eventoDeportivo[i].cancelado = cancelado;

                            editarEvento.codigoIncorrecto.setVisible(false);
                            editarEvento.fechaIncorrecta.setVisible(false);
                            editarEvento.cantidadPersonasIncorrecta.setVisible(false);
                            editarEvento.eventoEditado.setVisible(true);
                            editarEvento.botonEditar.setVisible(false);
                            
                            editarEvento.comboSiNo.setVisible(false);
                            editarEvento.etiquetaSiNo.setVisible(false);
                            
                        }else{
                            editarEvento.codigoIncorrecto.setVisible(true);
                        }

                    }

                    
                }
                
                if (editarEvento.seleccionCombo.getSelectedIndex()==1){
                    
                     //Verificamos si la cantidad de personas es posible.
                    if (nuevoCantidadPersonas <= 25000) {
                        cantidadPersonasCorrectas  = true;
                    }else{
                        editarEvento.cantidadPersonasIncorrecta.setVisible(true);
                    }
                    
                    
                    for (int i = 0; i < crearEvento.posicionEventoMusical+1; i++){
                        
                        if (codigoBuscarEditar.equals(eventoMusical[i].getCodigoUnico()) && cantidadPersonasCorrectas == true){
                            
                            eventoMusical[i].codigoUnico = nuevoCodigo;
                            eventoMusical[i].tituloEvento = nuevoTitulo;
                            eventoMusical[i].maximoGente = nuevoCantidadPersonas;
                            eventoMusical[i].montoRenta = nuevoMonto;
                            eventoMusical[i].descripcionEvento = nuevaDescripcion;

                            eventoMusical[i].fechaEvento = nuevaFechaEvento;
                            eventoMusical[i].futuro = futuro;
                            eventoMusical[i].cancelado = cancelado;

                            editarEvento.codigoIncorrecto.setVisible(false);
                            editarEvento.fechaIncorrecta.setVisible(false);
                            editarEvento.cantidadPersonasIncorrecta.setVisible(false);
                            editarEvento.eventoEditado.setVisible(true);
                            editarEvento.botonEditar.setVisible(false);
                            
                            editarEvento.comboSiNo.setVisible(false);
                            editarEvento.etiquetaSiNo.setVisible(false);
                            
                        }else{
                            editarEvento.codigoIncorrecto.setVisible(true);
                        }
                    }
                    
                }
                
                
                if (editarEvento.seleccionCombo.getSelectedIndex()==2){
                   
                    //Verificamos si la cantidad de personas es posible.
                    if (nuevoCantidadPersonas <= 30000) {
                        cantidadPersonasCorrectas  = true;
                    }else{
                        editarEvento.cantidadPersonasIncorrecta.setVisible(true);
                    }
                    
                    
                    for (int i = 0; i < crearEvento.posicionEventoReligioso+1; i++){
                        
                        if (codigoBuscarEditar.equals(eventoReligioso[i].getCodigoUnico()) && cantidadPersonasCorrectas == true){
                            
                            eventoReligioso[i].codigoUnico = nuevoCodigo;
                            eventoReligioso[i].tituloEvento = nuevoTitulo;
                            eventoReligioso[i].maximoGente = nuevoCantidadPersonas;
                            eventoReligioso[i].montoRenta = nuevoMonto;
                            eventoReligioso[i].descripcionEvento = nuevaDescripcion;

                            eventoReligioso[i].fechaEvento = nuevaFechaEvento;
                            eventoReligioso[i].futuro = futuro;
                            eventoReligioso[i].cancelado = cancelado;

                            editarEvento.codigoIncorrecto.setVisible(false);
                            editarEvento.fechaIncorrecta.setVisible(false);
                            editarEvento.cantidadPersonasIncorrecta.setVisible(false);
                            editarEvento.eventoEditado.setVisible(true);
                            editarEvento.botonEditar.setVisible(false);
                            
                            editarEvento.comboSiNo.setVisible(false);
                            editarEvento.etiquetaSiNo.setVisible(false);
                            
                            
                        }else{
                            editarEvento.codigoIncorrecto.setVisible(true);
                        }
                    }
                }
                    
                
                
                
                
                

            }else{
                editarEvento.fechaIncorrecta.setVisible(true);
            }
            
            
        
        }
        
        
                
        if (botonSeleccionado == editarEvento.seleccionCombo) {
            
            //Si se selecciona evento deportivo.
            if (editarEvento.seleccionCombo.getSelectedIndex()==0) {
                
                editarEvento.etiquetaDeporteEscogido.setVisible(true);
                editarEvento.etiquetaNombresEquipos.setVisible(true);
                editarEvento.indicarJugadoresEquipo1.setVisible(true);
                editarEvento.indicarJugadoresEquipo2.setVisible(true);
                editarEvento.espacioJugadoresEquipo1.setVisible(true);
                editarEvento.espacioJugadoresEquipo2.setVisible(true);
                editarEvento.comboDeporte.setVisible(true);
                editarEvento.espacioNombresEquipos.setVisible(true);



                editarEvento.indicarMusicos.setVisible(false);
                editarEvento.espacioMusicos.setVisible(false);
                editarEvento.comboMusica.setVisible(false);
                editarEvento.espacioGeneroEscogido.setVisible(false);
                editarEvento.etiquetaGeneroEscogido.setVisible(false);
                
                editarEvento.indicarPersonasConvertidas.setVisible(false);
                editarEvento.espacioPersonasConvertidas.setVisible(false);
                
            }
            
            //Si se escoge la opción de evento musical.
            if (editarEvento.seleccionCombo.getSelectedIndex()==1) {
                
                editarEvento.etiquetaDeporteEscogido.setVisible(false);
                editarEvento.etiquetaNombresEquipos.setVisible(false);
                editarEvento.indicarJugadoresEquipo1.setVisible(false);
                editarEvento.indicarJugadoresEquipo2.setVisible(false);
                editarEvento.espacioJugadoresEquipo1.setVisible(false);
                editarEvento.espacioJugadoresEquipo2.setVisible(false);
                editarEvento.comboDeporte.setVisible(false);
                editarEvento.espacioNombresEquipos.setVisible(false);
                

                editarEvento.indicarMusicos.setVisible(true);
                editarEvento.espacioMusicos.setVisible(true);
                editarEvento.comboMusica.setVisible(true);
                editarEvento.espacioGeneroEscogido.setVisible(true);
                editarEvento.etiquetaGeneroEscogido.setVisible(true);
                
                editarEvento.indicarPersonasConvertidas.setVisible(false);
                editarEvento.espacioPersonasConvertidas.setVisible(false);
                
            }
            
            //Si se escoge un evento religioso.
            if (editarEvento.seleccionCombo.getSelectedIndex()==2) {
                
                editarEvento.etiquetaDeporteEscogido.setVisible(false);
                editarEvento.etiquetaNombresEquipos.setVisible(false);
                editarEvento.indicarJugadoresEquipo1.setVisible(false);
                editarEvento.indicarJugadoresEquipo2.setVisible(false);
                editarEvento.espacioJugadoresEquipo1.setVisible(false);
                editarEvento.espacioJugadoresEquipo2.setVisible(false);
                editarEvento.comboDeporte.setVisible(false);
                editarEvento.espacioNombresEquipos.setVisible(false);



                editarEvento.indicarMusicos.setVisible(false);
                editarEvento.espacioMusicos.setVisible(false);
                editarEvento.comboMusica.setVisible(false);
                editarEvento.espacioGeneroEscogido.setVisible(false);
                editarEvento.etiquetaGeneroEscogido.setVisible(false);
                
                editarEvento.indicarPersonasConvertidas.setVisible(true);
                editarEvento.espacioPersonasConvertidas.setVisible(true);
            }
            
            
        }
        
        
        
        
        
          //Su botón para regresar.
        if (botonSeleccionado == editarEvento.botonRegresar) {
            add(administrarEventos);
            administrarEventos.setVisible(true);
            editarEvento.setVisible(false);
        }
        
        
        
        
        
        
        
  
        

        
        if (botonSeleccionado == administrarEventos.botonVerEvento) {
            add(verEvento);
            verEvento.setVisible(true);
            verEvento.datosEvento.setVisible(false);
            verEvento.datosEvento2.setVisible(false);
            verEvento.datosEvento3.setVisible(false);
            verEvento.datosEvento4.setVisible(false);
            verEvento.eventoNoEncontrado.setVisible(false);
            verEvento.espacioCodigo.setText(null);
            
            administrarEventos.setVisible(false);
        }
        
        
        
        if (botonSeleccionado == verEvento.botonVerEvento) {
            
            String codigoVerEvento = verEvento.espacioCodigo.getText();
            boolean eventoEncontrado = false;
            
            //Con el for buscamos en cada tipo de evento el código paral uego mostrar sus datos.
            for (int i = 0; i < crearEvento.posicionEventoDeportivo+1; i++) {

            
                    if(crearEvento.posicionEventoDeportivo > 0 && eventoDeportivo[i].cancelado == false){

                        if (codigoVerEvento.equals(eventoDeportivo[i].getCodigoUnico())) {

                            verEvento.datosEvento.setText(eventoDeportivo[i].toString());                    
                            verEvento.datosEvento2.setText(eventoDeportivo[i].toString2());
                            verEvento.datosEvento3.setText(eventoDeportivo[i].toString3());
                            verEvento.datosEvento4.setText(eventoDeportivo[i].toString4());

                            verEvento.datosEvento.setVisible(true);
                            verEvento.datosEvento2.setVisible(true);
                            verEvento.datosEvento3.setVisible(true);
                            verEvento.datosEvento4.setVisible(true);

                            verEvento.eventoNoEncontrado.setVisible(false);
                            eventoEncontrado = true;
                        }

                    }
            }        
            
            
            for (int i = 0; i < crearEvento.posicionEventoMusical+1; i++) {
                    if(crearEvento.posicionEventoMusical > 0){
                        
                        if (codigoVerEvento.equals(eventoMusical[i].getCodigoUnico()) && eventoMusical[i].cancelado == false) {

                            verEvento.datosEvento.setText(eventoMusical[i].toString());                    
                            verEvento.datosEvento2.setText(eventoMusical[i].toString2());
                            verEvento.datosEvento3.setText(eventoMusical[i].toString3());
                            verEvento.datosEvento4.setText(eventoMusical[i].toString4());

                            verEvento.datosEvento.setVisible(true);
                            verEvento.datosEvento2.setVisible(true);
                            verEvento.datosEvento3.setVisible(true);
                            verEvento.datosEvento4.setVisible(true);

                            verEvento.eventoNoEncontrado.setVisible(false);
                            eventoEncontrado = true;

                        }
                    }
                    
            }
                    

            for (int i = 0; i < crearEvento.posicionEventoReligioso+1; i++) {
                    if(crearEvento.posicionEventoReligioso > 0){
                        
                        if (codigoVerEvento.equals(eventoReligioso[i].getCodigoUnico()) && eventoReligioso[i].cancelado == false) {

                            verEvento.datosEvento.setText(eventoReligioso[i].toString());                    
                            verEvento.datosEvento2.setText(eventoReligioso[i].toString2());
                            verEvento.datosEvento3.setText(eventoReligioso[i].toString3());
                            verEvento.datosEvento4.setText(eventoReligioso[i].toString4());

                            verEvento.datosEvento.setVisible(true);
                            verEvento.datosEvento2.setVisible(true);
                            verEvento.datosEvento3.setVisible(true);
                            verEvento.datosEvento4.setVisible(true);

                            verEvento.eventoNoEncontrado.setVisible(false);
                            eventoEncontrado = true;


                        }
                    }

            }
                
                
            if (eventoEncontrado == false) {
                verEvento.eventoNoEncontrado.setVisible(true);
            }
            
            
        }
        
        
        
        
          //Su botón para regresar.
        if (botonSeleccionado == verEvento.botonRegresar) {
            add(administrarEventos);
            administrarEventos.setVisible(true);
            verEvento.setVisible(false);
        }
      
        
        
        if (botonSeleccionado == administrarEventos.botonRegresarMenu) {
            add(menuPrincipal);
            menuPrincipal.setVisible(true);
            administrarEventos.setVisible(false);
        }
       
        
        
        
        
        
        
  
        
        
        
        
        //Botones de la ventana de administrar usuarios.
        if (botonSeleccionado == administrarUsers.botonCrear) {
            
            add(crearUser);
            crearUser.setVisible(true);
            crearUser.espacioUsuario.setText(null);
            crearUser.espacioContraseña.setText(null);
            crearUser.nombreUsuarioEspacio.setText(null);
            crearUser.edadUsuarioEspacio.setText(null);
            crearUser.userRepetido.setVisible(false);
            administrarUsers.setVisible(false);
            
        } 
        
        
        

        
        if (botonSeleccionado == crearUser.botonCrearUsuario) {
            
                   
            //PRIMERO PARA CREAR ADMIN USERS.
            String usuarioNuevoAdmin = crearUser.espacioUsuario.getText();
            String contraseñaNuevaAdmin = crearUser.espacioContraseña.getText();
            String edadAdmin = crearUser.edadUsuarioEspacio.getText();
            String nombreAdmin = crearUser.nombreUsuarioEspacio.getText();
            
            boolean usuarioAdminUnico = true;
           
            
            if (crearUser.posicionUsuarioAdmin < 1000) {
                
                if (contraseñaNuevaAdmin.equals("") == false) {
                    
                    if (usuarioNuevoAdmin.equals("")== false) {
                        
                        
                        for (int x = 0; x < 1000; x++) {
                            
                            if (usuarioNuevoAdmin.equals(claseUserAdmin.usuarioAdmin[x])) {
                                usuarioAdminUnico = false;
                            }
                        }
                        
                        if (usuarioAdminUnico == true && crearUser.opcionUsuario.getSelectedIndex() == 2  ) { //Así sólamente si escogió el adecuado.
                            
                            for (int posicion = 0; posicion < claseUserAdmin.usuarioAdmin.length; posicion++) {
                             
                                if (claseUserAdmin.usuarioAdmin[posicion]==null) {
                                    
                                    claseUserAdmin.usuarioAdmin[posicion] = usuarioNuevoAdmin;
                                    claseUserAdmin.contraseña[posicion] = contraseñaNuevaAdmin;
                                    claseUserAdmin.nombreUsuario[posicion] = nombreAdmin;
                                    claseUserAdmin.edadUsuario[posicion] = edadAdmin;
                                    
                                    claseUserAdmin.posicionArreglo = posicion;
                                    crearUser.posicionUsuarioAdmin++;
                                    
                                    add(ventanaLogin);
                                    ventanaLogin.setVisible(true);
                                    ventanaLogin.noExisteEquivocado.setVisible(false);
                                    ventanaLogin.campoUsuario.setText(null);
                                    ventanaLogin.campoContraseña.setText(null);    
                                    
                                    crearUser.setVisible(false); 
                                    
                                    
                                    menuPrincipal.botonAdministrarUsers.setEnabled(false);//Pongo esto aquí para que al crearlo esté disponible ese botón.
                                    if (claseUserAdmin.administrarUsuarios() == true) {
                                        menuPrincipal.botonAdministrarUsers.setEnabled(true);
                                        
                                    }
                                    
                                    break;
                                    
                                    
                                }
                            }
                            
                            
                        }else{
                            crearUser.userRepetido.setVisible(true); //Hace que le indique al usuario que el usuario ya existe.
                        }
                        
                        
                        
                    }
                }
            }
          
            
            
            
            
            //Segundo para crear usuarios de contenido.
            String usuarioNuevoContenido = crearUser.espacioUsuario.getText();
            String contraseñaNuevaContenido = crearUser.espacioContraseña.getText();
            String edadContenido = crearUser.edadUsuarioEspacio.getText();
            String nombreContenido = crearUser.nombreUsuarioEspacio.getText();
            
            boolean usuarioContenidoUnico = true;
          
            
            if (crearUser.posicionUsuarioContenido < 1000) {
                
                if (contraseñaNuevaContenido.equals("") == false) {
                    
                    if (usuarioNuevoContenido.equals("")== false) {
                        
                        
                        for (int x = 0; x < 1000; x++) {
                            
                            if (usuarioNuevoContenido.equals(claseUserContenido.usuarioContenido[x])) {
                                usuarioContenidoUnico = false;
                            }
                        }
                        
                        if (usuarioContenidoUnico == true && crearUser.opcionUsuario.getSelectedIndex() == 1  ) { //Así solamente si escogió el adecuado.
                            
                            for (int ubicacion = 0;  ubicacion < claseUserContenido.usuarioContenido.length; ubicacion++) {
                             
                                if (claseUserContenido.usuarioContenido[ubicacion]==null) {
                                    
                                    claseUserContenido.usuarioContenido[ubicacion] = usuarioNuevoContenido;
                                    claseUserContenido.contraseñaContenido[ubicacion] = contraseñaNuevaContenido;
                                    claseUserContenido.nombreUsuario[ubicacion] = nombreContenido;
                                    claseUserContenido.edadUsuario[ubicacion] = edadContenido;
                                    
                                    claseUserAdmin.posicionArreglo = ubicacion;
                                    crearUser.posicionUsuarioContenido++;
                                    
                                    add(ventanaLogin);
                                    ventanaLogin.setVisible(true);
                                    ventanaLogin.noExisteEquivocado.setVisible(false);
                                    ventanaLogin.campoUsuario.setText(null);
                                    ventanaLogin.campoContraseña.setText(null); 
                                    crearUser.setVisible(false); 
                                    
                                    menuPrincipal.botonAdministrarUsers.setEnabled(false);//Pongo esto aquí para que al crearlo esté disponible ese botón.
                                    if (claseUserContenido.administrarUsuarios() == true) {
                                        menuPrincipal.botonAdministrarUsers.setEnabled(true);
                                        
                                    }
                                    
                                    
                                    
                                    break;
                                    
                                    
                                }
                            }
                            
                            
                        }else{
                            crearUser.userRepetido.setVisible(true);
                        }
                        
                        
                        
                    }
                }
            }
            
            
            
            
            //Tercero para crear usuarios limitados.
            String usuarioNuevoLimitado = crearUser.espacioUsuario.getText();
            String contraseñaNuevaLimitada = crearUser.espacioContraseña.getText();
            String edadLimitado = crearUser.edadUsuarioEspacio.getText();
            String nombreLimitado = crearUser.nombreUsuarioEspacio.getText();
            
            boolean usuarioLimitadoUnico = true;
            
            if (crearUser.posicionUsuarioLimitado < 1000) {
                
                if (contraseñaNuevaLimitada.equals("") == false) {
                    
                    if (usuarioNuevoLimitado.equals("")== false) {
                        
                        
                        for (int x = 0; x < 1000; x++) {
                            
                            if (usuarioNuevoLimitado.equals(claseUsuarioLimitado.usuarioLimitado[x])) {
                                usuarioLimitadoUnico = false;
                            }
                        }
                        
                        if (usuarioLimitadoUnico == true && crearUser.opcionUsuario.getSelectedIndex() == 0  ) { //Así sólamente si escogió el adecuado.
                            
                            for (int indice = 0; indice < claseUsuarioLimitado.usuarioLimitado.length; indice++) {
                             
                                if (claseUsuarioLimitado.usuarioLimitado[indice] == null) {
                                    
                                    claseUsuarioLimitado.usuarioLimitado[indice] = usuarioNuevoLimitado;
                                    claseUsuarioLimitado.contraseñaLimitado[indice]= contraseñaNuevaLimitada;
                                    claseUsuarioLimitado.nombreUsuario[indice] = nombreLimitado;
                                    claseUsuarioLimitado.edadUsuario[indice] = edadLimitado;
                                    
                                    claseUsuarioLimitado.posicionArreglo= indice;
                                    crearUser.posicionUsuarioLimitado++;
                                    
                                    add(ventanaLogin);
                                    ventanaLogin.setVisible(true);
                                    ventanaLogin.noExisteEquivocado.setVisible(false);
                                    ventanaLogin.campoUsuario.setText(null);
                                    ventanaLogin.campoContraseña.setText(null);   
                                    crearUser.setVisible(false); 
                                    
                                    
                                    menuPrincipal.botonAdministrarUsers.setEnabled(false);//Pongo esto aquí para que al crearlo esté disponible ese botón.
                                    if (claseUsuarioLimitado.administrarUsuarios()== true) {
                                        menuPrincipal.botonAdministrarUsers.setEnabled(true);
                                    }
                                    
                                    
                                    break;
                                    
                                    
                                }
                            }
                            
                            
                        }else{
                            crearUser.userRepetido.setVisible(true);
                        }
                        
                        
                        
                    }
                }
            }
            


            
            
        }
        
        
        
        //Su botón para regresar.
        if (botonSeleccionado == crearUser.botonRegresar) {
            add(administrarUsers);
            administrarUsers.setVisible(true);
            crearUser.setVisible(false);
        }
        
        
        
        
  
        
        

        if (botonSeleccionado == administrarUsers.botonEditar) {
            add(editarUser);
            editarUser.setVisible(true);
            editarUser.usuarioModificado.setVisible(false);
            editarUser.usuarioNoEncontrado.setVisible(false);
            editarUser.usuarioSolicitudCambio.setText(null);
            editarUser.espacioCambioUser.setText(null);
            editarUser.espacioCambioPass.setText(null);
            editarUser.espacioCambioNombre.setText(null);
            editarUser.espacioCambioEdad.setText(null);
                    
            administrarUsers.setVisible(false);
        }
        
        
        
        
        if (botonSeleccionado == editarUser.botonModificarUsuario) {
            
            String usuarioDeseaModificar = editarUser.usuarioSolicitudCambio.getText();
            String usuarioModificar = editarUser.espacioCambioUser.getText();
            String contraseñaModificar = editarUser.espacioCambioPass.getText();
            String nombreModificar = editarUser.espacioCambioNombre.getText();
            String edadModificar = editarUser.espacioCambioEdad.getText();
            
            boolean usuarioEncontrado = false;
            
            
            //Primero con los usuarios administradores.
            for (int i = 0; i < 1000; i++) {
                
                if (usuarioDeseaModificar.equals(claseUserAdmin.usuarioAdmin[i])) {
                    
                    claseUserAdmin.usuarioAdmin[i] = usuarioModificar;
                    claseUserAdmin.contraseña[i] = contraseñaModificar;
                    claseUserAdmin.nombreUsuario[i] = nombreModificar;
                    claseUserAdmin.edadUsuario[i] = edadModificar;
                    
                    editarUser.usuarioNoEncontrado.setVisible(false);
                    editarUser.usuarioModificado.setVisible(true);
                    
                    usuarioEncontrado = true;
                }
            }
            
            //Segundo con los usuarios de contenido.
            for (int i = 0; i < 1000; i++) {
                
                if (usuarioDeseaModificar.equals(claseUserContenido.usuarioContenido[i])) {
                    
                    claseUserContenido.usuarioContenido[i] = usuarioModificar;
                    claseUserContenido.contraseñaContenido[i] = contraseñaModificar;
                    claseUserContenido.nombreUsuario[i] = nombreModificar;
                    claseUserContenido.edadUsuario[i] = edadModificar;
                    
                    editarUser.usuarioNoEncontrado.setVisible(false);
                    editarUser.usuarioModificado.setVisible(true);
                    
                    usuarioEncontrado = true;
                }
            }
            
            //Tercer con los usuarios limitados.
            for (int i = 0; i < 1000; i++) {
                
                if (usuarioDeseaModificar.equals(claseUsuarioLimitado.usuarioLimitado[i])) {
                    
                    claseUsuarioLimitado.usuarioLimitado[i] = usuarioModificar;
                    claseUsuarioLimitado.contraseñaLimitado[i] = contraseñaModificar;
                    claseUsuarioLimitado.nombreUsuario[i] = nombreModificar;
                    claseUsuarioLimitado.edadUsuario[i] = edadModificar;
                    
                    editarUser.usuarioNoEncontrado.setVisible(false);
                    editarUser.usuarioModificado.setVisible(true);
                    
                    usuarioEncontrado = true;
                }
            }
            
            if (usuarioEncontrado == false) {
                editarUser.usuarioNoEncontrado.setVisible(true);
                editarUser.usuarioModificado.setVisible(false);
            }
            
        }
        
        
        
        
        //Su botón para regresar.
        if (botonSeleccionado == editarUser.botonRegresar) {
            add(administrarUsers);
            administrarUsers.setVisible(true);
            editarUser.setVisible(false);
        }
        
        
        
        
        
        
       
        if (botonSeleccionado == administrarUsers.botonBorrar) {
            add(borrarUser);
            borrarUser.setVisible(true);
            borrarUser.usuarioNoEncontrado.setVisible(false);
            borrarUser.borradoExitoso.setVisible(false);
            borrarUser.espacioUsuarioBorrar.setText(null);
            administrarUsers.setVisible(false);
        } 
       
        String usuarioBorrar = borrarUser.espacioUsuarioBorrar.getText();
        boolean noEncontrado = true;
        if (botonSeleccionado == borrarUser.botonConfirmarBorrar) {
            
            //Primero - Buscamos entre todos los usuarios administradores.
            for(int i=0; i<1000; i++){
           
                //Si es encontrado --> borrar todo.
                if (usuarioBorrar.equals(claseUserAdmin.nombreUsuario[i])) {
                    claseUserAdmin.nombreUsuario[i] = null;
                    claseUserAdmin.contraseña[i] = null;
                    claseUserAdmin.nombreUsuario[i] = null;
                    claseUserAdmin.edadUsuario[i] = null;
                    borrarUser.borradoExitoso.setVisible(true);
                    borrarUser.usuarioNoEncontrado.setVisible(false);
                    noEncontrado = false;
                    break;
                }
            
                }
            
            //Segundo - Buscamos entre todos los usuarios de contenido.
            for (int i = 0; i < 1000; i++) {
                
                //Si es encontrado --> borrar todo.
                if (usuarioBorrar.equals(claseUserContenido.nombreUsuario[i])) {
                    claseUserContenido.usuarioContenido[i] = null;
                    claseUserContenido.contraseñaContenido[i] = null;
                    claseUserContenido.nombreUsuario[i] = null;
                    claseUserContenido.edadUsuario[i] = null;
                    borrarUser.borradoExitoso.setVisible(true);
                    borrarUser.usuarioNoEncontrado.setVisible(false);
                    noEncontrado=false;
                    
                }
            }
            
            //Tercero - Buscamos entre todos los usuarios limitados.
            for (int i = 0; i < 1000; i++) {
                
                //Si es encontrado --> borrar todo.
                if (usuarioBorrar.equals(claseUsuarioLimitado.usuarioLimitado[i])) {
                    claseUsuarioLimitado.usuarioLimitado[i] = null;
                    claseUsuarioLimitado.contraseñaLimitado[i] = null;
                    claseUsuarioLimitado.nombreUsuario[i] = null;
                    claseUsuarioLimitado.edadUsuario[i] = null;
                    borrarUser.borradoExitoso.setVisible(true);
                    borrarUser.usuarioNoEncontrado.setVisible(false);
                    noEncontrado=false;
                }
            }
            
            if (noEncontrado == true) {
                borrarUser.usuarioNoEncontrado.setVisible(true);
            }
            
            
        }
        
        
        //Su botón para regresar.
        if (botonSeleccionado == borrarUser.botonRegresar) {
            add(administrarUsers);
            administrarUsers.setVisible(true);
            borrarUser.setVisible(false);
        }
        
      
        //Botón para regresar al menú principal.
        if (botonSeleccionado == administrarUsers.botonRegresar) {
            add(menuPrincipal);
            menuPrincipal.setVisible(true);
            administrarUsers.setVisible(false);
        }
        
        
        //Botones de la ventana de reportes.
        if (botonSeleccionado == reportes.botonEventosRealizados) {
            add(listarEventosRealizados);
            listarEventosRealizados.setVisible(true);
            reportes.setVisible(false);
            
            
            listarEventosRealizados.modelo.clear();

            
            String arreglo[] = new String[1000];
            int posicionArreglo = 0;
            int contadorDeportivos = 0;
            int contadorMusicales = 0;
            int contadorReligiosos = 0;
            Calendar fechaHoy = Calendar.getInstance();
            
            int montoDeportivo = 0;
            int montoMusical = 0;
            int montoReligioso = 0;
            
             if (crearEvento.posicionEventoDeportivo > 0) {

                for (int i = 1; i < crearEvento.posicionEventoDeportivo+1; i++) {

                    if (eventoDeportivo[i].fechaEvento.getTimeInMillis() <= fechaHoy.getTimeInMillis()) {
                        
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoDeportivo[i].codigoUnico+"  --  TIPO: DEPORTIVO  --  TÍTULO: "+eventoDeportivo[i].tituloEvento+"  --  FECHA: "+eventoDeportivo[i].getFechaEvento().getTime()+"  --  MONTO: "+eventoDeportivo[i].montoRenta+" Lps.";
                        listarEventosRealizados.modelo.addElement(arreglo[posicionArreglo]);
                        contadorDeportivos++;
                        montoDeportivo += eventoDeportivo[i].montoRenta;
                        
                    }
                }
            
            }
            
            //Segundo --> buscamos en los eventos musicales.
            if (crearEvento.posicionEventoMusical > 0) {
                
                //Se deja el iterador desde 1 para que no cuente el arreglo de prueba.
                for (int i = 1; i < crearEvento.posicionEventoMusical+1; i++) {
                    
                    if (eventoMusical[i].fechaEvento.getTimeInMillis() <= fechaHoy.getTimeInMillis()) {
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoMusical[i].codigoUnico+"  --  TIPO: MUSICAL  --  TÍTULO: "+eventoMusical[i].tituloEvento+"  --  FECHA: "+eventoMusical[i].getFechaEvento().getTime()+"  --  MONTO: "+eventoMusical[i].montoRenta+" Lps.";
                        listarEventosRealizados.modelo.addElement(arreglo[posicionArreglo]);
                        contadorMusicales++;
                        montoMusical += eventoMusical[i].montoRenta;
                    }
                }
            }
            
            //Tercero --> buscamos en los eventos religiosos.
            if (crearEvento.posicionEventoReligioso > 0) {
                
                for (int i = 1; i < crearEvento.posicionEventoReligioso+1; i++) {
                    
                    if (eventoReligioso[i].fechaEvento.getTimeInMillis() <= fechaHoy.getTimeInMillis()) {
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoReligioso[i].codigoUnico+"  --  TIPO: RELIGIOSO  --  TÍTULO: "+eventoReligioso[i].tituloEvento+"  --  FECHA: "+eventoReligioso[i].getFechaEvento().getTime()+"  --  MONTO: "+eventoReligioso[i].montoRenta+" Lps.";
                        listarEventosRealizados.modelo.addElement(arreglo[posicionArreglo]);
                        contadorReligiosos++;
                        montoReligioso += eventoReligioso[i].montoRenta;
                    }
                }
            }

            
            listarEventosRealizados.cantidadDeportivos.setText("Total eventos deportivos: "+contadorDeportivos+" ----------- Monto total: "+montoDeportivo+" Lps.");
            listarEventosRealizados.cantidadMusicales.setText("Total eventos musicales: "+contadorMusicales+" ----------- Monto total: "+montoMusical+" Lps. ");
            listarEventosRealizados.cantidadReligiosos.setText("Total eventos religiosos:  "+contadorReligiosos+" ----------- Monto total: "+montoReligioso+" Lps. ");
            
            
            
            
            
            
            
            
            
            
            
            
        }
        
        
        
        
        
        
        //Botón para regresar al menú de reportes.
        if (botonSeleccionado == listarEventosRealizados.botonRegresar) {
            add(reportes);
            reportes.setVisible(true);
            listarEventosRealizados.setVisible(false);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if (botonSeleccionado == reportes.botonEventosFuturos) {
            add(listarEventosFuturos);
            listarEventosFuturos.setVisible(true);
            listarEventosFuturos.modelo.clear();

            
            String arreglo[] = new String[1000];
            int posicionArreglo = 0;
            int contadorDeportivos = 0;
            int contadorMusicales = 0;
            int contadorReligiosos = 0;
            Calendar fechaHoy = Calendar.getInstance();
            
            int montoDeportivo = 0;
            int montoMusical = 0;
            int montoReligioso = 0;
            
            
             if (crearEvento.posicionEventoDeportivo > 0) {

                for (int i = 0; i < crearEvento.posicionEventoDeportivo+1; i++) {

                    if (eventoDeportivo[i].fechaEvento.getTimeInMillis() > fechaHoy.getTimeInMillis()) {
                        
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoDeportivo[i].codigoUnico+"  --  TIPO: DEPORTIVO  --  TÍTULO: "+eventoDeportivo[i].tituloEvento+"  --  FECHA: "+eventoDeportivo[i].getFechaEvento().getTime()+"  --  MONTO: "+eventoDeportivo[i].montoRenta+" Lps.";
                        listarEventosFuturos.modelo.addElement(arreglo[posicionArreglo]);
                        contadorDeportivos++;
                        montoDeportivo += eventoDeportivo[i].montoRenta;
                    }
                }
            
            }
            
            //Segundo --> buscamos en los eventos musicales.
            if (crearEvento.posicionEventoMusical > 0) {
                
                //aquí si.
                for (int i = 0; i < crearEvento.posicionEventoMusical+1; i++) {
                    
                    if (eventoMusical[i].fechaEvento.getTimeInMillis() > fechaHoy.getTimeInMillis()) {
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoMusical[i].codigoUnico+"  --  TIPO: MUSICAL  --  TÍTULO: "+eventoMusical[i].tituloEvento+"  --  FECHA: "+eventoMusical[i].getFechaEvento().getTime()+"  --  MONTO: "+eventoMusical[i].montoRenta+" Lps.";
                        listarEventosFuturos.modelo.addElement(arreglo[posicionArreglo]);
                        contadorMusicales++;
                        montoMusical += eventoMusical[i].montoRenta;
                    }
                }
            }
            
            //Tercero --> buscamos en los eventos religiosos.
            if (crearEvento.posicionEventoReligioso > 0) {
                
                for (int i = 0; i < crearEvento.posicionEventoReligioso+1; i++) {
                    
                    if (eventoReligioso[i].fechaEvento.getTimeInMillis() > fechaHoy.getTimeInMillis()) {
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoReligioso[i].codigoUnico+"  --  TIPO: RELIGIOSO  --  TÍTULO: "+eventoReligioso[i].tituloEvento+"  --  FECHA: "+eventoReligioso[i].getFechaEvento().getTime()+"  --  MONTO: "+eventoReligioso[i].montoRenta+" Lps.";
                        listarEventosFuturos.modelo.addElement(arreglo[posicionArreglo]);
                        contadorReligiosos++;
                        montoReligioso += eventoReligioso[i].montoRenta;
                    }
                }
            }

            
            listarEventosFuturos.cantidadDeportivos.setText("Total eventos deportivos: "+contadorDeportivos+" ----------- Monto total: "+montoDeportivo+" Lps.");
            listarEventosFuturos.cantidadMusicales.setText("Total eventos musicales: "+contadorMusicales+" ----------- Monto total: "+montoMusical+" Lps. ");
            listarEventosFuturos.cantidadReligiosos.setText("Total eventos religiosos:  "+contadorReligiosos+" ----------- Monto total: "+montoReligioso+" Lps. ");
            
            
            
            
            
            reportes.setVisible(false);
        }
        
        
        
        
        
        //Botón para regresar al menú de reportes.
        if (botonSeleccionado == listarEventosFuturos.botonRegresar) {
            add(reportes);
            reportes.setVisible(true);
            listarEventosFuturos.setVisible(false);
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        if (botonSeleccionado == reportes.botonEventosCancelados) {
            add(listarEventosCancelados);
            listarEventosCancelados.setVisible(true);
            listarEventosCancelados.modelo.clear();
            
            String arreglo[] = new String[1000];
            int posicionArreglo = 0;
            int contadorDeportivos = 0;
            int contadorMusicales = 0;
            int contadorReligiosos = 0;
            
            int multaTotalDeportivo = 0;
            int multaTotalMusical = 0;
            
            //Utilizamos un atributo tipo final porque esta multa no va a cambiar con nada debido a que es un evento religioso.
            final int multaTotalReligioso = 0;
            
            //Buscamos primero entre los eventos deportivos si hay algún evento cancelado.
            if (crearEvento.posicionEventoDeportivo > 0) {

                for (int i = 0; i < crearEvento.posicionEventoDeportivo+1; i++) {

                    if (eventoDeportivo[i].cancelado==true) {
                        
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoDeportivo[i].codigoUnico+" -- TIPO: DEPORTIVO -- TÍTULO: "+eventoDeportivo[i].tituloEvento+" -- FECHA: "+eventoDeportivo[i].getFechaEvento().getTime()+" -- Multa: "+eventoDeportivo[i].montoRenta+" Lps."; 
                        listarEventosCancelados.modelo.addElement(arreglo[posicionArreglo]);
                        contadorDeportivos++;
                        multaTotalDeportivo += eventoDeportivo[i].montoRenta;
                        
                    }
                }
            
            }
            
            //Segundo --> buscamos en los eventos musicales.
            if (crearEvento.posicionEventoMusical > 0) {
                
                //aquí si.
                for (int i = 0; i < crearEvento.posicionEventoMusical+1; i++) {
                    
                    if (eventoMusical[i].cancelado==true) {
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoMusical[i].codigoUnico+" -- TIPO: MUSICAL -- TÍTULO: "+eventoMusical[i].tituloEvento+" -- FECHA: "+eventoMusical[i].getFechaEvento().getTime()+" -- Multa: "+eventoMusical[i].montoRenta+" Lps.";
                        listarEventosCancelados.modelo.addElement(arreglo[posicionArreglo]);
                        contadorMusicales++;
                        multaTotalMusical += eventoMusical[i].montoRenta;
                    }
                }
            }
            
            //Tercero --> buscamos en los eventos religiosos.
            if (crearEvento.posicionEventoReligioso > 0) {
                
                for (int i = 0; i < crearEvento.posicionEventoReligioso+1; i++) {
                    
                    if (eventoReligioso[i].cancelado==true) {
                        arreglo[posicionArreglo] = "CÓDIGO: "+eventoReligioso[i].codigoUnico+" -- TIPO: RELIGIOSO -- TÍTULO: "+eventoReligioso[i].tituloEvento+" -- FECHA: "+eventoReligioso[i].getFechaEvento().getTime()+" -- Multa: 0 Lps.";
                        listarEventosCancelados.modelo.addElement(arreglo[posicionArreglo]);
                        contadorReligiosos++;
                    }
                }
            }

            
            listarEventosCancelados.cantidadDeportivos.setText("Deportivos: "+contadorDeportivos+" ---------- Multa: "+multaTotalDeportivo);
            listarEventosCancelados.cantidadMusicales.setText("Musicales: "+contadorMusicales+" ---------- Multa: "+multaTotalMusical);
            listarEventosCancelados.cantidadReligiosos.setText("Religiosos: "+contadorReligiosos+" ---------- Multa: "+multaTotalReligioso);
            
            
            reportes.setVisible(false);
            
        }
        
        
        
        //Botón para regresar al menú de reportes.
        if (botonSeleccionado == listarEventosCancelados.botonRegresar) {
            add(reportes);
            reportes.setVisible(true);
            listarEventosCancelados.setVisible(false);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if (botonSeleccionado == reportes.botonIngresosFecha) {
            add(ingresoGenerado);
            ingresoGenerado.setVisible(true);
            ingresoGenerado.montoEntreFechas.setVisible(false);
            
            ingresoGenerado.cantidadDeportivos.setVisible(true);
            ingresoGenerado.cantidadMusicales.setVisible(true);
            ingresoGenerado.cantidadReligiosos.setVisible(true);    
            
            ingresoGenerado.espacioDiaInicial.setText("0");
            ingresoGenerado.espacioMesInicial.setText("0");
            ingresoGenerado.espacioAñoInicial.setText("0");
            
            ingresoGenerado.espacioDiaFinal.setText("0");
            ingresoGenerado.espacioMesFinal.setText("0");
            ingresoGenerado.espacioAñoFinal.setText("0");
            
            ingresoGenerado.cantidadDeportivos.setText("Total eventos deportivos: 0");
            ingresoGenerado.cantidadMusicales.setText("Total eventos musicales: 0");
            ingresoGenerado.cantidadReligiosos.setText("Total eventos religiosos: 0");
            
            
            reportes.setVisible(false);
        }
        
        
        
        
        if (botonSeleccionado == ingresoGenerado.botonVerIngresos) {
            
            int contadorDeportivos = 0;
            int contadorMusicales = 0;
            int contadorReligiosos = 0;
            
            
            //Sacamos la fecha inicial.
            String diaInicialString = ingresoGenerado.espacioDiaInicial.getText();
            int diaInicial = Integer.parseInt(diaInicialString);
            String mesInicialString = ingresoGenerado.espacioMesInicial.getText();
            int mesInicial = Integer.parseInt(mesInicialString);
            String añoInicialString = ingresoGenerado.espacioAñoInicial.getText();
            int añoInicial = Integer.parseInt(añoInicialString);
            
            //Sacamoos la fecha final.
            String diaFinalString = ingresoGenerado.espacioDiaFinal.getText();
            int diaFinal = Integer.parseInt(diaFinalString);
            String mesFinalString = ingresoGenerado.espacioMesFinal.getText();
            int mesFinal = Integer.parseInt(mesFinalString);
            String añoFinalString = ingresoGenerado.espacioAñoFinal.getText();
            int añoFinal = Integer.parseInt(añoFinalString);
            
            
            Calendar fechaInicial = Calendar.getInstance();
            fechaInicial.set(añoInicial, mesInicial-1, diaInicial );
            
            Calendar fechaFinal = Calendar.getInstance();
            fechaFinal.set(añoFinal, mesFinal-1, diaFinal);
            
            boolean fechaCorrectaInicial = false;
            boolean fechaCorrectaFinal = false;
            
            if ((diaInicial>0 && diaInicial<32)&&(mesInicial>=0 && mesInicial<=11)) {
                fechaCorrectaInicial = true;
            }
            
            if ((diaFinal>0 && diaFinal<32)&&(mesFinal>=0 && mesFinal<=11)) {
                fechaCorrectaFinal = true;
            }
            
            boolean fechaEntreDia = false;
            boolean fechaEntreMes = false;
            boolean fechaEntreAño = false;
            
            double acumuladorTotal = 0;
            
            if ((fechaCorrectaInicial == true) && (fechaCorrectaFinal == true)) {
                
                
                //Primero recolectamos todos los eventos deportivos y sus respectivos montos.
                if(crearEvento.posicionEventoDeportivo > 0){
                    for (int i = 0; i < crearEvento.posicionEventoDeportivo+1; i++) {

                        //Revisamos si el día 
                        if (añoInicial < añoFinal) {

                            if (fechaInicial.getTime().getYear() <= eventoDeportivo[i].getFechaEvento().getTime().getYear() &&
                                eventoDeportivo[i].getFechaEvento().getTime().getYear() <=fechaFinal.getTime().getYear()) {
                                fechaEntreAño = true;
                                acumuladorTotal += eventoDeportivo[i].montoRenta;
                                contadorDeportivos++;
                            }

                        }

                        if (añoInicial >= añoFinal) {

                            if (fechaFinal.getTime().getYear() <= eventoDeportivo[i].getFechaEvento().getTime().getYear() &&
                                    eventoDeportivo[i].getFechaEvento().getTime().getYear() <= fechaInicial.getTime().getYear()) {
                                fechaEntreAño = true;
                                acumuladorTotal += eventoDeportivo[i].montoRenta;
                                contadorDeportivos++;
                            }

                        }
                    }

                }
                
                
                if(crearEvento.posicionEventoMusical > 0){
                    for (int i = 0; i < crearEvento.posicionEventoMusical+1; i++) {

                        //Revisamos si el día 
                        if (añoInicial < añoFinal) {

                            if (fechaInicial.getTime().getYear() <= eventoMusical[i].getFechaEvento().getTime().getYear() &&
                                eventoMusical[i].getFechaEvento().getTime().getYear() <=fechaFinal.getTime().getYear()) {
                                fechaEntreAño = true;
                                acumuladorTotal += eventoMusical[i].montoRenta;
                                contadorMusicales++;
                            }

                        }

                        if (añoInicial >= añoFinal) {

                            if (fechaFinal.getTime().getYear() <= eventoMusical[i].getFechaEvento().getTime().getYear() &&
                                    eventoMusical[i].getFechaEvento().getTime().getYear() <= fechaInicial.getTime().getYear()) {
                                fechaEntreAño = true;
                                acumuladorTotal += eventoMusical[i].montoRenta;
                                contadorMusicales++;
                            }

                        }
                    }

                }

                
                if(crearEvento.posicionEventoReligioso > 0){
                    for (int i = 0; i < crearEvento.posicionEventoReligioso+1; i++) {

                        //Revisamos si el día 
                        if (añoInicial < añoFinal) {

                            if (fechaInicial.getTime().getYear() <= eventoReligioso[i].getFechaEvento().getTime().getYear() &&
                                eventoReligioso[i].getFechaEvento().getTime().getYear() <=fechaFinal.getTime().getYear()) {
                                fechaEntreAño = true;
                                acumuladorTotal += eventoReligioso[i].montoRenta;
                                contadorReligiosos++;
                            }

                        }
                    
                    if (añoInicial >= añoFinal) {
                        
                        if (fechaFinal.getTime().getYear() <= eventoReligioso[i].getFechaEvento().getTime().getYear() &&
                                eventoReligioso[i].getFechaEvento().getTime().getYear() <= fechaInicial.getTime().getYear()) {
                            fechaEntreAño = true;
                            acumuladorTotal += eventoReligioso[i].montoRenta;
                            contadorReligiosos++;
                        }
                        
                    }
                 }
                }
                
            }else{
                ingresoGenerado.montoEntreFechas.setText("¡Ha ingresado una fecha incorrecta!");
                ingresoGenerado.montoEntreFechas.setVisible(true);
            }
            
            
            if (fechaEntreAño == true) {
                ingresoGenerado.montoEntreFechas.setText("El total de ingresos generado es: "+acumuladorTotal+" Lps.");
                ingresoGenerado.montoEntreFechas.setVisible(true);
            }
            
            
            ingresoGenerado.cantidadDeportivos.setText("Total eventos deportivos: "+contadorDeportivos);
            ingresoGenerado.cantidadMusicales.setText("Total eventos musicales: "+contadorMusicales);
            ingresoGenerado.cantidadReligiosos.setText("Total eventos religiosos: "+contadorReligiosos);
            
        }
        
        
        
        //Botón para regresar al menú de reportes.
        if (botonSeleccionado == ingresoGenerado.botonRegresar) {
            add(reportes);
            reportes.setVisible(true);
            ingresoGenerado.setVisible(false);
        }
        
        
        
        
        if (botonSeleccionado == reportes.botonVerPerfil) {
            add(perfilUsuario);
            perfilUsuario.setVisible(true);
            perfilUsuario.modelo.clear();
            
            if (indiceAdminLoggedIn > -1 && adminLogged == true) {
                perfilUsuario.datosUsuario1.setText("Usuario: "+claseUserAdmin.usuarioAdmin[indiceAdminLoggedIn]+" -------------- Contraseña: "+claseUserAdmin.contraseña[indiceAdminLoggedIn]);
                perfilUsuario.datosUsuario2.setText("Nombre del usuario: "+claseUserAdmin.nombreUsuario[indiceAdminLoggedIn]+"-------------- Edad: "+claseUserAdmin.edadUsuario[indiceAdminLoggedIn]);          
                //Llamamos a la función recursiva.
                recorrerEventosAdmin(claseUserAdmin, 0);
            }
            
            
            if (indiceContenidoLoggedIn > -1 && contenidoLogged == true) {
                perfilUsuario.datosUsuario1.setText("Usuario: "+claseUserContenido.usuarioContenido[indiceContenidoLoggedIn]+" -------------- Contraseña: "+claseUserContenido.contraseñaContenido[indiceContenidoLoggedIn]);
                perfilUsuario.datosUsuario2.setText("Nombre del usuario: "+claseUserContenido.nombreUsuario[indiceContenidoLoggedIn]+"-------------- Edad: "+claseUserContenido.edadUsuario[indiceContenidoLoggedIn]);
                //Llamamos a la función recursiva.
                recorrerEventosContenido(claseUserContenido, 0);
            }
            
            
            if (indiceLimitadoLoggedIn > -1 && limitadoLogged == true) {
                perfilUsuario.datosUsuario1.setText("Usuario: "+claseUsuarioLimitado.usuarioLimitado[indiceLimitadoLoggedIn]+" -------------- Contraseña: "+claseUsuarioLimitado.contraseñaLimitado[indiceLimitadoLoggedIn]);
                perfilUsuario.datosUsuario2.setText("Nombre del usuario: "+claseUsuarioLimitado.nombreUsuario[indiceLimitadoLoggedIn]+"-------------- Edad: "+claseUsuarioLimitado.edadUsuario[indiceLimitadoLoggedIn]);
            }
            
            
            perfilUsuario.datosUsuario1.setVisible(true);
            perfilUsuario.datosUsuario2.setVisible(true);
            
            reportes.setVisible(false);
        }

        
        //Botón para regresar al menú de reportes.
        if (botonSeleccionado == perfilUsuario.botonRegresar) {
            add(reportes);
            reportes.setVisible(true);
            perfilUsuario.setVisible(false);
        }
        
        
        
        
        
        
        
        
        //Botón para regresar al menú principal.
        if (botonSeleccionado == reportes.botonRegresar) {
            add(menuPrincipal);
            menuPrincipal.setVisible(true);
            reportes.setVisible(false);
        }



        
        
        
    }
    
    
    
    
    
    
    
    //Funciones recursivas.
    public final int recorrerArray(UsuarioAdministrador userAdmin, int indice, String usuario){
        
        if (indice != userAdmin.nombreUsuario.length) {
            if (userAdmin.nombreUsuario[indice].equals(usuario)) {
                return indice;
            }
            recorrerArray(userAdmin, indice+1, usuario);
        }
        
        return -1;
    }
    
    
    
    public final void recorrerEventosAdmin(UsuarioAdministrador userAdmin, int x){
        
        if (x != indiceAdminEvento ) {
            String arregloString[] = new String[1000];
            arregloString[x] = claseUserAdmin.idEventos[x];
            perfilUsuario.modelo.addElement(arregloString[x]);
            recorrerEventosAdmin(userAdmin, x+1);
        }
    }
    
        
    public final void recorrerEventosContenido(UsuarioContenido userContenido, int x){
        
        if (x != indiceConteEvento) {
            String arregloString[] = new String[1000];
            arregloString[x] = claseUserContenido.idEventos[x];
            perfilUsuario.modelo.addElement(arregloString[x]);
            recorrerEventosContenido(userContenido, x+1);
        }
    }

    

    
    
    
    
    
    
    

}