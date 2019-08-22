package academy.learnprogramming.beans;

import academy.learnprogramming.annotations.Police;
import academy.learnprogramming.annotations.Soldier;
import academy.learnprogramming.annotations.Web;
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
        if(name != null && name.length() > 0){
            if(name.startsWith("p")){
                Instance<Salute> select = dynamicSalute.select(new AnnotationLiteral<Police>() {
                });
                Salute salute = select.get();
                message = salute.salute(name);
            }
            else{
                Instance<Salute> select = dynamicSalute.select(new AnnotationLiteral<Soldier>() {
                });
                Salute salute = select.get();
                message = salute.salute(name);
            }
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
