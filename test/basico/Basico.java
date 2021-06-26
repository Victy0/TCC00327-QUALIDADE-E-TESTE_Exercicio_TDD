package basico;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Basico {
	
	@BeforeAll
	public static void inicializaTodos() {
		System.out.println("@BeforeAll EXERCICIO TDD\n");
	}
	
	@BeforeEach
	public void inicializa() {
		System.out.println("\t@BeforeEach");
	}
	
	@Test
	public void test1() {
		System.out.println("\t@test1");
	}
	
	@Test
	public void test2() {
		System.out.println("\t@test2");
	}
	
	@Test
	public void test3() {
		System.out.println("\t@test3");
	}
	
	@AfterEach
	public void finaliza() {
		System.out.println("\t@AfterEach\n");
	}		
	
	@AfterAll
	public static void finalizaTodos() {
		System.out.println("@AfterAll");
	}

}
