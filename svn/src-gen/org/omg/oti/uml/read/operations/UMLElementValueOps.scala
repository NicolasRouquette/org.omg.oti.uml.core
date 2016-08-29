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
import org.omg.oti.uml.read.api.{UML,UMLElementValue,UMLPackageableElement}
import scala.collection.immutable.Set
import scalaz._, Scalaz._
// End of user code

/**
  *
  *
  * <!-- Start of user code documentation -->
  * <!-- End of user code documentation -->
  */
trait UMLElementValueOps[Uml <: UML] { self: UMLElementValue[Uml] =>

// Start of user code for class imports
// End of user code

  // Start of user code for additional features

  override def asForwardReferencesToImportableOuterPackageableElements
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]]
  = elementValue_asForwardReferencesToImportableOuterPackageableElements

  def elementValue_asForwardReferencesToImportableOuterPackageableElements
  : Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]]
  = element
    .fold[Set[java.lang.Throwable] \/ Set[UMLPackageableElement[Uml]]](
    Set[UMLPackageableElement[Uml]]().right
  ) { e =>
    e.asForwardReferencesToImportableOuterPackageableElements
  }

  // End of user code
} //UMLElementValueOps
