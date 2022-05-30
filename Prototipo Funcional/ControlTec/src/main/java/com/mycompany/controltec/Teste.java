/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controltec;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import java.util.List;

/**
 *
 * @author erick
 */
public class Teste {
    public static void main(String[] args) {
        
        Looca looca = new Looca();
        List<Processo> processos = looca.getGrupoDeProcessos().getProcessos();
        
        for(Processo processo : processos){
            System.out.println("-".repeat(30));
            System.out.println(processo.getUsoCpu());
            System.out.println(processo.getUsoMemoria());
        }
    }
}
