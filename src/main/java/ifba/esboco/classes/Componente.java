package ifba.esboco.classes;

import java.time.LocalDate;
import ifba.esboco.enums.CompEstado;

public class Componente 
{
    protected int lattesId;
    protected String nome;
    protected String funcao;
    protected LocalDate entrada;
    protected LocalDate saida; 
    protected CompEstado estado;
    
    public void setNome (String nome) {
        if(nome.length() > 128)
            throw new IllegalArgumentException("O nome não pode ultrapassar 128 caracteres");
        
        this.nome = nome;
    }
    
    public void setEstado(String estado) {        
        this.estado = CompEstado.valueOf(estado);
        
        if(this.estado == CompEstado.desligado)
            this.saida = LocalDate.now();
    }
    
    public void setLattesId(int lattesId) {
        if(lattesId < 0)
            throw new IllegalArgumentException("Id Lattes incorreto!");
        
        this.lattesId = lattesId;
    }

    public Componente(int lattesId, String nome, String funcao, String estado) {
        this.funcao = funcao;
        this.entrada = LocalDate.now(); //Valor definido para teste, na aplicação final deverá ser definido em nível de banco de dados
        
        this.setNome(nome);
        this.setEstado(estado);
        this.setLattesId(lattesId);
    }

    public int getLattesId() {
        return lattesId;
    }

    public String getNome() {
        return nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getSaida() {
        return saida;
    }

    public CompEstado getEstado() {
        return estado;
    }   
    
    //Função de testes
    public void exibirDados() {
        if(this.estado != CompEstado.desligado)
            System.out.println("Lattes ID: " + this.lattesId + "\nNome: " + this.nome + "\nFunção: " + this.funcao + "\nEntrada: " + this.entrada + "\nEstado: " + this.estado.toString() + "\n");
        else
            System.out.println("Lattes ID: " + this.lattesId + "\nNome: " + this.nome + "\nFunção: " + this.funcao + "\nEntrada: " + this.entrada + "\nSaída: " + this.saida + "\nEstado: desligado\n");
    }
}
