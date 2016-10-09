// CONTROLLERS
workInfoApp.controller('labelController', ['$scope', '$http', '$modal', function ($scope, $http, $modal) {

    $scope.labels = [];
    $scope.newLabel = {};
    $scope.title;
    $scope.showForm = false;

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

    $scope.remove = function() {

    };

    $scope.cancel = function() {
        $scope.newLabel = {};
        $scope.showForm = false;
    }

    $scope.openNewLabelForm = function() {
        $scope.showForm = true;
    };

    $scope.open = function () {
        console.log('opening pop up');
        var modalInstance = $modal.open({
            templateUrl: 'parentLabelModal.html',
            controller: 'parentLabelModalController',
        });
    }

}]);
