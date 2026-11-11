package br.com.jornada360.testes;
import java.time.LocalDate;
import br.com.jornada360.model.Periodo;
import br.com.jornada360.repository.*;
import br.com.jornada360.report.*;
import br.com.jornada360.service.*;
public class TestesRelatorios {
 public static void main(String[] args) {
  var r=new RepositorioJornadasMemoria(); var c=new CalculadoraIndicadores(); var f=new FormatadorRelatorio();
  var p=new Periodo(LocalDate.of(2026,10,1),LocalDate.of(2026,10,31));
  String a=new RelatorioJornadasAtivas(r,c,f).gerar(p);
  String co=new RelatorioJornadasConcluidas(r,c,f).gerar(p);
  String i=new RelatorioJornadasInterrompidas(r,c,f).gerar(p);
  verificar(a.contains("Total: 3"),"Esperadas três jornadas ativas.");
  verificar(co.contains("Total: 2"),"Esperadas duas jornadas concluídas.");
  verificar(co.contains("TEMPO_MEDIO_DIAS: 9"),"Tempo médio esperado: nove dias.");
  verificar(i.contains("Total: 2"),"Esperadas duas jornadas interrompidas.");
  verificar(i.contains("Documentação não enviada")&&i.contains("Desistência do cliente"),"Motivos de interrupção ausentes.");
  System.out.println("Todos os testes foram concluídos com sucesso.");
 }
 private static void verificar(boolean ok,String msg){if(!ok)throw new AssertionError(msg);}
}
