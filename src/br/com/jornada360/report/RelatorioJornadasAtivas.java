package br.com.jornada360.report;
import java.util.List;
import br.com.jornada360.model.*;
import br.com.jornada360.repository.RepositorioJornadas;
import br.com.jornada360.service.*;
public class RelatorioJornadasAtivas extends RelatorioJornada {
 public RelatorioJornadasAtivas(RepositorioJornadas r,CalculadoraIndicadores c,FormatadorRelatorio f){super(r,c,f);}
 protected String titulo(){return "Jornadas ativas";}
 protected List<Jornada> selecionar(List<Jornada> js,Periodo p){return js.stream().filter(j->j.status()==StatusJornada.ATIVA&&p.contem(j.dataInicio())).toList();}
}
