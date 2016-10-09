// MODULE
var workInfoApp = angular.module('workInfoApp', ['ngRoute', 'ngResource', 'ui.bootstrap']);

workInfoApp.config(function($routeProvider) {

    $routeProvider

        .when('/', {
            templateUrl: 'app/pages/main/main.html',
            controller: 'mainController'
        })
        .when('/logins', {
            templateUrl: 'app/pages/login/login.html',
            controller: 'loginController'
        })
        .when('/courses', {
            templateUrl: 'app/pages/course/course.html',
            controller: 'courseController'
        })
        .when('/courses/:courseId/courseDetail', {
            templateUrl: 'app/pages/course/courseDetail.html',
            controller: 'courseController'
        })
        .when('/labels', {
            templateUrl: 'app/pages/label/label.html',
            controller: 'labelController'
        })
});

// CONTROLLERS
workInfoApp.controller('mainController', ['$scope', function ($scope) {

}]);

// FILTERS
workInfoApp.filter('getById', function() {
    return function(elements, id) {
        var selectedElement = {};
        angular.forEach(elements, function(element) {
            if(element.id == id) {
                selectedElement = element;
            }
        });
        return selectedElement;
    }
});