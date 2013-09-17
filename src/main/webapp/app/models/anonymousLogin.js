/**
 * Define Require module with dependencies
 */
define([
  'underscore',
  'backbone'
], function (_, Backbone) {
  /**
   * LoginStatus Model
   */
  var LoginStatus = Backbone.Model.extend({
    // Url binding of the REST service
    url:'rest/anonymousLogin'
  });

  // Return the view as the Require module
  return new LoginStatus();
});