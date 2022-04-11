package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi { 

	public static void main(String[] args) throws IOException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		File arquivo = new File("C:\\Users\\Wendel\\eclipse-workspaces\\curso-jdev\\ModLeituraEscritaArquivos\\src\\arquivos\\arquivo_excel.xls");
		FileInputStream fis = new FileInputStream(arquivo);

		@SuppressWarnings("resource")
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fis);
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);

		Iterator<Row> LinhaIterator = planilha.iterator();

		while (LinhaIterator.hasNext()) {

			Row linha = LinhaIterator.next();

			Iterator<Cell> celulaIterator = linha.iterator();

			Pessoa pessoa = new Pessoa();

			while (celulaIterator.hasNext()) {
				Cell celula = celulaIterator.next();

				switch (celula.getColumnIndex()) {
				case 0:
					pessoa.setNome(celula.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(celula.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(celula.getNumericCellValue()).intValue());
					break;
				}

			}
			
			pessoas.add(pessoa);

		}
		
		fis.close();
		System.out.println(pessoas);
	}
}
