package com.mycompany.controltec;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.controltec.entidades.Componentes;
import com.mycompany.controltec.entidades.Maquina;
import com.mycompany.controltec.entidades.UsoDeMaquina;
import com.mycompany.controltec.entidades.Usuario;
import com.mycompany.controltec.jdbc.Conexao;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ControlTec {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        Looca looca = new Looca();
        Conexao conexao = new Conexao();
        JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
        Long idMaquina = 0L;
        String identificador = looca.getProcessador().getId();
        UsoDeMaquina udm = new UsoDeMaquina();

        System.out.println("Login: ");
        String login = sc.nextLine();

        System.out.println("Senha: ");
        String senha = sc.nextLine();
        sc.close();
        
        List<Usuario> listaDeUsuarios = con.query("select * from dbo.Usuario where email = '" + login + "' "
                + "AND senha = '" + senha + "';",
                new BeanPropertyRowMapper(Usuario.class));

        List<Maquina> listaDeMaquinas = con.query("select * from dbo.Maquina ",
                new BeanPropertyRowMapper(Maquina.class));

        for (Maquina maquinas : listaDeMaquinas) {
            if (maquinas.getIdentificador().equals(identificador)) {
                idMaquina = maquinas.getIdMaquina();
            }
        }
        if (idMaquina <= 0) {
            System.out.println("Máquina não encontrada,"
                    + "Entre em contato com a sua instituição");
        }

        List<Componentes> listaDeComponentes = con.query("select * from dbo.Componentes where fkMaquina = '" + 4 + "'; ",
                new BeanPropertyRowMapper(Componentes.class));

        if (listaDeUsuarios.isEmpty()) {

            System.out.println("Login e/ou senha inválidos");
        } else {
            System.out.println("Logado com sucesso");

            while (true) {
                for (Componentes componente : listaDeComponentes) {
                    udm.capturarDados(listaDeUsuarios.get(0), componente);
                }
                Thread.sleep(200L);
            }
        }
    }

}
