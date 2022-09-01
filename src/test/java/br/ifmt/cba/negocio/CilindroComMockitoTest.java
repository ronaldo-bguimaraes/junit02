package br.ifmt.cba.negocio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class CilindroComMockitoTest {
  @Test
  public void quandoDadosCorretos() {
    // criando objeto duble
    Circulo circuloFalso = mock(Circulo.class);

    // ensinando resposta aos metodos
    when(circuloFalso.getRaio()).thenReturn(2.0);
    when(circuloFalso.getArea()).thenReturn(12.56);

    Cilindro cilindro = new Cilindro(circuloFalso, 4);
    assertEquals(75.39, cilindro.getArea(), 0.01);
  }

  @Test(expected = RuntimeException.class)
  public void quandoAlturaMenorOuIgualQueZero() {
    // criando objeto duble
    Circulo circuloFalso = mock(Circulo.class);

    // ensinando resposta aos metodos
    when(circuloFalso.getRaio()).thenReturn(2.0);
    when(circuloFalso.getArea()).thenReturn(12.56);

    Cilindro cilindro = new Cilindro(circuloFalso, 0);
    cilindro.getArea();
  }

  @Test(expected = RuntimeException.class)
  public void quandoRaioMenorOuIgualQueZero() {
    // criando objeto duble
    Circulo circuloFalso = mock(Circulo.class);

    // ensinando resposta aos metodos
    when(circuloFalso.getRaio()).thenReturn(-1.0);
    when(circuloFalso.getArea()).thenThrow(new RuntimeException("Raio com valor inconsistente"));

    Cilindro cilindro = new Cilindro(circuloFalso, 4);
    cilindro.getArea();
  }

  @Test(expected = RuntimeException.class)
  public void quandoCirculoNull() {
    Cilindro cilindro = new Cilindro(null, 4);
    cilindro.getArea();
  }
}
