package action;

import mundo.Jugador;
import mundo.Nivel;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import objetivos.Adicional;

public abstract class AdicionalActionBean extends BaseActionBean{
	Jugador jugador;
	@Validate(minvalue = 0)
	int cantidad = 0;
	Nivel miNivel;

	public Nivel getMiNivel() {
		return miNivel;
	}

	public void setMiNivel(Nivel miNivel) {
		this.miNivel = miNivel;
	}

	@HandlesEvent("agregar")
	public Resolution agregarObjetivo(){
		if(this.getCantidad() <= 0){
			throw new RuntimeException("debe ingresar una cantidad válida");
		}else{
			 Adicional adi= this.crearObjetivo(this.getCantidad());
			 getMiNivel().getObjetivos().add(adi);
		}		
		return new ForwardResolution("/editor.jsp");
	}

	protected abstract Adicional crearObjetivo(int cantidad2);

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
