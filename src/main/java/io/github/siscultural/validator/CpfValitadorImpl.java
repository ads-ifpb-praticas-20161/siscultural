/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.siscultural.validator;

import io.github.siscultural.exceptions.InvalidCpfException;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import io.github.siscultural.enums.ErrorMessages;
import java.util.List;

/**
 *
 * @author Natarajan Rodrigues
 */
public class CpfValitadorImpl implements CpfValitador{

    private final CPFValidator validator;

    public CpfValitadorImpl() {
        
        this.validator = new CPFValidator();
        
    }
    
    
    @Override
    public Boolean isValid(String cpf) throws InvalidCpfException {
        
        if (cpf == null) {
            throw new InvalidCpfException(ErrorMessages.EMPTY_CPF.toString());
        }
        
        List<ValidationMessage> validaCPF = validator.invalidMessagesFor(cpf);
        
        if (validaCPF.isEmpty()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
        
    }
    
}
