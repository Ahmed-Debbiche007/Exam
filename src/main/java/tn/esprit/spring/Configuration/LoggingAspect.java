package tn.esprit.spring.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
@ConditionalOnExpression("${aspect.enabled:true}")
public class LoggingAspect {
    private static final Logger logger =
            LogManager.getLogger(LoggingAspect.class);

    @AfterReturning("execution(* tn.esprit.spring.controllers.*.MontantApayerParClient(..))")
    public void afficher (JoinPoint joinPoint){
        logger.info("Montant Facture Calculé!");
    }

}
