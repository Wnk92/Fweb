/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.beans;

import com.futbolweb.persistence.entities.Valoracion;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author camila
 */
@Named(value = "desempenioTecnicoManagedBean")
@RequestScoped
public class desempenioTecnicoManagedBean {

    @Inject
    private ValoracionManagedBean valoracion;

    private int control;
    private int cambio;
    private int enganche;
    private int centros;

    public ValoracionManagedBean getValoracion() {
        return valoracion;
    }

    public void setValoracion(ValoracionManagedBean valoracion) {
        this.valoracion = valoracion;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public int getEnganche() {
        return enganche;
    }

    public void setEnganche(int enganche) {
        this.enganche = enganche;
    }

    public int getCentros() {
        return centros;
    }

    public void setCentros(int centros) {
        this.centros = centros;
    }
   

    public desempenioTecnicoManagedBean() {
    }

    @PostConstruct

    public void init() {
        asignarDesempenioTecnico();

    }

   public void asignarDesempenioTecnico() {

        List<Valoracion> valoraciones = getValoracion().listarValoracion2();

        for (int i = 0; i < valoraciones.size(); i++) {

            switch (i) {

                case 12:
                    control = valoraciones.get(i).getNota();
                    break;

                case 13:
                    cambio = valoraciones.get(i).getNota();
                    break;

                case 14:
                    enganche = valoraciones.get(i).getNota();
                    break;

                case 15:
                    centros = valoraciones.get(i).getNota();

                default:
            }
            Valoracion v = valoraciones.get(i);

        }
    }

}
