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

function cadastrar(nome, estado, bairro, cep, cidade, rua, pontoreferencia, complemento, numero, email, senha) {
    var instrucao = `
        INSERT INTO instituicao (nome, estado, bairro, cep, cidade, rua, pontoreferencia, complemento, numero, email, senha) VALUES ('${nome}', '${estado}', 
        '${bairro}','${cep}','${cidade}','${rua}','${pontoreferencia}','${complemento}','${numero}','${email}','${senha}');
    `;
    console.log("Executando a instrução SQL: \n"+instrucao);
    return database.executar(instrucao);
}

module.exports = {
    entrar,
    cadastrar,
    listar,
};