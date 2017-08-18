'use strict'


let app = angular.module("myTodoList", []);
app.controller("myTodoCtrl", function($scope) {
    if (localStorage.getItem('myNotes')) {
        $scope.list = JSON.parse(localStorage.getItem('myNotes'))
    }
    else{
        $scope.list = []
    }

    $scope.addToList = function() {
        let record = {
            value:$scope.addValue,
            completed:$scope.completed
        };
        $scope.list.push(record);
        $scope.addValue = "";
        localStorage.setItem('myNotes', JSON.stringify($scope.list))
    }

    $scope.removeItem = function(x) {
        $scope.list.splice(x,1)
        localStorage.setItem('myNotes', JSON.stringify($scope.list))
    }

    $scope.updateItem = function(x){
        $scope.completed = !$scope.completed
        $scope.list[x].completed = $scope.completed
        localStorage.setItem('myNotes', JSON.stringify($scope.list))


    }

});

