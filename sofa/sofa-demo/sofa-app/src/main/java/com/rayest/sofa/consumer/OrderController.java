package com.rayest.sofa.consumer;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.rayest.sofa.order.facade.IOrderService;
import com.rayest.sofa.order.facade.IUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lirui
 */
@Validated
@RestController
public class OrderController {


    @SofaReference(interfaceType = IOrderService.class, uniqueId = "${service-order.unique.id}", binding = @SofaReferenceBinding(bindingType = "bolt"))
    private IOrderService iOrderService;

    @GetMapping("/api/order/test")
    public String getByUsername(@RequestParam("name") String name) {
        return iOrderService.getByName(name);
    }
}
