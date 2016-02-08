package desafioCI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ManipuladorDeArquivo {
	
	
	public static void leitor(String path) throws IOException { 
		
		FileReader arq = new FileReader(path);
		BufferedReader buffRead = new BufferedReader(arq);
		String linha = ""; 
		double valorNovo;
		int unidadeNovo;
		double totalFinal = 0;
		
		
		
		TreeMap<String, Fruta> frutas = new TreeMap<String, Fruta>();  
		
		
			while ((linha = buffRead.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(linha, ";");
				String nome = st.nextToken();
				double valor = Double.parseDouble(st.nextToken());
				int unidade = Integer.parseInt(st.nextToken());
				
				
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
			
			
			for(Entry<String, Fruta> mapaFrutas : frutas.entrySet()){  
			    String nome = mapaFrutas.getKey();
			    nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
				System.out.printf("%s - %s un. -  R$ %.2f  \n", nome, mapaFrutas.getValue().getUnidade(),mapaFrutas.getValue().getValor());  
			      totalFinal = totalFinal + mapaFrutas.getValue().getValor();
			   }  
				System.out.printf("Total - R$ %.2f ", totalFinal);
		buffRead.close(); 
	}

}
