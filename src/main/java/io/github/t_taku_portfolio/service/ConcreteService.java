package io.github.t_taku_portfolio.service;

import io.github.t_taku_portfolio.model.RequestDTO;
import io.github.t_taku_portfolio.repository.ConcreteRepository;

@Deprecated
public class ConcreteService implements Service{
    private RequestDTO dto;
    private ConcreteRepository repository;

    public ConcreteService(ConcreteRepository theRepository){
        System.out.println("in constructor: " + getClass().getSimpleName());
        this.repository = theRepository;
    }

    @Override
    public void setDTO(RequestDTO theDTO) {
        this.dto = theDTO;
    }

    @Override
    public boolean validateRequest() {
        if(!"GET".equals(dto.method())) {
            System.out.println("[Service] request should be GET only");
            return false;
        }
        System.out.println("[Service] request approved");
        return true;
    }

    @Override
    public boolean isJson() {
         if("JSON".equals(dto.contentType())){
            System.out.println("[Service] valid content type");
            return true;
         }
         return false;
    }

    @Override
    public String getJson() {
        return "[" +
                "{\"id\":1001,\"name\":\"Taku\",year:2}," +
                "{\"id\":1002,\"name\":\"Yuki\",year:3}" +
                "]";
    }
}
