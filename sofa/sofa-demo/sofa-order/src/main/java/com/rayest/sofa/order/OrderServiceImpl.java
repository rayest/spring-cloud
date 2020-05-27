package com.rayest.sofa.order;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.rayest.sofa.order.facade.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author lirui
 */
@Slf4j
@Service
@SofaService(uniqueId = "${service.unique.id}", bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class OrderServiceImpl implements IOrderService {

    public String getByName(String name) {
        log.info("order name: {}", name);
        return name;
    }
}
