package devandroid.gabriel.viaCep.Models;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String uf;

    // === GETTERS =================================================================    public String getTitle() {
    public String getCep() {
        return cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public String getComplemento() {
        return complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public String getUf() {
        return uf;
    }

    // === SETTERS =================================================================    public String getTitle() {

    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }


    //@Override
    //public String toString () {
    //    return
    //}
}


//{
//  "cep": "01001-000",
//  "logradouro": "Praça da Sé",
//  "complemento": "lado ímpar",
//  "bairro": "Sé",
//  "localidade": "São Paulo",
//  "uf": "SP",
//  "ibge": "3550308",
//  "gia": "1004",
//  "ddd": "11",
//  "siafi": "7107"
//}