package action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;

import repos.MundoFactory;
import mundo.Jugador;

public class LogeoActionBean extends BaseActionBean{

	// **********************************************
	// * VARIABLES
	// **********************************************
	
	@Validate(required = true, minlength = 3, maxlength=15)
	private String nombre;	
	
	// **********************************************
	// * ACCESSORS
	// **********************************************
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// **********************************************
	// * METODOS
	// **********************************************
	
	@DefaultHandler
	public Resolution abrirEditor(){
		return new ForwardResolution("/editor.jsp");
	}
	
	@HandlesEvent("registrar")
	public Resolution registrar() {		
		if(this.elUsuarioExiste()){
			return this.mostrarError("El usuario ya existe");
		}else{
			Jugador nuevoJugador = new Jugador(this.getNombre()); 
			MundoFactory.getInstance().agregarJugador(nuevoJugador); 
			MundoFactory.getInstance().setJugadorSeleccionado(nuevoJugador);
			return this.abrirEditor();
		}		
	}
	
	@HandlesEvent("logear")
	public Resolution logear(){
		if(this.elUsuarioExiste()){
			MundoFactory.getInstance().setJugadorSeleccionado(this.jugadorSeleccionado());
			return this.abrirEditor();
		}else{			
            return this.mostrarError("El usuario no existe");
		}
	}
	
	//Metodos auxiliares-----------------------------------------------
	
	private Resolution mostrarError(String e){
		ValidationErrors errors = new ValidationErrors();
        errors.add("nombre", new SimpleError(e));
        
        this.getContext().setValidationErrors(errors);
        return new ForwardResolution("/logeo.jsp");
	}
	
	private Boolean elUsuarioExiste(){
		return this.buscarUsuario();
	}

	private Boolean buscarUsuario() {
		return MundoFactory.getInstance().buscarUsuario(this.getNombre());
	}
	
	private Jugador jugadorSeleccionado() {
		return MundoFactory.getInstance().retJugador(this.getNombre());
	}
	
	
}