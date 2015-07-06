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
package org.omg.oti.uml.read.operations

// Start of user code for imports
import org.omg.oti.uml._
import org.omg.oti.uml.read._
import org.omg.oti.uml.read.api._
import scala.collection.JavaConversions._
import scala.language.postfixOps
import scala.language.existentials
import scala.reflect.runtime.universe._
import scala.reflect._
import scala.util.Try
import scala.util.Success
import scala.util.Failure
// End of user code

/**
 * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 *
 * <!-- Start of user code documentation --> 
 * <!-- End of user code documentation -->
 */
trait UMLElementOps[Uml <: UML] { self: UMLElement[Uml] =>	

	implicit val ops: UMLOps[Uml]
	import self.ops._

	/**
	 * The Comments owned by this Element.
	 *
	 * <!-- Start of user code doc for ownedComment -->
	 * <!-- End of user code doc for ownedComment -->
	 *
	 * @property derived="false" ordered="false" unique="true" aggregation="composite" multiplicity="0..*"
	 * @opposite org.omg.oti.api.UMLComment.ownedComment_owningElement
	 */
	def ownedComment: Set[UMLComment[Uml]] = ownedElement.selectByKindOf { case x: UMLComment[Uml] => x }

	/**
	 * The query allOwnedElements() gives all of the direct and indirect ownedElements of an Element.
	 *
	 * <!-- Start of user code doc for allOwnedElements -->
	 * <!-- End of user code doc for allOwnedElements -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="0..*"
	 * @body result = (ownedElement->union(ownedElement->collect(e | e.allOwnedElements()))->asSet())
	 */
	def allOwnedElements: Set[UMLElement[Uml]] = {
		// Start of user code for "allOwnedElements"
  	closure[UMLElement[Uml], UMLElement[Uml]](self, _.ownedElement)
  	// End of user code
	}

	/**
	 * The query mustBeOwned() indicates whether Elements of this type must have an owner. Subclasses of Element that do not require an owner must override this operation.
	 *
	 * <!-- Start of user code doc for mustBeOwned -->
	 * <!-- End of user code doc for mustBeOwned -->
	 *
	 * @operation ordered="false" unique="true" multiplicity="1..1"
	 * @body result = (true)
	 */
	def mustBeOwned: Boolean = {
		// Start of user code for "mustBeOwned"
  	true
  	// End of user code
	}

	/**
	 * Elements that must be owned must have an owner.
	 *
	 * <!-- Start of user code doc for validate_has_owner -->
	 * <!-- End of user code doc for validate_has_owner -->
	 *
	 * @body mustBeOwned() implies owner->notEmpty()
	 */
	def validate_has_owner: Boolean = {
		// Start of user code for "has_owner"
  	if (mustBeOwned) {
      owner.isDefined 
    } else true
  	// End of user code
	}

	/**
	 * An element may not directly or indirectly own itself.
	 *
	 * <!-- Start of user code doc for validate_not_own_self -->
	 * <!-- End of user code doc for validate_not_own_self -->
	 *
	 * @body not allOwnedElements()->includes(self)
	 */
	def validate_not_own_self: Boolean = {
		// Start of user code for "not_own_self"
  	!allOwnedElements.contains(self)
  	// End of user code
	}

	// Start of user code for additional features

  /**
   * The element or the first owner of the element that is a package with an effective URI; none if no such owner package exists.
   */
  @annotation.tailrec final def getPackageOwnerWithEffectiveURI: Option[UMLPackage[Uml]] =
    self match {
      case p: UMLPackage[Uml] if p.getEffectiveURI.isDefined => Some( p )
      case _ => owner match {
        case Some( o ) => o.getPackageOwnerWithEffectiveURI
        case None      => None
      }
    }

