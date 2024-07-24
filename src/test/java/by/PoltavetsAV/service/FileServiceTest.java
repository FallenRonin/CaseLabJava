package by.PoltavetsAV.service;

import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.BodyPublishers;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    HttpClient client;

    @BeforeEach
    void setUp(){
        client = HttpClient.newBuilder().build();
    }

    @Test
    void isAPIALiveAtAll() throws Exception{
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8082/api/files")).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        assertEquals(200, response.statusCode());
    }


    @Test
    void whenCreateNewFileMustReturnSomeID() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text", "0J/RgNC40LLQtdGCINC80LjRgA==" );
        jsonObject.put("title", "Hello world text" );
        jsonObject.put("creation_date", "2024-24-07T13:00:00" );
        jsonObject.put("description", "Test file" );

        HttpRequest request = HttpRequest.newBuilder().setHeader("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonObject.toString()))
                .uri(URI.create("http://localhost:8082/api/files")).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
    }

    @Test
    void whenCreatedNewFileRequestByItsIDMustNotBe404() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text", "0J/RgNC40LLQtdGCINC80LjRgA==" );
        jsonObject.put("title", "Hello world text" );
        jsonObject.put("creation_date", "2024-24-07T13:00:00" );
        jsonObject.put("description", "Test file" );

        HttpRequest request = HttpRequest.newBuilder().setHeader("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonObject.toString()))
                .uri(URI.create("http://localhost:8082/api/files")).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        HttpRequest request1 = HttpRequest.newBuilder().GET()
                .uri(URI.create("http://localhost:8082/api/files/" + response.body())).build();
        HttpResponse<String> response1 = client.send(request1, BodyHandlers.ofString());

        assertEquals(200, response1.statusCode());
    }
}