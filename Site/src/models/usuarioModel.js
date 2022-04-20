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
        SELECT * FROM instituicao WHERE email = '${email}' AND senha = '${senha}';
        
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
    
}

function cadastrar(nome, estado, bairro, cidade, rua, pontoreferencia, complemento, numero, email, senha) {
    var instrucao = `
        INSERT INTO instituicao (nome, numero, Rua, Bairro, Cidade, Estado, Complemento, PontoReferencia, email, senha) VALUES ('${nome}', '${estado}', 
        '${numero}','${cidade}','${bairro}','${pontoreferencia}','${rua}','${complemento}','${email}','${senha}');
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    listar,
};