  /**
   * directed, non-derived, composite association end properties
   *
   * The order is according to Canonical XMI (ptc/2013-08-31), B5.2:
   * B5.2 Property Elements
   *
   * Issue 17261: clarify the ordering
   * Properties of an element are ordered by the class in which they are defined.
   * Properties defined by a superclass appear before those of its subclasses.
   * Where a class inherits from more than one direct superclass,
   * properties from the class with the alphabetically earlier class name appear
   * before those of an alphabetically later class name.
   *
   * Issue 17262: add note to clarify the ordering
   * Note that if a property is redefined in a subclass,
   * its position in the order remains the position of the original redefined property within the parent class.
   *
   * In OTI, B5.2 is interpreted as follows:
   *
   * For classes C1, C2 and for composite, non-derived properties P1, P2 such that:
   * - P1 is defined in C1
   * - P2 is defined in C2
   * - C2 is the specific classifier in a generalization relationship with C1 as general classifier
   * Then:
   * - compositeMetaProperties contains P1 and P2
   * - P1 is before P2, regardless of whether P2 directly or indirectly redefines P1
   *
   * @see http://solitaire.omg.org/browse/TIWG-29
   * @see http://solitaire.omg.org/browse/TIWG-25
   */
  def compositeMetaProperties: MetaPropertyFunctions

  /**
   * directed, non-derived, reference association end properties
   *
   * The order is according to Canonical XMI (ptc/2013-08-31), B5.2:
   * B5.2 Property Elements
   *
   * Issue 17261: clarify the ordering
   * Properties of an element are ordered by the class in which they are defined.
   * Properties defined by a superclass appear before those of its subclasses.
   * Where a class inherits from more than one direct superclass,
   * properties from the class with the alphabetically earlier class name appear
   * before those of an alphabetically later class name.
   *
   * Issue 17262: add note to clarify the ordering
   * Note that if a property is redefined in a subclass,
   * its position in the order remains the position of the original redefined property within the parent class.
   *
   * In OTI, B5.2 is interpreted as follows:
   *
   * For classes C1, C2 and for non-composite, non-derived properties P1, P2 such that:
   * - P1 is defined in C1
   * - P2 is defined in C2
   * - C2 is the specific classifier in a generalization relationship with C1 as general classifier
   * Then:
   * - referenceMetaProperties contains P1 and P2
   * - P1 is before P2, regardless of whether P2 directly or indirectly redefines P1
   *
   * @see http://solitaire.omg.org/browse/TIWG-29
   * @see http://solitaire.omg.org/browse/TIWG-25
   */
  def referenceMetaProperties: MetaPropertyFunctions

  /**
   * The set of Elements referenced from this Element due to link instances of
   * directed, non-composite, non-derived associations defined in the UML metamodel
   *
   * This method is defined for every metaclass according to the figures from the UML spec in two idioms:
   * - concrete metaclasses:
   *
   * The override method includes up to 3 contributions:
   * - those of the metaclass itself
   *
   * - the concrete direct generalization parent metaclass (zero or one)
   * => super.forwardReferencesFromMetamodelAssociations
   *
   * - each abstract direct generalization parent metaclass (zero or more)
   * => [metaclass name]_forwardReferencesFromMetamodelAssociations
   */
  def forwardReferencesFromMetamodelAssociations: Set[UMLElement[Uml]]

  /**
   * The element itself (if it is a kind of namespace)
   * or the first owner of the element that is a kind of namespace.
   */
  @annotation.tailrec final def owningNamespace: Option[UMLNamespace[Uml]] = self match {
    case ns: UMLNamespace[Uml] => Some( ns )
    case e: UMLElement[Uml] => e.owner match {
      case None      => None
      case Some( o ) => o.owningNamespace
    }
  }

