/**
 * FriendService
 */

app.factory('FriendService',function($http){
	var friendService={}

	friendService.getAllSuggestedUsers=function(){
		return $http.get("http://localhost:8080/portalMiddleware/suggestedusers")
	}
	
	friendService.sendFriendRequest=function(user){//value for toId property in Friend Entity
		return $http.post("http://localhost:8080/portalMiddleware/friendrequest",user)
	}
	
	friendService.getPendingRequests=function(){
		return $http.get("http://localhost:8080/portalMiddleware/pendingrequests")
	}
	
	friendService.acceptRequest=function(friendRequest){
		return $http.put("http://localhost:8080/portalMiddleware/acceptrequest",friendRequest)
	}
	friendService.deleteRequest=function(friendRequest){
		return $http.put("http://localhost:8080/portalMiddleware/deleterequest",friendRequest)
	}
	
	friendService.getAllFriends=function(){
		return $http.get("http://localhost:8080/portalMiddleware/friends")
	}
	
	return friendService;
})
