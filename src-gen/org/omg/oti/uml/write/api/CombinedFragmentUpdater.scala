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

package org.omg.oti.uml.write.api

// Start of user code for imports
import org.omg.oti.uml.read.api._

import scala.{AnyVal,Option,Unit}
import scala.collection.immutable._
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class CombinedFragmentUpdater[Uml <: UML](val domain: UMLCombinedFragment[Uml]) extends AnyVal {

  def links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate
  (range: Set[UMLGate[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_CombinedFragment_combinedFragment_compose_cfragmentGate_Gate(domain, range)

  def links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand
  (range: Seq[UMLInteractionOperand[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_CombinedFragment_combinedFragment_compose_operand_InteractionOperand(domain, range)

  def setInteractionOperator
  (interactionOperator: Option[UMLInteractionOperatorKind.Value])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_CombinedFragment_interactionOperator(domain, interactionOperator)
}
