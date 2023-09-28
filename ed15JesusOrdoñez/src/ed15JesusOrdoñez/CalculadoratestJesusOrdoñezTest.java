package ed15JesusOrdoñez;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoratestJesusOrdoñezTest {
    
    private Calculadora calculadora;
    
    @Before
    public void setUp() {
        calculadora = new Calculadora();
    }
    
    @Test
    public void testSuma() {
        calculadora.suma(5);
        Assert.assertEquals(5, calculadora.getPantalla().intValue());
    }
    
    @Test
    public void testResta() {
        calculadora.resta(3);
        Assert.assertEquals(-3, calculadora.getPantalla().intValue());
    }
    
    @Test
    public void testMultiplica() {
        calculadora.multiplica(4);
        Assert.assertEquals(0, calculadora.getPantalla().intValue());
    }
    
    @Test
    public void testDivide() {
        calculadora.divide(2);
        Assert.assertEquals(0, calculadora.getPantalla().intValue());
        
        calculadora.divide(0);
        Assert.assertEquals(0, calculadora.getPantalla().intValue());
    }
    
    @Test
    public void testPorcentaje() {
        calculadora.suma(100);
        calculadora.porcentaje(50);
        Assert.assertEquals(50, calculadora.getPantalla().intValue());
    }
    
    @Test
    public void testResetea() {
        calculadora.suma(10);
        calculadora.resta(5);
        calculadora.resetea();
        Assert.assertEquals(0, calculadora.getPantalla().intValue());
    }
    
}
