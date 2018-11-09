package com.example.api;

import com.example.api.models.PersonObject;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link PeopleApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface PeopleApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * @see PeopleApi#getPerson
     */
    default ResponseEntity<PersonObject> getPerson(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"gender\" : \"Male\",  \"phone\" : \"202-555-0112\",  \"dob\" : \"2000-01-23\",  \"id\" : \"id\",  \"title\" : \"Dr\",  \"email\" : \"email\",  \"ssn\" : \"403-38-6993\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see PeopleApi#savePerson
     */
    default ResponseEntity<PersonObject> savePerson(PersonObject personObject) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"gender\" : \"Male\",  \"phone\" : \"202-555-0112\",  \"dob\" : \"2000-01-23\",  \"id\" : \"id\",  \"title\" : \"Dr\",  \"email\" : \"email\",  \"ssn\" : \"403-38-6993\"}");
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    ApiUtil.setExampleResponse(request, "application/xml", "<null>  <title>aeiou</title>  <gender>aeiou</gender>  <firstName>aeiou</firstName>  <lastName>aeiou</lastName>  <ssn>403-38-6993</ssn>  <phone>202-555-0112</phone>  <email>aeiou</email>  <id>aeiou</id>  <dob>2000-01-23</dob></null>");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
