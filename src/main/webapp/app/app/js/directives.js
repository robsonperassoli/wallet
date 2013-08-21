'use strict';

var conversorDecimalDirective = function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, ngModelController) {
            ngModelController.$parsers.push(function(data) {
                //convert data from view format to model format
                return formataDecimalBrasileiroParaAmericano(data);
            });

            ngModelController.$formatters.push(function(data) {
                //convert data from model format to view format
                return formataDecimalAmericanoParaBrasileiro(data);
            });
        }
    };
};

/* Directives */
angular.module('wallet.directives', [])
.directive('appVersion', ['version', function(version) {
    return function(scope, elm, attrs) {
      elm.text(version);
    };
}])
.directive('conversorMoeda', conversorDecimalDirective);
