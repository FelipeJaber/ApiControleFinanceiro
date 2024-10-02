package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.UpdateMetaServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.MetaModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Meta.UpdateMetaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Meta.UpdateMetaResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateMetaService implements iUpdateMetaService{

    iMetaRepository metaRepository;

    @Autowired
    public UpdateMetaService(iMetaRepository metaRepository) {
        this.metaRepository = metaRepository;
    }

    @Override
    public UpdateMetaResponseRecord updateMeta(UpdateMetaRecord updateMetaRecord) throws Exception {
        MetaModel metaToBeAltered = findMeta(updateMetaRecord.idMeta());
        MetaModel AlteredMeta = updateMeta(updateMetaRecord, metaToBeAltered);
        AlteredMeta = saveMeta(AlteredMeta);
        return new UpdateMetaResponseRecord(AlteredMeta);
    }

    private MetaModel findMeta(UUID idMeta) throws Exception{
        Optional<MetaModel> meta = metaRepository.findById(idMeta);
        if(meta.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_LANCAMENTO.name());
        if(meta.get().getGrupo().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return meta.get();
    }

    private MetaModel updateMeta(UpdateMetaRecord updateMetaRecord, MetaModel metaToBeAltered)throws Exception{
        metaToBeAltered.setValor(updateMetaRecord.valor());
        metaToBeAltered.setTipoLancamento(updateMetaRecord.tipo());
        return metaToBeAltered;
    }

    private MetaModel saveMeta(MetaModel metaModel) throws Exception{
        return metaRepository.save(metaModel);
    }
}
