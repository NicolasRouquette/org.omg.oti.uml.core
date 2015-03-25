/*
 *
 *  License Terms
 *
 *  Copyright (c) 2015, California Institute of Technology ("Caltech").
 *  U.S. Government sponsorship acknowledged.
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *
 *
 *   *   Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *   *   Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the
 *       distribution.
 *
 *   *   Neither the name of Caltech nor its operating division, the Jet
 *       Propulsion Laboratory, nor the names of its contributors may be
 *       used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 *  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.omg.oti.api

// Start of user code for imports
import org.omg.oti._
import org.omg.oti.operations._
// End of user code

/**
 * <!-- begin-model-doc -->
 * A StringExpression is an Expression that specifies a String value that is derived by concatenating a sequence of operands with String values or a sequence of subExpressions, some of which might be template parameters.
 * <!-- end-model-doc -->
 */
trait UMLStringExpression[Uml <: UML]
	extends UMLExpression[Uml]
	with UMLTemplateableElement[Uml]
	with UMLStringExpressionOps[Uml] {
	
	import ops._

	/**
	 * <!-- begin-model-doc -->
	 * The StringExpression of which this StringExpression is a subExpression.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLStringExpression.subExpression
	 */
	def owningExpression: Option[UMLStringExpression[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * The StringExpressions that constitute this StringExpression.
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="true" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLStringExpression.owningExpression
	 */
	def subExpression: Seq[UMLStringExpression[Uml]]

	/**
	 * <!-- begin-model-doc -->
	 * <!-- end-model-doc -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="none" multiplicity="0..1"
	 * @opposite org.omg.oti.api.UMLNamedElement.nameExpression
	 */
	def nameExpression_namedElement: Option[UMLNamedElement[Uml]]

	/**
	 * The XMI meta-attributes relevant to this object
	 */
	override def metaAttributes: MetaAttributeFunctions =
		stringExpression_metaAttributes

	/**
	 * The XMI meta-attributes relevant to class UMLStringExpression
	 */
	def stringExpression_metaAttributes: MetaAttributeFunctions = 
		appendUnique(
			expression_metaAttributes,
			templateableElement_metaAttributes,
			Seq ())

	/**
	 * The XMI composite meta-properties relevant to this object
	 */
	override def compositeMetaProperties: MetaPropertyFunctions =
		stringExpression_compositeMetaProperties

	/**
	 * The XMI composite meta-properties relevant to class UMLStringExpression
	 */
	def stringExpression_compositeMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			expression_compositeMetaProperties,
			templateableElement_compositeMetaProperties,
			Seq (MetaPropertyCollection[Uml, UMLStringExpression[Uml], UMLStringExpression[Uml]]("subExpression", _.subExpression)))

	/**
	 * The XMI reference meta-properties relevant to this object
	 */
	override def referenceMetaProperties: MetaPropertyFunctions =
		stringExpression_referenceMetaProperties

	/**
	 * The XMI reference meta-properties relevant to class UMLStringExpression
	 */
	def stringExpression_referenceMetaProperties: MetaPropertyFunctions = 
		appendUnique(
			expression_referenceMetaProperties,
			templateableElement_referenceMetaProperties,
			Seq ())

	/**
	 * The XMI forward references from metamodel associations relevant to this object
	 */
	override def forwardReferencesFromMetamodelAssociations: Elements =
		stringExpression_forwardReferencesFromMetamodelAssociations

	/**
	 * The XMI forward references from metamodel associations relevant to class UMLStringExpression
	 */
	def stringExpression_forwardReferencesFromMetamodelAssociations: Elements =
		expression_forwardReferencesFromMetamodelAssociations ++
		templateableElement_forwardReferencesFromMetamodelAssociations ++
		owningExpression 

} //UMLStringExpression
