package br.com.jornada360.service;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import br.com.jornada360.model.DocumentoRelatorio;
public class FormatadorRelatorio {
 private static final DateTimeFormatter DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 public String formatar(DocumentoRelatorio d) {
  StringBuilder s = new StringBuilder();
  s.append("\n========== ").append(d.titulo()).append(" ==========\n");
  s.append("Período: ").append(d.periodo().inicio().format(DATA)).append(" a ").append(d.periodo().fim().format(DATA)).append("\n");
  s.append("Total: ").append(d.quantidade()).append("\n");
  if(!d.indicadores().isEmpty()) { s.append("\nIndicadores:\n"); for(Map.Entry<String,Long> e:d.indicadores().entrySet()) s.append("- ").append(e.getKey()).append(": ").append(e.getValue()).append("\n"); }
  s.append("\nDetalhes:\n");
  if(d.detalhes().isEmpty()) s.append("Nenhum registro encontrado no período.\n"); else d.detalhes().forEach(x -> s.append("- ").append(x).append("\n"));
  return s.append("==============================================\n").toString();
 }
}
