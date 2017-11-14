/**
 * Created by Dominika on 2017-01-23.
 */

angular.module('infoApp').service('EquipmentService', function ($resource, $http) {


    this.findByName = function (name) {
        var URL = "equipment/name/" + name;
        return $http({

                method: "GET",
                url: URL
            }
        ).then(function successCallBack(response) {
            return response;
        }, function error(response) {
            return response.status;
        });
    };

    this.loadAll = function () {
        var URL = "equipment/all/";
        return $http({

                method: "GET",
                url: URL
            }
        ).then(function successCallBack(response) {
            return response;
        }, function error(response) {
            return response.status;
        });
    };





});