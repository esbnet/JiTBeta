package esbdev.com.br.jit_beta.model;

/**
 * Created by edmilson on 05/11/2017.
 */

public class Conta {

    private String Nome;
    private String Email;
    private String Celular;
    private String Senha;


    public Conta(){

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
