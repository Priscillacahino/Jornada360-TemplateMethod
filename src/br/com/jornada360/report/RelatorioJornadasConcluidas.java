package br.com.jornada360.report;
import java.util.List;
import java.util.Map;
import br.com.jornada360.model.*;
import br.com.jornada360.repository.RepositorioJornadas;
import br.com.jornada360.service.*;
public class RelatorioJornadasConcluidas extends RelatorioJornada {
 // Inicializa o relatório com os serviços compartilhados.
 public RelatorioJornadasConcluidas(RepositorioJornadas r,CalculadoraIndicadores c,FormatadorRelatorio f){super(r,c,f);}
 // Identifica o tipo de relatório na saída.
 protected String titulo(){return "Jornadas concluídas";}
 // Filtra jornadas pelo status e período correspondente.
 protected List<Jornada> selecionar(List<Jornada> js,Periodo p){return js.stream().filter(j->j.status()==StatusJornada.CONCLUIDA&&p.contem(j.dataFim())).toList();}
 // Calcula o indicador específico de tempo médio de conclusão.
 protected Map<String,Long> calcularIndicadores(List<Jornada> js){return calculadora().tempoMedioConclusao(js);}
 // Apresenta os detalhes específicos deste tipo de jornada.
 protected List<String> montarDetalhes(List<Jornada> js){return js.stream().map(j->j.id()+" | "+j.cliente()+" | Início: "+j.dataInicio()+" | Conclusão: "+j.dataFim()+" | Resultado: "+j.resultado()).toList();}
}
