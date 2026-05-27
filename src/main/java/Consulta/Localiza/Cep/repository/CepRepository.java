package Consulta.Localiza.Cep.repository;

import Consulta.Localiza.Cep.model.CepModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CepRepository extends JpaRepository<CepModel, Long>{
    List<CepModel> findBycep(String cep);
}