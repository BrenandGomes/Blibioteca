package biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.model.Livro;

public class LivroDAO implements DAO <Livro> {
	
	private List<Livro> livros = new ArrayList<>();

    @Override
    public void adicionar(Livro livro) {
        livros.add(livro);
    }

    
    public void atualizar(Livro livro) {
        int index = livros.indexOf(livro);
        if (index != -1) {
            livros.set(index, livro);
        }
    }

    
    public Livro buscar(int id) throws LivroNaoEncontradoException {
        return livros.stream()
                .filter(livro -> livro.getId() == id)
                .findFirst()
                .orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado!"));
    }

    
    public void remover(int id) throws LivroNaoEncontradoException {
        Livro livro = buscar(id);
        livros.remove(livro);
    }

    
    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }
}
	
	
	

