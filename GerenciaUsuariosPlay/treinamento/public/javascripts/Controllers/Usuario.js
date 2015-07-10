(function($){	
	var app = angular.module('app');

	app.controller('UsuarioController', function ($scope,$http,$route,$window){

		$scope.$parent.titulo = "Usuários";

		$http.get('/usuarios').then(
			function success(response) {
				$scope.usuarios = response.data;
			}
		);

		$http.get('/perfis').then(
			function success(response) {
				$scope.perfis = response.data;
			}
		);

		$http.get('/cargos').then(
			function success(response) {
				$scope.cargos = response.data;
			}
		);

		$scope.insert = function () {

			var dataObj = { 
				nome:$scope.nomeUsuario
			}

			$http.post('/perfis', dataObj).then(
				function success(data) {

					var msg = data.data;
					var tipo = "success";	

					window.location.reload();
				},

				function error(data){

					var msg = data.data;
					var tipo = "danger";
				}
			);
		}

		$scope.pesquisarPorCargo = function(cargo){
			$scope.cargoUsuario = cargo;
		}

		$scope.pesquisarPorPerfil = function(perfil){
			$scope.perfilUsuario = perfil;
		}

		$scope.cadastrarUsuario = function(){
			$scope.acao = 'Cadastrar';
			$scope.icon = 'ok';
		};

		$scope.pesquisarUsuario = function(){
			$scope.acao = 'Pesquisar';
			$scope.icon = 'search';
		};

		$(document).ready(function(){
			$scope.acao = 'Pesquisar';
			$scope.icon = 'search';
		});

	});


})(jQuery);