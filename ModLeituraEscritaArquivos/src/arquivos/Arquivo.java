package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arquivo {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa01 = new Pessoa("Maria Silva", "mms@gmail.com", 42);
		Pessoa pessoa02 = new Pessoa("Lucas Abreu", "lucas2020@gmail.com", 18);
		Pessoa pessoa03 = new Pessoa("Gabriela Tutoia", "gabit@gmail.com", 25);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(Arrays.asList(pessoa01, pessoa02, pessoa03));
		
		File arquivo = new File("D:\\eclipse-workspaces\\suporte\\ModLeituraEscritaArquivos\\src\\arquivos\\arquivo.txt");
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter fw = new FileWriter(arquivo);
		
		for (Pessoa p : pessoas) {
			fw.write(p.getNome()+";"+p.getEmail()+";"+p.getIdade()+"\n");
		}
		
		fw.flush();
		fw.close();
		
	}

}
