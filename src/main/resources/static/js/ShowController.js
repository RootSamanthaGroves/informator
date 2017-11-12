angular.module('infoApp').controller('ShowController', function ($scope,$resource, $http) {
    $scope.message = 'Hello from ShowController';



    var loadAll = function () {

        var Eque = $resource('equipment/all', {}, {
            query: {method: 'get', isArray: true, cancellable: true}

        });

        Eque.query(function (response) {

            // alert(response);
            $scope.eque = response; // widoku będziesz używał teraz people
            console.log(response);
        });
    };
    loadAll();
});