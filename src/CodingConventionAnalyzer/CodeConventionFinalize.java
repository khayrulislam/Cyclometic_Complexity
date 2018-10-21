package CodingConventionAnalyzer;

import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import FileReader.Statement;

public class CodeConventionFinalize {

	ArrayList<Statement> statementListOfAClass = new ArrayList<>();

	public CodeConventionFinalize(ArrayList<Statement> statementListOfAClass) {

		this.statementListOfAClass = statementListOfAClass;

	}

	public void finalizeTheConvention() {

		
		for (int i = 0; i < statementListOfAClass.size(); i++) {

			if (isBracketAtTheEndOfLine(statementListOfAClass.get(i), "}")) spliteCurrentStatement("}",0,i);

			if (isBracketAtTheEndOfLine(statementListOfAClass.get(i), "{")) spliteCurrentStatement("{",0,i);

			if (isSingleLineStatement(statementListOfAClass.get(i))) spliteSingleLineStatement(i);

		}
		mergeStatement();
		
		categorizeStatement();
	}

	private void categorizeStatement() {
		
		
		
		
	}

	private void spliteSingleLineStatement(int i) {
		
		if( isStatementContains(statementListOfAClass.get(i), "if") ||isStatementContains(statementListOfAClass.get(i), "for") || 
			isStatementContains(statementListOfAClass.get(i), "while") || 
			isStatementContains(statementListOfAClass.get(i), "else if") ) spliteCurrentStatement("(",1,i);
		
		else if (isStatementContains(statementListOfAClass.get(i), "else")) spliteCurrentStatement("else",4,i);
		
	}

	private void spliteCurrentStatement(String finder, int increment,int i) {
		
		int startIndex;

		startIndex = statementListOfAClass.get(i).getStatement().indexOf(finder) + increment;

		spliteStatement(i, startIndex);
		
	}

	private boolean isSingleLineStatement(Statement statement) {

		// to do update using regx
		return isStatementContains(statement, ";") && ( isStatementContains(statement, "if") ||
				isStatementContains(statement, "for") || isStatementContains(statement, "while") ||
				isStatementContains(statement, "else") || isStatementContains(statement, "else if") );
	}

	private boolean isBracketAtTheEndOfLine(Statement statement, String bracket) {

		return (isStatementContains(statement, bracket) && (statement.getStatement().length() > 1));

	}

	private void spliteStatement(int i, int startIndex) {

		if (startIndex == 0)
			startIndex++;

		Statement newStatement = new Statement(
				statementListOfAClass.get(i).getStatement().substring(startIndex, statementListOfAClass.get(i).getStatement().length()).trim(),
				statementListOfAClass.get(i).getStatementLineNumber());

		statementListOfAClass.get(i)
				.setStatement(statementListOfAClass.get(i).getStatement().substring(0, startIndex).trim());

		statementListOfAClass.add(i + 1, newStatement);

	}

	private boolean isStatementContains(Statement statement, String expectedSequence) {

		return statement.getStatement().contains(expectedSequence);

	}

	private boolean isComleteStatement(Statement statement) {

		char lastChar;

		lastChar = statement.getStatement().charAt(statement.getStatement().length() - 1);

		if (lastChar == ';' || lastChar == ')') return true;

		if (statement.getStatement().contains("else") && 
				statement.getStatement().indexOf("else")+4== statement.getStatement().length()) return true;
		
		return false;
	
	}

	private boolean isBracket(Statement statement) {

		if (statement.getStatement().contains("{") || statement.getStatement().contains("}")) return true;
		
		return false;

	}

	private void mergeStatement() {

		for (int i = 0; i < statementListOfAClass.size(); i++) {

			if (!isComleteStatement(statementListOfAClass.get(i)) && !isBracket(statementListOfAClass.get(i))
					&& !isBracket(statementListOfAClass.get(i + 1))) {

				// System.out.println(statementListOfAClass.get(i).getStatement() + " "+
				// statementListOfAClass.get(i + 1).getStatement());

				statementListOfAClass.get(i).setStatement(statementListOfAClass.get(i).getStatement() + " "
						+ statementListOfAClass.get(i + 1).getStatement());

				statementListOfAClass.remove(i + 1);

				i--;
			}

		}

	}

}
