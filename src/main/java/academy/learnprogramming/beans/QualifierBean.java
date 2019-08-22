package academy.learnprogramming.beans;

import academy.learnprogramming.annotations.*;
import academy.learnprogramming.interfaces.Salute;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import java.io.Serializable;

@Web
public class QualifierBean implements Serializable {

    @Inject
    @Police
    private Salute policeSalute;

    @Inject
    @Soldier
    private Salute soldierSalute;

    @Inject
    @Any
    private Instance<Salute> dynamicSalute;

    private String police;
    private String soldier;
    private String name;
    private String message;

    public void policeSalutation() {
        police = policeSalute.salute(name);
    }

    public void soldierSalutation() {
        soldier = soldierSalute.salute(name);
    }

    public String getPolice() {
        return police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public String getSoldier() {
        return soldier;
    }

    public void setSoldier(String soldier) {
        this.soldier = soldier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void dynamicSalutation(){
        if(name != null && name.length() == 1){
            Instance<Salute> selectInstance = dynamicSalute.select(new NamedLiteral(name));
            Salute salutationService;
            if (!selectInstance.isUnsatisfied()) {
                salutationService =  selectInstance.get();
            } else {
                System.out.println("Defaulting to Soldier Salutation Service...");
                salutationService = dynamicSalute.select(new AnnotationLiteral<Soldier>() {}).get();
            }
            message = salutationService.salute(name);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
