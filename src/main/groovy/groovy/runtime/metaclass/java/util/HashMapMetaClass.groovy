/*
 * Copyright 2002-2007 the original author or authors.
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

 package groovy.runtime.metaclass.java.util;

import groovy.lang.DelegatingMetaClass
import net.sf.json.JSONObject

/**
 * @author Andres Almiray <aalmiray@users.sourceforge.net>
 */
class HashMapMetaClass extends DelegatingMetaClass {
   HashMapMetaClass( final Class clazz ){
      super( clazz )
      initialize()
   }
   HashMapMetaClass( MetaClassRegistry registry, final Class clazz ){
      super( clazz )
   }

   public Object invokeMethod(Object instance, String methodName, Object[] args )
   {
       if( methodName == "asType" ){
          return asType( instance, args[0] )
       }else{
          return super.invokeMethod( instance, methodName, args )
       }
   }

   private Object asType( map, clazz ){
      if( clazz == JSONObject ){
         return JSONObject.fromObject( map )
      }else{
         return super.invokeMethod( map, methodName, args )
      }
   }
}