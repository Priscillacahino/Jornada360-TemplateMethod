package br.com.jornada360.app;
import java.time.LocalDate;
import java.util.Scanner;
import br.com.jornada360.model.Periodo;
import br.com.jornada360.repository.*;
import br.com.jornada360.report.*;
import br.com.jornada360.service.*;
public class Aplicacao {
 public static void main(String[] args) {
  RepositorioJornadas r=new RepositorioJornadasMemoria(); CalculadoraIndicadores c=new CalculadoraIndicadores(); FormatadorRelatorio f=new FormatadorRelatorio();
  RelatorioJornada[] relatorios={new RelatorioJornadasAtivas(r,c,f),new RelatorioJornadasConcluidas(r,c,f),new RelatorioJornadasInterrompidas(r,c,f)};
  try(Scanner sc=new Scanner(System.in)) {
   System.out.println("Jornada360 — Relatórios de acompanhamento");
   System.out.print("Data inicial (AAAA-MM-DD): "); LocalDate inicio=LocalDate.parse(sc.nextLine().trim());
   System.out.print("Data final (AAAA-MM-DD): "); LocalDate fim=LocalDate.parse(sc.nextLine().trim()); Periodo p=new Periodo(inicio,fim);
   boolean continuar=true;
   while(continuar) {
    System.out.println("\n1 - Jornadas ativas\n2 - Jornadas concluídas\n3 - Jornadas interrompidas\n0 - Sair");
    System.out.print("Opção: "); String op=sc.nextLine().trim();
    switch(op){case "1"->System.out.println(relatorios[0].gerar(p));case "2"->System.out.println(relatorios[1].gerar(p));case "3"->System.out.println(relatorios[2].gerar(p));case "0"->continuar=false;default->System.out.println("Opção inválida.");}
   }
  } catch(Exception e){System.out.println("Não foi possível executar: "+e.getMessage());}
 }
}
