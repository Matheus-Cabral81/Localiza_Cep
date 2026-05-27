package Consulta.Localiza.Cep.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "LocalizaCEP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CepModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String logradouro;

    @Column
    private String complemento;

    @Column
    private String unidade;

    @Column
    private String bairro;

    @Column(nullable = false)
    private String localidade;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String regiao;

    @Column(nullable = false)
    private String ibge;

    @Column
    private String gia;

    @Column(nullable = false)
    private String ddd;

    @Column(nullable = false)
    private String siafi;

    @Column(name = "consultado_em")
    private LocalDateTime consultadoEm = LocalDateTime.now();
}