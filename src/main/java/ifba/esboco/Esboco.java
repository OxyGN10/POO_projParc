package ifba.esboco;

import ifba.esboco.classes.Projeto;
import java.time.LocalDate;
import java.time.Month;

public class Esboco 
{
    public static void main(String[] args) 
    {
        int numBase = 61557;
        String[] nomes = {"Teste 1", "Teste 2"};
        String[] funcoes = {"lider", "auxiliar"};
        
        Projeto novoProjeto = new Projeto("Projeto de Teste", "PIBIC_af");
        
        for(int i = 0; i < nomes.length; i++) {
            novoProjeto.cadastro_componente(numBase, nomes[i], funcoes[i], "ativo");
            numBase++;
        }
        
        novoProjeto.exibirDados();
        //novoProjeto.desligarComp(61558);
        novoProjeto.exibirDados();
        
        /*novoProjeto.novoAviso(numBase-1, "Teste aviso");
        novoProjeto.exibirAvisos();*/
        
        novoProjeto.novaAtividade("Levantamento do Arcabouço Teórico", LocalDate.of(2026, Month.MARCH, 9), LocalDate.of(2026, Month.APRIL, 9));
        novoProjeto.exibirAtividades();
    }
}
