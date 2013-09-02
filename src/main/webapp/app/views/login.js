/**
 * Define Require module with dependencies
 */
define([
  'bootstrap',
  'underscore',
  'backbone',
  'models/login',
  'models/message'
], function ($, _, Backbone, LoginStatus, Message) {
  /**
   * Login view which represents the login popup
   */
  var LoginView = Backbone.View.extend({
    // Wired on the login modal
    el:'body',
    // Listen view events on modal buttons
    events:{
      'click .modal-footer .btn.cancelLogin':'cancel',
      'click .modal-footer .btn.doLogin':'ok',
      'click .modal-footer .btn.showRegister':'showRegister',
      'click .modal-footer .btn.doRegister':'doRegister',
      'click .submitMessage':'submitMessage'
    },
    // View initialization with logout outside if the view and listening on model
    initialize:function (callback) {
      this.callback = callback;
      //$("a.logout").click(this.logout);
      LoginStatus.on('change:returnCode', this.returnCodeChange, this);
      LoginStatus.fetch();
    },
    // Login state change handler
    returnCodeChange:function () {
      if (LoginStatus.get('loggedIn')) {
        this.cancel();
        this.$("ul.nav.pull-right").html('<li><a href="logout" class="logout">Logout '+LoginStatus.get('username')+'</a></li>');
        if (this.callback) {
          this.callback();
        }
      } else {
    	  // Not logged in or login error
    	  if(LoginStatus.get('returnCode')==-1 || LoginStatus.get('returnCode')==1) {
    		  this.$("form input").val(null);
    	      this.showLogin();
    	  }
    	  // Login error or register error
          if(LoginStatus.get('returnCode')==1 || LoginStatus.get('returnCode')==2) {
        	  this.$('.alert').show();
          }
          this.$("ul.nav.pull-right").html('<li><a href="#login">Login</a></li>');
      }
    },
    // Ok button handler
    ok:function () {
      LoginStatus.set({
        username:this.$("#username").val(),
        password:this.$("#password").val(),
        rememberMe:this.$("#rememberMe:checked").length > 0,
      });
      LoginStatus.save({}, {type: 'put'});
    },
    doRegister:function(){
    	LoginStatus.set({
    		username:this.$("#newUsername").val(),
    	    password:this.$("#newPassword").val(),
    	});
    	LoginStatus.save({}, {type: 'post'});
    },
    // Cancel button handler
    cancel:function () {
      this.$("div.modal").modal('hide');
    },
    showRegister:function() {
    	this.$('.alert').hide();
    	this.$("div.modal.login").modal('hide');
    	this.$("div.modal.register").modal('show');
    },
    showLogin:function() {
    	this.$('.alert').hide();
    	this.$("div.modal.login").modal('show');
    	this.$("div.modal.register").modal('hide');
    },
    submitMessage:function() {
    	Message.set({
    		text:this.$("#newMessage").val(),
    		user:{id:LoginStatus.get("id")},
    	});
    	Message.save();
    }
    // Logout button handler
//    logout:function () {
//      LoginStatus.destroy();
//      LoginStatus.set({
//        loggedIn:false
//      });
//    }
  });

  // Return the view as the Require module
  return LoginView;

});
