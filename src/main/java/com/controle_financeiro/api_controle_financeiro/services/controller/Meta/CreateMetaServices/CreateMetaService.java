package com.controle_financeiro.api_controle_financeiro.services.controller.Meta.CreateMetaServices;

import com.controle_financeiro.api_controle_financeiro.configurations.security.UserCredentials;
import com.controle_financeiro.api_controle_financeiro.enums.ExceptionsEnum;
import com.controle_financeiro.api_controle_financeiro.models.GrupoModel;
import com.controle_financeiro.api_controle_financeiro.models.MetaModel;
import com.controle_financeiro.api_controle_financeiro.records.requests.meta.CreateMetaRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.meta.CreateMetaResponseRecord;
import com.controle_financeiro.api_controle_financeiro.repositories.iGrupoRepository;
import com.controle_financeiro.api_controle_financeiro.repositories.iMetaRepository;
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
