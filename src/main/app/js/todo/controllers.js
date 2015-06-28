angular.module('Todo.ctl', []).
    controller('todoCtl', ['$http', '$scope', function ($http, $scope) {

        function reset(item) {
            item.action = ""
            item.priority = "NORMAL"
        }

        $scope.item = {}
        $scope.editing = false
        $scope.current = 0
        reset($scope.item)

        $http.get("/todo").success(function (data) {
            console.log(data)
            $scope.todos = data.items
        })

        $scope.select = function (id) {
            console.log(id)
            $scope.current = id
        }

        $scope.add = function () {
            console.log("add:" + $scope.item)
            $http.post("/todo", $scope.item).success(function (data) {
                $scope.todos = data.items
                reset($scope.item)
            })
        }

        $scope.edit = function () {
            console.log("edit:" + $scope.current)
            //console.log($scope.todos)
            angular.forEach($scope.todos, function (v) {
                if (v.id == $scope.current) {
                    $scope.item = v
                    $scope.editing = true
                }
            })
        }

        $scope.save = function () {
            //console.log("add:"+$scope.item)
            $http.put("/todo", $scope.item)
                .success(function (data) {
                    $scope.todos = data.items
                    reset($scope.item)
                    $scope.editing = false
                })
        }

        $scope.done = function () {
            console.log("del:" + $scope.current)
            $http.delete("/todo/" + $scope.current)
                .success(function (data) {
                    $scope.todos = data.items
                })
        }
    }])