var app = angular.module("propostaCredito", []);

app.controller("propostaCreditoController", function($scope, propostaCreditoService) {

    $scope.tituloPropostaCredito = "Proposta de Crédito"
    $scope.propostas=[];
    $scope.estados=[
        {nome: "Acre"},
        {nome: "Alagoas"},
        {nome: "Amapá"}
    ];
    $scope.sexos=[
        {cod: "M", nome: "Masculino"},
        {cod: "F", nome: "Feminino"}
    ];
    $scope.estadosCivis=[
        {cod: "SOLTEIRO", nome: "Solteiro(a)"},
        {cod: "CASADO", nome: "Casado(a)"},
        {cod: "VIUVO", nome: "Viúvo(a)"},
        {cod: "DIVORCIADO", nome: "Divorciado(a)"}
    ];
    $('.dinheiro').mask('#.##0,00', {reverse: true});

    $scope.cadastrarProposta = function(proposta) {
        
        propostaCreditoService.cadastrarProposta(proposta).then(function (result) {
            delete $scope.proposta;
            $scope.propostaForm.$setPristine();
            
            if(result.status == 200) {
                alert("Cadastrado com sucesso!");
                limparDados();
            }
        });

    }

    $scope.buscarPropostaPorCpf = function(filtroCpf) {
        $scope.propostas = [];
        propostaCreditoService.buscarPorCpf(filtroCpf).then(function (result) {
            $scope.propostas.push(result.data);
        }, function(notFound) {
            alert("Nenhuma proposta encontrada para o cpf informado!");
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