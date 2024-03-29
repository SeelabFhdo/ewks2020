/*
 * generated by Xtext 2.21.0
 */
grammar InternalStructureDsl;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package de.fhdo.ewks.ml_example.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package de.fhdo.ewks.ml_example.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.fhdo.ewks.ml_example.xtext.services.StructureDslGrammarAccess;

}

@parser::members {

 	private StructureDslGrammarAccess grammarAccess;

    public InternalStructureDslParser(TokenStream input, StructureDslGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Context";
   	}

   	@Override
   	protected StructureDslGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleContext
entryRuleContext returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContextRule()); }
	iv_ruleContext=ruleContext
	{ $current=$iv_ruleContext.current; }
	EOF;

// Rule Context
ruleContext returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='context'
		{
			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getContextAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getContextRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getContextAccess().getStructuresStructureParserRuleCall_3_0());
				}
				lv_structures_3_0=ruleStructure
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getContextRule());
					}
					add(
						$current,
						"structures",
						lv_structures_3_0,
						"de.fhdo.ewks.ml_example.xtext.StructureDsl.Structure");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getContextAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleStructure
entryRuleStructure returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStructureRule()); }
	iv_ruleStructure=ruleStructure
	{ $current=$iv_ruleStructure.current; }
	EOF;

// Rule Structure
ruleStructure returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='structure'
		{
			newLeafNode(otherlv_0, grammarAccess.getStructureAccess().getStructureKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getStructureRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getStructureAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getStructureAccess().getAttributesAttributeParserRuleCall_3_0());
				}
				lv_attributes_3_0=ruleAttribute
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStructureRule());
					}
					add(
						$current,
						"attributes",
						lv_attributes_3_0,
						"de.fhdo.ewks.ml_example.xtext.StructureDsl.Attribute");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=','
			{
				newLeafNode(otherlv_4, grammarAccess.getStructureAccess().getCommaKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getStructureAccess().getAttributesAttributeParserRuleCall_4_1_0());
					}
					lv_attributes_5_0=ruleAttribute
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getStructureRule());
						}
						add(
							$current,
							"attributes",
							lv_attributes_5_0,
							"de.fhdo.ewks.ml_example.xtext.StructureDsl.Attribute");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getStructureAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleAttribute
entryRuleAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAttributeRule()); }
	iv_ruleAttribute=ruleAttribute
	{ $current=$iv_ruleAttribute.current; }
	EOF;

// Rule Attribute
ruleAttribute returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeEnumRuleCall_0_0());
				}
				lv_type_0_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAttributeRule());
					}
					set(
						$current,
						"type",
						lv_type_0_0,
						"de.fhdo.ewks.ml_example.xtext.StructureDsl.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAttributeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
	)
;

// Rule Type
ruleType returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='boolean'
			{
				$current = grammarAccess.getTypeAccess().getBOOLEANEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getTypeAccess().getBOOLEANEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='double'
			{
				$current = grammarAccess.getTypeAccess().getDOUBLEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getTypeAccess().getDOUBLEEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='float'
			{
				$current = grammarAccess.getTypeAccess().getFLOATEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getTypeAccess().getFLOATEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='int'
			{
				$current = grammarAccess.getTypeAccess().getINTEGEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getTypeAccess().getINTEGEREnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4='string'
			{
				$current = grammarAccess.getTypeAccess().getSTRINGEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getTypeAccess().getSTRINGEnumLiteralDeclaration_4());
			}
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
