package br.com.jornada360.report;
import java.util.List;
import br.com.jornada360.model.*;
import br.com.jornada360.repository.RepositorioJornadas;
import br.com.jornada360.service.*;
public class RelatorioJornadasInterrompidas extends RelatorioJornada {
 public RelatorioJornadasInterrompidas(RepositorioJornadas r,CalculadoraIndicadores c,FormatadorRelatorio f){super(r,c,f);}
 protected String titulo(){return "Jornadas interrompidas";}
 protected List<Jornada> selecionar(List<Jornada> js,Periodo p){return js.stream().filter(j->j.status()==StatusJornada.INTERROMPIDA&&p.contem(j.dataInicio())).toList();}
 protected List<String> montarDetalhes(List<Jornada> js){return js.stream().map(j->j.id()+" | "+j.cliente()+" | Etapa: "+j.etapaAtual()+" | Motivo: "+j.motivoInterrupcao()).toList();}
}
