/**
	 * UserService
	 */
	app.factory('UserService',function($http){
		var userService={}
		
		userService.registration=function(user){//user from controller
			return $http.post("http://localhost:8080/portalMiddleware/register",user)
		}
		
		userService.login=function(user){
			return $http.put("http://localhost:8080/portalMiddleware/login",user)
		}
		
		
		userService.logout=function(){
			return $http.put("http://localhost:8080/portalMiddleware/logout")
		}
		
		return userService;
	})





