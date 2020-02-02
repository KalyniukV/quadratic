package com.test.quadratic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "equation")
public class Equation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "val_A", nullable = false, precision=10, scale=3)
    private BigDecimal valA;

    @Column(name = "val_B", nullable = false, precision=10, scale=3)
    private BigDecimal valB;

    @Column(name = "val_C", nullable = false, precision=10, scale=3)
    private BigDecimal valC;

    @Column(name = "res_x1", nullable = false, precision=10, scale=3)
    private BigDecimal resX1;

    @Column(name = "res_x2", precision=10, scale=3)
    private BigDecimal resX2;

    public Equation() {
    }

    public Equation(BigDecimal valA, BigDecimal valB, BigDecimal valC, BigDecimal resX1, BigDecimal resX2) {
        this.valA = valA;
        this.valB = valB;
        this.valC = valC;
        this.resX1 = resX1;
        this.resX2 = resX2;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValA() {
        return valA;
    }

    public void setValA(BigDecimal valA) {
        this.valA = valA;
    }

    public BigDecimal getValB() {
        return valB;
    }

    public void setValB(BigDecimal valB) {
        this.valB = valB;
    }

    public BigDecimal getValC() {
        return valC;
    }

    public void setValC(BigDecimal valC) {
        this.valC = valC;
    }

    public BigDecimal getResX1() {
        return resX1;
    }

    public void setResX1(BigDecimal resX1) {
        this.resX1 = resX1;
    }

    public BigDecimal getResX2() {
        return resX2;
    }

    public void setResX2(BigDecimal resX2) {
        this.resX2 = resX2;
    }
}
