package com.adsimepac.fisioterapia.controller;

import com.adsimepac.fisioterapia.model.RegistroMedicao;
import com.adsimepac.fisioterapia.service.RegistroMedicaoService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registros")
public class RegistroMedicaoController {

    @Autowired
    private RegistroMedicaoService registroMedicaoService;

    @GetMapping
    public ResponseEntity<List<RegistroMedicao>> listarTodos() {
        List<RegistroMedicao> registros = registroMedicaoService.listarTodos();
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscarPorId(@PathVariable Long id) {
        try {
            Optional<RegistroMedicao> registro = registroMedicaoService.buscarPorId(id);
            
            if (registro.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(converterParaMap(registro.get()));
            
        } catch (Exception e) {
            System.err.println("Erro ao buscar medição: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/consulta/{consultaId}")
    public ResponseEntity<?> criarParaConsulta(
            @PathVariable Long consultaId, 
            @RequestBody RegistroMedicao registro) {
        try {
            RegistroMedicao novoRegistro = registroMedicaoService.criarParaConsulta(consultaId, registro);
            return ResponseEntity.status(HttpStatus.CREATED).body(converterParaMap(novoRegistro));
        } catch (RuntimeException e) {
            System.err.println("Erro ao criar registro de medição: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("erro", e.getMessage()));
        } catch (Exception e) {
            System.err.println("Erro inesperado ao criar registro de medição: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("erro", "Erro interno do servidor"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            registroMedicaoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<RegistroMedicao>> buscarPorPaciente(@PathVariable Long pacienteId) {
        try {
            List<RegistroMedicao> registros = registroMedicaoService.buscarPorPaciente(pacienteId);
            return ResponseEntity.ok(registros);
        } catch (Exception e) {
            System.err.println("Erro ao buscar medições do paciente: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/paciente/{pacienteId}/ultima")
    public ResponseEntity<Map<String, Object>> buscarUltimaMedicao(@PathVariable Long pacienteId) {
        try {
            Optional<RegistroMedicao> registro = registroMedicaoService.buscarUltimaMedicao(pacienteId);
            
            if (registro.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(converterParaMap(registro.get()));
            
        } catch (Exception e) {
            System.err.println("Erro ao buscar última medição: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/consulta/{consultaId}")
    public ResponseEntity<Map<String, Object>> buscarPorConsulta(@PathVariable Long consultaId) {
        try {
            Optional<RegistroMedicao> registro = registroMedicaoService.buscarPorConsulta(consultaId);
            
            if (registro.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(converterParaMap(registro.get()));
            
        } catch (Exception e) {
            System.err.println("Erro ao buscar medição da consulta: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody RegistroMedicao registro) {
        try {
            RegistroMedicao registroAtualizado = registroMedicaoService.atualizar(id, registro);
            return ResponseEntity.ok(converterParaMap(registroAtualizado));
        } catch (RuntimeException e) {
            System.err.println("Erro ao atualizar registro de medição: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", e.getMessage()));
        } catch (Exception e) {
            System.err.println("Erro inesperado ao atualizar registro de medição: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("erro", "Erro interno do servidor"));
        }
    }
    
    // Método auxiliar para converter RegistroMedicao em Map (evita problemas de serialização)
    private Map<String, Object> converterParaMap(RegistroMedicao m) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", m.getId());
        map.put("dataRegistro", m.getDataRegistro() != null ? m.getDataRegistro().toString() : null);
        
        // Medições PRÉ
        map.put("pressaoArterialPre", m.getPressaoArterialPre());
        map.put("glicemiaPre", m.getGlicemiaPre());
        map.put("escalaDorPre", m.getEscalaDorPre());
        map.put("saturacaoO2Pre", m.getSaturacaoO2Pre());
        map.put("bpmPre", m.getBpmPre());
        map.put("observacaoPre", m.getObservacaoPre());
        
        // Medições PÓS
        map.put("pressaoArterialPos", m.getPressaoArterialPos());
        map.put("glicemiaPos", m.getGlicemiaPos());
        map.put("escalaDorPos", m.getEscalaDorPos());
        map.put("saturacaoO2Pos", m.getSaturacaoO2Pos());
        map.put("bpmPos", m.getBpmPos());
        map.put("observacaoPos", m.getObservacaoPos());
        
        return map;
    }
}
