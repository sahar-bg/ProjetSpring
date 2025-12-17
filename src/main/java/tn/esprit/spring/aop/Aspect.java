package tn.esprit.spring.aop;



import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@org.aspectj.lang.annotation.Aspect
@Slf4j
public class Aspect {

    // Avant l'exécution des méthodes "ajouter*" dans les RestController
    @Before("execution(* tn.esprit.spring.restcontrollers.*.ajouter*(..))")
    public void avant(JoinPoint joinPoint) {
        String packageName = joinPoint.getTarget().getClass().getPackageName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        log.info("Avant exécution : Package = " + packageName
                + ", Classe = " + className
                + ", Méthode = " + methodName
                + " à " + new Date());
    }

    // Après exécution réussie des méthodes "ajouter*"
    @AfterReturning("execution(* tn.esprit.spring.restcontrollers.*.ajouter*(..))")
    public void apres(JoinPoint joinPoint) {
        String packageName = joinPoint.getTarget().getClass().getPackageName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        log.info("Après exécution réussie : Package = " + packageName
                + ", Classe = " + className
                + ", Méthode = " + methodName
                + " à " + new Date());
    }
}
