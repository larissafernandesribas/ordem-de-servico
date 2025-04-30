/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.kge.eti.OSApiApplication.domain.service;

import br.kge.eti.OSApiApplication.StatusOrdemServico;
import br.kge.eti.OSApiApplication.domain.model.OrdemServico;
import br.kge.eti.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesideva
 */

@Service
public class OrdemServicoService {
    
    
@Autowired
private OrdemServicoRepository ordemServicoRepository;

public OrdemServico criar(OrdemServico ordemServico) {
    ordemServico.setStatus(StatusOrdemServico.ABERTA);
    ordemServico.setDataAbertura(LocalDateTime.now());
    
    return ordemServicoRepository.save(ordemServico);
}

public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

public OrdemServico findById(Long id) {
        return ordemServicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada com id: " + id));
    }

    public OrdemServico atualizar(Long id, OrdemServico ordemAtualizada) {
        OrdemServico existente = findById(id); // garante que existe

        existente.setDescricao(ordemAtualizada.getDescricao());
        existente.setStatus(ordemAtualizada.getStatus());
        existente.setDataFinalizacao(ordemAtualizada.getDataFinalizacao());

        return ordemServicoRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!ordemServicoRepository.existsById(id)) {
            throw new RuntimeException("Ordem de serviço não encontrada com id: " + id);
        }
        ordemServicoRepository.deleteById(id);
    }


}
