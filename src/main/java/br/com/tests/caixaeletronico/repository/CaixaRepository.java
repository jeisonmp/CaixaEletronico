package br.com.tests.caixaeletronico.repository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;

public class CaixaRepository {

    private HashMap<Integer, Integer> notas;

    public CaixaRepository () {
        this.notas = new HashMap<>();
    }

    public HashMap<Integer, Integer> getNotasDisponiveis() {
        return this.notas;
    }

    public boolean AdicionarNota(Integer valor, Integer quantidade) {

        if (this.notas.get(valor) != null) {
            notas.put(valor, notas.get(valor) + quantidade);
        }
        else {
            notas.put(valor, quantidade);
        }

        return true;
    }

    public boolean RetirarNota(Integer valor, Integer quantidade) {

        if (this.notas.get(valor) != null) {
            notas.put(valor, notas.get(valor) - quantidade);

            return true;
        }

        return false;
    }
}
