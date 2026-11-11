package br.com.jornada360.model;
import java.time.LocalDate;
public record Jornada(String id, String cliente, StatusJornada status, EtapaJornada etapaAtual,
 LocalDate dataInicio, LocalDate dataFim, String motivoInterrupcao, String resultado) {
 public Jornada {
  if (id == null || id.isBlank() || cliente == null || cliente.isBlank()) throw new IllegalArgumentException("ID e cliente são obrigatórios.");
  if (status == null || etapaAtual == null || dataInicio == null) throw new IllegalArgumentException("Status, etapa e data de início são obrigatórios.");
  if (status == StatusJornada.CONCLUIDA && dataFim == null) throw new IllegalArgumentException("Jornada concluída precisa de data final.");
  if (status == StatusJornada.INTERROMPIDA && (motivoInterrupcao == null || motivoInterrupcao.isBlank())) throw new IllegalArgumentException("Jornada interrompida precisa de motivo.");
 }
}
