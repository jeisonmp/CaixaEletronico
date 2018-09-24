package br.com.tests.caixaeletronico.services;

import br.com.tests.caixaeletronico.repository.CaixaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaixaServiceTests {

    private CaixaRepository caixa;
    private CaixaService caixaService;

    public CaixaServiceTests () {
        this.caixa = new CaixaRepository();
        this.caixaService = new CaixaService();
    }

    @Test
    public void SacarDinheiroTest() {

        HashMap<Integer, Integer> notas = new HashMap<>();
        notas.put(10, 200);
        notas.put(20, 100);
        notas.put(50, 50);
        notas.put(100, 50);

        caixa = caixaService.IniciarCaixa(notas);

        caixaService.SacarDinheiro(caixa, 90);
        Assert.assertEquals(50, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(49, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(98, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(200, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 30);
        Assert.assertEquals(50, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(49, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(97, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(199, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 200);
        Assert.assertEquals(48, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(49, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(97, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(199, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 5);
        Assert.assertEquals(48, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(49, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(97, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(199, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 2250);
        Assert.assertEquals(26, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(48, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(97, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(199, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 50);
        Assert.assertEquals(26, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(47, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(97, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(199, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 10);
        Assert.assertEquals(26, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(47, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(97, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(198, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 210);
        Assert.assertEquals(24, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(47, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(97, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(197, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 2400);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(47, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(97, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(197, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 520);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(37, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(96, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(197, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 2230);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(77, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(197, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 1540);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(197, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 1970);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(10).intValue());

        caixa.AdicionarNota(100, 1);
        caixa.AdicionarNota(50, 30);
        caixa.AdicionarNota(10, 10);

        caixaService.SacarDinheiro(caixa, 70);
        Assert.assertEquals(1, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(29, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(8, caixa.getNotasDisponiveis().get(10).intValue());

        caixaService.SacarDinheiro(caixa, 1630);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(10).intValue());

        Assert.assertEquals(false, caixaService.SacarDinheiro(caixa, 51));
        Assert.assertEquals(false, caixaService.SacarDinheiro(caixa, 49));
        Assert.assertEquals(false, caixaService.SacarDinheiro(caixa, -1));
        Assert.assertEquals(false, caixaService.SacarDinheiro(caixa, 11));
        Assert.assertEquals(false, caixaService.SacarDinheiro(caixa, 9));
        Assert.assertEquals(false, caixaService.SacarDinheiro(caixa, 6));
        Assert.assertEquals(false, caixaService.SacarDinheiro(caixa, 4));
        Assert.assertEquals(false, caixaService.SacarDinheiro(caixa, 0));

        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(100).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(50).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(20).intValue());
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(10).intValue());


        caixa.AdicionarNota(100, 1);
        caixaService.SacarDinheiro(caixa, 101);
        caixaService.SacarDinheiro(caixa, 99);
        Assert.assertEquals(1, caixa.getNotasDisponiveis().get(100).intValue());
        caixaService.SacarDinheiro(caixa, 100);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(100).intValue());

        caixa.AdicionarNota(50, 1);
        caixaService.SacarDinheiro(caixa, 51);
        caixaService.SacarDinheiro(caixa, 49);
        Assert.assertEquals(1, caixa.getNotasDisponiveis().get(50).intValue());
        caixaService.SacarDinheiro(caixa, 50);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(50).intValue());

        caixa.AdicionarNota(20, 1);
        caixaService.SacarDinheiro(caixa, 21);
        caixaService.SacarDinheiro(caixa, 19);
        Assert.assertEquals(1, caixa.getNotasDisponiveis().get(20).intValue());
        caixaService.SacarDinheiro(caixa, 20);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(20).intValue());

        caixa.AdicionarNota(10, 1);
        caixaService.SacarDinheiro(caixa, 11);
        caixaService.SacarDinheiro(caixa, 9);
        Assert.assertEquals(1, caixa.getNotasDisponiveis().get(10).intValue());
        caixaService.SacarDinheiro(caixa, 10);
        Assert.assertEquals(0, caixa.getNotasDisponiveis().get(10).intValue());




    }

}
