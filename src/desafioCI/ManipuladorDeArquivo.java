package desafioCI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class ManipuladorDeArquivo {
	
	
	public static void leitor(String path) throws IOException { 
		
		FileReader arq = new FileReader(path);
		BufferedReader buffRead = new BufferedReader(arq);
		String linha = ""; 
		String nome = null;
		double valor;
		int unidade;
		
		HashMap<String, Fruta> frutas = new HashMap<String, Fruta>();  
		
		while (true) {
			if ((linha = buffRead.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(linha, ";");
				nome = st.nextToken();
				valor = Double.parseDouble(st.nextToken());
				unidade = Integer.parseInt(st.nextToken());
				
				Fruta fruta = new Fruta(nome,valor,unidade);
				
				Set<String> chaves = frutas.keySet();
				for (String chave : chaves)
				{
					if(chave != null)
						System.out.println(chave);
				}
				
				if(frutas.containsKey(fruta.getNome())){
					System.out.println(frutas.values().toString());
					System.out.println("Objeto " + fruta.getNome() + " ja existe");
				}else{
					frutas.put(fruta.getNome(), fruta);
					
					System.out.println("Nome: " + fruta.getNome()  + " / " + "Valor: R$ " + fruta.getValor() + " / " + "Unidades: " + fruta.getUnidade());
					
				}
				
				
				
				
				
			} else 
				break;
		} 
		
		buffRead.close(); 
	}

}
