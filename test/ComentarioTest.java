import org.junit.Test;
import vendaingressos.Comentario;
import vendaingressos.Usuario;

import java.io.File;
import static org.junit.Assert.*;
/**
public class ComentarioTest {

    @Test
    public void testeVerificarArquivo(){
        // Instância do ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Objeto a ser salvo no JSON
        Comentario comentario = new Comentario(4, "Gostei mas não é ótimo");

        // Salvando o objeto como arquivo JSON
        mapper.writeValue(new File("/comentario.json"), comentario);

        // Verificando se o arquivo foi criado
        File arquivoJson = new File("/comentario.json");
        assertTrue(arquivoJson.exists(), "O arquivo JSON não foi criado.");

        // Lendo o arquivo JSON
        Comentario usuarioLido = mapper.readValue(arquivoJson, Comentario.class);

        // Verificando se os dados são iguais
        assertEquals(comentario.avaliacoes[0], usuarioLido.nome, "O nome no arquivo JSON não corresponde.");
        assertEquals(comentario.comentarios[0], usuarioLido.idade, "A idade no arquivo JSON não corresponde.");
    }
}
**/