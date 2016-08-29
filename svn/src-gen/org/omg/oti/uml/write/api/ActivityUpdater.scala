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

import scala.{AnyVal,Boolean,Unit}
import scala.collection.immutable.Set
import scalaz._
// End of user code

/**
 * <!-- Start of user code documentation -->
 * <!-- End of user code documentation -->
 */
class ActivityUpdater[Uml <: UML](val domain: UMLActivity[Uml]) extends AnyVal {

  def links_Activity_activity_compose_edge_ActivityEdge
  (range: Set[UMLActivityEdge[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Activity_activity_compose_edge_ActivityEdge(domain, range)

  def links_Activity_inActivity_compose_group_ActivityGroup
  (range: Set[UMLActivityGroup[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Activity_inActivity_compose_group_ActivityGroup(domain, range)

  def links_Activity_activity_compose_node_ActivityNode
  (range: Set[UMLActivityNode[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Activity_activity_compose_node_ActivityNode(domain, range)

  def links_Activity_activity_reference_partition_ActivityPartition
  (range: Set[UMLActivityPartition[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Activity_activity_reference_partition_ActivityPartition(domain, range)

  def links_Activity_activity_compose_structuredNode_StructuredActivityNode
  (range: Set[UMLStructuredActivityNode[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Activity_activity_compose_structuredNode_StructuredActivityNode(domain, range)

  def links_Activity_activityScope_compose_variable_Variable
  (range: Set[UMLVariable[Uml]])
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.links_Activity_activityScope_compose_variable_Variable(domain, range)

  def setIsReadOnly
  (isReadOnly: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Activity_isReadOnly(domain, isReadOnly)

  def setIsSingleExecution
  (isSingleExecution: Boolean)
  (implicit umlU: UMLUpdate[Uml])
  : \/[Set[java.lang.Throwable],Unit] =
    umlU.set_Activity_isSingleExecution(domain, isSingleExecution)
}
