package Main;

import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.service.BibliotecaService;
import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Usuário");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do livro: ");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha

                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();

                    Livro livro = new Livro(idLivro, titulo, autor);
                    bibliotecaService.adicionarLivro(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha

                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o CPF do usuário: ");
                    String cpf = scanner.nextLine();

                    Usuario usuario = new Usuario(idUsuario, nome, cpf);
                    bibliotecaService.adicionarUsuario(usuario);
                    System.out.println("Usuário adicionado com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o ID do livro a ser emprestado: ");
                    int idLivroEmprestimo = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha

                    System.out.print("Digite o ID do usuário: ");
                    int idUsuarioEmprestimo = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha

                    try {
                        bibliotecaService.emprestarLivro(idLivroEmprestimo, idUsuarioEmprestimo);
                        System.out.println("Livro emprestado com sucesso!");
                    } catch (LivroNaoEncontradoException | UsuarioNaoEncontradoException | IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do livro a ser devolvido: ");
                    int idLivroDevolucao = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha

                    try {
                        bibliotecaService.devolverLivro(idLivroDevolucao);
                        System.out.println("Livro devolvido com sucesso!");
                    } catch (LivroNaoEncontradoException | IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}

