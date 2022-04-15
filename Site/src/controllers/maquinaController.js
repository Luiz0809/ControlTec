var maquinaModel = require("../models/usuarioModel");

var sessoes = [];

function testar (req, res) {
    console.log("ENTRAMOS NA usuarioController");
    res.json("ESTAMOS FUNCIONANDO!");
}

function listar(req, res) {
    usuarioModel.listar()
    .then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(
        function (erro) {
            console.log(erro);
            console.log("Houve um erro ao realizar a consulta! Erro: ", erro.sqlMessage);
            res.status(500).json(erro.sqlMessage);
        }
    );
}

function entrar (req, res) {
    var email = req.body.email;
    var senha = req.body.senha;

    if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {
        usuarioModel.entrar(email, senha)
        .then(
            function (resultado) {
                console.log(`\nResultados encontrados: ${resultado.length}`);
                console.log(`Resultados: ${JSON.stringify(resultado)}`); 
                console.log("logado");

                if (resultado.length == 1) {
                    console.log(resultado);
                    res.json(resultado[0]);
                } else if (resultado.length == 0) {
                    res.status(403).send("Email e/ou senha inválido(s)");
                } else {
                    res.status(403).send("Mais de um usuário com o mesmo login e senha!");
                }
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
    }

}

function cadastrar(req, res) {
    var ipt_identify = req.body.ipt_identify;
    var ipt_system = req.body.ipt_system;
    var ipt_name_disk = req.body.ipt_name_disk;
    var ipt_model_disk = req.body.ipt_model_disk;
    var ipt_lenth_disk = req.body.ipt_lenth_disk;
    var ipt_name_memory = req.body.ipt_name_memory;
    var ipt_model_memory = req.body.ipt_model_memory;
    var ipt_lenth_memory = req.body.ipt_lenth_memory;;

    if (ipt_identify == undefined) {
        res.status(400).send("Seu nome está undefined!");
    } else if (ipt_system == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (ipt_name_disk == undefined) {
        res.status(400).send("O nome do seu disco está undefined!");
    }else if (ipt_model_disk == undefined) {
        res.status(400).send("O modelo do seu disco está undefined!");
    }else if (ipt_lenth_disk == undefined) {
        res.status(400).send("O tamanho do seu disco está undefined!");
    }else if (ipt_model_memory == undefined) {
        res.status(400).send("O modelo da sua memoria está undefined!");
    }else if (ipt_lenth_memory == undefined) {
        res.status(400).send("O tamanho da sua memoria está undefined!");
    }else if (ipt_name_memory == undefined) {
        res.status(400).send("Seu nome da memoria está undefined!");
    }else {
        usuarioModel.cadastrar(ipt_identify, ipt_system, ipt_name_disk, ipt_model_disk, ipt_lenth_disk, ipt_name_memory, ipt_model_memory, ipt_lenth_memory)
        .then(
            function (resultado) {
                res.json(resultado);
            }
        ).catch(
            function (erro) {
                console.log(erro);
                console.log(
                    "\nHouve um erro ao realizar o cadastro! Erro: ",
                    erro.sqlMessage
                );
                res.status(500).json(erro.sqlMessage);
            }
        );
    }
}

module.exports = {
    entrar,
    cadastrar,
    testar
}