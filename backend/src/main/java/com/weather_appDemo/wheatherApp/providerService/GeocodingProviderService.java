package com.weather_appDemo.wheatherApp.providerService;

import com.weather_appDemo.wheatherApp.model.CityCoordinate;
import com.weather_appDemo.wheatherApp.model.GeocodingCoordinatesEntity;
import com.weather_appDemo.wheatherApp.model.WeatherRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingProviderService {
    @Value("${api.key}")
    private String key;
    @Value("${geocoding.url}")
    private String geocodingUrl;
    public GeocodingCoordinatesEntity getCoordinate(WeatherRequest weatheRequest) throws Exception {
//        geocooding api call
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<GeocodingCoordinatesEntity[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null,null);

        //build URL
        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("q", weatheRequest.getCity())
                .queryParam("limit", "1")
                .queryParam("appid", key).build();

        try {
            responseEntity = restTemplate
                    .exchange(uriBuilder.toUriString(),
                            HttpMethod.GET,
                            requestEntity,
                            GeocodingCoordinatesEntity[].class);
        } catch (HttpStatusCodeException e) {
            throw new Exception(e.getMessage());
        }

        assert responseEntity.getBody() != null;
        return  responseEntity.getBody()[0];

    }
}
