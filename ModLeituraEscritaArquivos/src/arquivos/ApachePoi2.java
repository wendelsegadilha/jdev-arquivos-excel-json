package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa01 = new Pessoa("Maria Silva", "mms@gmail.com", 42);
		Pessoa pessoa02 = new Pessoa("Lucas Abreu", "lucas2020@gmail.com", 18);
		Pessoa pessoa03 = new Pessoa("Gabriela Tutoia", "gabit@gmail.com", 25);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(Arrays.asList(pessoa01, pessoa02, pessoa03));
		
		File arquivo = new File("C:\\Users\\Wendel\\eclipse-workspaces\\curso-jdev\\ModLeituraEscritaArquivos\\src\\arquivos\\arquivo_excel.xls");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		@SuppressWarnings("resource") 
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet planilha = hssfWorkbook.createSheet("Planinha de Pessoas");
		
		int numeroLinha =  0;
		
		for (Pessoa p : pessoas) {
			Row linha = planilha.createRow(numeroLinha++);
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++);
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++);
			celEmail.setCellValue(p.getEmail());
			
			Cell CelIdade = linha.createCell(celula++);
			CelIdade.setCellValue(p.getIdade());
		}
		
		FileOutputStream arquivoSaida = new FileOutputStream(arquivo);
		hssfWorkbook.write(arquivoSaida);
		arquivoSaida.flush();
		arquivoSaida.close();
		
		System.out.println("Sucesso!");
		
	}

}
