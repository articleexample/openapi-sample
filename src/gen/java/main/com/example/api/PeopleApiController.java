package com.example.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.API Title.base-path:}")
public class PeopleApiController implements PeopleApi {

    private final PeopleApiDelegate delegate;

    public PeopleApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) PeopleApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PeopleApiDelegate() {});
    }

    @Override
    public PeopleApiDelegate getDelegate() {
        return delegate;
    }

}
