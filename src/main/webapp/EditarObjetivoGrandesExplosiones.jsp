<%@ include file="/taglibs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editar objetivo: Explosiones por color</title>
</head>
<body>
	<stripes:form beanclass="action.EditarObjetivoActionBean" focus="">
      <stripes:errors/>
      <div style="height:50px;">
	    <stripes:label for = "color">Color: </stripes:label>
	    <stripes:select name="colores">
          <stripes:options-collection collection="${actionBean.Jugador.dificultadSeleccionada.dulces}" label="color" value="id"/>
        </stripes:select>
      </div>
      <div style="height:50px;">
	    <stripes:label for = "color">Cantidad: </stripes:label>
	    <stripes:select name="cantidad">
          <stripes:options-collection collection="" label="color" value="id"/>
        </stripes:select>
      </div>
      <div>
        <stripes:submit name="explosionPorColor" value = "modificar"></stripes:submit>
        <stripes:submit name="cancelar" value = "cancelar"></stripes:submit>
      </div>
    </stripes:form>
</body>
</html>