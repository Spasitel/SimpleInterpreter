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
		RULE_variable = 13, RULE_constant = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "var", "out", "print", "expr", "sequence", "sequence_def", 
			"map", "unaryLambda", "reduce", "binaryLambda", "numerical", "variable", 
			"constant"
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				stmt();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0) );
			setState(35);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				var();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				out();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__0);
			setState(43);
			match(VARIABLE_NAME);
			setState(44);
			match(EQ);
			setState(45);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitOut(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutContext out() throws RecognitionException {
		OutContext _localctx = new OutContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_out);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__1);
			setState(48);
			numerical(0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__2);
			setState(51);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				numerical(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sequence);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				sequence_def();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				map();
				}
				break;
			case VARIABLE_NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitSequence_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sequence_defContext sequence_def() throws RecognitionException {
		Sequence_defContext _localctx = new Sequence_defContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sequence_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__3);
			setState(63);
			numerical(0);
			setState(64);
			match(COMMA);
			setState(65);
			numerical(0);
			setState(66);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_map);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__5);
			setState(69);
			sequence();
			setState(70);
			match(COMMA);
			setState(71);
			unaryLambda();
			setState(72);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitUnaryLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryLambdaContext unaryLambda() throws RecognitionException {
		UnaryLambdaContext _localctx = new UnaryLambdaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unaryLambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(VARIABLE_NAME);
			setState(75);
			match(T__6);
			setState(76);
			numerical(0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitReduce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReduceContext reduce() throws RecognitionException {
		ReduceContext _localctx = new ReduceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_reduce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__7);
			setState(79);
			sequence();
			setState(80);
			match(COMMA);
			setState(81);
			numerical(0);
			setState(82);
			match(COMMA);
			setState(83);
			binaryLambda();
			setState(84);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitBinaryLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryLambdaContext binaryLambda() throws RecognitionException {
		BinaryLambdaContext _localctx = new BinaryLambdaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_binaryLambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(VARIABLE_NAME);
			setState(87);
			match(VARIABLE_NAME);
			setState(88);
			match(T__6);
			setState(89);
			numerical(0);
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
		public NumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical; }
	 
		public NumericalContext() { }
		public void copyFrom(NumericalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SignedNumContext extends NumericalContext {
		public Token sing;
		public NumericalContext paren;
		public ConstantContext cons;
		public ReduceContext red;
		public VariableContext vari;
		public TerminalNode LPAREN() { return getToken(SimpleParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleParser.RPAREN, 0); }
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SimpleParser.MINUS, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ReduceContext reduce() {
			return getRuleContext(ReduceContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public SignedNumContext(NumericalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitSignedNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpNumContext extends NumericalContext {
		public NumericalContext left;
		public Token op;
		public NumericalContext right;
		public List<NumericalContext> numerical() {
			return getRuleContexts(NumericalContext.class);
		}
		public NumericalContext numerical(int i) {
			return getRuleContext(NumericalContext.class,i);
		}
		public TerminalNode POW() { return getToken(SimpleParser.POW, 0); }
		public TerminalNode TIMES() { return getToken(SimpleParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(SimpleParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(SimpleParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SimpleParser.MINUS, 0); }
		public OpNumContext(NumericalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitOpNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalContext numerical() throws RecognitionException {
		return numerical(0);
	}

	private NumericalContext numerical(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NumericalContext _localctx = new NumericalContext(_ctx, _parentState);
		NumericalContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_numerical, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new SignedNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(92);
					((SignedNumContext)_localctx).sing = match(MINUS);
					}
				}

				setState(95);
				match(LPAREN);
				setState(96);
				((SignedNumContext)_localctx).paren = numerical(0);
				setState(97);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new SignedNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(99);
					((SignedNumContext)_localctx).sing = match(MINUS);
					}
				}

				setState(102);
				((SignedNumContext)_localctx).cons = constant();
				}
				break;
			case 3:
				{
				_localctx = new SignedNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(103);
					((SignedNumContext)_localctx).sing = match(MINUS);
					}
				}

				setState(106);
				((SignedNumContext)_localctx).red = reduce();
				}
				break;
			case 4:
				{
				_localctx = new SignedNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(107);
					((SignedNumContext)_localctx).sing = match(MINUS);
					}
				}

				setState(110);
				((SignedNumContext)_localctx).vari = variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new OpNumContext(new NumericalContext(_parentctx, _parentState));
						((OpNumContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_numerical);
						setState(113);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(114);
						((OpNumContext)_localctx).op = match(POW);
						setState(115);
						((OpNumContext)_localctx).right = numerical(6);
						}
						break;
					case 2:
						{
						_localctx = new OpNumContext(new NumericalContext(_parentctx, _parentState));
						((OpNumContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_numerical);
						setState(116);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(117);
						((OpNumContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIV) ) {
							((OpNumContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						((OpNumContext)_localctx).right = numerical(6);
						}
						break;
					case 3:
						{
						_localctx = new OpNumContext(new NumericalContext(_parentctx, _parentState));
						((OpNumContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_numerical);
						setState(119);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(120);
						((OpNumContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((OpNumContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(121);
						((OpNumContext)_localctx).right = numerical(5);
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return numerical_sempred((NumericalContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean numerical_sempred(NumericalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0086\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2\"\n\2\r\2"+
		"\16\2#\3\2\3\2\3\3\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\5\7:\n\7\3\b\3\b\3\b\5\b?\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\5\16`\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16g\n\16\3\16\3\16\5\16k\n\16\3\16\3\16\5\16o\n\16\3\16\5\16r"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16}\n\16\f\16\16"+
		"\16\u0080\13\16\3\17\3\17\3\20\3\20\3\20\2\3\32\21\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36\2\4\3\2\20\21\3\2\16\17\2\u0086\2!\3\2\2\2\4*\3\2\2"+
		"\2\6,\3\2\2\2\b\61\3\2\2\2\n\64\3\2\2\2\f9\3\2\2\2\16>\3\2\2\2\20@\3\2"+
		"\2\2\22F\3\2\2\2\24L\3\2\2\2\26P\3\2\2\2\30X\3\2\2\2\32q\3\2\2\2\34\u0081"+
		"\3\2\2\2\36\u0083\3\2\2\2 \"\5\4\3\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$"+
		"\3\2\2\2$%\3\2\2\2%&\7\2\2\3&\3\3\2\2\2\'+\5\6\4\2(+\5\b\5\2)+\5\n\6\2"+
		"*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+\5\3\2\2\2,-\7\3\2\2-.\7\27\2\2./\7\22"+
		"\2\2/\60\5\f\7\2\60\7\3\2\2\2\61\62\7\4\2\2\62\63\5\32\16\2\63\t\3\2\2"+
		"\2\64\65\7\5\2\2\65\66\7\13\2\2\66\13\3\2\2\2\67:\5\32\16\28:\5\16\b\2"+
		"9\67\3\2\2\298\3\2\2\2:\r\3\2\2\2;?\5\20\t\2<?\5\22\n\2=?\5\34\17\2>;"+
		"\3\2\2\2><\3\2\2\2>=\3\2\2\2?\17\3\2\2\2@A\7\6\2\2AB\5\32\16\2BC\7\23"+
		"\2\2CD\5\32\16\2DE\7\7\2\2E\21\3\2\2\2FG\7\b\2\2GH\5\16\b\2HI\7\23\2\2"+
		"IJ\5\24\13\2JK\7\r\2\2K\23\3\2\2\2LM\7\27\2\2MN\7\t\2\2NO\5\32\16\2O\25"+
		"\3\2\2\2PQ\7\n\2\2QR\5\16\b\2RS\7\23\2\2ST\5\32\16\2TU\7\23\2\2UV\5\30"+
		"\r\2VW\7\r\2\2W\27\3\2\2\2XY\7\27\2\2YZ\7\27\2\2Z[\7\t\2\2[\\\5\32\16"+
		"\2\\\31\3\2\2\2]_\b\16\1\2^`\7\17\2\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab"+
		"\7\f\2\2bc\5\32\16\2cd\7\r\2\2dr\3\2\2\2eg\7\17\2\2fe\3\2\2\2fg\3\2\2"+
		"\2gh\3\2\2\2hr\5\36\20\2ik\7\17\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lr\5"+
		"\26\f\2mo\7\17\2\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pr\5\34\17\2q]\3\2\2\2"+
		"qf\3\2\2\2qj\3\2\2\2qn\3\2\2\2r~\3\2\2\2st\f\b\2\2tu\7\25\2\2u}\5\32\16"+
		"\bvw\f\7\2\2wx\t\2\2\2x}\5\32\16\byz\f\6\2\2z{\t\3\2\2{}\5\32\16\7|s\3"+
		"\2\2\2|v\3\2\2\2|y\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\33"+
		"\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\27\2\2\u0082\35\3\2\2\2\u0083\u0084"+
		"\7\26\2\2\u0084\37\3\2\2\2\r#*9>_fjnq|~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}