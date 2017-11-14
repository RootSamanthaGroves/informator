angular.module('infoApp').controller('ShowController', function ($scope,$resource,$http) {
    $scope.message = 'Hello from ShowController';

    $scope.test;


    $scope.saveEQ = function () {
        if ($scope.gallery.length === 0) {
            $scope.image = undefined;
        } else {
            if ($scope.gallery[0].indexOf('data:image/jpeg;base64,') >= 0) {
                $scope.image = $scope.gallery[0].replace('data:image/jpeg;base64,', '');
            }
            if ($scope.gallery[0].indexOf('data:image/png;base64,') >= 0) {
                $scope.image = $scope.gallery[0].replace('data:image/png;base64,', '');
            }
        }

        // console.log($scope.nazwaEQ, $scope.opisEQ);
        var nn = $scope.nazwaEQ;
        var oo = $scope.opisEQ;
        var eqObject = {
            name: nn,
            description: oo ,
            image: $scope.image
        };

        $http.post('/equipment/add', eqObject).success(function () { //wywloujemy

            $scope.loadAll();

            $scope.nazwaEQ = "";
            $scope.opisEQ = "";

        }).error(function () {
            alert("Error");

        })
    };
    $scope.loadAll = function () {

        var Equipment = $resource('equipment/all', {}, {
            query: {method: 'get', isArray: true, cancellable: true}

        });

        Equipment.query(function (response) {

             alert(response);
            $scope.eque = response; // widoku będziesz używał teraz people

        });
    };
    $scope.loadAll();
});