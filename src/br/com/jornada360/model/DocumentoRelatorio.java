package br.com.jornada360.model;
import java.util.List;
import java.util.Map;
public record DocumentoRelatorio(String titulo, Periodo periodo, int quantidade, Map<String,Long> indicadores, List<String> detalhes) {
 public DocumentoRelatorio { indicadores = Map.copyOf(indicadores); detalhes = List.copyOf(detalhes); }
}
