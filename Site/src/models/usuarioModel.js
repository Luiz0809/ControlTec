var database = require("../database/config")

function listar() {
    var instrucao = `
        SELECT * FROM usuario;
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function entrar(email, senha) {
        var instrucao = `
        SELECT * FROM usuario WHERE email = '${email}' AND senha = '${senha}';
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

function cadastrar(nome, email, senha, estado, bairro, cep, cidade, rua, pontodereferencia, complemento, instituicao, numero) {
    var instrucao = `
        INSERT INTO usuario (nome, numero, Rua, Bairro, Cidade, Estado, CEP, Complemento, PontoReferencia) VALUES ('${nome}', '${numero}', 
        '${Rua}','${Bairro}','${Cidade}','${Estado}','${Estado}','${CEP}','${Complememto}','${PontoReferencia}');
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    listar,
};