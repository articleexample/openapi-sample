package com.example.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.API Title.base-path:}")
public class FamilyApiController implements FamilyApi {

    private final FamilyApiDelegate delegate;

    public FamilyApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) FamilyApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FamilyApiDelegate() {});
    }

    @Override
    public FamilyApiDelegate getDelegate() {
        return delegate;
    }

}
