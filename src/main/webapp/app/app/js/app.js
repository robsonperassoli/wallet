'use strict';


// Declare app level module which depends on filters, and services
angular.module('wallet', ['wallet.filters', 'wallet.services', 'wallet.directives', 'wallet.controllers']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/inicio', {templateUrl: 'partials/inicio.html', controller: 'InicioController'});
    $routeProvider.when('/movimentacao', {templateUrl: 'partials/movimentacao.html', controller: 'MovimentacaoController'});
    $routeProvider.otherwise({redirectTo: '/inicio'});
  }]);
