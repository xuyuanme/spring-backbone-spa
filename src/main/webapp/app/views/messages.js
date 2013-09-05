/**
 * Define Require module with dependencies
 */
define([
  'bootstrap',
  'underscore',
  'backbone',
  'collections/messages',
  'text!templates/messages.html',
  'models/message'
], function ($, _, Backbone, MessagesCollection, MessagesTemplate, Message) {
  /**
   * Message view which represents the message list
   */
  var MessagesView = Backbone.View.extend({
	el:'body',
    // The view generate a div tag
    tagName:'div',
    // Binding the messages collection
    model:MessagesCollection,
    // Binding the MessagesTemplate loaded by text plugin of Require
    template:_.template(MessagesTemplate),
    events:{
        'click .submitMessage':'submitMessage'
    },
    // View initialization with listening of the collection
    initialize:function () {
      console.log('MessagesView.initialize');
      this.model.on('reset', this.render, this);
    },
    // View rendering handler
    render:function () {
      console.log("MessagesView.render", this.model);
      $('.content').html(this.template({
        link:'#messages',
        text:'text',
        user:'user',
        collection:this.model
      }));
//      this.model.each(function (user) {
//        new UserSkillsView({
//          el:this.$('[data-anchor="' + user.get('login') + '"]'),
//          model:user.get('user.User.skills')
//        });
//      });
    },
    submitMessage:function() {
    	Message.set({
    		text:this.$("#newMessage").val(),
    		//user:{id:LoginStatus.get("id")},
    	});
    	Message.save(null,{success:function(model, response){this.$("#newMessage").val('');MessagesCollection.fetchPage();},
    		error:function(model, response){this.$("#newMessage").val('');MessagesCollection.fetchPage();}});
    }
  });

  // Return the view as the Require module
  return MessagesView;
});
