package ifba.esboco.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import ifba.esboco.enums.Tipos;
import ifba.esboco.enums.CompEstado;

public class Projeto 
{
    //protected int numProj; //Gerado automaticamente no banco de dados
    protected String titulo;
    protected Tipos tipo;
    protected ArrayList<Componente> componentes = new ArrayList<>();
    protected ArrayList<Aviso> avisos = new ArrayList<>();
    protected ArrayList<Atividade> atividades = new ArrayList<>();
    
    public void cadastro_componente(int lattesId, String nome, String funcao, String estado) {
        try {
            this.componentes.add(new Componente(lattesId, nome, funcao, estado));
        }
        catch(IllegalArgumentException err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }
    
    public void novoAviso(int lattesId, String aviso) {
        if(lattesId != -255) {
            Componente remetente = this.buscaComp(lattesId);
            
            if(remetente.getEstado() == CompEstado.desligado)
                throw new IllegalArgumentException("Componentes desligados não podem emitir aviso!");
            
            this.avisos.add(new Aviso(lattesId, aviso));
        }
        else if(lattesId == -255)
            this.avisos.add(new Aviso(lattesId, aviso));
        //Lattes ID -255 é reservado para os avisos do sistema
    }
    
    public void novaAtividade(String atividade, LocalDate inicio, LocalDate fim) {
        this.atividades.add(new Atividade(atividade, inicio, fim, false));
    }
    
    public void desligarComp(int lattesId) {
        for(Componente componente : this.componentes) {
            if(componente.getLattesId() == lattesId) {
                componente.setEstado("desligado");
                break;
            }
        }
    }
    
    private Componente buscaComp(int lattesId) {
        for(Componente componente : this.componentes) {
            if(componente.getLattesId() == lattesId)
                return componente;
        }
        
        throw new IllegalArgumentException("Componente não encontrado!");
    }

    public Projeto(String titulo, String tipo) {
        this.titulo = titulo;
        this.tipo = Tipos.valueOf(tipo);
    }

    public String getTitulo() {
        return titulo;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public ArrayList<Aviso> getAvisos() {
        return avisos;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }
    
    //Funções para testes
    public void exibirDados() {
        System.out.println("Titulo do projeto: " + this.titulo + "\nTipo de projeto: " + this.tipo.toString());
        System.out.println("Componentes:\n");
        
        for(Componente componente : this.componentes) {
            componente.exibirDados();
        }      
    }
    
    public void exibirAvisos() {
        for(Aviso aviso : this.avisos) {
            Componente rem = this.buscaComp(aviso.getRemetente());
            System.out.println("Aviso Nº ###### \nRemetente: " + rem.getLattesId() + " - " + rem.getNome() + "\nAviso: " + aviso.getAviso() + "\nPublicação: " + aviso.getPublicacao() + "\n");
        }
    }
    
    public void exibirAtividades() {
        for(Atividade atividade : this.atividades) {
            System.out.println("Atividade Nº ###### \nDescricao: " + atividade.getAtividade() + "\nPrazo: " + atividade.getInicio() + " - " + atividade.getFim() + "\nSituacao: " + atividade.getSitucao().toString());
        }
    }
        
}