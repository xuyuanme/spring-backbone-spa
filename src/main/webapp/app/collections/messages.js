/**
 * Define Require module with dependencies
 */
define([
  'underscore',
  'backbone',
  'collections/Hateoas'
], function (_, Backbone, Hateoas) {

  var MessagesCollection = Hateoas.PageableCollection.extend({
    url:'data-rest/message/search/findAllDto'
  });

  // Return the view as the Require module
  return new MessagesCollection();
});
