package com.adsimepac.fisioterapia.dto;

import java.time.LocalDateTime;

public class MedicaoDTO {
    private Long id;
    
    // Medições PRÉ
    private String pressaoArterialPre;
    private String glicemiaPre;
    private String escalaDorPre;
    private String saturacaoO2Pre;
    private String bpmPre;
    private String observacaoPre;
    
    // Medições PÓS
    private String pressaoArterialPos;
    private String glicemiaPos;
    private String escalaDorPos;
    private String saturacaoO2Pos;
    private String bpmPos;
    private String observacaoPos;
    
    private LocalDateTime dataRegistro;

    // Construtor vazio
    public MedicaoDTO() {
    }

    // Construtor completo
    public MedicaoDTO(Long id, 
                     String pressaoArterialPre, String glicemiaPre, String escalaDorPre, 
                     String saturacaoO2Pre, String bpmPre, String observacaoPre,
                     String pressaoArterialPos, String glicemiaPos, String escalaDorPos, 
                     String saturacaoO2Pos, String bpmPos, String observacaoPos,
                     LocalDateTime dataRegistro) {
        this.id = id;
        this.pressaoArterialPre = pressaoArterialPre;
        this.glicemiaPre = glicemiaPre;
        this.escalaDorPre = escalaDorPre;
        this.saturacaoO2Pre = saturacaoO2Pre;
        this.bpmPre = bpmPre;
        this.observacaoPre = observacaoPre;
        this.pressaoArterialPos = pressaoArterialPos;
        this.glicemiaPos = glicemiaPos;
        this.escalaDorPos = escalaDorPos;
        this.saturacaoO2Pos = saturacaoO2Pos;
        this.bpmPos = bpmPos;
        this.observacaoPos = observacaoPos;
        this.dataRegistro = dataRegistro;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Getters e Setters PRÉ
    public String getPressaoArterialPre() { return pressaoArterialPre; }
    public void setPressaoArterialPre(String pressaoArterialPre) { this.pressaoArterialPre = pressaoArterialPre; }

    public String getGlicemiaPre() { return glicemiaPre; }
    public void setGlicemiaPre(String glicemiaPre) { this.glicemiaPre = glicemiaPre; }

    public String getEscalaDorPre() { return escalaDorPre; }
    public void setEscalaDorPre(String escalaDorPre) { this.escalaDorPre = escalaDorPre; }

    public String getSaturacaoO2Pre() { return saturacaoO2Pre; }
    public void setSaturacaoO2Pre(String saturacaoO2Pre) { this.saturacaoO2Pre = saturacaoO2Pre; }

    public String getBpmPre() { return bpmPre; }
    public void setBpmPre(String bpmPre) { this.bpmPre = bpmPre; }

    public String getObservacaoPre() { return observacaoPre; }
    public void setObservacaoPre(String observacaoPre) { this.observacaoPre = observacaoPre; }

    // Getters e Setters PÓS
    public String getPressaoArterialPos() { return pressaoArterialPos; }
    public void setPressaoArterialPos(String pressaoArterialPos) { this.pressaoArterialPos = pressaoArterialPos; }

    public String getGlicemiaPos() { return glicemiaPos; }
    public void setGlicemiaPos(String glicemiaPos) { this.glicemiaPos = glicemiaPos; }

    public String getEscalaDorPos() { return escalaDorPos; }
    public void setEscalaDorPos(String escalaDorPos) { this.escalaDorPos = escalaDorPos; }

    public String getSaturacaoO2Pos() { return saturacaoO2Pos; }
    public void setSaturacaoO2Pos(String saturacaoO2Pos) { this.saturacaoO2Pos = saturacaoO2Pos; }

    public String getBpmPos() { return bpmPos; }
    public void setBpmPos(String bpmPos) { this.bpmPos = bpmPos; }

    public String getObservacaoPos() { return observacaoPos; }
    public void setObservacaoPos(String observacaoPos) { this.observacaoPos = observacaoPos; }

    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
}
