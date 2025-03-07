import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {

	private static Cuenta cuenta;
	
	@BeforeAll
	static void inicializarCuenta(){
		cuenta = new Cuenta("ES21099865462528660871295", 100);
	}
	
	//LOS MÉTODOS NO SE PRUEBAN EN ESTE ORDEN SINO EN ORDEN ALFABÉTICO
	
	@Test
	void testGetSaldo() {
		 float saldo = cuenta.getSaldo();
	     assertEquals(480, saldo, "El saldo debería ser 480");
	}

	@Test
	void testSetSaldo() {
		cuenta.setSaldo(200);
		assertEquals(200, cuenta.getSaldo());
	}

	@Test
	void testIngresarDinero() {
		cuenta.ingresarDinero(400);
		assertEquals(480, cuenta.getSaldo());
	}

	@Test
	void testExtraerDinero() {
		try {
			cuenta.extraerDinero(20);
			assertEquals(80, cuenta.getSaldo());
			cuenta.extraerDinero(120);
			fail("EROOR. SE DEBERÍA LANZAR LA EXCEPCIÓN");
		} catch (ArithmeticException ae){
			System.out.println("La prueba es correcta: se lanzó la excepción de saldo negativo");
		}
		
		
	}
	
	@Test
	void testGetNumero() {
		String num = "ES96099865462528660871200";
		assertEquals(num, cuenta.getNumero());
	}
	
	@Test
	void testSetNumero() {
		String num = "ES96099865462528660871200";
		cuenta.setNumero(num);
		assertEquals(num, cuenta.getNumero());
	}
	
	@Test
	void testMostrarCuenta() {
		cuenta.mostrarCuenta();
	}

}
