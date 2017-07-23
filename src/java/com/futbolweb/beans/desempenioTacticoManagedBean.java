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
@Named(value = "desempenioTacticoManagedBean")
@RequestScoped
public class desempenioTacticoManagedBean {

    @Inject
    private ValoracionManagedBean valoracion;

    private int sucesion;
    private int acompaniamiento;
    private int avance;
    private int mando;

    public ValoracionManagedBean getValoracion() {
        return valoracion;
    }

    public void setValoracion(ValoracionManagedBean valoracion) {
        this.valoracion = valoracion;
    }

    public int getSucesion() {
        return sucesion;
    }

    public void setSucesion(int sucesion) {
        this.sucesion = sucesion;
    }

    public int getAcompaniamiento() {
        return acompaniamiento;
    }

    public void setAcompaniamiento(int acompaniamiento) {
        this.acompaniamiento = acompaniamiento;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getMando() {
        return mando;
    }

    public void setMando(int mando) {
        this.mando = mando;
    }

    public desempenioTacticoManagedBean() {
    }

    @PostConstruct

    public void init() {
        asignarDesempenioTactico();

    }

    public void asignarDesempenioTactico() {

        List<Valoracion> valoraciones = getValoracion().listarValoracion2();

        for (int i = 0; i < valoraciones.size(); i++) {

            switch (i) {

                case 4:
                    sucesion = valoraciones.get(i).getNota();
                    break;

                case 5:
                    acompaniamiento = valoraciones.get(i).getNota();
                    break;

                case 6:
                    avance = valoraciones.get(i).getNota();
                    break;

                case 7:
                    mando = valoraciones.get(i).getNota();

                default:
            }
            Valoracion v = valoraciones.get(i);

        }
    }

}
