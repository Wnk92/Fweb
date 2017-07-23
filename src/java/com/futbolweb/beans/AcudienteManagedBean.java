/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.beans;

import com.futbolweb.login.beans.SessionManagedBean;
import com.futbolweb.persistence.entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "acudienteManagedBean")
@RequestScoped
public class AcudienteManagedBean implements Serializable {

    private Usuario u;
    @Inject
    private SessionManagedBean sesion;

    public SessionManagedBean getSesion() {
        return sesion;
    }

    public void setSesion(SessionManagedBean sesion) {
        this.sesion = sesion;
    }

    public AcudienteManagedBean() {
    }

    public List<Usuario> acudienteJugador() {
        u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("jugador");
        return getSesion().getUsuarioSesion().getIdAcudiente().getUsuarioList();
    }
}
