package desafioCI;


public class Fruta implements Comparable<Fruta>{
	
	private String nome;
	private int unidade;
	private double valor;
	
	
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

	@Override
	public int compareTo(Fruta outraFruta) {
		if( this.getNome() == null && outraFruta.getNome() != null){ 
			return 1; 
		}else if( this.getNome() != null && outraFruta.getNome() == null ){
			return -1;
		}else if(this.getNome() == null && outraFruta.getNome() == null) { 
			return 0;
		}else {
			return this.getNome().compareTo(outraFruta.getNome());
		}
	}
	
	
	

	
	

}
