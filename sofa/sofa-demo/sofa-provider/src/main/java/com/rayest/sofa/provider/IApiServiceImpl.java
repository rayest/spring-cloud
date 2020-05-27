package com.rayest.sofa.provider;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.rayest.sofa.provider.facade.IApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author lirui
 */
@Slf4j
@Service
@SofaService(uniqueId = "${service.unique.id}", bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class IApiServiceImpl implements IApiService {

    @Override
    public void test(String name) {
        log.info("name: {}", name);
    }
}