  /**
   * To enable verifying whether all forward references from elements contained within
   * the scope of a package refer to elements that are directly or indirectly imported
   * from that package or included in directly or indirectly applied profiles, it is necessary
   * to aggregate a forward reference to an element up to the first,
   * importable outer packageable element. This aggregation is metaclass-specific.
   *
   * By default, this method delegates to asForwardReferencesToOwningElementImportableOuterPackageableElements
   *
   * @see asForwardReferencesToOwningElementImportableOuterPackageableElements
   */
  def asForwardReferencesToImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] =
    asForwardReferencesToOwningElementImportableOuterPackageableElements

  def mofXMI_metaAtttributes: MetaAttributeFunctions =
    Seq(
      MetaAttributeStringFunction[Uml, UMLElement[Uml]]( Some( "xmi" ), "id", _.xmiID ),
      MetaAttributeStringFunction[Uml, UMLElement[Uml]]( Some( "xmi" ), "uuid", _.xmiUUID ),
      MetaAttributeStringFunction[Uml, UMLElement[Uml]]( Some( "xmi" ), "type", _.xmiType ) )

  type MetaAttributeFunction = MetaAttributeAbstractFunction[Uml, _ <: UMLElement[Uml], _]

  type MetaAttributeFunctions = Seq[MetaAttributeFunction]

  /**
   * Non-derived property attributes typed by a PrimitiveType
   */
  def metaAttributes: MetaAttributeFunctions

  // -----------------------

  type Elements = Set[UMLElement[Uml]]

  type MetaPropertyEvaluator = MetaPropertyFunction[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]
  type MetaReferenceEvaluator = MetaPropertyReference[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]
  type MetaCollectionEvaluator = MetaPropertyCollection[Uml, _ <: UMLElement[Uml], _ <: UMLElement[Uml]]

  type MetaPropertyFunctions = Seq[MetaPropertyEvaluator]

  /**
   * @todo TIWG-35
   *
   * @return
   */
  def forwardRelationTriples: Try[Set[RelationTriple[Uml]]] = {

    def addEvaluatedTriples(
      acc: Try[Set[RelationTriple[Uml]]],
      f: MetaPropertyEvaluator ): Try[Set[RelationTriple[Uml]]] = acc match {
      case Failure( t ) => Failure( t )
      case Success( triples ) => f match {
        case rf: MetaReferenceEvaluator =>
          rf.evaluate( self ) match {
            case Failure( t )           => Failure( t )
            case Success( None )        => Success( triples )
            case Success( Some( ref ) ) => 
              if (self.owner.get == ref ) Success( triples )
              else Success( triples + AssociationTriple( sub = self, relf = rf, obj = ref ) )
          }
        case cf: MetaCollectionEvaluator =>
          cf.evaluate( self ) match {
            case Failure( t )    => Failure( t )
            case Success( Nil )  => Success( triples )
            case Success( refs ) => Success( triples ++ (refs.toSet - self.owner.get).map( AssociationTriple( sub = self, relf = cf, _ ) ) )
          }
      }
    }

    // TIWG-35
    val triples: Set[RelationTriple[Uml]] = ???
//      tagValues.flatMap { case ( p, vs ) =>
//      p.owningStereotype match {
//        case None =>
//          Set[RelationTriple[Uml]]()
//        case Some( s ) =>
//          val refs = vs flatMap (_.forwardReferencesFromStereotypeTagValue)
//          (refs map (StereotypePropertyTriple(sub=self, rels=s, relp=p, _))).toSet[RelationTriple[Uml]]
//      }
//    } toSet

    val acc0: Try[Set[RelationTriple[Uml]]] = Success( triples )
    val accN = ( acc0 /: self.referenceMetaProperties )( addEvaluatedTriples )
    accN
  }
  
  def appendUnique[F]( s1: Seq[F], s2: Seq[F] )( implicit f: ClassTag[F] ): Seq[F] =
    s1 ++ ( s2 filter ( !s1.contains( _ ) ) )

  def appendUnique[F]( ss: Seq[F]* )( implicit f: ClassTag[F] ): Seq[F] =
    ss.toList match {
      case Nil                 => Seq()
      case ( s :: Nil )        => s
      case ( s1 :: s2 :: Nil ) => appendUnique( s1, s2 )
      case ( s :: sx )         => appendUnique( s, appendUnique( sx: _* ) )
    }

  // TIWG-35
