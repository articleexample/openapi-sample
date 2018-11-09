package com.example.api;

import com.example.api.models.FamilyObject;
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
 * A delegate to be called by the {@link FamilyApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface FamilyApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * @see FamilyApi#getFamily
     */
    default ResponseEntity<FamilyObject> getFamily(String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"address\" : {    \"city\" : \"Fremont\",    \"state\" : \"CA\",    \"line3\" : \"line3\",    \"line2\" : \"line2\",    \"line1\" : \"line1\"  },  \"members\" : [ {    \"firstName\" : \"firstName\",    \"lastName\" : \"lastName\",    \"gender\" : \"Male\",    \"phone\" : \"202-555-0112\",    \"dob\" : \"2000-01-23\",    \"id\" : \"id\",    \"title\" : \"Dr\",    \"email\" : \"email\",    \"ssn\" : \"403-38-6993\"  }, {    \"firstName\" : \"firstName\",    \"lastName\" : \"lastName\",    \"gender\" : \"Male\",    \"phone\" : \"202-555-0112\",    \"dob\" : \"2000-01-23\",    \"id\" : \"id\",    \"title\" : \"Dr\",    \"email\" : \"email\",    \"ssn\" : \"403-38-6993\"  } ],  \"id\" : \"id\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see FamilyApi#saveFamily
     */
    default ResponseEntity<FamilyObject> saveFamily(FamilyObject familyObject) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"address\" : {    \"city\" : \"Fremont\",    \"state\" : \"CA\",    \"line3\" : \"line3\",    \"line2\" : \"line2\",    \"line1\" : \"line1\"  },  \"members\" : [ {    \"firstName\" : \"firstName\",    \"lastName\" : \"lastName\",    \"gender\" : \"Male\",    \"phone\" : \"202-555-0112\",    \"dob\" : \"2000-01-23\",    \"id\" : \"id\",    \"title\" : \"Dr\",    \"email\" : \"email\",    \"ssn\" : \"403-38-6993\"  }, {    \"firstName\" : \"firstName\",    \"lastName\" : \"lastName\",    \"gender\" : \"Male\",    \"phone\" : \"202-555-0112\",    \"dob\" : \"2000-01-23\",    \"id\" : \"id\",    \"title\" : \"Dr\",    \"email\" : \"email\",    \"ssn\" : \"403-38-6993\"  } ],  \"id\" : \"id\"}");
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    ApiUtil.setExampleResponse(request, "application/xml", "<null>  <id>aeiou</id></null>");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
