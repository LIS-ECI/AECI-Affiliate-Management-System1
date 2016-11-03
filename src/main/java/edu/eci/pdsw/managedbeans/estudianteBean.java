/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.managedbeans;

/**
 *
 * @author estudiante
 */
public class estudianteBean {
    /**
     * <p:dataTable var="foro" value="#{beanRegistroForosBean.sp}" selectionMode="single" selection="#{beanRegistroForosBean.seleccionado}" rowKey="#{foro.identificador}">
        
        <p:column headerText="Identificador">
                        <h:outputText value="#{foro.identificador}" />
                    </p:column>
        <p:column headerText="Autor">
            <h:outputText value="#{foro.autor.nombre}" />
                    </p:column>
        <p:column headerText="Comentario">
                        <h:outputText value="#{foro.comentario}" />
                    </p:column>
        <p:column headerText="Titulo">
                        <h:outputText value="#{foro.titulo}" />
                    </p:column>

    </p:dataTable>
    *             <p:commandButton value="Agregar foro" update="infoEstudiante" actionListener="#{beanRegistroForosBean.add}"></p:commandButton>
    * 
     */
    
}
