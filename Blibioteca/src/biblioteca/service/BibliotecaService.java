package biblioteca.service;


import biblioteca.dao.LivroDAO;
import biblioteca.dao.UsuarioDAO;
import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;

public class BibliotecaService {
    private LivroDAO livroDAO = new LivroDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void adicionarLivro(Livro livro) {
        livroDAO.adicionar(livro);
    }

    public Livro buscarLivro(int id) throws LivroNaoEncontradoException {
        return livroDAO.buscar(id);
    }

    public void removerLivro(int id) throws LivroNaoEncontradoException {
        livroDAO.remover(id);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarioDAO.adicionar(usuario);
    }

    public Usuario buscarUsuario(int id) throws UsuarioNaoEncontradoException {
        return usuarioDAO.buscar(id);
    }

    public void removerUsuario(int id) throws UsuarioNaoEncontradoException {
        usuarioDAO.remover(id);
    }

    public void emprestarLivro(int livroId, int usuarioId) throws LivroNaoEncontradoException, UsuarioNaoEncontradoException {
        Livro livro = livroDAO.buscar(livroId);
        Usuario usuario = usuarioDAO.buscar(usuarioId);

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            livro.setEmprestadoPara(usuario);
            livroDAO.atualizar(livro);
        } else {
            throw new IllegalStateException("Livro não está disponível para empréstimo.");
        }
    }

    public void devolverLivro(int livroId) throws LivroNaoEncontradoException {
        Livro livro = livroDAO.buscar(livroId);

        if (!livro.isDisponivel()) {
            livro.setDisponivel(true);
            livro.setEmprestadoPara(null);
            livroDAO.atualizar(livro);
        } else {
            throw new IllegalStateException("Livro não está emprestado.");
        }
    }
}


