workInfoApp.controller('parentLabelModalController', ['$scope','$modalInstance',function ($scope, $modalInstance) {
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
}]);