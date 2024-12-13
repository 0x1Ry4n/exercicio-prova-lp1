import java.util.ArrayList;
import java.util.Scanner;

import model.Departamento;
import model.Pessoa;
import model.Confraternizacao;
import model.PessoaConfraternizacao;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Departamento> listaDepartamentos = new ArrayList<>();
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        ArrayList<Confraternizacao> listaConfraternizacoes = new ArrayList<>();
        ArrayList<PessoaConfraternizacao> listaPessoaConfraternizacoes = new ArrayList<>();

        int opcao = 0; 
        
        Scanner scanner = new Scanner(System.in);
        do { 
            System.out.printf("""
            \n\n---MENU---
            1 - Cadastrar Pessoa
            2 - Cadastrar Confraternização
            3 - Cadastrar Departamento
            4 - Cadastrar Pessoa na Confraternização
            11 - Listar Pessoas
            12 - Listar Confraternizações c/ Pessoas
            13 - Listar Departamentos 
            99 - Sair
            \n
            """);

            System.out.println("Digite uma opção válida: ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1: 
                    if (listaDepartamentos.isEmpty()) {
                        System.out.println("Para cadastrar uma pessoa é necessário ao menos um departamento!");
                        break;
                    }

                    Pessoa pessoa = new Pessoa();
                    pessoa.cadastrar(scanner, listaDepartamentos);
                    listaPessoas.add(pessoa);
                    break;

                case 2: 
                    Confraternizacao confraternizacao = new Confraternizacao();
                    confraternizacao.cadastrar(scanner);
                    listaConfraternizacoes.add(confraternizacao);
                    break;

                case 3: 
                    Departamento departamento = new Departamento();
                    departamento.cadastrar(scanner);
                    listaDepartamentos.add(departamento);
                    break;

                case 4:     
                    if (listaPessoas.isEmpty() || listaConfraternizacoes.isEmpty()) {
                        System.out.println("Não há pessoas ou confraternizações cadastradas para realizar este cadastro.");
                        break;
                    }
                    System.out.println("Digite o ID da pessoa que deseja cadastrar na confraternização: ");
                    int pessoaId = scanner.nextInt();
                    System.out.println("Digite o ID da confraternização: ");
                    int confraternizacaoId = scanner.nextInt();

                    Pessoa pessoaSelecionada = null;
                    for (Pessoa p : listaPessoas) {
                        if (p.getId() == pessoaId) {
                            pessoaSelecionada = p;
                            break;
                        }
                    }

                    Confraternizacao confraternizacaoSelecionada = null;
                    for (Confraternizacao c : listaConfraternizacoes) {
                        if (c.getId() == confraternizacaoId) {
                            confraternizacaoSelecionada = c;
                            break;
                        }
                    }

                    if (pessoaSelecionada != null && confraternizacaoSelecionada != null) {
                        PessoaConfraternizacao pessoaConfraternizacao = new PessoaConfraternizacao(pessoaSelecionada, confraternizacaoSelecionada);
                        listaPessoaConfraternizacoes.add(pessoaConfraternizacao);
                        System.out.println("Pessoa cadastrada na confraternização com sucesso!");
                    } else {
                        System.out.println("Pessoa ou Confraternização não encontrada.");
                    }
                    break;

                case 11: 
                    for (Pessoa p : listaPessoas) {
                        System.out.println(p.listar());
                    }
                    break;

                case 12: 
                    for (Confraternizacao c : listaConfraternizacoes) {
                        System.out.println(c.listar());
                        for (PessoaConfraternizacao pc : listaPessoaConfraternizacoes) {
                            if (pc.getConfraternizacao().equals(c)) {
                                System.out.println("\t" + pc.getPessoa().listar());
                            }
                        }
                    }
                    break;

                case 13:  
                    for (Departamento d : listaDepartamentos) {
                        System.out.println(d.listar());
                    }
                    break;

                case 99: 
                    System.exit(0);
                    break;
                default: 
                    System.out.println("Digite uma opção válida!");
                    break;
            }

        } while (opcao != 99);

        scanner.close();
    }
}
