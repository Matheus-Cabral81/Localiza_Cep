package Consulta.Localiza.Cep.exception;

public class CepInvalidoException extends RuntimeException{
    public CepInvalidoException(String cep){
        super("Cep com letras" + cep);
    }
}

