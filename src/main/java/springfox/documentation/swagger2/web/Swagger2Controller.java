

package springfox.documentation.swagger2.web;

//import static springfox.documentation.swagger2.web.HostNameProvider.*; 
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.PropertySourcedMapping;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

@Controller
@ApiIgnore
public class Swagger2Controller {

  public static final String DEFAULT_URL = "/v2/api-docs";
  private static final String HAL_MEDIA_TYPE = "application/hal+json";

  private final String hostNameOverride;
  private final DocumentationCache documentationCache;
  private final ServiceModelToSwagger2Mapper mapper;
  private final JsonSerializer jsonSerializer;

  @Autowired
  public Swagger2Controller(
      Environment environment,
      DocumentationCache documentationCache,
      ServiceModelToSwagger2Mapper mapper,
      JsonSerializer jsonSerializer) {

    this.hostNameOverride = environment.getProperty("springfox.documentation.swagger.v2.host", "DEFAULT");
    this.documentationCache = documentationCache;
    this.mapper = mapper;
    this.jsonSerializer = jsonSerializer;
  }
  
  
  @RequestMapping(
	      value = DEFAULT_URL,
	      method = RequestMethod.GET,
	      produces = { APPLICATION_JSON_VALUE, HAL_MEDIA_TYPE })
	  @PropertySourcedMapping(
	      value = "${springfox.documentation.swagger.v2.path}",
	      propertyKey = "springfox.documentation.swagger.v2.path")
	  @ResponseBody
	  public ResponseEntity<Json> getDocumentation1(
	      @RequestParam(value = "group", required = false) String swaggerGroup,
	      HttpServletRequest servletRequest) throws IOException {
	  ClassPathResource classPathResource = new ClassPathResource("api.yaml");
	  InputStream inputStream = classPathResource.getInputStream();
	  String string = IOUtils.toString(inputStream);
	  String jsonText = convertYamlToJson(string);
	  Json json = new Json(jsonText);
	  return new ResponseEntity<Json>(json, HttpStatus.OK);
	  
	  
  }
  
  String convertYamlToJson(String yaml) throws JsonParseException, JsonMappingException, IOException {
	    ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
	    Object obj = yamlReader.readValue(yaml, Object.class);

	    ObjectMapper jsonWriter = new ObjectMapper();
	    return jsonWriter.writeValueAsString(obj);
	}
  

}
