package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Pessoa.UpdatePessoaServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.PessoaModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Pessoa.UpdatePessoaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Pessoas.UpdatePessoaResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iPessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdatePessoaService implements iUpdatePessoaService {
    iPessoaRepository pessoaRepository;

    public UpdatePessoaService(iPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UpdatePessoaResponseRecord updatePessoa(UpdatePessoaRecord updatePessoaRecord) throws Exception {
        PessoaModel pessoaToBeAltered = getPessoaToBeAltered();
        pessoaToBeAltered = getPessoaModelAltered(pessoaToBeAltered, updatePessoaRecord);
        pessoaToBeAltered = saveAlteredPessoaModel(pessoaToBeAltered);
        return createUpdatePessoaResponse(pessoaToBeAltered);
    }

    private PessoaModel getPessoaToBeAltered() throws Exception{
        return UserCredentials.getInstance().getUserModel();
    }

    private PessoaModel getPessoaModelAltered(PessoaModel userToBeAltered, UpdatePessoaRecord updatePessoaRecord) throws Exception{
        PessoaModel modelWithNewInfo = new PessoaModel(updatePessoaRecord);
        userToBeAltered.setCpfPessoa(modelWithNewInfo.getCpfPessoa());
        userToBeAltered.setEmailPessoa(modelWithNewInfo.getEmailPessoa());
        userToBeAltered.setTelefonePessoa(modelWithNewInfo.getTelefonePessoa());
        userToBeAltered.setNomePessoa(modelWithNewInfo.getNomePessoa());
        return userToBeAltered;
    }

    private PessoaModel saveAlteredPessoaModel(PessoaModel alteredPessoaModel) throws Exception{
        return pessoaRepository.save(alteredPessoaModel);
    }

    private UpdatePessoaResponseRecord createUpdatePessoaResponse(PessoaModel newPessoaModel){
        return new UpdatePessoaResponseRecord("Sucess", newPessoaModel);
    }
}
