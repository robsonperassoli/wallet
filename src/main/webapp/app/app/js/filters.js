'use strict';

/* Filters */

angular.module('wallet.filters', [])
.filter('interpolate', ['version', function(version) {
    return function(text) {
      return String(text).replace(/\%VERSION\%/mg, version);
    };
}])
.filter('moeda', [ function(input){
    return function(text) {
        return formataDecimalAmericanoParaBrasileiro(text);
    };
}]);
