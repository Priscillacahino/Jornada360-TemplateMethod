package br.com.jornada360.report;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import br.com.jornada360.model.*;
import br.com.jornada360.repository.RepositorioJornadas;
import br.com.jornada360.service.*;
public abstract class RelatorioJornada {
 private final RepositorioJornadas repositorio;
 private final CalculadoraIndicadores calculadora;
 private final FormatadorRelatorio formatador;
 protected RelatorioJornada(RepositorioJornadas r, CalculadoraIndicadores c, FormatadorRelatorio f) {
  repositorio=Objects.requireNonNull(r); calculadora=Objects.requireNonNull(c); formatador=Objects.requireNonNull(f);
 }
 // Template Method: fixa a sequência de geração e preserva o algoritmo comum.
 public final String gerar(Periodo periodo) {
  Objects.requireNonNull(periodo,"O período é obrigatório.");
  List<Jornada> base=repositorio.listarTodas();
  List<Jornada> selecionadas=selecionar(base,periodo);
  Map<String,Long> indicadores=calcularIndicadores(selecionadas);
  List<String> detalhes=montarDetalhes(selecionadas);
  return formatador.formatar(new DocumentoRelatorio(titulo(),periodo,selecionadas.size(),indicadores,detalhes));
 }
 protected abstract String titulo();
 protected abstract List<Jornada> selecionar(List<Jornada> jornadas, Periodo periodo);
 protected Map<String,Long> calcularIndicadores(List<Jornada> jornadas) { return calculadora.porEtapa(jornadas); }
 protected List<String> montarDetalhes(List<Jornada> jornadas) {
  return jornadas.stream().map(j -> j.id()+" | "+j.cliente()+" | Etapa: "+j.etapaAtual()).toList();
 }
 protected CalculadoraIndicadores calculadora() { return calculadora; }
}
