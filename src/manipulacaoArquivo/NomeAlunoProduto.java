package manipulacaoArquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class NomeAlunoProduto {

	private String produto;
	private int quantidade;
	private double preco;
	private double valor_total;

	public NomeAlunoProduto(String produto, int quantidade, double preco) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public void calcularValorTotal() {
		valor_total = quantidade*preco;
	}
	
	public String toCSV() {
		return produto + "," + quantidade + "," + preco + "," + valor_total;
	}
	
	public static void main(String[] args) {
		
		File file = new File("pasta/leia.CSV");

		ArrayList<NomeAlunoProduto> produtos = new ArrayList<>();
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] campos = data.split(",");
                String produto = campos[0];
                int quantidade = Integer.parseInt(campos[1]);
                double preco = Double.parseDouble(campos[2]);
                NomeAlunoProduto p = new NomeAlunoProduto(produto, quantidade, preco);
                
                    p.calcularValorTotal();
                    produtos.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
            } 
        
	File file2 = new File("pasta/escreva.CSV"); 
		
			try {
            if (file2.createNewFile()) {
                System.out.println("Arquivo criado: " + file2.getName());
            } else {
                System.out.println("O arquivo já existe.");
            }
            
            try (FileWriter writer = new FileWriter(file2)) {
            	for (NomeAlunoProduto p : produtos) {
                writer.write(p.toCSV() + "\n");
            }
            }
            System.out.println("Dados gravados com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar ou escrever no arquivo.");
            e.printStackTrace();
        }
			

			
	}
}
