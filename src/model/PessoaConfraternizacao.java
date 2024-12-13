package model;

public class PessoaConfraternizacao {
    private Pessoa pessoa;
    private Confraternizacao confraternizacao;

    public PessoaConfraternizacao(Pessoa pessoa, Confraternizacao confraternizacao) {
        this.pessoa = pessoa;
        this.confraternizacao = confraternizacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Confraternizacao getConfraternizacao() {
        return confraternizacao;
    }

    public void setConfraternizacao(Confraternizacao confraternizacao) {
        this.confraternizacao = confraternizacao;
    }

    public String listar() {
        return "Participação: " + pessoa.getNome() + " na confraternização " +
                confraternizacao.getDescricao();
    }
}
