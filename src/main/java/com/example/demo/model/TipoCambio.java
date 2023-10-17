package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "tipocambio")
public class TipoCambio {

    //La API debe devolver el “monto”, “monto con tipo de cambio”, “moneda origen”, “moneda destino” y “tipo de cambio”.
    private Integer id;
    private float monto;
    private float montoConTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private float tipoDeCambio;

    public TipoCambio(){

    }

    public TipoCambio(float monto, float montoConTipoCambio, String monedaOrigen, String monedaDestino, float tipoDeCambio){
        this.monto = monto;
        this.montoConTipoCambio = montoConTipoCambio;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoDeCambio = tipoDeCambio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "monto", nullable = false)
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Column(name = "monto_con_tipo_cambio", nullable = false)
    public float getMontoConTipoCambio() {
        return montoConTipoCambio;
    }

    public void setMontoConTipoCambio(float montoConTipoCambio) {
        this.montoConTipoCambio = montoConTipoCambio;
    }

    @Column(name = "moneda_origen", nullable = false)
    public String getMonedaOrigen() {
        return monedaOrigen;
    }
    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    @Column(name = "moneda_destino", nullable = false)
    public String getMonedaDestino() {
        return monedaDestino;
    }
    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    @Column(name = "tipo_de_cambio", nullable = false)
    public float getTipoDeCambio() {
        return tipoDeCambio;
    }

    public void setTipoDeCambio(float tipoDeCambio) {
        this.tipoDeCambio = tipoDeCambio;
    }

    @Override
    public String toString() {
        return "TipoCambio [" +
                "id=" + id +
                ", monto=" + monto +
                ", monto_con_tipo_cambio=" + montoConTipoCambio +
                ", moneda_origen=" + monedaOrigen +
                ", moneda_destino=" + monedaDestino +
                ", tipo_de_cambio=" + tipoDeCambio +
                "]";
    }
}
