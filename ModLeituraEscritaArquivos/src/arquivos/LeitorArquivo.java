package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorArquivo {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		File arquivo = new File("D:\\eclipse-workspaces\\suporte\\ModLeituraEscritaArquivos\\src\\arquivos\\arquivo.txt");
		
		FileInputStream fis = new FileInputStream(arquivo);
		
		@SuppressWarnings("resource")
		Scanner leitorArquivo = new Scanner(fis, "UTF-8");
		
		while(leitorArquivo.hasNext()) {
			
			String linha = leitorArquivo.nextLine();
			
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split(";");
				Pessoa pessoa = new Pessoa(dados[0], dados[1], Integer.parseInt(dados[2]));
				pessoas.add(pessoa);
			}
		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}

	}

}
