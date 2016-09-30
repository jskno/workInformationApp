workInfoApp.controller('courseController', ['$scope', '$log', '$routeParams', '$filter',
    function($scope, $log, $routeParams, $filter) {

    $scope.title = 'COURSE FORM';

    $scope.id = $routeParams.courseId || 0;

    $scope.courses = [
        {
            id: 1,
            title: 'Java',
            center: 'Everis',
            duration: 120,
            startingDate: '',
            endDate: '',
            link: 'www.java.com'
        },
        {
            id: 2,
            title: 'AngularJS',
            center: 'Everis',
            duration: 220,
            startingDate: '',
            endDate: '',
            link: 'www.java.com'
        },
        {
            id: 3,
            title: 'Maven',
            center: 'Everis',
            duration: 150,
            startingDate: '',
            endDate: '',
            link: 'www.java.com'
        }
    ];

    $scope.selectedCourse = $filter('getById')($scope.courses, $scope.id);

}]);