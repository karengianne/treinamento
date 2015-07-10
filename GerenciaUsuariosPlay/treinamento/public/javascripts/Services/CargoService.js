(function($){	
	var app = angular.module('app');

	app.service('CargoService', function ($http,$route) {		

 		return {
    		list: function (){
    			var cargos;

				$http.get('/cargos').then(
					function success(response) {
						cargos = response.data;
					}
				);

				return cargos;
			}	
		}	

		this.listTeste = (function(){
			var cargos;

				$http.get('/cargos').then(
					function success(response) {
						cargos = response.data;
					}
				);

			return cargos;
		})();
	}); 

})(jQuery);