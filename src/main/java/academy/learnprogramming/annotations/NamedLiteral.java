package academy.learnprogramming.annotations;

import javax.enterprise.util.AnnotationLiteral;

public class NamedLiteral extends AnnotationLiteral<ServiceMan> implements ServiceMan {

        private String value;

        public NamedLiteral(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
}