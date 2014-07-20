package action;

import objetivos.Adicional;
import objetivos.ExplosionesPorColor;

public class NuevaExplosionPorColorActionBean extends AdicionalActionBean{

	//METODOS
	protected Adicional crearObjetivo(int cantidad2) {
		return new ExplosionesPorColor(cantidad2);
	}
	
}
