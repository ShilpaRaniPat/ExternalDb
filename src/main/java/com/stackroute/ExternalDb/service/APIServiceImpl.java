package com.stackroute.ExternalDb.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stackroute.ExternalDb.domain.Items;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.List;

@Slf4j
@Service
public class APIServiceImpl implements APIservice, Serializable {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Items> getData(String URL) {
        RestAssured.baseURI = "https://api.stackexchange.com";
        // Getting the RequestSpecification of the request
        RequestSpecification httpRequest = RestAssured.given();
        // Making GET request directly by RequestSpecification.get() method
        Response response = httpRequest.get("/2.2/search?pagesize=100&order=desc&sort=votes&intitle=angular&site=stackoverflow");
        //Retrieving Body of response
        String body = response.getBody().asString();

        JSONObject obj=new JSONObject(body);
        Object it=obj.get("items");
        System.out.println("33ddd"+it);
        //using gson to convert jsonstring to object
        Gson gson = new Gson();
        List<Items> returnedItems = gson.fromJson(it.toString(), new TypeToken<List<Items>>(){}.getType());
        System.out.println("demo"+returnedItems);

        int status = response.getStatusCode();
        //Retrieving Status Line
        String statusLine = response.getStatusLine();
        //Printing the response
        System.out.println("Response Body is "+body);
        System.out.println("Status code is "+status);
        System.out.println("Status line is "+statusLine);
        return returnedItems;

    }

}




