/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:8080/portalMiddleware/addblogpost",blog)
	}
	
	blogService.getBlogsWaitingForApproval=function(){
		return $http.get("http://localhost:8080/portalMiddleware/blogswaitingforapproval")
	}
	
	blogService.getBlogsApproved=function(){
		return $http.get("http://localhost:8080/portalMiddleware/blogsapproved")
	}
	
	blogService.getBlog=function(blogPostId){
		return $http.get("http://localhost:8080/portalMiddleware/getBlog/"+blogPostId)
	}
	
    blogService.approve=function(blogPost){
    	return $http.put("http://localhost:8080/portalMiddleware/approve",blogPost)
    }	
	
	blogService.reject=function(blogPost,rejectionReason){
		return $http.put("http://localhost:8080/portalMiddleware/reject/"+rejectionReason,blogPost)
	}
	
	blogService.hasUserLikedBlogPost=function(blogPostId){
		return $http.get("http://localhost:8080/portalMiddleware/hasUserLikedBlogPost/"+blogPostId);
	}
	
	blogService.updateLikes=function(blogPostId){
		return $http.put("http://localhost:8080/portalMiddleware/updatelikes/"+blogPostId);
	}
	
	blogService.addBlogComment=function(blogComment){
		//newly created blogcomment object with the values for two properties - blogPost, commentTxt
		//blogComment {'blogPost':{},'commentTxt':'Thanks'}
		return $http.post("http://localhost:8080/portalMiddleware/addblogcomment",blogComment)
	}
	
	blogService.getAllBlogComments=function(blogPostId){
	return $http.get("http://localhost:8080/portalMiddleware/getblogcomments/"+blogPostId)	
	}
	
	return blogService;
})
