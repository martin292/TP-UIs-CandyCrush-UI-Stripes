package action;

import objetivos.Adicional;
import mundo.Nivel;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;

public class EditarExplosionActionBean extends BaseActionBean{
		
		//VARIABLES
		@Validate(required = true, minvalue = 0)
		int cantidad;
		Nivel nivel;
		
		//METODOS
		public Nivel getNivel() {
			return nivel;
		}

		public void setNivel(Nivel nivel) {
			this.nivel = nivel;
		}

		@HandlesEvent("editar")
		public Resolution editarObjetivo(Adicional exc){
			if(this.getCantidad() <= 0){
				throw new RuntimeException("debe ingresar una cantidad válida");
			}else if (!this.getNivel().getObjetivos().contains(exc)){
				throw new RuntimeException("el nivel seleccionado no existe");
			} else {
				exc.setCantidad(this.getCantidad());
			}	
			return new ForwardResolution("/editarObjetivo.jsp");
		}
		
		@HandlesEvent("cancelar")
		public Resolution cancelarObjetivo(){
			return new ForwardResolution("/editor.jsp");
		}

		//ACCESORS
		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}		
	}

