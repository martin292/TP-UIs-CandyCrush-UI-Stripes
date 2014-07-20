<%@ include file="/taglibs.jsp"%>

<stripes:layout-render name="/layout.jsp" title="Editor">
	<stripes:layout-component name="body">
	<stripes:useActionBean beanclass="action.EditorActionBean" var="editorBean"/>

		<h2>Pantalla de creacion y edicion de niveles</h2>

			<stripes:errors globalErrorsOnly="true" />

			<div style="float: right;">
				<div>Jugador: 
				<stripes:label name="${editorBean.jugador}" />
				</div>
				<div>
					<a href="logeo.jsp">Volver al inicio</a>
				</div>
				<div>
					<h4>Niveles creados</h4>
					<div>
						<stripes:form beanclass="action.EditorActionBean" focus="">
							Filtrar:
							<stripes:text name="filtroBusquedaNivel" />
							<stripes:submit name="filtrarNiveles" value="Filtrar" />
						</stripes:form>
					</div>
					<div>
						<table>
							<tr>
								<td>Nombre</td>
								<td>Editar</td>
								<td>Borrar</td>
							</tr>
							<c:forEach items="${editorBean.nivelesFiltrados}" var="nivel">
								<tr>
									<td>${nivel}</td>
									<td><stripes:link name="editar"
											beanclass="action.EditorActionBean" event="editarNivel">
											<stripes:param name="nivel" value="${nivel.nombre}" />
											<img src="images/edit.gif" />
										</stripes:link></td>
									<td><stripes:link name="borrar"
											beanclass="action.EditorActionBean" event="eliminarNivel">
											<stripes:param name="nivel" value="${nivel.nombre}" />
											<img src="images/delete.gif" />
										</stripes:link></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div>
				<h3>Crear un nivel</h3>
				<stripes:form beanclass="action.EditorActionBean" focus="">
					<div>
						Nombre del nivel:
						<stripes:text name="nombreNivel" />
						<stripes:errors field="nombre" />

						<br /> Tablero: Filas:
						<stripes:text name="filas" />
						<stripes:errors field="filas" />
						<br /> Columnas:
						<stripes:text name="columnas" />
						<stripes:errors field="columnas" />
						<br /> Movimientos:
						<stripes:text name="movimientos" />
						<stripes:errors field="movimientos" />
						<br />
					</div>
					<div>
						<table>
							<tr>
								<td>Objetivos</td>
								<td>Editar</td>
								<td>Borrar</td>
							</tr>
							<c:forEach items="${editorBean.objetivos}" var="objetivo">
								<tr>
									<td>${objetivo.nombre()}</td>
									<td><stripes:image name="editar" src="images/edit.gif"
											value="objetivoSeleccionado" alt="editar"
											onclick="editarObjetivo" /></td>
									<td><stripes:link name="borrar"
											beanclass="action.EditorActionBean" event="eliminarObjetivo">
											<stripes:param name="objetivo" value="${objetivo}" />
											<img src="images/delete.gif" />
										</stripes:link></td>
								</tr>
							</c:forEach>
						</table>
						<stripes:button name="crearExplosionPorColor"
							value="Nueva Explosión por color"
							onclick="document.location='editor.jsp'" />
						<stripes:button name="crearGranExplosion"
							value="Nueva Gran Explosión"
							onclick="document.location='editor.jsp'" />
					</div>
					<stripes:submit name="crearNivel" value="Crear" />
				</stripes:form>
			</div>
		
	</stripes:layout-component>
</stripes:layout-render>