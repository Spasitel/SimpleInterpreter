// Generated from C:/workspace/SimpleInterpreter/src/main/resources\Simple.g4 by ANTLR 4.7.2
package com.jetbrains.simpleinterpreter.model.antlrgen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		STRING=18, NUMBER=19, IDENTIFIER=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"STRING", "NUMBER", "IDENTIFIER", "VALID_ID_START", "VALID_ID_CHAR", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "'out'", "'print'", "'^'", "'*'", "'/'", "'+'", 
			"'-'", "'('", "')'", "'{'", "','", "'}'", "'map'", "'->'", "'reduce'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "STRING", "NUMBER", "IDENTIFIER", 
			"WS"
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


	public SimpleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u008e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\7\23f\n\23\f\23\16\23i\13\23\3\23\3\23\3\24\6\24n\n\24"+
		"\r\24\16\24o\3\24\3\24\6\24t\n\24\r\24\16\24u\5\24x\n\24\3\25\3\25\7\25"+
		"|\n\25\f\25\16\25\177\13\25\3\26\5\26\u0082\n\26\3\27\3\27\5\27\u0086"+
		"\n\27\3\30\6\30\u0089\n\30\r\30\16\30\u008a\3\30\3\30\2\2\31\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\2-\2/\27\3\2\5\3\2$$\5\2C\\aac|\5\2\13\f\17\17\"\""+
		"\2\u0092\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2/\3\2\2\2\3\61\3\2\2"+
		"\2\5\65\3\2\2\2\7\67\3\2\2\2\t;\3\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17E\3\2"+
		"\2\2\21G\3\2\2\2\23I\3\2\2\2\25K\3\2\2\2\27M\3\2\2\2\31O\3\2\2\2\33Q\3"+
		"\2\2\2\35S\3\2\2\2\37U\3\2\2\2!Y\3\2\2\2#\\\3\2\2\2%c\3\2\2\2\'m\3\2\2"+
		"\2)y\3\2\2\2+\u0081\3\2\2\2-\u0085\3\2\2\2/\u0088\3\2\2\2\61\62\7x\2\2"+
		"\62\63\7c\2\2\63\64\7t\2\2\64\4\3\2\2\2\65\66\7?\2\2\66\6\3\2\2\2\678"+
		"\7q\2\289\7w\2\29:\7v\2\2:\b\3\2\2\2;<\7r\2\2<=\7t\2\2=>\7k\2\2>?\7p\2"+
		"\2?@\7v\2\2@\n\3\2\2\2AB\7`\2\2B\f\3\2\2\2CD\7,\2\2D\16\3\2\2\2EF\7\61"+
		"\2\2F\20\3\2\2\2GH\7-\2\2H\22\3\2\2\2IJ\7/\2\2J\24\3\2\2\2KL\7*\2\2L\26"+
		"\3\2\2\2MN\7+\2\2N\30\3\2\2\2OP\7}\2\2P\32\3\2\2\2QR\7.\2\2R\34\3\2\2"+
		"\2ST\7\177\2\2T\36\3\2\2\2UV\7o\2\2VW\7c\2\2WX\7r\2\2X \3\2\2\2YZ\7/\2"+
		"\2Z[\7@\2\2[\"\3\2\2\2\\]\7t\2\2]^\7g\2\2^_\7f\2\2_`\7w\2\2`a\7e\2\2a"+
		"b\7g\2\2b$\3\2\2\2cg\7$\2\2df\n\2\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh"+
		"\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7$\2\2k&\3\2\2\2ln\4\62;\2ml\3\2\2\2no"+
		"\3\2\2\2om\3\2\2\2op\3\2\2\2pw\3\2\2\2qs\7\60\2\2rt\4\62;\2sr\3\2\2\2"+
		"tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wq\3\2\2\2wx\3\2\2\2x(\3\2\2\2"+
		"y}\5+\26\2z|\5-\27\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~*\3\2"+
		"\2\2\177}\3\2\2\2\u0080\u0082\t\3\2\2\u0081\u0080\3\2\2\2\u0082,\3\2\2"+
		"\2\u0083\u0086\5+\26\2\u0084\u0086\4\62;\2\u0085\u0083\3\2\2\2\u0085\u0084"+
		"\3\2\2\2\u0086.\3\2\2\2\u0087\u0089\t\4\2\2\u0088\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008d\b\30\2\2\u008d\60\3\2\2\2\13\2gouw}\u0081\u0085\u008a"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}