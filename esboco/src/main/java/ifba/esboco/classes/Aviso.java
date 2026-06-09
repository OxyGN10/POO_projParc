package ifba.esboco.classes;

import java.time.LocalDateTime;

public class Aviso 
{
    //protected int codAviso; //Gerado automaticamente no banco de dados
    protected int remetente;
    protected LocalDateTime publicacao;
    protected String aviso;

    public Aviso(int remetente, String aviso) {
        this.remetente = remetente;
        this.aviso = aviso;
        
        this.publicacao = LocalDateTime.now();
    }   

    public int getRemetente() {
        return remetente;
    }

    public LocalDateTime getPublicacao() {
        return publicacao;
    }

    public String getAviso() {
        return aviso;
    }
    
    
}