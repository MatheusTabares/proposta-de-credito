angular.module("propostaCredito").factory("propostaCreditoService", function($http) {
    var _cadastrarProposta = function(proposta) {
        return $http.post("http://localhost:9080/propostas", proposta);
    }

    var _buscarPorCpf = function(filtroCpf) {
        debugger;
        return $http.get("http://localhost:9080/propostas/"+filtroCpf);
    }

    return {
        cadastrarProposta : _cadastrarProposta,
        buscarPorCpf : _buscarPorCpf
    };
});