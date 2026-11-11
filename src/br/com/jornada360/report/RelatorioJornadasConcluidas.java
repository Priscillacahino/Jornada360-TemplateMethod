package br.com.jornada360.report;
import java.util.List;
import java.util.Map;
import br.com.jornada360.model.*;
import br.com.jornada360.repository.RepositorioJornadas;
import br.com.jornada360.service.*;
public class RelatorioJornadasConcluidas extends RelatorioJornada {
 public RelatorioJornadasConcluidas(RepositorioJornadas r,CalculadoraIndicadores c,FormatadorRelatorio f){super(r,c,f);}
 protected String titulo(){return "Jornadas concluídas";}
 protected List<Jornada> selecionar(List<Jornada> js,Periodo p){return js.stream().filter(j->j.status()==StatusJornada.CONCLUIDA&&p.contem(j.dataFim())).toList();}
 protected Map<String,Long> calcularIndicadores(List<Jornada> js){return calculadora().tempoMedioConclusao(js);}
 protected List<String> montarDetalhes(List<Jornada> js){return js.stream().map(j->j.id()+" | "+j.cliente()+" | Início: "+j.dataInicio()+" | Conclusão: "+j.dataFim()+" | Resultado: "+j.resultado()).toList();}
}
