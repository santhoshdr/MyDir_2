<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
     <html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.16/angular.min.js"></script>
</head>
<body ng-controller="studentController">
    <h1>Student Information:</h1>
    <form ng-submit="submitStudnetForm()" >
            <label for="firstName" >First Name: </label><br />
            <input type="text" id="firstName" ng-model="student.firstName" /> <br />

            <label for="lastName">Last Name</label><br />
                <input type="text" id="lastName" ng-model="student.lastName" /> <br />
            <label for="dob" >DoB</label><br />
                <input type="date" id="dob" ng-model="student.DoB" /> <br /><br />

            <label for="gender" >Gender</label> <br />
                <select id="gender" ng-model="student.gender">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select><br /> <br />
                <span>Training Type:</span><br />
                    <label><input value="online" type="radio" name="training" ng-model="student.trainingType" />Online</label><br />
                    <label><input value="onsite" type="radio" name="training" ng-model="student.trainingType" />OnSite</label> <br /><br />
                <span>Subjects</span><br />
                    <label><input type="checkbox" ng-model="student.maths" />Maths</label> <br />
                    <label><input type="checkbox" ng-model="student.physics" />Physics</label> <br />
                    <label><input type="checkbox"  ng-model="student.chemistry" />Chemistry</label><br /><br />

        <input type="submit" value="Submit" />
        <input type="reset" ng-click="resetForm()" value="Reset" /> <br />
		@* Note: This form will not be submitted in demo. *@
    </form>
    <script>
        //1. create app module
        var studentApp = angular.module('studentApp', []);

        //2. create controller
        studentApp.controller("studentController", function ($scope, $http) {

            //3. attach originalStudent model object
            $scope.originalStudent = {
                firstName: 'James',
                lastName: 'Bond',
                DoB: new Date('01/31/1980'),
                gender: 'male',
                trainingType: 'online',
                maths: false,
                physics: true,
                chemistry: true
            };

            //4. copy originalStudent to student. student will be bind to a form
            $scope.student = angular.copy($scope.originalStudent);

            //5. create submitStudentForm() function. This will be called when user submits the form
            $scope.submitStudnetForm = function () {

                // send $http request to save student
            };

            //6. create resetForm() function. This will be called on Reset button click.
            $scope.resetForm = function () {
                $scope.student = angular.copy($scope.OriginalStudent);
            };
    });
    </script>
</body>
</html>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>