//  def stereotypeTagValues: Map[UMLStereotype[Uml], Map[UMLProperty[Uml], Seq[UMLValueSpecification[Uml]]]] =
//    tagValues.groupBy( _._1.owningStereotype.get )

  /**
   * @todo TIWG-35
   *
   * @param tagProperty
   * @return
   */
  def getStereotypeTagPropertyStringValue(tagProperty: Option[UMLProperty[Uml]])
  : Option[String] = ???
//    (for {
//      tag <- tagProperty
//      value <- ( tagValues get tag )
//      result <- value.headOption match {
//        case Some(s: UMLLiteralString[Uml]) =>
//          Some(s.value)
//        case _ =>
//          None
//      }
//    } yield result).flatten

  /**
   * @todo TIWG-35
   *
   * @param tagProperty
   * @return
   */
  def getStereotypeTagPropertyEnumValue(tagProperty: Option[UMLProperty[Uml]])
  : Option[UMLEnumerationLiteral[Uml]] = ???
//    for {
//      tag <- tagProperty
//      value <- ( tagValues get tag )
//      result <- value.headOption match {
//        case Some(iv: UMLInstanceValue[Uml]) =>
//          iv.instance match {
//            case Some(e: UMLEnumerationLiteral[Uml]) =>
//              Some(e)
//            case _ =>
//              None
//          }
//        case _ =>
//          None
//      }
//    } yield result

  def oti_xmiID: Option[String] =
    getStereotypeTagPropertyStringValue(OTI_IDENTITY_xmiID)

  def oti_xmiUUID: Option[String] =
    getStereotypeTagPropertyStringValue(OTI_IDENTITY_xmiUUID)

  def xmiID: Iterable[String] = oti_xmiID match {
    case None => Iterable(id)
    case Some(oid) => Iterable(oid)
  }

  def xmiUUID: Iterable[String] = oti_xmiUUID match {
    case None => uuid.toIterable
    case Some(ouuid) => Iterable(ouuid)
  }

  def xmiElementLabel: String = mofMetaclassName
  def metaclass_name: String = mofMetaclassName( 0 ).toLower + mofMetaclassName.drop( 1 )
  
  def xmiOrderingKey: String = element_xmiOrderingKey
  def element_xmiOrderingKey: String = xmiElementLabel + xmiUUID.headOption.getOrElse( xmiID.headOption.getOrElse( "" ) )

  def xmiType: Iterable[String] = Iterable( "uml:" + mofMetaclassName )

  /**
   * All the non-package elements directly or indirectly owned by a package scope.
   */
  def allOwnedElementsWithinPackageScope: Set[UMLElement[Uml]] = {

    def directlyOwnedElementFilter( owned: UMLElement[Uml] ): Boolean =
      owned match {
        case _: UMLPackage[Uml]       => false
        case _: UMLElementImport[Uml] => false
        case _: UMLPackageImport[Uml] => false
        case _: UMLPackageMerge[Uml]  => false
        case _                        => true
      }

    @annotation.tailrec def allOwnedElementsWithinPackageScopeAggregator(
      acc: Set[UMLElement[Uml]],
      es: List[UMLElement[Uml]] ): Set[UMLElement[Uml]] = es match {
      case Nil => acc
      case x :: xs =>
        x match {
          case p: UMLPackage[Uml] =>
            val pOwned = p.ownedElement.filter( directlyOwnedElementFilter( _ ) ).toList
            allOwnedElementsWithinPackageScopeAggregator( acc, pOwned ::: xs )
          case e if ( directlyOwnedElementFilter( e ) ) =>
            val eOwned = e.ownedElement.filter( directlyOwnedElementFilter( _ ) ).toList
            allOwnedElementsWithinPackageScopeAggregator( acc + e, eOwned ::: xs )
          case _ =>
            allOwnedElementsWithinPackageScopeAggregator( acc, xs )
        }
    }

    allOwnedElementsWithinPackageScopeAggregator( Set(), List( this ) ) - this
  }
  
  /**
   * @todo TIWG-35
   * The set of Elements referenced from this Element due to values of applied stereotype tag properties
   */
  def allForwardReferencesFromStereotypeTagProperties: Set[UMLElement[Uml]] = {

    def forwardReferencesFromStereotypeTagProperties1( x: UMLElement[Uml] ): Set[UMLElement[Uml]] = ???
//      x.getAppliedStereotypes.keys.toSet[UMLElement[Uml]] ++
//        ( x.tagValues flatMap { case ( p, vs ) => vs flatMap ( _.forwardReferencesFromStereotypeTagValue ) } )

    closure( this, forwardReferencesFromStereotypeTagProperties1 )
  }

  /**
   * @todo TIWG-35
   * Serializing an element E to a document includes serializing E's composite references from E's stereotype tag property values
   */
  def compositeReferencesFromStereotypeTagPropertyValues: Set[UMLElement[Uml]] = ???
