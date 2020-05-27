package com.rayest.sofa.consumer;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.rayest.sofa.provider.facade.IApiService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class ApiController {


    @SofaReference(interfaceType = IApiService.class, uniqueId = "${service-provider.unique.id}", binding = @SofaReferenceBinding(bindingType = "bolt"))
    private IApiService iApiService;

    @GetMapping("/api/test")
    public String list(@RequestParam("name") String name) {
        iApiService.test(name);
        return "OK";
    }
}
