package com.adsimepac.fisioterapia.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "registros_medicao")
public class RegistroMedicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"medicao"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consulta_id", nullable = false, unique = true)
    private Consulta consulta;

    @Column(name = "data_registro", nullable = false)
    private LocalDateTime dataRegistro;

    // Medições PRÉ consulta
    @Column(name = "pressao_arterial_pre")
    private String pressaoArterialPre;

    @Column(name = "glicemia_pre")
    private String glicemiaPre;

    @Column(name = "escala_dor_pre")
    private String escalaDorPre;

    @Column(name = "saturacao_o2_pre")
    private String saturacaoO2Pre;

    @Column(name = "bpm_pre")
    private String bpmPre;

    @Column(name = "observacao_pre", columnDefinition = "TEXT")
    private String observacaoPre;

    // Medições PÓS consulta
    @Column(name = "pressao_arterial_pos")
    private String pressaoArterialPos;

    @Column(name = "glicemia_pos")
    private String glicemiaPos;

    @Column(name = "escala_dor_pos")
    private String escalaDorPos;

    @Column(name = "saturacao_o2_pos")
    private String saturacaoO2Pos;

    @Column(name = "bpm_pos")
    private String bpmPos;

    @Column(name = "observacao_pos", columnDefinition = "TEXT")
    private String observacaoPos;

    // Construtores
    public RegistroMedicao() {
        this.dataRegistro = LocalDateTime.now();
    }

    public RegistroMedicao(Consulta consulta) {
        this.consulta = consulta;
        this.dataRegistro = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    // Getters e Setters PRÉ
    public String getPressaoArterialPre() {
        return pressaoArterialPre;
    }

    public void setPressaoArterialPre(String pressaoArterialPre) {
        this.pressaoArterialPre = pressaoArterialPre;
    }

    public String getGlicemiaPre() {
        return glicemiaPre;
    }

    public void setGlicemiaPre(String glicemiaPre) {
        this.glicemiaPre = glicemiaPre;
    }

    public String getEscalaDorPre() {
        return escalaDorPre;
    }

    public void setEscalaDorPre(String escalaDorPre) {
        this.escalaDorPre = escalaDorPre;
    }

    public String getSaturacaoO2Pre() {
        return saturacaoO2Pre;
    }

    public void setSaturacaoO2Pre(String saturacaoO2Pre) {
        this.saturacaoO2Pre = saturacaoO2Pre;
    }

    public String getBpmPre() {
        return bpmPre;
    }

    public void setBpmPre(String bpmPre) {
        this.bpmPre = bpmPre;
    }

    public String getObservacaoPre() {
        return observacaoPre;
    }

    public void setObservacaoPre(String observacaoPre) {
        this.observacaoPre = observacaoPre;
    }

    // Getters e Setters PÓS
    public String getPressaoArterialPos() {
        return pressaoArterialPos;
    }

    public void setPressaoArterialPos(String pressaoArterialPos) {
        this.pressaoArterialPos = pressaoArterialPos;
    }

    public String getGlicemiaPos() {
        return glicemiaPos;
    }

    public void setGlicemiaPos(String glicemiaPos) {
        this.glicemiaPos = glicemiaPos;
    }

    public String getEscalaDorPos() {
        return escalaDorPos;
    }

    public void setEscalaDorPos(String escalaDorPos) {
        this.escalaDorPos = escalaDorPos;
    }

    public String getSaturacaoO2Pos() {
        return saturacaoO2Pos;
    }

    public void setSaturacaoO2Pos(String saturacaoO2Pos) {
        this.saturacaoO2Pos = saturacaoO2Pos;
    }

    public String getBpmPos() {
        return bpmPos;
    }

    public void setBpmPos(String bpmPos) {
        this.bpmPos = bpmPos;
    }

    public String getObservacaoPos() {
        return observacaoPos;
    }

    public void setObservacaoPos(String observacaoPos) {
        this.observacaoPos = observacaoPos;
    }
}
