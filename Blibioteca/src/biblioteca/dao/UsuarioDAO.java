package biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;
import biblioteca.model.Usuario;

public class UsuarioDAO implements DAO <Usuario>{
	
	private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        int index = usuarios.indexOf(usuario);
        if (index != -1) {
            usuarios.set(index, usuario);
        }
    }

    @Override
    public Usuario buscar(int id) throws UsuarioNaoEncontradoException {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado!"));
    }

    
    public void remover(int id) throws UsuarioNaoEncontradoException {
        Usuario usuario = buscar(id);
        usuarios.remove(usuario);
    }

    
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}

