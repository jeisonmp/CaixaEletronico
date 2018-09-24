package br.com.tests.caixaeletronico.services;

import br.com.tests.caixaeletronico.repository.CaixaRepository;

import java.util.HashMap;

public class CaixaService {

    public CaixaRepository IniciarCaixa(HashMap<Integer, Integer> notas) {

        CaixaRepository caixa = new CaixaRepository();

        if (!notas.isEmpty()) {
            notas.forEach((k, v) -> caixa.AdicionarNota(k, v));
        }

        return caixa;
    }

    public boolean SacarDinheiro(CaixaRepository caixa, Integer valor) {

        HashMap<Integer, Integer> notas = caixa.getNotasDisponiveis();

        if ((valor % 10 > 0) || valor <= 0) return false;

        while (valor >= 0) {
            int nota = 0;
            boolean _sair = true;

            for (Integer key : notas.keySet()) {
                if (notas.get(key) > 0) {
                    if (key.equals(valor)) {
                        nota = key;
                        _sair = true;
                        break;
                    } else if (key < valor && nota < key) {
                        nota = key;
                        _sair = false;
                    }
                }
            }

            valor -= nota;
            caixa.RetirarNota(nota, 1);

            if (_sair) break;
        }

        return true;
    }

}
