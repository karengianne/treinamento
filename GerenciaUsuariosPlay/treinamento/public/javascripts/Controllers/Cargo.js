(function($){	
	var app = angular.module('app');

	app.controller ('CargoController', function ($scope,$http,$route,$window,CargoService) {

		$scope.$parent.titulo = "Cargos";

		$http.get('/cargos').then(
			function success(response) {
				$scope.cargos = response.data;
			}
		);

		$scope.insert = function () {

			var dataObj = { 
				nome:$scope.nomeCargo
			}

			$http.post('/cargos', dataObj).then(
				function success(data) {

					var msg = data.data;
					var tipo = "success";

					$scope.$parent.$emit('showAlert', msg, tipo);	

				},

				function error(data){

					var msg = data.data;
					var tipo = "danger";

					$scope.$parent.$emit('showAlert', msg, tipo);
				}
			);
		}

		$scope.delete = function(id){
			
			$http.post('/cargo/' + id + '/remove').then(

				function success(data){

					var msg = data.data;
					var tipo = "success";

					$scope.$parent.$emit('showAlert', msg, tipo);

				},

				function error(data){

					var msg = data.data;
					var tipo = "danger";

					$scope.$parent.$emit('showAlert', msg, tipo);
				}
			);

		}

		$scope.update = function(id){

			var dataObj = { 
				nome:$scope.nomeEdita.nome
			}

			$http.post('/cargo/' + id, dataObj).then(

				function success(data){

					var msg = data.data;
					var tipo = "success";

					$scope.$parent.$emit('showAlert', msg, tipo);
				},

				function error(data){
					
					var msg = data.data;
					var tipo = "danger";

					$scope.$parent.$emit('showAlert', msg, tipo);
					
				});
		};

		$scope.atualizar = function(cargo){

			$scope.nomeEdita = cargo;

			$('.collapseEditaCargo').collapse();

		};

//		$scope.$on('showAlert', function(event,mensagem,tipoMensagem){
//
//			$scope.mensagem = mensagem;
//			$scope.tipoMensagem = tipoMensagem;
//			$('#alert').show();
//		});

	});

})(jQuery);