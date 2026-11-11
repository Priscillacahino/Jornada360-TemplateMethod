package br.com.jornada360.model;
import java.time.LocalDate;
public record Periodo(LocalDate inicio, LocalDate fim) {
 public Periodo {
  if (inicio == null || fim == null) throw new IllegalArgumentException("As datas do período são obrigatórias.");
  if (fim.isBefore(inicio)) throw new IllegalArgumentException("A data final não pode ser anterior à inicial.");
 }
 public boolean contem(LocalDate data) { return data != null && !data.isBefore(inicio) && !data.isAfter(fim); }
}
