package action;

import java.util.*;

import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.Validate;

import objetivos.Objetivo;
import repos.MundoFactory;
import mundo.Jugador;
import mundo.Nivel;
import dificultad.Dificultad;

@SessionScope
public class EditorActionBean extends BaseActionBean{
	
	// **********************************************
	// * VARIABLES
	// **********************************************
	//protected Jugador jugador = MundoFactory.getInstance().getJugadores().get(0);
	protected Jugador jugador = MundoFactory.getInstance().getJugadorSeleccionado();
	
	@Validate(minlength=3)
	protected String nombreNivel;
	
	@Validate(minvalue=3, maxvalue=8)
	protected int filas;
	
	@Validate(minvalue=3, maxvalue=8)
	protected int columnas;
	
	@Validate(minvalue=1, maxvalue=99)
	protected int movimientos;
	
	protected List<Objetivo> objetivos;
	
	protected Dificultad dificultad;
	
	protected String filtroBusquedaNivel;
	protected List<Nivel> nivelesFiltrados;
	
	// **********************************************
	// * METODOS
	// **********************************************
//	@Before(stages=LifecycleStage.ActionBeanResolution)
//	public void cargarSocio() {
//		this.setFiltroBusquedaNivel("");
//		this.filtrarNiveles();
//	}
	
	@DefaultHandler
	public Resolution view(){
		return new ForwardResolution("/editor.jsp");
	}
	
	public Resolution filtrarNiveles(){
		List<Nivel> niveles = new ArrayList<Nivel>();
		if(this.getFiltroBusquedaNivel() == null){
			niveles = this.getJugador().getNivelesPropios();
		}
		else {
			for(Nivel nivel : this.getJugador().getNivelesPropios()){
				if(nivel.getNombre().contains(this.getFiltroBusquedaNivel())){
					niveles.add(nivel);
				}
			}
		}
		this.setNivelesFiltrados(niveles);
		return new ForwardResolution("/editor.jsp");
	}
	
	public Resolution editarNivel(){
		String nombreNivel = this.getContext().getRequest().getParameter("nivel");
		Nivel nivel = this.getJugador().getNivelPropio(nombreNivel);
		
		this.setNombreNivel(nivel.getNombre());
		this.setFilas(nivel.getFilas());
		this.setColumnas(nivel.getColumnas());
		this.setMovimientos(nivel.getMovimientosDisponibles());
		this.setObjetivos(nivel.getObjetivos());
		return this.view();
	}
	
	public Resolution eliminarNivel(){
		this.getJugador().eliminarNivelPropio(this.getContext().getRequest().getParameter("nivel"));
		return this.view();
	}
	
	public Resolution editarObjetivo(){
		//TODO
		return this.view();
	}
	
	public Resolution eliminarObjetivo(){
		Objetivo objetivoAEliminar = this.getObjetivos().get(0);
		for(Objetivo objetivo : this.getObjetivos()){
			if(objetivo.toString().equals(this.getContext().getRequest().getParameter("objetivo"))){
				objetivoAEliminar = objetivo;
			}
		}
		this.getObjetivos().remove(objetivoAEliminar);
		return this.view();
	}
	
	public void resetearNivel(){
		this.setNombreNivel(null);
		this.setFilas(0);
		this.setColumnas(0);
		this.setMovimientos(0);
		this.setObjetivos(null);
	}
	
	public Resolution crearNivel(){
		Nivel nivel = new Nivel(this.getNombreNivel(), this.getFilas(), 
				this.getColumnas(), this.getMovimientos(), this.getObjetivos());
		this.getJugador().agregarNivel(nivel);
		this.resetearNivel();
		return this.view();
	}
	
	// **********************************************
	// * ACCESSORS
	// **********************************************
	public Jugador getJugador() 						{return jugador;}
	public void setJugador(Jugador jugador) 			{this.jugador = jugador;}
	public String getNombreNivel() 						{return nombreNivel;}
	public void setNombreNivel(String nombreNivel)		{this.nombreNivel = nombreNivel;}
	public Dificultad getDificultad() 					{return dificultad;}
	public void setDificultad(Dificultad dificultad)	{this.dificultad = dificultad;}
	public int getFilas() 								{return filas;}
	public void setFilas(int filas) 					{this.filas = filas;}
	public int getColumnas() 							{return columnas;}
	public void setColumnas(int columnas) 				{this.columnas = columnas;}
	public int getMovimientos() 						{return movimientos;}
	public void setMovimientos(int movimientos) 		{this.movimientos = movimientos;}
	public String getFiltroBusquedaNivel() 				{return filtroBusquedaNivel;}
	public void setFiltroBusquedaNivel(String filtro)	{this.filtroBusquedaNivel = filtro;}
	public List<Objetivo> getObjetivos() 				{return objetivos;}
	public void setObjetivos(List<Objetivo> objetivos)	{this.objetivos = objetivos;}
	public List<Nivel> getNivelesFiltrados()			{return nivelesFiltrados;}
	public void setNivelesFiltrados(List<Nivel> niveles){this.nivelesFiltrados = niveles;}
	
}
