package model;

import java.util.Scanner;

public class Departamento implements Cadastro {
    private int id = 0; 
    private String descricao = "";

    public Departamento() { }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void cadastrar(Scanner scanner) throws Exception {
        do { 
            System.out.println("Digite o id:");
            this.id = scanner.nextInt();
            scanner.nextLine();
        } while(this.id <= 0);

        do {
            System.out.println("Digite a descrição: ");
            this.descricao = scanner.nextLine();
        } while (this.descricao.length() < 10 || this.descricao.length() > 100);
    }

    @Override 
    public String listar() {
        return "Departamento: " + this.id + " - " + this.descricao;
    }
}
