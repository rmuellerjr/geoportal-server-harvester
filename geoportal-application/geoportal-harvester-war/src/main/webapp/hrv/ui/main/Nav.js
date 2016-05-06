/* 
 * Copyright 2016 Esri, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

define(["dojo/_base/declare",
        "dojo/_base/lang",
        "dojo/topic",
        "dijit/_WidgetBase",
        "dijit/_TemplatedMixin",
        "dijit/_WidgetsInTemplateMixin",
        "dojo/i18n!../../nls/resources",
        "dojo/text!./templates/Nav.html"
      ],
  function(declare,lang,topic,_WidgetBase,_TemplatedMixin,_WidgetsInTemplateMixin,i18n,template){
  
    return declare([_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin],{
      i18n: i18n,
      templateString: template,
    
      postCreate: function(){
        
      },
      
      _onhome: function() {
        topic.publish("nav","home");
      },
      
      _onbrokers: function() {
        topic.publish("nav","brokers");
      },
      
      _ontasks: function() {
        topic.publish("nav","tasks");
      },
      
      _onprocesses: function() {
        topic.publish("nav","processes");
      }
    });
});
