package tn.esprit.spring.services;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClasseService implements InterfaceService {
    //instance repositories
    @Override
    public void testMethod(){
        System.err.println("l'injection fonctionne tres bien");
    }

}
