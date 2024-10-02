package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.GetAllMetasServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Meta.GetAllMetasResponseRecord;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetAllMetasService implements iGetAllMetasService{
    @Override
    public GetAllMetasResponseRecord getAllMetas(UUID groupId) throws Exception {
        return null;
    }
}
