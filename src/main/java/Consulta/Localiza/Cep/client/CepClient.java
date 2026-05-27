package Consulta.Localiza.Cep.client;
import Consulta.Localiza.Cep.dto.response.CepDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class CepClient {

    private final RestClient restClient;
    public CepClient() {
        this.restClient = RestClient.builder()
                .baseUrl("http://viacep.com.br/ws")
                .build();
    }

    public CepDto procuraCep(String cep) {
        return restClient.get()
                .uri("/{cep}/json/", cep)
                .retrieve()
                .body(CepDto.class);
    }

}