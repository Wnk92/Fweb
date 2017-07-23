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
@Named(value = "desempenioPsicologicoManagedBean")
@RequestScoped
public class desempenioPsicologicoManagedBean {

    @Inject
    private ValoracionManagedBean valoracion;

    private int compañerismo;
    private int acomplamiento;
    private int rendimiento;
    private int conducta;

    public ValoracionManagedBean getValoracion() {
        return valoracion;
    }

    public void setValoracion(ValoracionManagedBean valoracion) {
        this.valoracion = valoracion;
    }

    public int getCompañerismo() {
        return compañerismo;
    }

    public void setCompañerismo(int compañerismo) {
        this.compañerismo = compañerismo;
    }

    public int getAcomplamiento() {
        return acomplamiento;
    }

    public void setAcomplamiento(int acomplamiento) {
        this.acomplamiento = acomplamiento;
    }

    public int getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(int rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int getConducta() {
        return conducta;
    }

    public void setConducta(int conducta) {
        this.conducta = conducta;
    }

    public desempenioPsicologicoManagedBean() {
    }

    @PostConstruct

    public void init() {
        asignarDesempenioPsicologico();

    }

    public void asignarDesempenioPsicologico() {

        List<Valoracion> valoraciones = getValoracion().listarValoracion2();

        for (int i = 0; i < valoraciones.size(); i++) {

            switch (i) {

                case 8:
                    compañerismo = valoraciones.get(i).getNota();
                    break;

                case 9:
                    acomplamiento = valoraciones.get(i).getNota();
                    break;

                case 10:
                    rendimiento = valoraciones.get(i).getNota();
                    break;

                case 11:
                    conducta = valoraciones.get(i).getNota();

                default:
            }
            Valoracion v = valoraciones.get(i);

        }
    }
}
