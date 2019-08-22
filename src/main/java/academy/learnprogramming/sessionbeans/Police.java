package academy.learnprogramming.sessionbeans;

import academy.learnprogramming.interfaces.Salute;
import academy.learnprogramming.annotations.ServiceMan;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.text.MessageFormat;

@Stateful
@ServiceMan(value = ServiceMan.ServiceType.POLICE)
@academy.learnprogramming.annotations.Police
public class Police implements Salute, Serializable {
    @Override
    public String salute(String name) {
        return MessageFormat.format("Your name starts with p. Police bean injected mr {0}", name);
    }
}
