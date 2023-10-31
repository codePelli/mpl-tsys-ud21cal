package UD21_Calculadora.Ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	Calculadora cal = new Calculadora();
	App app = new App();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
	}
	
	@Test
	public void testApp() {
		
		try {
			App.main(null);
			
		} catch (Exception e){
		}
	}
	
	@Test
	public void testSuma() {
		
		cal.numeroActual = 5.0;
		cal.setOperador("+");
		cal.calcular();
		assertEquals(5.0, cal.getResultado(),0.01);
	}
	
	@Test
	public void testResta() {
		
		cal.numeroActual = 10.0;
		cal.setOperador("-");
		cal.calcular();
		assertEquals(10.0, cal.getResultado(),0.01);
	}
	
    @Test
    void testMulti() {
    	
        cal.numeroActual = 5.0;
        cal.setOperador("*");
        cal.calcular();
        assertEquals(0.0, cal.getResultado(), 0.01);
    }
    
    @Test
    void testDiv() {
    	
        cal.numeroActual = 10.0;
        cal.setOperador("/");
        cal.calcular();
        assertEquals(0.0, cal.getResultado(), 0.01);
    }
	
	@Test
	public void signo() {
		
	       cal.numeroActual = 5.0;
	       cal.setOperador("+");
	       cal.calcular();
	       cal.setOperador("+/-");
	       cal.calcular();
	       assertEquals(5.0, cal.getResultado(), 0.01);
	}
	
	@Test
    void testBorrado() {
		
        cal.numeroActual = 5.0;
        cal.calcular();
        cal.setOperador("<-");
        cal.calcular();
        assertEquals(0.0, cal.getResultado(), 0.01);
    }
	
	@Test
    void testSumaCero() {
		
        cal.numeroActual = 0.0;
        cal.calcular();
        cal.setOperador("+");
        cal.calcular();
        assertEquals(0.0, cal.getResultado(), 0.01);
    }
	
	@Test
    void testDivCero() {
		
        cal.numeroActual = 10.0;
        cal.calcular();
        cal.setOperador("/");
        cal.calcular();
        assertEquals(0.0, cal.getResultado(), 0.01);
    }
	
    @Test
    public void testMultiplesOperaciones() {
    	
        cal.numeroActual = 5.0;
        cal.setOperador("+");
        cal.calcular();
        cal.setOperador("*");
        cal.calcular();
        cal.numeroActual = 2.0;
        cal.setOperador("-");
        cal.calcular();
        cal.numeroActual = 3.0;
        cal.setOperador("/");
        cal.calcular();
        assertEquals(0.0, cal.getResultado(), 0.01);
    }
    
    @Test
    public void testActualizarLabel() {
    	
    	cal.actualizarLabel();
    }
	
    @Test
    public void calcularIgualCero() {

    	cal.numeroActual = 0;
    	assertEquals(0, cal.getResultado(), 0.10);
    }

}
