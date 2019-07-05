var app = angular.module("mainApp", []);

app.controller("PropostaCreditoController", function($scope, $http) {

    $scope.propostas=[];
    $scope.resultadoAnalise="";

    $scope.cadastrarProposta = function() {
        var proposta = {
            nome: $scope.Nome,
            cpf: $scope.Cpf,
            idade: $scope.Idade,
            sexo: $scope.Sexo,
            estadoCivil: $scope.EstadoCivil,
            estado: $scope.Estado,
            dependentes: $scope.Dependentes,
            renda: $scope.Renda
        }

        $http.post("http://localhost:8080/propostas", proposta).then(function (data) {
            $scope.resultadoAnalise = data;
            console.log("Resultado análise" + $scope.resultadoAnalise);
        });

        $scope.propostas.push(proposta);
        limparDados();
    }

    function limparDados() {
        $scope.Nome = '';
        $scope.Cpf = '';
        $scope.Idade = 0;
        $scope.Sexo = '';
        $scope.EstadoCivil = '';
        $scope.Estado = '';
        $scope.Dependentes = 0;
        $scope.Renda = 0;
    }

});