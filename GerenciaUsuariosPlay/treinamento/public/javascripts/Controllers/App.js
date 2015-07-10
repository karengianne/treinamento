(function($){	
	var app = angular.module('app',['ngRoute']);
	
	app.config(function($routeProvider, $locationProvider, $httpProvider) {
		
		$routeProvider		
		.when('/cargos', {
			templateUrl : '/app/cargo.html',
			controller  : "CargoController"
		})
		
		.when('/perfis', {
			templateUrl : '/app/perfil.html',
			controller  : "PerfilController"
		})
		
		.when('/usuarios', {
			templateUrl : '/app/usuario.html',
			controller  : "UsuarioController"
		})

		.when('/', {
			templateUrl : '/app/main.html',
			controller  : "AppController"
		})

		.otherwise ({ 
			redirectTo: '/'
		});
	});	

	app.controller ('AppController', function ($scope) {	

		$scope.$on('showAlert', function(event,mensagem,tipoMensagem){

			$scope.mensagem = mensagem;
			$scope.tipoMensagem = tipoMensagem;
			$('#alert').show();

		});

		$scope.closeAlert = function () {

			$('#alert').hide();		
		};

	});
				
})(jQuery);