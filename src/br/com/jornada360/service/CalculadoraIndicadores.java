package br.com.jornada360.service;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import br.com.jornada360.model.*;
public class CalculadoraIndicadores {
 public Map<String,Long> porEtapa(List<Jornada> jornadas) {
  Map<String,Long> r = new LinkedHashMap<>();
  for (EtapaJornada e : EtapaJornada.values()) { long n = jornadas.stream().filter(j -> j.etapaAtual() == e).count(); if(n>0) r.put(e.name(),n); }
  return r;
 }
 public Map<String,Long> tempoMedioConclusao(List<Jornada> jornadas) {
  List<Jornada> concluidas = jornadas.stream().filter(j -> j.status()==StatusJornada.CONCLUIDA && j.dataFim()!=null).toList();
  long media = concluidas.isEmpty()?0:Math.round(concluidas.stream().mapToLong(j -> ChronoUnit.DAYS.between(j.dataInicio(),j.dataFim())).average().orElse(0));
  return Map.of("TEMPO_MEDIO_DIAS",media);
 }
}
