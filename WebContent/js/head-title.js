/**
 * 
 */
$(function(){
	$.ajax({
		type: "GET",
		async: false,
        url: "html/head-title.html", 
        dataType: "html",
        data:{
        },
        success : function(data){
        	$("#head-title").html(data);
        	}    
        }		
	);
	$.getJSON("log",{method:"getUser"},function(data){ 
			if(data["msg"]=="NotLogin"){
        		
        	
        	$("#username").html("游客，请");
        	
        	$("#log").html('<a href="javascript:void(0)" id="login">登录</a>');
        	H_login.openLogin();
        	}else if(data["msg"]=="Login"){
        		$("#username").html(data["username"]);
        		$("#log").html('<a id="logout" href="javascript:void(0)" id="logout">注销</a>');
        		H_login.logout();
        		if(data["identify"]=="1"){
        			$("#head-title").append('<a class="function" href="addTask.html" id="addTask">布置作业</a>');
        		}
        	}
		});
	$(function () {
		
	    H_login = {};
	    H_login.openLogin = function(){
	        $('#login').click(function(){
	            $('.login').show();
	            $('.login-bg').show();
	        });
	    };
	    H_login.closeLogin = function(){
	        $('.close-login').click(function(){
	            $('.login').hide();
	            $('.login-bg').hide();
	        });
	    };
	    H_login.loginForm = function () {
	        $("#login-button-submit").on('click',function(){
	              var userIdInput = $("#userId");
	              var userIdValue = $("#userId").val();
	              var passwordInput = $("#password");
	              var passwordValue = $("#password").val();
	            if(userIdValue == ""){
	            	$("#message label").html("账号不能为空");
	            	$("#message label").css("color","red");
	                userIdInput.focus();
	                return false;
	            }else if(passwordValue == ""){
	            	$("#message label").html("密码不能为空");
	            	$("#message label").css("color","red");
	                passwordInput.focus();
	                return false;
	            }else{
	            	

	            	$.ajax({
	            		type: "POST",
	            		async: false,
	                    url: "log?method=login", 
	                    dataType: "text",
	                    data:{
	                        userId : userIdValue,
	                        password : passwordValue,
	                    },
	                    success : function(data){
	                    	if(data=="NotExist"){
	                    		
	                    	
	                    	$("#message label").html("用户不存在");
	                    	$("#message label").css("color","red");
	                    	userIdInput.focus();
	                    	return false;
	                    	}else if(data=="PasswordWrong"){
	                    		$("#message label").html("密码错误");
	                        	$("#message label").css("color","red");
	                    		passwordInput.focus();
	                    		return false;
	                    	}
	                    	else if(data=="Success"){
	                    		$("#message label").html("登陆成功");
	                        	$("#message label").css("color","green");
	                    		setTimeout(function(){
	                                $('.login').hide();
	                                $('.login-bg').hide();
	                                window.location.reload();
	                            },800);
	                    		
	                    	}    
	                    }
	            	}
	            			
	            	);
	            	
	                
	            }
	        });
	    };
	    H_login.logout=function(){
	    	$("#logout").click(function(){
	    		$.ajax({
	    			url:"log?method=logout",
	    			success:function(){
	    				 window.location.reload();
	    			}
	    		}
	    		)
	    	}
	    	)
	    }
	    H_login.run = function () {
	        this.closeLogin();
	        this.openLogin();
	        this.loginForm();
	        this.logout();
	    };
	    H_login.run();
	});

})