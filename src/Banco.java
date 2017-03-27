import com.senac.SimpleJava.Console;

public class Banco {
	static int[] notasCem = { 100, 100, 100, 100, 100, 100, 100, 100 };
	static int[] notasCinquenta = { 50, 50, 50, 50, 50, 50, 50, 50 };
	static int[] notasVinte = { 20, 20, 20, 20, 20, 20, 20, 20 };
	static int[] notasDez = { 10, 10, 10, 10, 10, 10, 10, 10 };

	public void run() {
		int sair = 0;
		String resultado = "";
		int valorSaque = 0;

		Console.println("Bem vindo!!");
		do {
			
			valorSaque = Console.readInt("Inform o valor que deseja sacar...");
			resultado = VerificaTroco(valorSaque,Console.readInt("Digite 1: para mais troco ou 2: para menos troco: "));
			Console.println(resultado);
			sair = Console.readInt("Digite 0: para sair e 1: para continuar...");
		} while (sair != 0);

	}

	public static String VerificaTroco(int Valor, int opcaoTroc) {
		String texto = "";
		switch (opcaoTroc) {
		case 1:
			texto = SacaComMaisTroco(Valor);
			break;
		case 2:

			break;

		default:
			break;
		}

		return texto;

	}

	public static String SacaComMaisTroco(int valor) {
		String texto = "";

		if (valor <= 100) {
			return GetNotasPequenas(valor);
		} else if (valor > 100 && valor <= 400) {
			return GetNotasPequenasEMedias(valor);
		}
		return texto;
	}

	public static String GetNotasPequenas(int valor) {
		int contnotasVint = 0;
		int contnotasDe = 0;
		int valorTest = 0;

		if (notasVinte[7] != 0) {
			if (valor > 30) {
				for (int i = 0; i < notasVinte.length; i++) {

					if (valor < 50) {
						if (valorTest < 20) {
							if (notasVinte[i] != 0) {
								valorTest = valorTest + notasVinte[i];
								notasVinte[i] = 0;
								contnotasVint++;
							}
						}
					} else if (valor <= 70) {
						if (valorTest < 40) {
							if (notasVinte[i] != 0) {
								valorTest = valorTest + notasVinte[i];
								notasVinte[i] = 0;
								contnotasVint++;
							}
						}
					} else {
						if(valor >= 100){
							if (valorTest < 100) {
								if (notasVinte[i] != 0) {
									valorTest = valorTest + notasVinte[i];
									notasVinte[i] = 0;
									contnotasVint++;
								}
							}
						}else{
							if (valorTest < 60) {
								if (notasVinte[i] != 0) {
									valorTest = valorTest + notasVinte[i];
									notasVinte[i] = 0;
									contnotasVint++;
								}
							}
						}

					}
				}
			}
			if (notasDez[7] != 0) {
				for (int i = 0; i < notasDez.length; i++) {
					if (notasDez[i] != 0) {
						if (valorTest < valor) {
							valorTest = valorTest + notasDez[i];
							notasDez[i] = 0;
							contnotasDe++;
						}
					}
				}
			}
		}
		if (valor <= 30) {
			return "Sacou " + contnotasDe + " de dez...";
		} else
			return "Sacou " + contnotasVint + " de vinte e " + contnotasDe + " de dez...";
	}

	public static String GetNotasPequenasEMedias(int valor) {
		int contnotasCinq = 0;
		int valorTest = 0;
		int Restante_V = 0;
		

		for (int i = 0; i < notasCinquenta.length; i++) {
			if (valor <= 150) {
				if (valorTest < 50) {
					valorTest = valorTest + notasCinquenta[i];
					notasCinquenta[i] = 0;
					contnotasCinq++;
				}
			} else if (valor > 150 && valor <= 300) {
				if (valorTest < 150) {
					valorTest = valorTest + notasCinquenta[i];
					notasCinquenta[i] = 0;
					contnotasCinq++;
				}
			} else if (valor > 300 && valor <= 400) {
				if (valorTest < 250) {
					valorTest = valorTest + notasCinquenta[i];
					notasCinquenta[i] = 0;
					contnotasCinq++;
				}
			}
		}
		Restante_V = valor - valorTest;

		return "Sacou " + contnotasCinq + " notas de Cinquenta " + GetNotasPequenas(Restante_V);

	}
}
