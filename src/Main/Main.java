package Main;

import java.io.IOException;

import FileReader.ReadClassFromProject;
import StatementAnalyzer.Analyzer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		
		ReadClassFromProject rcfp = new ReadClassFromProject();
		
		//rcfp.printStatements();
		
		Analyzer a = new Analyzer();
		
		a.startStatementAnalysis(rcfp.readStatementsFromAClass("F:\\EclipseWork\\Cyclometic_Complexity\\src\\input\\code.java") );
		
	}
	
}
