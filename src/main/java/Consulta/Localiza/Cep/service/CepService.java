package Consulta.Localiza.Cep.service;

import Consulta.Localiza.Cep.client.CepClient;
import Consulta.Localiza.Cep.dto.response.CepDto;
import Consulta.Localiza.Cep.exception.CepInvalidoException;
import Consulta.Localiza.Cep.exception.CepNotFoundException;
import Consulta.Localiza.Cep.model.CepModel;
import Consulta.Localiza.Cep.repository.CepRepository;
import org.springframework.stereotype.Service;
import Consulta.Localiza.Cep.exception.CepNotFoundException;

import java.util.List;

@Service
public class CepService {

    private final CepClient cepClient;
    private final CepRepository cepRepository;

    public CepService(CepClient cepClient, CepRepository cepRepository) {
        this.cepClient = cepClient;
        this.cepRepository = cepRepository;
    }

    public CepModel buscar(String cep) {

        if (cep == null || !cep.matches("\\d{8}")){
            throw new CepInvalidoException(cep);
        }

        CepDto dto = cepClient.procuraCep(cep);

        if (dto == null || dto.getCep() == null){
            throw new CepNotFoundException(cep);
        }

        CepModel entity = new CepModel();
        entity.setCep(dto.getCep());
        entity.setLogradouro(dto.getLogradouro());
        entity.setComplemento(dto.getComplemento());
        entity.setUnidade(dto.getUnidade());
        entity.setBairro(dto.getBairro());
        entity.setLocalidade(dto.getLocalidade());
        entity.setUf(dto.getUf());
        entity.setEstado(dto.getEstado());
        entity.setRegiao(dto.getRegiao());
        entity.setIbge(dto.getIbge());
        entity.setGia(dto.getGia());
        entity.setDdd(dto.getDdd());
        entity.setSiafi(dto.getSiafi());

        CepModel saved = cepRepository.save(entity);
        return saved;
    }

    public List<CepModel> listarHistorico() {
        return cepRepository.findAll();
    }

}