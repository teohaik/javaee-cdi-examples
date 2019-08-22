package academy.learnprogramming.sessionbeans;

import academy.learnprogramming.interfaces.Salute;
import academy.learnprogramming.annotations.ServiceMan;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.text.MessageFormat;

@Stateful
@ServiceMan(value = "P")
@academy.learnprogramming.annotations.Police
public class Police implements Salute, Serializable {
    @Override
    public String salute(String name) {
        return "Police bean injected. Passed parameter = "+name;
    }
}
