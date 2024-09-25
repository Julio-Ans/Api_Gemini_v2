package br.edu.fatecpg.apigemini.view;

import br.edu.fatecpg.apigemini.service.ConsomeApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static br.edu.fatecpg.apigemini.service.ConsomeApi.*;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);

        int saida = 1;
        int contador = 0;
        int Qtd_Pergunta_Min = 3;
        ArrayList<String> lista_resposta = new ArrayList<String>();
        ArrayList<String> resumo;

        System.out.println("Faça Três Perguntas para a IA:");

        while (saida == 1) {
            String pergunta = scan.nextLine();
            String resposta = ConsomeApi.fazerPergunta(pergunta);
            System.out.println("\n" + resposta);
            contador = contador + 1;
            lista_resposta.add(resposta);

            if (contador < Qtd_Pergunta_Min) {
                System.out.println("Você tem que fazer pelo menos três perguntas. " + contador + " já foram feitas.");
                saida = 1;
            }

            if (contador >= Qtd_Pergunta_Min) {
                System.out.println("Deseja continuar: sim ou não");
                String resp = scan.nextLine();
                if (!Objects.equals(resp, "sim")) {
                    saida = -1;
                }
                System.out.println("Deseja mostrar os resumos: Sim ou não");
                String resp2 = scan.nextLine();
                if (Objects.equals(resp2, "sim")) {
                     resumo = gerarResumo(lista_resposta);
                     imprimirResumo(resumo);
                     salvarResumo(resumo);

                }


            }
        }
    }}

