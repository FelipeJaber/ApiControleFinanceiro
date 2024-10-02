package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.CreateLancamentoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.LancamentoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Lancamento.CreateLancamentoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Lancamento.CreateLancamentoResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iLancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CreateLancamentoService implements iCreateLancamentoService{

    iGrupoRepository grupoRepository;
    iLancamentoRepository lancamentoRepository;

    @Autowired
    public CreateLancamentoService(iGrupoRepository grupoRepository, iLancamentoRepository lancamentoRepository) {
        this.grupoRepository = grupoRepository;
        this.lancamentoRepository = lancamentoRepository;
    }

    @Override
    public CreateLancamentoResponseRecord createLancamento(CreateLancamentoRecord createLancamentoRecord) throws Exception {
        GrupoModel grupo = findGrupo(createLancamentoRecord.idGrupo());
        LancamentoModel newLancamento = createNewLancamento(createLancamentoRecord,grupo);
        return new CreateLancamentoResponseRecord("Success",newLancamento);
    }

    private GrupoModel findGrupo(UUID idGrupo) throws Exception{
        Optional<GrupoModel> grupo = grupoRepository.findById(idGrupo);
        if(grupo.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_GRUPO.name());
        if(grupo.get().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return grupo.get();
    }

    private LancamentoModel createNewLancamento(CreateLancamentoRecord createLancamentoRecord, GrupoModel grupo)throws Exception{
        LancamentoModel newLancamento = new LancamentoModel();

        newLancamento.setValor(createLancamentoRecord.valor());
        newLancamento.setTipoLancamento(createLancamentoRecord.tipo());
        newLancamento.setData(createLancamentoRecord.data());
        newLancamento.setGrupo(grupo);
        newLancamento.setDescricao(createLancamentoRecord.descricao());
        newLancamento.setCategoriaLancamento(createLancamentoRecord.categoria());
        newLancamento.setNome(createLancamentoRecord.nome());

        return lancamentoRepository.save(newLancamento);
    }
}