//    tagValues flatMap { case ( p, vs ) => vs flatMap ( _.compositeReferencesFromStereotypeTagValue ) } toSet

  /**
   * Calculate the references from this element to other elements due to any of the following:
   * - non-composite, non-derived properties defined for the element's metaclass (`forwardReferencesFromMetamodelAssociations`)
   * - stereotype tag property values due to stereotypes applied to the element (`allForwardReferencesFromStereotypeTagProperties`)
   *
   * For serializing an OTI model into an OMG Canonical XMI document,
   * the references among elements do matter; particularly, references
   * due to non-composite, non-derived properties matter because their serialization
   * depends on whether the two elements are serialized within the same document or not.
   *
   * The OMG MOF/XMI spec is incomplete in the sense that it does not mention
   * references due to values of applied stereotype tag properties.
   */
  def allForwardReferencesToElements: Set[UMLElement[Uml]] =
    Set( this ) ++ forwardReferencesFromMetamodelAssociations ++ allForwardReferencesFromStereotypeTagProperties

  /**
   * Aggregates all forward references to the level of importable outer packageable elements
   */
  def allForwardReferencesToImportablePackageableElements: Set[UMLPackageableElement[Uml]] =
    allForwardReferencesToElements flatMap ( _.asForwardReferencesToImportableOuterPackageableElements )

  def asForwardReferencesToOwningElementImportableOuterPackageableElements: Set[UMLPackageableElement[Uml]] =
    owner.fold( Set[UMLPackageableElement[Uml]]() )( _.asForwardReferencesToImportableOuterPackageableElements )

  // API to be implemented

  def mofMetaclassName: String

  def tagValues: Map[UMLProperty[Uml], UMLStereotypeTagValue[Uml]]

  /**
   * @See MOF2.5
   *
   * Section 15.9 Additional Operations
   * [6] This returns the single Property with a slot that represents
   *     the current owner of the Object based on current instance values;
   *     may be null for top level objects.
   *
   *  (M1)Object::owningProperty(): (M2)Property modeled as (M1)ClassInstance::owningProperty(): (M2)Property
   *  result = self.classifier.allSlottableProperties()->any(p |p.opposite <> null and p.opposite.isComposite and self.get(p)<> null)
   *
   * @return The MetaPropertyEvaluator, if any, that represents the current owner of the (M1)Element object.
   */
  def getContainingMetaPropertyEvaluator: Try[Option[MetaPropertyEvaluator]] =
    owner match {
      case None => Success(None)
      case Some(o) =>
        val props: Seq[MetaPropertyEvaluator] = o.compositeMetaProperties.reverse.flatMap {
          case mp: MetaReferenceEvaluator => mp.evaluate(o) match {
            case Failure(f) => return Failure(f)
            case Success(Some(e)) if e == self => Some[MetaPropertyEvaluator](mp)
            case _ => None
          }
          case mp: MetaCollectionEvaluator => mp.evaluate(o) match {
            case Failure(f) => return Failure(f)
            case Success(es) if es.contains(self) => Some[MetaPropertyEvaluator](mp)
            case _ => None
          }
        }
        Success( props.headOption )
    }

  /**
   * @See MOF 2.5
   *
   * Section 9.4
   * get(property: Property) : Object
   * Gets the value of the given property.
   * If the Property has multiplicity upper bound of 1, get() returns the value of the Property.
   * If Property has multiplicity upper bound >1, get() returns a ReflectiveCollection containing the values of the Property.
   * If there are no values, the ReflectiveCollection returned is empty.
   * Exception: throws IllegalArgumentException if Property is not a member of the Class from class().
   *
   * Section 15.5
   * Object::get(Property p): Element
   * modeled as ObjectInstance::get(Property p): ElementInstance
   * -- If a foreign association end, then navigate link, else access slot or derive the value
   * post: (p.namespace.isOclType(Association) and result = navigate(p)) or
   *       self.propertySlot(p) <> null and (
   *        (self.propertySlot(p).value <> null and result = self.propertySlot(p).value) or result = p.default) or
   *        (p.isDerivedUnion and result = unionedProperties(p)->union(s| s = self.get(s)) or
   *        (p.isDerived and result = self.extInvoke('get', p))
   *
   * @param f (M2)Property
   * @return A collection of (M1)Element(s) that are the value of the (M2)Property f on the element.
   * @throws IllegalArgumentException if `f` is not an (M2)Property of the (M2)Class that is the metaclass of the element.
   */
  def getElementMetamodelPropertyValue( f: MetaPropertyEvaluator ): Try[Iterable[UMLElement[Uml]]] =
    f match {
      case rf: MetaReferenceEvaluator => for { v <- rf.evaluate(self) } yield v
      case cf: MetaCollectionEvaluator => cf.evaluate(self)
    }

  /**
   * Every UML Element must have a tool-specific "xmi:id" identifier of some kind.
   * This "xmi:id" is a local with respect to the "XMI" document in which the UML Element is serialized.
   *
   * @return the tool-specific "xmi:id" identifier for the UML Element.
   * @throws java.lang.IllegalArgumentException if there is no tool-specific "xmi:id" available.
   */
  def id: String
  
  /**
   * Every UML Element should have a tool-specific "xmi:uuid" identifier of some kind.
   * This "xmi:uuid" should be globally unique.
   *
   * @return the tool-specific "xmi:uuid" global identifier for the UML Element, if any.
   */
  def uuid: Option[String]

   /* the builtInID method is intended to provide the xmi:id as serialized in the file,
   * as opposed to as computed by the IDGenerator  
   */
   def builtInID: Option[String] = ???
    
  def hasStereotype( s: UMLStereotype[Uml] ): Boolean

  /**
   * @return A map for each applied stereotype (key) and the corresponding "base_<metaclass>" property
   */
  def getAppliedStereotypes: Map[UMLStereotype[Uml], UMLProperty[Uml]]
      
  /**
   * Stereotypes applied; however, there is no applicable 'base_...' property for the element's metaclass.
   */
  def getAppliedStereotypesWithoutMetaclassProperties: Set[UMLStereotype[Uml]]
    
  def isAncestorOf( other: UMLElement[Uml] ): Boolean
  
  def toWrappedObjectString : String = ???
  
  // isSpecicationRoot allows knowing whether this element is a root of an OMG specification
  // it is true if the <<SpecificationRoot>> stereotype is applied, and false otherwise
  def isSpecificationRoot: Boolean = OTI_SPECIFICATION_ROOT_S match {
      case Some(s) => hasStereotype(s)    
      case None => false
    }
  
  // End of user code
} //UMLElementOps
