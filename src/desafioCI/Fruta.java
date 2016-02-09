/*
 * @author Ricardo Luis Borges da Conceição
 * 
 * Essa classe foi criada para representar um objeto do tipo fruta
 * com os atributos necessários para essa aplicação.
 * */


package desafioCI;


public class Fruta{
	
	private String nome;
	private int unidade;
	private double valor;
	
	/*Esse é o construtor do objeto fruta que recebe os valores por meio de parâmetro.*/
	public Fruta(String nome,double valor,int unidade){
		this.nome = nome;
		this.valor = valor;
		this.unidade = unidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	
	
	

	
	

}
