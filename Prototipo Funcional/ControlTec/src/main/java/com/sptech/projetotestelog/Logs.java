/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sptech.projetotestelog;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Usuário
 */
public class Logs {

    private static PrintWriter gravarArq = null;
    private static String arquivo = null;
    private static String captacao = null;
    private static String time = null;
    private static FileWriter arq = null;

    static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date = new Date();

    public void gerarLogs() throws Exception {

        while (true) {
            String captacao = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            arquivo = String.format("HOSTID-%s", captacao);

            Looca looca = new Looca();
            Memoria memoria = looca.getMemoria();
            Processador processador = looca.getProcessador();
            Temperatura temperatura = looca.getTemperatura();
            DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
            ServicosGroup grupoDeServicos = looca.getGrupoDeServicos();
            ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();

            String infoPc = (String.format(
                    "Data e hora: %s\n"
                    + "\n                      Memória em uso: %d\n"
                    + "\n                      Uso do processador: %2f\n"
                    + "\n                      Temperatura: %2f\n"
                    + "\n                      Quantidade de discos: %d\n "
                    + "\n                      Serviços ativos: %s\n"
                    + "\n                      Numero de processos: %d\n"
                    + "\n ",
                    arquivo,
                    looca.getMemoria().getEmUso(),
                    looca.getProcessador().getUso(),
                    looca.getTemperatura().getTemperatura(),
                    looca.getGrupoDeDiscos().getQuantidadeDeDiscos(),
                    looca.getGrupoDeServicos().getServicosAtivos(),
                    looca.getGrupoDeProcessos().getTotalProcessos()
            ));
            Logs log = new Logs();
            log.criarLog(infoPc);
            Thread.sleep(2000L);
        }
    }

    public void criarLog(String infoPc) throws Exception {
        Looca looca = new Looca();
        Long porcentagemMemoria = (looca.getMemoria().getEmUso() * 100 / looca.getMemoria().getTotal() * 100) / 100;
        try {
            if (porcentagemMemoria >= 75) {
                FileWriter myWriter = new FileWriter("filename.log");
                myWriter.write(infoPc);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

/**
 *
 * @param infoPc
 * @throws Exception
 */
