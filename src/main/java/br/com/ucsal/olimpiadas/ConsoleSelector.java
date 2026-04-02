package br.com.ucsal.olimpiadas;

import java.util.List;
import java.util.Scanner;

public class ConsoleSelector implements ParticipanteSelector, ProvaSelector {

    private final List<Participante> participantes;
    private final List<Prova> provas;
    private final Scanner in;

    public ConsoleSelector(List<Participante> participantes, List<Prova> provas, Scanner in) {
        this.participantes = participantes;
        this.provas = provas;
        this.in = in;
    }

    @Override
    public Long escolherParticipante() {
        System.out.println("\nParticipantes:");
        for (var p : participantes) {
            System.out.printf("  %d) %s%n", p.getId(), p.getNome());
        }
        System.out.print("Escolha o id do participante: ");

        try {
            long id = Long.parseLong(in.nextLine());
            boolean existe = participantes.stream().anyMatch(p -> p.getId() == id);
            if (!existe) {
                System.out.println("id inválido");
                return null;
            }
            return id;
        } catch (Exception e) {
            System.out.println("entrada inválida");
            return null;
        }
    }

    @Override
    public Long escolherProva() {
        System.out.println("\nProvas:");
        for (var p : provas) {
            System.out.printf("  %d) %s%n", p.getId(), p.getTitulo());
        }
        System.out.print("Escolha o id da prova: ");

        try {
            long id = Long.parseLong(in.nextLine());
            boolean existe = provas.stream().anyMatch(p -> p.getId() == id);
            if (!existe) {
                System.out.println("id inválido");
                return null;
            }
            return id;
        } catch (Exception e) {
            System.out.println("entrada inválida");
            return null;
        }
    }
}