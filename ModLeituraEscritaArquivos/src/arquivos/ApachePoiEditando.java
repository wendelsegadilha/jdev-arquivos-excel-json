package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {

	public static void main(String[] args) throws Exception{
		
		
		File arquivo = new File("C:\\Users\\Wendel\\eclipse-workspaces\\curso-jdev\\ModLeituraEscritaArquivos\\src\\arquivos\\arquivo_excel.xls");
		
		FileInputStream fis = new FileInputStream(arquivo);
		
		@SuppressWarnings("resource")
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fis);
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();
			int numeroCelulas = linha.getPhysicalNumberOfCells();
			Cell celula = linha.createCell(numeroCelulas);
			celula.setCellValue("5.487,20");
		}
				
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(arquivo);
		hssfWorkbook.write(fos);
		fos.flush();
		fos.close();
		
		System.out.println("Planilha atualizada.");
	}

}
