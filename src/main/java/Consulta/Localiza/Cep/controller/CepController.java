package Consulta.Localiza.Cep.controller;
import Consulta.Localiza.Cep.client.CepClient;
import Consulta.Localiza.Cep.dto.response.CepDto;
import Consulta.Localiza.Cep.model.CepModel;
import Consulta.Localiza.Cep.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Consulta.Localiza.Cep.model.CepModel;
import java.util.List;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    private final CepService cepService;
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<CepModel> buscar(@PathVariable String cep) {
        CepModel resultado = cepService.buscar(cep);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/historico")
    public ResponseEntity<List<CepModel>> listarHistorico() {
        return ResponseEntity.ok(cepService.listarHistorico());
    }
}