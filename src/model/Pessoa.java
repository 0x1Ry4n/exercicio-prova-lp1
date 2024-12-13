package model;

import java.util.Scanner;
import java.util.ArrayList;


public class Pessoa {
    private int id = 0;
    private String nome = "";
    private Departamento departamento;
    private ArrayList<PessoaConfraternizacao> participacoes = new ArrayList<>();

    public Pessoa() {
    
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void adicionarConfraternizacao(PessoaConfraternizacao participacao) {
        participacoes.add(participacao);
    }

    public ArrayList<PessoaConfraternizacao> getParticipacoes() {
        return participacoes;
    }

    public void cadastrar(Scanner scanner, ArrayList<Departamento> departamentos) throws Exception {
        do { 
            System.out.println("Digite o id:");
            this.id = scanner.nextInt();
            scanner.nextLine();
        } while(this.id <= 0);

        do {
            System.out.println("Digite o nome da pessoa: ");
            this.nome = scanner.nextLine();
        } while (this.nome.length() < 10 || this.nome.length() > 100);

        do {
            System.out.println("Selecione um Departamento: ");
            System.out.println("Departamentos cadastrados: ");
            
            for (Departamento dep : departamentos) {
                System.out.println(dep.listar());
            }
            
            System.out.println("Digite o id do departamento: ");
            
            int idDepartamento = scanner.nextInt();

            for (Departamento dep : departamentos) {
                if (dep.getId() == idDepartamento) this.departamento = dep;
            }
        } while (this.departamento.getId() == 0);
    }

    public String listar() {
        return "Pessoa: " + id + " - " + nome + " - " + departamento.getDescricao();
    }
}
