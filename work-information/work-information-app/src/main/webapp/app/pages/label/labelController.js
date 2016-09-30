// CONTROLLERS
workInfoApp.controller('labelController', ['$scope', '$http', function ($scope, $http) {

    $scope.labels = [];
    $scope.newLabel = {};

    $http.get('rs/labels/findAll')
        .success(function(data) {
            $scope.labels = data.labels;
        })
        .error(function(data, status) {
            console.log(data);
        });

    $scope.save = function() {

        $http.post('rs/labels/save', $scope.newLabel)
            .success(function(data) {

            })
            .error(function(data, status) {
                console.log(data);
            });
    };

}]);
