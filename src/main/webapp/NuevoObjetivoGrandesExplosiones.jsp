<%@ include file="/taglibs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nuevo objetivo: Grandes explosiones</title>
</head>
<body>
	<stripes:form beanclass="action.NuevaExplosionActionBean" focus="">
      <stripes:errors/>
      <div style="height:50px;">
	    <stripes:label for = "color">Color: </stripes:label>
	    <stripes:select name="colores">
          <stripes:option value="">Seleccionar un color</stripes:option>
          <stripes:options-collection collection="${Jugador.dificultadSeleccionada.dulces}" label="color" value="id"/>
        </stripes:select>
      </div>
      <div style="height:50px;">
      <stripes:label for = "color">Cantidad:  </stripes:label>
      <stripes:select name="colores">
          <stripes:option value="">Seleccionar una cantidad</stripes:option>
          <stripes:options-collection collection="${actionBean.posiblesCantidades}" label="cantidad" value="id"/>
        </stripes:select>
      </div>
      <div>
        <stripes:submit name="agregarGE" value = "agregarGE"></stripes:submit>
        <stripes:submit name="cancelar" value = "cancelar"></stripes:submit>
      </div>
    </stripes:form>
</body>
</html>