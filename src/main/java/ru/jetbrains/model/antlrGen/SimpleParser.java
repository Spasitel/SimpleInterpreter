// Generated from C:/workspace/SimpleInterpreter/src/main/resources\Simple.g4 by ANTLR 4.7.2
package ru.jetbrains.model.antlrGen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, STRING=9, 
		LPAREN=10, RPAREN=11, PLUS=12, MINUS=13, TIMES=14, DIV=15, EQ=16, COMMA=17, 
		POINT=18, POW=19, CONST=20, VARIABLE_NAME=21, WS=22;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_var = 2, RULE_out = 3, RULE_print = 4, 
		RULE_expr = 5, RULE_sequence = 6, RULE_sequence_def = 7, RULE_map = 8, 
		RULE_unaryLambda = 9, RULE_reduce = 10, RULE_binaryLambda = 11, RULE_numerical = 12, 
		RULE_multiplyingExpression = 13, RULE_powExpression = 14, RULE_signedAtom = 15, 
		RULE_atom = 16, RULE_variable = 17, RULE_constant = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "var", "out", "print", "expr", "sequence", "sequence_def", 
			"map", "unaryLambda", "reduce", "binaryLambda", "numerical", "multiplyingExpression", 
			"powExpression", "signedAtom", "atom", "variable", "constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'out'", "'print'", "'{'", "'}'", "'map('", "'->'", "'reduce('", 
			null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'='", "','", "'.'", 
			"'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "STRING", "LPAREN", 
			"RPAREN", "PLUS", "MINUS", "TIMES", "DIV", "EQ", "COMMA", "POINT", "POW", 
			"CONST", "VARIABLE_NAME", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpleParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				stmt();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0) );
			setState(43);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public OutContext out() {
			return getRuleContext(OutContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				var();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				out();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				print();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VARIABLE_NAME() { return getToken(SimpleParser.VARIABLE_NAME, 0); }
		public TerminalNode EQ() { return getToken(SimpleParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			match(VARIABLE_NAME);
			setState(52);
			match(EQ);
			setState(53);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutContext extends ParserRuleContext {
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public OutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_out; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterOut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitOut(this);
		}
	}

	public final OutContext out() throws RecognitionException {
		OutContext _localctx = new OutContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_out);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__1);
			setState(56);
			numerical();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__2);
			setState(59);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				numerical();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				sequence();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceContext extends ParserRuleContext {
		public Sequence_defContext sequence_def() {
			return getRuleContext(Sequence_defContext.class,0);
		}
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitSequence(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sequence);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				sequence_def();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				map();
				}
				break;
			case VARIABLE_NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sequence_defContext extends ParserRuleContext {
		public List<NumericalContext> numerical() {
			return getRuleContexts(NumericalContext.class);
		}
		public NumericalContext numerical(int i) {
			return getRuleContext(NumericalContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(SimpleParser.COMMA, 0); }
		public Sequence_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterSequence_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitSequence_def(this);
		}
	}

	public final Sequence_defContext sequence_def() throws RecognitionException {
		Sequence_defContext _localctx = new Sequence_defContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sequence_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__3);
			setState(71);
			numerical();
			setState(72);
			match(COMMA);
			setState(73);
			numerical();
			setState(74);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SimpleParser.COMMA, 0); }
		public UnaryLambdaContext unaryLambda() {
			return getRuleContext(UnaryLambdaContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleParser.RPAREN, 0); }
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitMap(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_map);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__5);
			setState(77);
			sequence();
			setState(78);
			match(COMMA);
			setState(79);
			unaryLambda();
			setState(80);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryLambdaContext extends ParserRuleContext {
		public TerminalNode VARIABLE_NAME() { return getToken(SimpleParser.VARIABLE_NAME, 0); }
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public UnaryLambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryLambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterUnaryLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitUnaryLambda(this);
		}
	}

	public final UnaryLambdaContext unaryLambda() throws RecognitionException {
		UnaryLambdaContext _localctx = new UnaryLambdaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unaryLambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(VARIABLE_NAME);
			setState(83);
			match(T__6);
			setState(84);
			numerical();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReduceContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleParser.COMMA, i);
		}
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public BinaryLambdaContext binaryLambda() {
			return getRuleContext(BinaryLambdaContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleParser.RPAREN, 0); }
		public ReduceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reduce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterReduce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitReduce(this);
		}
	}

	public final ReduceContext reduce() throws RecognitionException {
		ReduceContext _localctx = new ReduceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_reduce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__7);
			setState(87);
			sequence();
			setState(88);
			match(COMMA);
			setState(89);
			numerical();
			setState(90);
			match(COMMA);
			setState(91);
			binaryLambda();
			setState(92);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryLambdaContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(SimpleParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(SimpleParser.VARIABLE_NAME, i);
		}
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public BinaryLambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryLambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterBinaryLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitBinaryLambda(this);
		}
	}

	public final BinaryLambdaContext binaryLambda() throws RecognitionException {
		BinaryLambdaContext _localctx = new BinaryLambdaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_binaryLambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(VARIABLE_NAME);
			setState(95);
			match(VARIABLE_NAME);
			setState(96);
			match(T__6);
			setState(97);
			numerical();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericalContext extends ParserRuleContext {
		public List<MultiplyingExpressionContext> multiplyingExpression() {
			return getRuleContexts(MultiplyingExpressionContext.class);
		}
		public MultiplyingExpressionContext multiplyingExpression(int i) {
			return getRuleContext(MultiplyingExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SimpleParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SimpleParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SimpleParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SimpleParser.MINUS, i);
		}
		public NumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitNumerical(this);
		}
	}

	public final NumericalContext numerical() throws RecognitionException {
		NumericalContext _localctx = new NumericalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_numerical);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			multiplyingExpression();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(100);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(101);
				multiplyingExpression();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplyingExpressionContext extends ParserRuleContext {
		public List<PowExpressionContext> powExpression() {
			return getRuleContexts(PowExpressionContext.class);
		}
		public PowExpressionContext powExpression(int i) {
			return getRuleContext(PowExpressionContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(SimpleParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(SimpleParser.TIMES, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SimpleParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(SimpleParser.DIV, i);
		}
		public MultiplyingExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyingExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterMultiplyingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitMultiplyingExpression(this);
		}
	}

	public final MultiplyingExpressionContext multiplyingExpression() throws RecognitionException {
		MultiplyingExpressionContext _localctx = new MultiplyingExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiplyingExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			powExpression();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIV) {
				{
				{
				setState(108);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(109);
				powExpression();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowExpressionContext extends ParserRuleContext {
		public List<SignedAtomContext> signedAtom() {
			return getRuleContexts(SignedAtomContext.class);
		}
		public SignedAtomContext signedAtom(int i) {
			return getRuleContext(SignedAtomContext.class,i);
		}
		public List<TerminalNode> POW() { return getTokens(SimpleParser.POW); }
		public TerminalNode POW(int i) {
			return getToken(SimpleParser.POW, i);
		}
		public PowExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterPowExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitPowExpression(this);
		}
	}

	public final PowExpressionContext powExpression() throws RecognitionException {
		PowExpressionContext _localctx = new PowExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_powExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			signedAtom();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POW) {
				{
				{
				setState(116);
				match(POW);
				setState(117);
				signedAtom();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedAtomContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SimpleParser.MINUS, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SignedAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterSignedAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitSignedAtom(this);
		}
	}

	public final SignedAtomContext signedAtom() throws RecognitionException {
		SignedAtomContext _localctx = new SignedAtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_signedAtom);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(MINUS);
				setState(124);
				atom();
				}
				break;
			case T__7:
			case LPAREN:
			case CONST:
			case VARIABLE_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ReduceContext reduce() {
			return getRuleContext(ReduceContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimpleParser.LPAREN, 0); }
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleParser.RPAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atom);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				variable();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				constant();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				reduce();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				match(LPAREN);
				setState(132);
				numerical();
				setState(133);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VARIABLE_NAME() { return getToken(SimpleParser.VARIABLE_NAME, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(VARIABLE_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(SimpleParser.CONST, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleListener ) ((SimpleListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(CONST);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0090\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\6\2*\n\2\r\2\16\2+\3\2\3\2\3\3\3\3\3\3\5\3\63"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\5\7B\n\7\3\b"+
		"\3\b\3\b\5\bG\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\7\16i\n\16\f\16\16\16l\13\16\3\17\3\17\3\17\7\17q\n\17\f"+
		"\17\16\17t\13\17\3\20\3\20\3\20\7\20y\n\20\f\20\16\20|\13\20\3\21\3\21"+
		"\3\21\5\21\u0081\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u008a\n"+
		"\22\3\23\3\23\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&\2\4\3\2\16\17\3\2\20\21\2\u0089\2)\3\2\2\2\4\62\3\2\2\2\6\64"+
		"\3\2\2\2\b9\3\2\2\2\n<\3\2\2\2\fA\3\2\2\2\16F\3\2\2\2\20H\3\2\2\2\22N"+
		"\3\2\2\2\24T\3\2\2\2\26X\3\2\2\2\30`\3\2\2\2\32e\3\2\2\2\34m\3\2\2\2\36"+
		"u\3\2\2\2 \u0080\3\2\2\2\"\u0089\3\2\2\2$\u008b\3\2\2\2&\u008d\3\2\2\2"+
		"(*\5\4\3\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\2\2\3"+
		".\3\3\2\2\2/\63\5\6\4\2\60\63\5\b\5\2\61\63\5\n\6\2\62/\3\2\2\2\62\60"+
		"\3\2\2\2\62\61\3\2\2\2\63\5\3\2\2\2\64\65\7\3\2\2\65\66\7\27\2\2\66\67"+
		"\7\22\2\2\678\5\f\7\28\7\3\2\2\29:\7\4\2\2:;\5\32\16\2;\t\3\2\2\2<=\7"+
		"\5\2\2=>\7\13\2\2>\13\3\2\2\2?B\5\32\16\2@B\5\16\b\2A?\3\2\2\2A@\3\2\2"+
		"\2B\r\3\2\2\2CG\5\20\t\2DG\5\22\n\2EG\5$\23\2FC\3\2\2\2FD\3\2\2\2FE\3"+
		"\2\2\2G\17\3\2\2\2HI\7\6\2\2IJ\5\32\16\2JK\7\23\2\2KL\5\32\16\2LM\7\7"+
		"\2\2M\21\3\2\2\2NO\7\b\2\2OP\5\16\b\2PQ\7\23\2\2QR\5\24\13\2RS\7\r\2\2"+
		"S\23\3\2\2\2TU\7\27\2\2UV\7\t\2\2VW\5\32\16\2W\25\3\2\2\2XY\7\n\2\2YZ"+
		"\5\16\b\2Z[\7\23\2\2[\\\5\32\16\2\\]\7\23\2\2]^\5\30\r\2^_\7\r\2\2_\27"+
		"\3\2\2\2`a\7\27\2\2ab\7\27\2\2bc\7\t\2\2cd\5\32\16\2d\31\3\2\2\2ej\5\34"+
		"\17\2fg\t\2\2\2gi\5\34\17\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\33"+
		"\3\2\2\2lj\3\2\2\2mr\5\36\20\2no\t\3\2\2oq\5\36\20\2pn\3\2\2\2qt\3\2\2"+
		"\2rp\3\2\2\2rs\3\2\2\2s\35\3\2\2\2tr\3\2\2\2uz\5 \21\2vw\7\25\2\2wy\5"+
		" \21\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\37\3\2\2\2|z\3\2\2\2}"+
		"~\7\17\2\2~\u0081\5\"\22\2\177\u0081\5\"\22\2\u0080}\3\2\2\2\u0080\177"+
		"\3\2\2\2\u0081!\3\2\2\2\u0082\u008a\5$\23\2\u0083\u008a\5&\24\2\u0084"+
		"\u008a\5\26\f\2\u0085\u0086\7\f\2\2\u0086\u0087\5\32\16\2\u0087\u0088"+
		"\7\r\2\2\u0088\u008a\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0083\3\2\2\2\u0089"+
		"\u0084\3\2\2\2\u0089\u0085\3\2\2\2\u008a#\3\2\2\2\u008b\u008c\7\27\2\2"+
		"\u008c%\3\2\2\2\u008d\u008e\7\26\2\2\u008e\'\3\2\2\2\13+\62AFjrz\u0080"+
		"\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}