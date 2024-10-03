package com.controle_financeiro.api_controle_financeiro.services.controller.Meta.UpdateMetaServices;

import com.controle_financeiro.api_controle_financeiro.configurations.security.UserCredentials;
import com.controle_financeiro.api_controle_financeiro.enums.ExceptionsEnum;
import com.controle_financeiro.api_controle_financeiro.models.MetaModel;
import com.controle_financeiro.api_controle_financeiro.records.requests.meta.UpdateMetaRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.meta.UpdateMetaResponseRecord;
import com.controle_financeiro.api_controle_financeiro.repositories.iMetaRepository;
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
