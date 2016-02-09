package desafioCI;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		/*Aqui nesse trecho estou passando para a variavel path o caminho do arquivo de texto*/
		String path = "../desafioCI/dados.txt";
		
		/*Nesse trecho estou utilizando o metodo Leitor da classe ManipuladorDeArquivo*/
		ManipuladorDeArquivo.leitor(path);
		

	}

}
