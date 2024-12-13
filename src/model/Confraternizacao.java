package model;

import java.util.Scanner;
import java.util.ArrayList;

public class Confraternizacao implements Cadastro {
    private int id; 
    private String data; 
    private String hora; 
    private String descricao;
    private ArrayList<PessoaConfraternizacao> participantes = new ArrayList<>();

    public Confraternizacao() { }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    } 

    public String getHora() {
        return this.hora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void adicionarPessoa(PessoaConfraternizacao participacao) {
        participantes.add(participacao);
    }

    public ArrayList<PessoaConfraternizacao> getParticipantes() {
        return participantes;
    }

    @Override
    public void cadastrar(Scanner scanner) throws Exception {
        do { 
            System.out.println("Digite o id:");
            this.id = scanner.nextInt();
            scanner.nextLine();
        } while(this.id <= 0);

        do {
            System.out.println("Digite a data(dd/MM/yyyy): ");
            this.data = scanner.nextLine();
        } while (this.data.length() < 9);

        do {
            System.out.println("Digite a hora (HH:mm): ");
            this.data = scanner.nextLine();
        } while (this.data.length() < 5);


        do {
            System.out.println("Digite a descrição: ");
            this.descricao = scanner.nextLine();
        } while (this.descricao.length() < 10 || this.descricao.length() > 100);
    }

    @Override
    public String listar() {
        return "Confraternizacao: " + this.id + " - " + this.data + " " + this.hora + " - " + this.descricao;
    }

}

