package br.com.ucsal.olimpiadas;

public class CalculadoraNotaPorAcertos implements CalculadoraNota {

    @Override
    public int calcular(Tentativa tentativa) {
        int total = 0;

        for (Resposta resposta : tentativa.getRespostas()) {
            if (resposta.isCorreta()) {
                total++;
            }
        }

        return total;
    }
}