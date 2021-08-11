package com.yyesw.springcloud.controller;

import com.yyesw.springcloud.entities.CommonResult;
import com.yyesw.springcloud.entities.Payment;
import com.yyesw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/9
 * <br/>Time: 16:48
 */

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;  //通过服务发现获取服务消息

    /**
     *
     * @param payment @RequestBody注解指示方法参数的注释应绑定到 Web 请求的正文。
     *                请求的正文通过HttpMessageConverter传递，以根据请求的内容类型解析方法参数。
     *                或者，可以通过使用@Valid注释参数来应用自动验证。
     *                同时加上这个注解后接收的是json格式的数据 可以使用postman测试
     *                【原因 post请求默认发送的格式是json格式的对象 所以后端必须加@RequestBody注解接收】
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("成功插入数据{}条",result);

        if (result>0){
            return new CommonResult(200,"插入数据库成功,服务端口号为"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败,服务端口号为"+serverPort,null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){

        Payment result = paymentService.getPaymentById(id);
        log.info("返回查询返回数据消息为：：【{}】!！,服务端口号为{}",result,serverPort);

        int age=10/2;

        if (result!=null){
            return new CommonResult(200,"查询成功,服务端口号为"+serverPort,result);
        }else {
            return new CommonResult(444,"没有对应id为【"+id+"】的记录！！",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        services.forEach(element->{
            log.info("***element::{}",element);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance->{
            log.info(instance.getInstanceId()+"\t"+instance.getHost()
                    +"\t"+instance.getPort()+"\t"+instance.getUri());
        });

        return discoveryClient;
    }

}
