package be.technifutur.apigateway.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class AuthenticationService {

    private final WebClient webClient;

    public AuthenticationService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("lb://user-service").build();
    }

    public Mono<ClientResponse> validateToken(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        return webClient.get()
                .uri(
                        uriBuilder -> uriBuilder
                                .path("/login")
                                .build()
                )
                .header("Authorization", token)
                .exchangeToMono( Mono::just );
    }

}
