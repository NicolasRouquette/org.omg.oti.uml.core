/*
 * Copyright 2014 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Copyright 2015 Airbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml.read.api._
import scala.language.postfixOps
import scala.Boolean
import scala.Option
import scala.Predef.???
// End of user code

/**
  * A StartClassifierBehaviorAction is an Action that starts the classifierBehavior of the input object.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLStartClassifierBehaviorActionOps[Uml <: UML] { self: UMLStartClassifierBehaviorAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The InputPin that holds the object whose classifierBehavior is to be started.
    *
    * <!-- Start of user code doc for _object -->
    * <!-- End of user code doc for _object -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLInputPin.object_startClassifierBehaviorAction
    */
  def _object: Option[UMLInputPin[Uml]] = input headOption

  /**
    * The multiplicity of the object InputPin is 1..1
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body object.is(1,1)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  /**
    * If the InputPin has a type, then the type or one of its ancestors must have a classifierBehavior.
    *
    * <!-- Start of user code doc for validate_type_has_classifier -->
    * <!-- End of user code doc for validate_type_has_classifier -->
    *
    * {{{
    * OCL Body object.type->notEmpty() implies 
    *    (object.type.oclIsKindOf(BehavioredClassifier) and object.type.oclAsType(BehavioredClassifier).classifierBehavior<>null)
    * }}}
    */
  def validate_type_has_classifier: Boolean = {
    // Start of user code for "type_has_classifier"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLStartClassifierBehaviorActionOps
