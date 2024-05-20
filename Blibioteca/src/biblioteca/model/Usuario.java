package biblioteca.model;

public class Usuario extends Pessoa {
    private int id;

    public Usuario(int id, String nome, String cpf) {
        super(nome, cpf);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}


