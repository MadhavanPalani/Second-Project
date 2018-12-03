/**
 * NotificationService
 */
app.factory('NotificationService',function($http){
	var notificationService={}
	
	notificationService.getAllNotifications=function(){
		return $http.get("http://localhost:8080/portalMiddleware/getallnotifications")
	}
	
	
	notificationService.getNotification=function(notificationId){
		return $http.get("http://localhost:8080/portalMiddleware/getnotification/"+notificationId)
	}
	
	notificationService.updateNotification=function(notificationId){
		return $http.put("http://localhost:8080/portalMiddleware/updatenotification/"+notificationId);
	}
	
	return notificationService;
})
