/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.beans;

import com.futbolweb.converters.InterfaceController;
import com.futbolweb.login.beans.SessionManagedBean;
import com.futbolweb.persistence.entities.Jugador;
import com.futbolweb.persistence.entities.Seguimiento;
import com.futbolweb.persistence.entities.Usuario;
import com.futbolweb.persistence.facades.JugadorFacade;
import com.futbolweb.persistence.facades.SeguimientoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Iesua
 */
@Named(value = "jugadorManagedBean")
@RequestScoped
public class JugadorManagedBean implements Serializable, InterfaceController<Jugador> {

    private Jugador jugador;
    @EJB
    private JugadorFacade jugadorEJB;
    @Inject
    private SessionManagedBean sessionMB;
    private List<Seguimiento> lista;

    @EJB
    private SeguimientoFacade segf;

    public JugadorManagedBean() {
    }

    @PostConstruct
    public void init() {
        jugador = new Jugador();
    }

    @Override
    public Jugador getObjectByKey(Integer key) {
        return jugadorEJB.find(key);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public SessionManagedBean getSessionMB() {
        return sessionMB;
    }

    public void setSessionMB(SessionManagedBean sessionMB) {
        this.sessionMB = sessionMB;
    }

    public List<Jugador> listarJugadores() {
        return jugadorEJB.findAll();
    }

    public void creaJugador() {
        try {
            jugadorEJB.create(jugador);
        } catch (Exception e) {

        }
    }

    public List<Seguimiento> listarSeguimientoo() {
        return segf.listarSeguimientoEspecifico(jugador);
    }

    public List<Seguimiento> getListaJuagador() {
        return (List<Seguimiento>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seguimientos");
    }

    public String solicitarJugador2(Jugador j) {
        jugador = j;
        //lista = lseguimiento;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("seguimientos", lista);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("jseg", j);
        return "/protegido/jugador/listajugadoresseguimiento.xhtml?faces-redirect=true";
    }

    public void redireccionarJugador() {

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("registro_jugador.xhtml");
        } catch (Exception e) {
        }
    }

}
