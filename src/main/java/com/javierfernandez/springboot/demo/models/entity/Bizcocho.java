package com.javierfernandez.springboot.demo.models.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="bizcochos")
public class Bizcocho {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroraciones;
    private Integer votos;


    private String descripcion;
    private String intolerancias;





    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @PrePersist
    public void prePersist(){
        fecha= new Date();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroraciones() {
        return numeroraciones;
    }

    public void setNumeroraciones(Integer numeroraciones) {
        this.numeroraciones = numeroraciones;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIntoleracias() {
        return intoleracias;
    }

    public void setIntoleracias(String intoleracias) {
        this.intoleracias = intoleracias;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
