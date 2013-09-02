/**
 * Define Require module with dependencies
 */
define([
  'bootstrap',
  'underscore',
  'backbone',
  'collections/messages',
  'text!templates/datagrid.html'
], function ($, _, Backbone, MessagesCollection, DataGridTemplate) {
  /**
   * User view which represents the user data grid
   */
  var MessagesView = Backbone.View.extend({
    // The view generate a div tag
    tagName:'div',
    // Binding the users collection
    model:MessagesCollection,
    // Binding the DataGridTemplate loaded by text plugin of Require
    template:_.template(DataGridTemplate),
    // No events
    events:{
    },
    // View initialization with listening of the collection
    initialize:function () {
      console.log('UsersView.initialize');
      this.model.on('reset', this.render, this);
    },
    // View rendering handler
    render:function () {
      console.log("UsersView.render", this.model);
      $('.content').html(this.template({
        link:'#messages',
        columns:[
          {
            title:'Message',
            key:'text',
            sort:true
          },
          {
            title:'User',
            key:'user',
            sort:true
          },
          {
            title:"Other",
            anchor:'login'
          }
        ],
        collection:this.model
      }));
//      this.model.each(function (user) {
//        new UserSkillsView({
//          el:this.$('[data-anchor="' + user.get('login') + '"]'),
//          model:user.get('user.User.skills')
//        });
//      });
    }
  });

  // Return the view as the Require module
  return MessagesView;
});
