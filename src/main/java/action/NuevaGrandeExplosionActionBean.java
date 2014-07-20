package action;

import objetivos.Adicional;
import objetivos.GrandesExplosiones;

public class NuevaGrandeExplosionActionBean extends AdicionalActionBean{


	protected Adicional crearObjetivo(int cantidad2) {
		return new GrandesExplosiones(cantidad2);
	}

}
