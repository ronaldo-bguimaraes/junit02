package br.ifmt.cba.negocio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CirculoTest {
  @Test
  public void quandoDadosCorretos() {
    Circulo circulo = new Circulo(2);
    assertEquals(12.56, circulo.getArea(), 0.01);
  }

  @Test(expected = RuntimeException.class)
  public void quandoRaioMenorOuIgualQueZero() {
    Circulo circulo = new Circulo(-1);
    circulo.getArea();
  }
}
