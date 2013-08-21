var _MovimentacaoController = function($scope, $http, apiPath) {

    //$scope.movimentacoes = [];
    var newMovimentacao = function() {
        return {id: null, descricao: '', valor: 0.0, data: '', tipo: ''};
    };

    $scope.totalDespesas = 0.0;
    $scope.totalReceitas = 0.0;
    $scope.total = 0.0;

    $scope.movimentacao = newMovimentacao();

    var config = {
        headers: {
            apiKey: '123456789'
        }
    };

    var init = function() {
        $http.get(apiPath + "/movimentacao/", config)
        .success(function(data) {
            $scope.movimentacoes = data;
            atualizaTotais();
        }).error(function(e) {
            console.log(e);
        });
    };
    init();

    var atualizaTotais = function(){
        $scope.totalDespesas = 0.0;
        $scope.totalReceitas = 0.0;
        $scope.total = 0.0;
        $scope.movimentacoes.forEach(function(movimentacao){
            switch(movimentacao.tipo) {
                case 'R': $scope.totalReceitas += movimentacao.valor; break;
                case 'D': $scope.totalDespesas += movimentacao.valor; break;
            }
        });
        $scope.total = $scope.totalReceitas - $scope.totalDespesas;
    };
    
    $scope.salvar = function() {
        $http.post(apiPath + "/movimentacao/", $scope.movimentacao, config)
        .success(function(data) {
            $scope.movimentacoes.push($scope.movimentacao);
            atualizaTotais();
            $('#modalMovimentacao').modal('hide');
        }).error(function(e) {
            console.log(e);
        });
    };

    $scope.novo = function() {
        $scope.movimentacao = newMovimentacao();
        $('#modalMovimentacao').modal('show');
    };
    
};