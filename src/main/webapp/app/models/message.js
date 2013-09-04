/**
 * Define Require module with dependencies
 */
define([
  'underscore',
  'backbone'
], function (_, Backbone) {
  /**
   * Message Model
   */
  var Message = Backbone.Model.extend({
	defaults:{
		user: {id:"1"}
	},
    // Url binding of the REST service
    url:'data-rest/message'
  });

  // Return the view as the Require module
  return new Message();
});