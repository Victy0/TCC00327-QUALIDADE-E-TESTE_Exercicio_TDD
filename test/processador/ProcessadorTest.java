package processador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProcessadorTest {
	
	private Processador processador;
	
	@Test
	public void inicializa() {
		processador = new Processador();
		Assertions.assertNotNull(processador);
	}

}
