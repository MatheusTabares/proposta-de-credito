var app = angular.module("propostaCredito", []);

app.controller("propostaCreditoController", function($scope, propostaCreditoService) {

    $scope.tituloPropostaCredito = "Proposta de Crédito"
    $scope.propostas=[];
    
    $scope.cadastrarProposta = function(proposta) {
        
        propostaCreditoService.cadastrarProposta(proposta).then(function (result) {
            delete $scope.proposta;
            if(result.status == 200) {
                $scope.propostas.push(result.data);
                limparDados();
            }
        });

    }

    function limparDados() {
        $scope.nome = '';
        $scope.cpf = '';
        $scope.idade = 0;
        $scope.sexo = '';
        $scope.estadoCivil = '';
        $scope.estado = '';
        $scope.dependentes = 0;
        $scope.renda = 0;
    }

});