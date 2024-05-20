package biblioteca.dao;
import biblioteca.model.Livro;
import java.util.List;
import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;

public interface DAO <T>{
	
	    void adicionar(T t);
	    void atualizar(T t);
	    T buscar(int id) throws LivroNaoEncontradoException, UsuarioNaoEncontradoException;
	    void remover(int id) throws LivroNaoEncontradoException, UsuarioNaoEncontradoException;
	    List<T> listarTodos();
	}


