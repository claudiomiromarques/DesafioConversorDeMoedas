// Importa classes para escrita de arquivos e manipulação de data/hora
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

// Classe responsável por registrar mensagens de erro em um arquivo de log
public class GerarArquivoLog {

    // Método que registra uma mensagem de erro no arquivo "log.txt"
    public void registrarErro(String mensagem) {
        // Bloco try-with-resources para garantir o fechamento adequado do FileWriter
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            // Escreve no arquivo o horário atual e a mensagem de erro
            writer.write(LocalDateTime.now() + " - ERRO: " + mensagem + "\n");
        } catch (IOException e) {
            // Se houver falha ao gravar o log, exibe mensagem no console
            System.out.println("Erro ao registrar log.");
        }
    }
}
