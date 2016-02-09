/*
 * @author Ricardo Luis Borges da Conceição
 * 
 * Essa classe foi criada para a leitura e manipulação de um arquivo
 * que tem seus dados separados por ponto e virgula.
 * */


package desafioCI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ManipuladorDeArquivo {
	
	
	public static void leitor(String path) throws IOException { 
		
		/*O trecho a seguir representa a leitura, carregamento de um arquivo */
		FileReader arq = new FileReader(path);
		BufferedReader buffRead = new BufferedReader(arq);
		String linha = ""; 
		double valorNovo;
		int unidadeNovo;
		double totalFinal = 0;
		
		
		/*Foi utilizada a estrutura de dados TreeMap por entender que seria a mais adequada
		 *para a manipulação e ordenação dos dados que foram lidos no arquivo*/
		TreeMap<String, Fruta> frutas = new TreeMap<String, Fruta>();  
		
		/*O laço while foi escolhido para que fosse identificado o final do arquivo. */
			while ((linha = buffRead.readLine()) != null) {
				/*Utilizei o StringTokenizer para a separar os dados que vierem na leitura de cada linha do arquivo.*/
				StringTokenizer st = new StringTokenizer(linha, ";");
				String nome = st.nextToken();
				double valor = Double.parseDouble(st.nextToken());
				int unidade = Integer.parseInt(st.nextToken());
				
				/*Na estrutura de controle de fluxo if-else foi utilizado o metodo containsKey da estrutura
				 * TreeMap para que fosse verificado se a chave já existia.
				 * Se a chave fosse existente os valores seriam atualizados de acordo com a necessidade(No caso foram atualizados os campos unidade e valor).
				 * Caso contrário apenas o valor total que foi vendido seria calculado.
				 */
				if(frutas.containsKey(nome) ==  true){	
					  Fruta frutaEscolhida = frutas.get(nome);
					  unidadeNovo = unidade + frutaEscolhida.getUnidade();
					  valorNovo = ((unidade * valor) + frutaEscolhida.getValor());
					  frutas.put(nome, new Fruta(nome, valorNovo, unidadeNovo));
					  
				}else{
					valorNovo = valor * unidade;
					frutas.put(nome,new Fruta(nome, valorNovo, unidade));
				}
			}
			
			/*O laço de repetição for foi utilizado para percorrer o TreeMap
			 *  e buscar os valores para que fossem exibidos de acordo com o que foi solicitado pelo cliente Leco.
			 *  Os valores foram formatados para um melhor entendimento.*/
			for(Entry<String, Fruta> mapaFrutas : frutas.entrySet()){  
			    String nome = mapaFrutas.getKey();
			    nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
				System.out.printf("%s - %s un. - R$%.2f  \n", nome, mapaFrutas.getValue().getUnidade(),mapaFrutas.getValue().getValor());  
			      totalFinal = totalFinal + mapaFrutas.getValue().getValor();
			   }  
				System.out.printf("Total - R$%.2f ", totalFinal);
		buffRead.close(); 
	}

}
