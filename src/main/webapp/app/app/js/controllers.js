'use strict';

/* Controllers */

angular.module('wallet.controllers', [])
.controller('InicioController', ['$scope', '$http', _InicioController])
.controller('MovimentacaoController', ['$scope', '$http' , 'apiPath',_MovimentacaoController]);