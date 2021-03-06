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
  * A TestIdentityAction is an Action that tests if two values are identical objects.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLTestIdentityActionOps[Uml <: UML] { self: UMLTestIdentityAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The OutputPin whose Boolean value indicates whether the two input objects are identical.
    *
    * <!-- Start of user code doc for result -->
    * <!-- End of user code doc for result -->
    *
    * UML Property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="1..1"
    * UML opposite Property: org.omg.oti.uml.read.api.UMLOutputPin.result_testIdentityAction
    */
  def result: Option[UMLOutputPin[Uml]] = output headOption

  /**
    * The multiplicity of the InputPins is 1..1.
    *
    * <!-- Start of user code doc for validate_multiplicity -->
    * <!-- End of user code doc for validate_multiplicity -->
    *
    * {{{
    * OCL Body first.is(1,1) and second.is(1,1)
    * }}}
    */
  def validate_multiplicity: Boolean = {
    // Start of user code for "multiplicity"
    ???
    // End of user code
  }

  /**
    * The InputPins have no type.
    *
    * <!-- Start of user code doc for validate_no_type -->
    * <!-- End of user code doc for validate_no_type -->
    *
    * {{{
    * OCL Body first.type= null and second.type = null
    * }}}
    */
  def validate_no_type: Boolean = {
    // Start of user code for "no_type"
    ???
    // End of user code
  }

  /**
    * The type of the result OutputPin is Boolean. 
    *
    * <!-- Start of user code doc for validate_result_is_boolean -->
    * <!-- End of user code doc for validate_result_is_boolean -->
    *
    * {{{
    * OCL Body result.type=Boolean
    * }}}
    */
  def validate_result_is_boolean: Boolean = {
    // Start of user code for "result_is_boolean"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLTestIdentityActionOps
