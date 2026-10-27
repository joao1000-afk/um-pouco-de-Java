package treino;

public class TratamentoDeExcecoes {

	public static void main(String[] args) {
		
		
		try {  
			 String nome = null;
				System.out.println(nome.length());
		
		
		}
		catch(NullPointerException ex) {
			
		System.out.println("texto nulo");

	}

}
}
