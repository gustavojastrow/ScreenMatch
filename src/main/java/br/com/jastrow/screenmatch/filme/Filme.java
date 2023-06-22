package br.com.jastrow.screenmatch.filme;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Integer duracao;
    private Integer lancamento;
    private String genero;
    
    public Filme(DadosCadastroFilme dados){
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.lancamento = dados.lancamento();
        this.genero = dados.genero();
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }   

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getDuracao() {
        return duracao;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    public Integer getLancamento() {
        return lancamento;
    }
    public void setLancamento(Integer lancamento) {
        this.lancamento = lancamento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Filme(){
    }

    @Override
    public String toString() {
        return "Filme [nome=" + nome + ", duracao=" + duracao + ", lancamento=" + lancamento + ", genero=" + genero
                + "]";
    }


    public void atualizaDados(DadosAtualizadaFilme dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.lancamento = dados.lancamento();
        this.genero = dados.genero();
    }

}
