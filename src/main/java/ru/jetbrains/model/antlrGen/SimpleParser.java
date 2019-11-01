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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, STRING=12, PLUS=13, MINUS=14, TIMES=15, DIV=16, EQ=17, 
		POINT=18, POW=19, CONST=20, VARIABLE_NAME=21, WS=22;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_var = 2, RULE_out = 3, RULE_print = 4, 
		RULE_sequence = 5, RULE_sequenceDef = 6, RULE_map = 7, RULE_reduce = 8, 
		RULE_numerical = 9, RULE_variable = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "var", "out", "print", "sequence", "sequenceDef", 
			"map", "reduce", "numerical", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'out'", "'print'", "'{'", "','", "'}'", "'map('", "'->'", 
			"')'", "'reduce('", "'('", null, "'+'", "'-'", "'*'", "'/'", "'='", "'.'", 
			"'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"STRING", "PLUS", "MINUS", "TIMES", "DIV", "EQ", "POINT", "POW", "CONST", 
			"VARIABLE_NAME", "WS"
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
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				stmt();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0) );
			setState(27);
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
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				var();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				out();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
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
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	 
		public VarContext() { }
		public void copyFrom(VarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarToVarContext extends VarContext {
		public Token def;
		public Token toCopy;
		public TerminalNode EQ() { return getToken(SimpleParser.EQ, 0); }
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(SimpleParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(SimpleParser.VARIABLE_NAME, i);
		}
		public VarToVarContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitVarToVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumToVarContext extends VarContext {
		public Token def;
		public TerminalNode EQ() { return getToken(SimpleParser.EQ, 0); }
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public TerminalNode VARIABLE_NAME() { return getToken(SimpleParser.VARIABLE_NAME, 0); }
		public NumToVarContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitNumToVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqToVarContext extends VarContext {
		public Token def;
		public TerminalNode EQ() { return getToken(SimpleParser.EQ, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode VARIABLE_NAME() { return getToken(SimpleParser.VARIABLE_NAME, 0); }
		public SeqToVarContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitSeqToVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarToVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(T__0);
				setState(35);
				((VarToVarContext)_localctx).def = match(VARIABLE_NAME);
				setState(36);
				match(EQ);
				setState(37);
				((VarToVarContext)_localctx).toCopy = match(VARIABLE_NAME);
				}
				break;
			case 2:
				_localctx = new NumToVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(T__0);
				setState(39);
				((NumToVarContext)_localctx).def = match(VARIABLE_NAME);
				setState(40);
				match(EQ);
				setState(41);
				numerical(0);
				}
				break;
			case 3:
				_localctx = new SeqToVarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				match(T__0);
				setState(43);
				((SeqToVarContext)_localctx).def = match(VARIABLE_NAME);
				setState(44);
				match(EQ);
				setState(45);
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
			setState(48);
			match(T__1);
			setState(49);
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
			setState(51);
			match(T__2);
			setState(52);
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

	public static class SequenceContext extends ParserRuleContext {
		public SequenceDefContext sequenceDef() {
			return getRuleContext(SequenceDefContext.class,0);
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
		enterRule(_localctx, 10, RULE_sequence);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				sequenceDef();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				map();
				}
				break;
			case VARIABLE_NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
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

	public static class SequenceDefContext extends ParserRuleContext {
		public NumericalContext start;
		public NumericalContext finish;
		public List<NumericalContext> numerical() {
			return getRuleContexts(NumericalContext.class);
		}
		public NumericalContext numerical(int i) {
			return getRuleContext(NumericalContext.class,i);
		}
		public SequenceDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitSequenceDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceDefContext sequenceDef() throws RecognitionException {
		SequenceDefContext _localctx = new SequenceDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sequenceDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__3);
			setState(60);
			((SequenceDefContext)_localctx).start = numerical(0);
			setState(61);
			match(T__4);
			setState(62);
			((SequenceDefContext)_localctx).finish = numerical(0);
			setState(63);
			match(T__5);
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
		public TerminalNode VARIABLE_NAME() { return getToken(SimpleParser.VARIABLE_NAME, 0); }
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_map);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__6);
			setState(66);
			sequence();
			setState(67);
			match(T__4);
			setState(68);
			match(VARIABLE_NAME);
			setState(69);
			match(T__7);
			setState(70);
			numerical(0);
			setState(71);
			match(T__8);
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
		public NumericalContext init;
		public Token first;
		public Token second;
		public NumericalContext lambda;
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public List<NumericalContext> numerical() {
			return getRuleContexts(NumericalContext.class);
		}
		public NumericalContext numerical(int i) {
			return getRuleContext(NumericalContext.class,i);
		}
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(SimpleParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(SimpleParser.VARIABLE_NAME, i);
		}
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
		enterRule(_localctx, 16, RULE_reduce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__9);
			setState(74);
			sequence();
			setState(75);
			match(T__4);
			setState(76);
			((ReduceContext)_localctx).init = numerical(0);
			setState(77);
			match(T__4);
			setState(78);
			((ReduceContext)_localctx).first = match(VARIABLE_NAME);
			setState(79);
			((ReduceContext)_localctx).second = match(VARIABLE_NAME);
			setState(80);
			match(T__7);
			setState(81);
			((ReduceContext)_localctx).lambda = numerical(0);
			setState(82);
			match(T__8);
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
		public Token sign;
		public NumericalContext parentheses;
		public ReduceContext reduceResult;
		public VariableContext numVar;
		public Token constant;
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SimpleParser.MINUS, 0); }
		public ReduceContext reduce() {
			return getRuleContext(ReduceContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode CONST() { return getToken(SimpleParser.CONST, 0); }
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_numerical, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new SignedNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(85);
					((SignedNumContext)_localctx).sign = match(MINUS);
					}
				}

				setState(88);
				match(T__10);
				setState(89);
				((SignedNumContext)_localctx).parentheses = numerical(0);
				setState(90);
				match(T__8);
				}
				break;
			case 2:
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
					((SignedNumContext)_localctx).sign = match(MINUS);
					}
				}

				setState(95);
				((SignedNumContext)_localctx).reduceResult = reduce();
				}
				break;
			case 3:
				{
				_localctx = new SignedNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(96);
					((SignedNumContext)_localctx).sign = match(MINUS);
					}
				}

				setState(99);
				((SignedNumContext)_localctx).numVar = variable();
				}
				break;
			case 4:
				{
				_localctx = new SignedNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(100);
					((SignedNumContext)_localctx).sign = match(MINUS);
					}
				}

				setState(103);
				((SignedNumContext)_localctx).constant = match(CONST);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(115);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new OpNumContext(new NumericalContext(_parentctx, _parentState));
						((OpNumContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_numerical);
						setState(106);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(107);
						((OpNumContext)_localctx).op = match(POW);
						setState(108);
						((OpNumContext)_localctx).right = numerical(6);
						}
						break;
					case 2:
						{
						_localctx = new OpNumContext(new NumericalContext(_parentctx, _parentState));
						((OpNumContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_numerical);
						setState(109);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(110);
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
						setState(111);
						((OpNumContext)_localctx).right = numerical(6);
						}
						break;
					case 3:
						{
						_localctx = new OpNumContext(new NumericalContext(_parentctx, _parentState));
						((OpNumContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_numerical);
						setState(112);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(113);
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
						setState(114);
						((OpNumContext)_localctx).right = numerical(5);
						}
						break;
					}
					} 
				}
				setState(119);
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
		enterRule(_localctx, 20, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30}\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\2\3\2\3\3\3\3\3\3\5\3#\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\5\7<\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\5"+
		"\13Y\n\13\3\13\3\13\3\13\3\13\3\13\5\13`\n\13\3\13\3\13\5\13d\n\13\3\13"+
		"\3\13\5\13h\n\13\3\13\5\13k\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\7\13v\n\13\f\13\16\13y\13\13\3\f\3\f\3\f\2\3\24\r\2\4\6\b\n\f"+
		"\16\20\22\24\26\2\4\3\2\21\22\3\2\17\20\2\u0082\2\31\3\2\2\2\4\"\3\2\2"+
		"\2\6\60\3\2\2\2\b\62\3\2\2\2\n\65\3\2\2\2\f;\3\2\2\2\16=\3\2\2\2\20C\3"+
		"\2\2\2\22K\3\2\2\2\24j\3\2\2\2\26z\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2"+
		"\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\2\2\3"+
		"\36\3\3\2\2\2\37#\5\6\4\2 #\5\b\5\2!#\5\n\6\2\"\37\3\2\2\2\" \3\2\2\2"+
		"\"!\3\2\2\2#\5\3\2\2\2$%\7\3\2\2%&\7\27\2\2&\'\7\23\2\2\'\61\7\27\2\2"+
		"()\7\3\2\2)*\7\27\2\2*+\7\23\2\2+\61\5\24\13\2,-\7\3\2\2-.\7\27\2\2./"+
		"\7\23\2\2/\61\5\f\7\2\60$\3\2\2\2\60(\3\2\2\2\60,\3\2\2\2\61\7\3\2\2\2"+
		"\62\63\7\4\2\2\63\64\5\24\13\2\64\t\3\2\2\2\65\66\7\5\2\2\66\67\7\16\2"+
		"\2\67\13\3\2\2\28<\5\16\b\29<\5\20\t\2:<\5\26\f\2;8\3\2\2\2;9\3\2\2\2"+
		";:\3\2\2\2<\r\3\2\2\2=>\7\6\2\2>?\5\24\13\2?@\7\7\2\2@A\5\24\13\2AB\7"+
		"\b\2\2B\17\3\2\2\2CD\7\t\2\2DE\5\f\7\2EF\7\7\2\2FG\7\27\2\2GH\7\n\2\2"+
		"HI\5\24\13\2IJ\7\13\2\2J\21\3\2\2\2KL\7\f\2\2LM\5\f\7\2MN\7\7\2\2NO\5"+
		"\24\13\2OP\7\7\2\2PQ\7\27\2\2QR\7\27\2\2RS\7\n\2\2ST\5\24\13\2TU\7\13"+
		"\2\2U\23\3\2\2\2VX\b\13\1\2WY\7\20\2\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z"+
		"[\7\r\2\2[\\\5\24\13\2\\]\7\13\2\2]k\3\2\2\2^`\7\20\2\2_^\3\2\2\2_`\3"+
		"\2\2\2`a\3\2\2\2ak\5\22\n\2bd\7\20\2\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2e"+
		"k\5\26\f\2fh\7\20\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ik\7\26\2\2jV\3\2\2"+
		"\2j_\3\2\2\2jc\3\2\2\2jg\3\2\2\2kw\3\2\2\2lm\f\b\2\2mn\7\25\2\2nv\5\24"+
		"\13\bop\f\7\2\2pq\t\2\2\2qv\5\24\13\brs\f\6\2\2st\t\3\2\2tv\5\24\13\7"+
		"ul\3\2\2\2uo\3\2\2\2ur\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\25\3\2\2"+
		"\2yw\3\2\2\2z{\7\27\2\2{\27\3\2\2\2\r\33\"\60;X_cgjuw";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}