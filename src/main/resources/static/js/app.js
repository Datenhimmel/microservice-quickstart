var commentApp = angular.module('CommentApp',['ngRoute']);

commentApp.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when('/:artikel', {
	  templateUrl: 'templates/home.html',
	  controller: 'CommentCtrl'
	})
});

commentApp.controller('CommentCtrl', function ($scope, $http, $routeParams) {
	
	var articleID = $routeParams.artikel;
	$scope.buttonName = 'Kommentar abschicken';
	$scope.currentComment = {};
	
	$scope.loadComments = function(){
		$http.get('comments/'+articleID)
		.success(function(data) {
			$scope.comments = data;
		 })
	};
	
	$scope.addComment = function(){
		$scope.currentComment.articleID = articleID;
		$http.post('comments',$scope.currentComment)
		.success(function(data) {
			$scope.loadComments();
			$scope.buttonName = 'Kommentar abschicken';
			$scope.currentComment = {};
		 })
	};
	
	$scope.showComment = function(comment){
		$http.get('comments/'+articleID+'/'+comment.id)
		.success(function(data) {
			$scope.currentComment = data;
			$scope.buttonName = 'Bearbeitung beenden ';
			$scope.loadComments();
		})
	};
	
	$scope.deleteComment = function(comment){
		$http.delete('comments/'+articleID+'/'+comment.id)
		.success(function(data) {
			$scope.loadComments();
		 })
	};
	
	$scope.loadComments();
});