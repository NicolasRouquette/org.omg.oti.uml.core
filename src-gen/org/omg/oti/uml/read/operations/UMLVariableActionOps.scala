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
import scala.Boolean
import scala.Predef.???
// End of user code

/**
  * VariableAction is an abstract class for Actions that operate on a specified Variable.
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLVariableActionOps[Uml <: UML] { self: UMLVariableAction[Uml] =>

// Start of user code for class imports
// End of user code


  /**
    * The VariableAction must be in the scope of the variable.
    *
    * <!-- Start of user code doc for validate_scope_of_variable -->
    * <!-- End of user code doc for validate_scope_of_variable -->
    *
    * {{{
    * OCL Body variable.isAccessibleBy(self)
    * }}}
    */
  def validate_scope_of_variable: Boolean = {
    // Start of user code for "scope_of_variable"
    ???
    // End of user code
  }

  // Start of user code for additional features
  // End of user code
} //UMLVariableActionOps
