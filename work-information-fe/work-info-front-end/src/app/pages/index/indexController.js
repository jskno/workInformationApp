// var app = angular.module('STOR');
//
// app.controller('StorRootController', ['$scope', '$q', 'UserContextAccessService',
//     function ($scope, $q, UserContextAccessService) {
//
//         'use strict';
//         $scope.userContext = {
//             userLoginName: null,
//             userUid: null,
//             permissions: []
//         };
//
//         $scope.initOK = true;
//
//         var init = function () {
//             UserContextAccessService.getUserContext().then(function (data) {
//                 if (angular.isDefined(data['userLoginName'])) {
//                     $scope.userContext.userLoginName = data['userLoginName'];
//                 }
//                 if (angular.isDefined(data['userUid'])) {
//                     $scope.userContext.userUid = data['userUid'];
//                 }
//                 if (angular.isDefined(data['permissions'])) {
//                     for (var iter in data.permissions) {
//                         if (data.permissions.hasOwnProperty(iter)) {
//                             $scope.userContext.permissions.push(data.permissions[iter]);
//                         }
//                     }
//                 }
//             }, function (reason) {
//                 // error
//                 $scope.initOK = false;
//             });
//         };
//         init();
//
//     }]);
