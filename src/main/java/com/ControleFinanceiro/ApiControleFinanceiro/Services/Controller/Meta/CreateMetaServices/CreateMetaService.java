package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.CreateMetaServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.MetaModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Meta.CreateMetaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Meta.CreateMetaResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CreateMetaService implements iCreateMetaService{

    iGrupoRepository grupoRepository;
    iMetaRepository metaRepository;

    @Autowired
    public CreateMetaService(iGrupoRepository grupoRepository, iMetaRepository metaRepository) {
        this.grupoRepository = grupoRepository;
        this.metaRepository = metaRepository;
    }

    @Override
    public CreateMetaResponseRecord createMeta(CreateMetaRecord createMetaRecord) throws Exception {
        GrupoModel grupo = findGrupo(createMetaRecord.idGrupo());
        MetaModel newMeta = createNewMeta(createMetaRecord, grupo);
        newMeta = saveMetaModel(newMeta);
        return new CreateMetaResponseRecord(newMeta);
    }

    private GrupoModel findGrupo(UUID idGrupo) throws Exception{
        Optional<GrupoModel> grupo = grupoRepository.findById(idGrupo);
        if(grupo.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_GRUPO.name());
        if(grupo.get().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return grupo.get();
    }

    private MetaModel createNewMeta(CreateMetaRecord createMetaRecord, GrupoModel grupoModel) throws Exception{
        MetaModel newMeta = new MetaModel();
        newMeta.setValor(createMetaRecord.valor());
        newMeta.setTipoLancamento(createMetaRecord.tipo());
        newMeta.setGrupo(grupoModel);
        return newMeta;
    }

    private MetaModel saveMetaModel(MetaModel metaModel) throws Exception{
        return metaRepository.save(metaModel);
    }
}
