angular.module('Todo.ctl', []).
    controller('todoCtl', [ '$http', '$scope', function ($http, $scope) {
        $http.get("/todo/list").success(function(data) {
            $scope.todos = data
        })
        $scope.add = function(action) {
            console.log("add:"+action)
            $http.get("/todo/add/"+action).success(function(data) { $scope.todos = data })
        }
        $scope.del = function(index) {
            console.log("del:"+index)
            $http.get("/todo/del/"+index).success(function(data) { $scope.todos = data })
        }
    }])