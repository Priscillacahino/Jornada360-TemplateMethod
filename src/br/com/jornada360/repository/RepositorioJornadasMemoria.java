package br.com.jornada360.repository;
import java.time.LocalDate;
import java.util.List;
import br.com.jornada360.model.*;
public class RepositorioJornadasMemoria implements RepositorioJornadas {
 private final List<Jornada> jornadas = List.of(
  new Jornada("J001","Cliente Alfa",StatusJornada.ATIVA,EtapaJornada.DOCUMENTACAO,LocalDate.of(2026,10,2),null,null,null),
  new Jornada("J002","Cliente Beta",StatusJornada.ATIVA,EtapaJornada.ANALISE,LocalDate.of(2026,10,5),null,null,null),
  new Jornada("J003","Cliente Gama",StatusJornada.ATIVA,EtapaJornada.CADASTRO,LocalDate.of(2026,10,12),null,null,null),
  new Jornada("J004","Cliente Delta",StatusJornada.CONCLUIDA,EtapaJornada.FINALIZADA,LocalDate.of(2026,10,1),LocalDate.of(2026,10,8),null,"Concluída"),
  new Jornada("J005","Cliente Épsilon",StatusJornada.CONCLUIDA,EtapaJornada.FINALIZADA,LocalDate.of(2026,10,4),LocalDate.of(2026,10,14),null,"Concluída"),
  new Jornada("J006","Cliente Zeta",StatusJornada.INTERROMPIDA,EtapaJornada.DOCUMENTACAO,LocalDate.of(2026,10,6),null,"Documentação não enviada",null),
  new Jornada("J007","Cliente Ômega",StatusJornada.INTERROMPIDA,EtapaJornada.ANALISE,LocalDate.of(2026,10,9),null,"Desistência do cliente",null));
 public List<Jornada> listarTodas() { return jornadas; }
}
