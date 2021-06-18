package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.account.Account;
import org.example.domain.account.commands.CreateAccount;

public class CreateAccountUseCase extends UseCase<RequestCommand<CreateAccount>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateAccount> createAccountRequestCommand) {
        var command = createAccountRequestCommand.getCommand();
        var account = new Account(command.getAccountId(), command.getName(),
                command.getAge(), command.getEmail(), command.getPhoneNumber());

        /*if(reto.aprendicesCantidad() >= 12){
            throw new BusinessException(
                    command.getId().value(),
                    "No se puede registrar otro aprendiz en este reto"
            );
        };*/

        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));
    }
}