package com.adsimepac.fisioterapia.service;

import com.adsimepac.fisioterapia.model.Consulta;
import com.adsimepac.fisioterapia.model.RegistroMedicao;
import com.adsimepac.fisioterapia.repository.ConsultaRepository;
import com.adsimepac.fisioterapia.repository.RegistroMedicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistroMedicaoService {

    @Autowired
    private RegistroMedicaoRepository registroMedicaoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<RegistroMedicao> listarTodos() {
        return registroMedicaoRepository.findAll();
    }

    public Optional<RegistroMedicao> buscarPorId(Long id) {
        return registroMedicaoRepository.findById(id);
    }

    public RegistroMedicao salvar(RegistroMedicao registro) {
        return registroMedicaoRepository.save(registro);
    }

    public RegistroMedicao atualizar(Long id, RegistroMedicao novosDados) {
        RegistroMedicao registroExistente = registroMedicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de Medição não encontrado com id: " + id));

        // Atualizar campos PRÉ
        registroExistente.setPressaoArterialPre(novosDados.getPressaoArterialPre());
        registroExistente.setGlicemiaPre(novosDados.getGlicemiaPre());
        registroExistente.setEscalaDorPre(novosDados.getEscalaDorPre());
        registroExistente.setSaturacaoO2Pre(novosDados.getSaturacaoO2Pre());
        registroExistente.setBpmPre(novosDados.getBpmPre());
        registroExistente.setObservacaoPre(novosDados.getObservacaoPre());

        // Atualizar campos PÓS
        registroExistente.setPressaoArterialPos(novosDados.getPressaoArterialPos());
        registroExistente.setGlicemiaPos(novosDados.getGlicemiaPos());
        registroExistente.setEscalaDorPos(novosDados.getEscalaDorPos());
        registroExistente.setSaturacaoO2Pos(novosDados.getSaturacaoO2Pos());
        registroExistente.setBpmPos(novosDados.getBpmPos());
        registroExistente.setObservacaoPos(novosDados.getObservacaoPos());

        return registroMedicaoRepository.save(registroExistente);
    }

    public RegistroMedicao criarParaConsulta(Long consultaId, RegistroMedicao registro) {
        Consulta consulta = consultaRepository.findById(consultaId)
            .orElseThrow(() -> new RuntimeException("Consulta não encontrada com id: " + consultaId));
        
        // Verificar se já existe uma medição para esta consulta
        if (consulta.getMedicao() != null) {
            throw new RuntimeException("Esta consulta já possui uma medição. Use o método de atualização.");
        }
        
        registro.setConsulta(consulta);
        return registroMedicaoRepository.save(registro);
    }

    public void deletar(Long id) {
        registroMedicaoRepository.deleteById(id);
    }

    public List<RegistroMedicao> buscarPorPaciente(Long pacienteId) {
        // Buscar todas as consultas do paciente e retornar suas medições
        List<Consulta> consultas = consultaRepository.findByPacienteIdOrderByDataInicioDesc(pacienteId);
        return consultas.stream()
                .map(Consulta::getMedicao)
                .filter(medicao -> medicao != null)
                .collect(Collectors.toList());
    }

    public Optional<RegistroMedicao> buscarUltimaMedicao(Long pacienteId) {
        List<RegistroMedicao> medicoes = buscarPorPaciente(pacienteId);
        return medicoes.isEmpty() ? Optional.empty() : Optional.of(medicoes.get(0));
    }

    public Optional<RegistroMedicao> buscarPorConsulta(Long consultaId) {
        Optional<Consulta> consultaOpt = consultaRepository.findById(consultaId);
        
        if (consultaOpt.isEmpty()) {
            return Optional.empty();
        }
        
        return Optional.ofNullable(consultaOpt.get().getMedicao());
    }
}
