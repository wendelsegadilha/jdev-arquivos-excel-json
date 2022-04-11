package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Rafael");
		usuario1.setLogin("rafa");
		usuario1.setSenha("123");
		usuario1.setCpf("123456789");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("José");
		usuario2.setLogin("jose");
		usuario2.setSenha("123");
		usuario2.setCpf("123456789");
		
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String userJson = gson.toJson(usuarios);
		
		System.out.println(userJson);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Wendel\\eclipse-workspaces\\curso-jdev\\ModLeituraEscritaArquivos\\src\\arquivos\\user.json");
		fileWriter.write(userJson);
		fileWriter.flush();
		fileWriter.close();
		
		//======================== LENDO O ARQUIVO JSON ==========================================
		FileReader fileReader = new FileReader("C:\\Users\\Wendel\\eclipse-workspaces\\curso-jdev\\ModLeituraEscritaArquivos\\src\\arquivos\\user.json");
		
		JsonArray  jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		
		for(JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuario);
		}
		
		System.out.println("Leitura de arquivo Json: " + listUsuarios);
	}

}
