angular.module("propostaCredito").factory("propostaCreditoService", function($http) {
    var _cadastrarProposta = function(proposta) {
        return $http.post("http://localhost:8080/propostas", proposta);
    }

    return {
        cadastrarProposta : _cadastrarProposta
    };
});