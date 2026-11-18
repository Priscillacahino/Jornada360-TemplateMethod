package br.com.jornada360.report;
import java.util.List;
import br.com.jornada360.model.*;
import br.com.jornada360.repository.RepositorioJornadas;
import br.com.jornada360.service.*;
public class RelatorioJornadasAtivas extends RelatorioJornada {
 // Inicializa o relatório com os serviços compartilhados.
 public RelatorioJornadasAtivas(RepositorioJornadas r,CalculadoraIndicadores c,FormatadorRelatorio f){super(r,c,f);}
 // Identifica o tipo de relatório na saída.
 protected String titulo(){return "Jornadas ativas";}
 // Filtra jornadas pelo status e período correspondente.
 protected List<Jornada> selecionar(List<Jornada> js,Periodo p){return js.stream().filter(j->j.status()==StatusJornada.ATIVA&&p.contem(j.dataInicio())).toList();}
}
