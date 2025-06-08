// Importa classes do Gson para manipulação de JSON
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// Importa classes para leitura de dados da internet
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Classe responsável por fazer a requisição à API de câmbio
public class RequestApi {

    // Método que retorna a taxa de câmbio entre duas moedas (origem e destino)
    public double obterTaxaCambio(String moedaOrigem, String moedaDestino) throws Exception {
        // Sua chave de API para autenticação no serviço da ExchangeRate-API
        String apiKey = "76113257645ed8aac3c905f508";

        // Monta a URL para obter as taxas de câmbio a partir da moeda de origem
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaOrigem;

        // Cria uma URL e abre conexão HTTP
        URL url = new URL(urlStr);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET"); // Define o método HTTP como GET

        // Lê a resposta da API usando um buffer de leitura
        BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

        // Converte a resposta JSON em um objeto JsonObject usando Gson
        JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
        reader.close(); // Fecha o buffer de leitura

        // Acessa o objeto que contém as taxas de conversão (rates)
        JsonObject rates = json.getAsJsonObject("conversion_rates");

        // Retorna a taxa de câmbio da moeda de destino
        return rates.get(moedaDestino).getAsDouble();
    }
}
