(function($){	
	var app = angular.module('app');

	app.controller ('PerfilController', function ($scope,$http,$route,$window) {
			
		$scope.$parent.titulo = "Perfis";

		$http.get('/perfis').then(
			function success(response) {
				$scope.perfis = response.data;
			}
		);


		$scope.insert = function () {

			var dataObj = { 
				nome:$scope.nomePerfil
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

		$scope.delete = function(id){
			
			$http.post('/perfil/' + id + '/remove').then(

				function success(data){

					$scope.mensagem = data.data;
					$scope.tipoMensagem = "success";		

					window.location.reload();			
				},

				function error(data){

					$scope.mensagem = data.data;
					$scope.tipoMensagem = "danger";
				}
			);

		}

		$scope.update = function(id){

			var dataObj = { 
				nome:$scope.nomeEdita.nome
			}

			$http.post('/perfil/' + id, dataObj).then(

				function success(data){
					$scope.mensagem = data.data;
					$route.reload();
				},

				function error(data){
					$scope.mensagem = data.data;
					$scope.tipoMensagem = "danger";					
				});
		};

		$scope.atualizar = function(cargo){

			$scope.nomeEdita = cargo;


			$('.collapseEditaPerfil').collapse();

		};

		$(document).ready(function(){

			$("#alert").alert();
		});

	});

})(jQuery);