
var infoApp = angular.module('infoApp', ['ngRoute', 'ngResource', 'ui.bootstrap' ]);

infoApp.config(function ($routeProvider) {
    $routeProvider

        .when('/', {
            templateUrl: 'Views/show.html',
            controller: 'ShowController'
        })
        .when('/add', {
            templateUrl: 'Views/add.html',
            controller: 'AddController'
        })
        .when('/sign', {
            templateUrl: 'Views/sign.html',
            controller: 'UserController'
        })
        .otherwise({redirectTo: '/'});
});

